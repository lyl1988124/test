package com.lyl.technology.python;

import org.python.util.PythonInterpreter;

/**
 * Created by lyl on 2018/11/6.
 */
public class ExecPython {

    public static void main(String[] args) {
        PythonInterpreter pythonInterpreter = new PythonInterpreter();
        pythonInterpreter.execfile("mypy.py");

    }
}
