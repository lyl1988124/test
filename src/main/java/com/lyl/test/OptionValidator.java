package com.lyl.test;

/**
 * Created by lyl on 2017/7/10.
 */
public class OptionValidator {
    OptionValidator() {
    }

    static void validateOption(String opt) throws IllegalArgumentException {
        if(opt != null) {
            if(opt.length() == 1) {
                char ch = opt.charAt(0);
                if(!isValidOpt(ch)) {
                    throw new IllegalArgumentException("illegal option value '" + ch + "'");
                }
            } else {
                char[] chars = opt.toCharArray();

                for(int i = 0; i < chars.length; ++i) {
                    if(!isValidChar(chars[i])) {
                        throw new IllegalArgumentException("opt contains illegal character value '" + chars[i] + "'");
                    }
                }
            }

        }
    }

    private static boolean isValidOpt(char c) {
        return isValidChar(c) || c == 32 || c == 63 || c == 64;
    }

    private static boolean isValidChar(char c) {
        return Character.isJavaIdentifierPart(c);
    }
}
