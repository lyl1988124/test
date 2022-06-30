package com.lyl.work.aop;

import com.lyl.work.sensitiveutils.sensitive.SensitiveInfoUtils;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 
 * <p> Description : JoinPoint
 *
 * @author : liuyuanlong
 * @date : 2022/6/29 9:24
 */
public class LogAop {


    private static final Logger LOGGER = LoggerFactory.getLogger(LogAop.class);

    @Pointcut(value = "execution(public * com.test.idps.dashboard.controller.*.*(..)) " +
        "&& !execution(public * com.test.idps.dashboard.controller.AlertController.*(..))")
    public void aiLog() {
    }

    @Pointcut(value = "execution(public * com.test.idps.assets.controller.*.*(..))")
    public void assetsLog() {
    }

    @Pointcut(value = "execution(public * com.test.idps.samplestore.dashboard.controller.*.*(..))")
    public void sampleStoreLog() {
    }

    /**
     * 当前只能配置于字符类型字段
     */
    @Value("${log.sensitive.field.name}")
    private List<String> sensitiveList;

    @Around(value = "aiLog() || assetsLog() || sampleStoreLog()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String paramInfo = genMethodParams(joinPoint);

        String paramInfo2 = generateParamWithDesensitization(joinPoint);

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LOGGER.info("request in. url={} userId={} workspaceId={} param={}",
            request.getRequestURI(),
            paramInfo);

        LOGGER.info("request in. url={} userId={} workspaceId={} param={}",
            request.getRequestURI(),
            paramInfo2);

        Object object = joinPoint.proceed();

        // 出参数据大小比较离散(例如部分接口返回list信息非常大)，不打印
        LOGGER.info("request out. url={} userId={} workspaceId={}",
            request.getRequestURI());

        return object;
    }

    /**
     * @param point point
     */
    public String genMethodParams(ProceedingJoinPoint point) {
        if (point == null) {
            return null;
        }

        // 获取类名
        String className = point.getTarget().getClass().getName();

        // 获取方法名
        String methodName = point.getSignature().getName();

        // 获取方法的参数值数组
        Object[] methodArgs = point.getArgs();

        try {
            // 获取方法参数名称
            String[] paramNames = getFieldsName(className, methodName);

            // 生成方法参数
            return generateParam(paramNames, methodArgs);
        } catch (Exception e) {
            LOGGER.warn("gen method params error. exception=", e);
            throw new RuntimeException();
        }
    }

    /**
     * 使用javassist来获取方法参数名称
     *
     * @param className  类名
     * @param methodName 方法名
     * @return
     * @throws Exception
     */
    private String[] getFieldsName(String className, String methodName) throws Exception {
        Class<?> clazz = Class.forName(className);
        String clazzName = clazz.getName();

        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(clazz);
        pool.insertClassPath(classPath);

        CtClass ctClass = pool.get(clazzName);
        CtMethod ctMethod = ctClass.getDeclaredMethod(methodName);


        MethodInfo methodInfo = ctMethod.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            return null;
        }

        String[] paramsArgsName = new String[ctMethod.getParameterTypes().length];
        int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1;
        for (int i = 0; i < paramsArgsName.length; i++) {
            paramsArgsName[i] = attr.variableName(i + pos);
        }
        return paramsArgsName;
    }

    /**
     * 打印方法参数值  基本类型直接打印，非基本类型需要重写toString方法
     *
     * @param paramsArgsName  方法参数名数组
     * @param paramsArgsValue 方法参数值数组
     */
    private String generateParam(String[] paramsArgsName, Object[] paramsArgsValue) {
        if (ArrayUtils.isEmpty(paramsArgsName) || ArrayUtils.isEmpty(paramsArgsValue)) {
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < paramsArgsName.length; i++) {
            //参数名
            String name = paramsArgsName[i];
            //参数值
            Object value = paramsArgsValue[i];

            if (CollectionUtils.isNotEmpty(sensitiveList)) {
                value = SensitiveInfoUtils.desensitization(value, sensitiveList);
            }

            buffer.append(name);
            buffer.append(":");
            buffer.append(value);
            buffer.append(",");
        }
        return buffer.toString();
    }

    private String generateParamWithDesensitization(ProceedingJoinPoint joinPoint) {

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();

        // 获取名
        Parameter[] parameters = targetMethod.getParameters();
        // 获取参数
        Object[] methodArgs = joinPoint.getArgs();

        if (ArrayUtils.isEmpty(methodArgs) || ArrayUtils.isEmpty(methodArgs)) {
            return null;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < parameters.length; i++) {
            //参数名
            String name = parameters[i].getType().getSimpleName();
            //参数值
            Object value = methodArgs[i];

            if (CollectionUtils.isNotEmpty(sensitiveList)) {
                value = SensitiveInfoUtils.desensitization(value, sensitiveList);
            }

            stringBuffer.append(name);
            stringBuffer.append(":");
            stringBuffer.append(value);
            stringBuffer.append(",");
        }

        return stringBuffer.toString();
    }
}
