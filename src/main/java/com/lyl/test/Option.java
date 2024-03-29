package com.lyl.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyl on 2017/7/10.
 */
public class Option implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    public static final int UNINITIALIZED = -1;
    public static final int UNLIMITED_VALUES = -2;
    private String opt;
    private String longOpt;
    private String argName;
    private String description;
    private boolean required;
    private boolean optionalArg;
    private int numberOfArgs;
    private Object type;
    private List values;
    private char valuesep;

    public Option(String opt, String description) throws IllegalArgumentException {
        this(opt, (String)null, false, description);
    }

    public Option(String opt, boolean hasArg, String description) throws IllegalArgumentException {
        this(opt, (String)null, hasArg, description);
    }

    public Option(String opt, String longOpt, boolean hasArg, String description) throws IllegalArgumentException {
        this.argName = "arg";
        this.numberOfArgs = -1;
        this.values = new ArrayList();
        OptionValidator.validateOption(opt);
        this.opt = opt;
        this.longOpt = longOpt;
        if(hasArg) {
            this.numberOfArgs = 1;
        }

        this.description = description;
    }

    public int getId() {
        return this.getKey().charAt(0);
    }

    String getKey() {
        return this.opt == null?this.longOpt:this.opt;
    }

    public String getOpt() {
        return this.opt;
    }

    public Object getType() {
        return this.type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public String getLongOpt() {
        return this.longOpt;
    }

    public void setLongOpt(String longOpt) {
        this.longOpt = longOpt;
    }

    public void setOptionalArg(boolean optionalArg) {
        this.optionalArg = optionalArg;
    }

    public boolean hasOptionalArg() {
        return this.optionalArg;
    }

    public boolean hasLongOpt() {
        return this.longOpt != null;
    }

    public boolean hasArg() {
        return this.numberOfArgs > 0 || this.numberOfArgs == -2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public void setArgName(String argName) {
        this.argName = argName;
    }

    public String getArgName() {
        return this.argName;
    }

    public boolean hasArgName() {
        return this.argName != null && this.argName.length() > 0;
    }

    public boolean hasArgs() {
        return this.numberOfArgs > 1 || this.numberOfArgs == -2;
    }

    public void setArgs(int num) {
        this.numberOfArgs = num;
    }

    public void setValueSeparator(char sep) {
        this.valuesep = sep;
    }

    public char getValueSeparator() {
        return this.valuesep;
    }

    public boolean hasValueSeparator() {
        return this.valuesep > 0;
    }

    public int getArgs() {
        return this.numberOfArgs;
    }

    void addValueForProcessing(String value) {
        switch(this.numberOfArgs) {
            case -1:
                throw new RuntimeException("NO_ARGS_ALLOWED");
            default:
                this.processValue(value);
        }
    }

    private void processValue(String value) {
        if(this.hasValueSeparator()) {
            char sep = this.getValueSeparator();

            for(int index = value.indexOf(sep); index != -1 && this.values.size() != this.numberOfArgs - 1; index = value.indexOf(sep)) {
                this.add(value.substring(0, index));
                value = value.substring(index + 1);
            }
        }

        this.add(value);
    }

    private void add(String value) {
        if(this.numberOfArgs > 0 && this.values.size() > this.numberOfArgs - 1) {
            throw new RuntimeException("Cannot add value, list full.");
        } else {
            this.values.add(value);
        }
    }

    public String getValue() {
        return this.hasNoValues()?null:(String)this.values.get(0);
    }

    public String getValue(int index) throws IndexOutOfBoundsException {
        return this.hasNoValues()?null:(String)this.values.get(index);
    }

    public String getValue(String defaultValue) {
        String value = this.getValue();
        return value != null?value:defaultValue;
    }

    public String[] getValues() {
        return this.hasNoValues()?null:(String[])((String[])this.values.toArray(new String[this.values.size()]));
    }

    public List getValuesList() {
        return this.values;
    }

    public String toString() {
        StringBuffer buf = (new StringBuffer()).append("[ option: ");
        buf.append(this.opt);
        if(this.longOpt != null) {
            buf.append(" ").append(this.longOpt);
        }

        buf.append(" ");
        if(this.hasArgs()) {
            buf.append("[ARG...]");
        } else if(this.hasArg()) {
            buf.append(" [ARG]");
        }

        buf.append(" :: ").append(this.description);
        if(this.type != null) {
            buf.append(" :: ").append(this.type);
        }

        buf.append(" ]");
        return buf.toString();
    }

    private boolean hasNoValues() {
        return this.values.isEmpty();
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            Option option = (Option)o;
            if(this.opt != null) {
                if(!this.opt.equals(option.opt)) {
                    return false;
                }
            } else if(option.opt != null) {
                return false;
            }

            if(this.longOpt != null) {
                if(this.longOpt.equals(option.longOpt)) {
                    return true;
                }
            } else if(option.longOpt == null) {
                return true;
            }

            return false;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.opt != null?this.opt.hashCode():0;
        result = 31 * result + (this.longOpt != null?this.longOpt.hashCode():0);
        return result;
    }

    public Object clone() {
        try {
            Option option = (Option)super.clone();
            option.values = new ArrayList(this.values);
            return option;
        } catch (CloneNotSupportedException var2) {
            throw new RuntimeException("A CloneNotSupportedException was thrown: " + var2.getMessage());
        }
    }

    void clearValues() {
        this.values.clear();
    }

    /** @deprecated */
    public boolean addValue(String value) {
        throw new UnsupportedOperationException("The addValue method is not intended for client use. Subclasses should use the addValueForProcessing method instead. ");
    }
}
