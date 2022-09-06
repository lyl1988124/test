package com.lyl.test;

/**
 * Created by lyl on 2017/7/10.
 */
public class Util {
    Util() {
    }

    static String stripLeadingHyphens(String str) {
        return str == null?null:(str.startsWith("--")?str.substring(2, str.length()):(str.startsWith("-")?str.substring(1, str.length()):str));
    }

    static String stripLeadingAndTrailingQuotes(String str) {
        if(str.startsWith("\"")) {
            str = str.substring(1, str.length());
        }

        if(str.endsWith("\"")) {
            str = str.substring(0, str.length() - 1);
        }

        return str;
    }
}
