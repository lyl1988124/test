package com.lyl.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyl on 2017/7/10.
 */
public class Flatten {
    protected String[] flatten(Options options, String[] arguments, boolean stopAtNonOption) {
        List tokens = new ArrayList();
        boolean eatTheRest = false;

        for(int i = 0; i < arguments.length; ++i) {
            String arg = arguments[i];
            if("--".equals(arg)) {
                eatTheRest = true;
                tokens.add("--");
            } else if("-".equals(arg)) {
                tokens.add("-");
            } else if(arg.startsWith("-")) {
                String opt = Util.stripLeadingHyphens(arg);
                if(options.hasOption(opt)) {
                    tokens.add(arg);
                } else if(opt.indexOf(61) != -1 && options.hasOption(opt.substring(0, opt.indexOf(61)))) {
                    tokens.add(arg.substring(0, arg.indexOf(61)));
                    tokens.add(arg.substring(arg.indexOf(61) + 1));
                } else if(options.hasOption(arg.substring(0, 2))) {
                    tokens.add(arg.substring(0, 2));
                    tokens.add(arg.substring(2));
                } else {
                    eatTheRest = stopAtNonOption;
                    tokens.add(arg);
                }
            } else {
                tokens.add(arg);
            }

            if(eatTheRest) {
                ++i;

                while(i < arguments.length) {
                    tokens.add(arguments[i]);
                    ++i;
                }
            }
        }

        return (String[])((String[])tokens.toArray(new String[tokens.size()]));
    }

    public static void main(String[] args) {
        Flatten f = new Flatten();
        Options p = new Options();
        String[] s = new String[]{"aa","--","-c"};
        f.flatten(p,s,false);
    }
}
