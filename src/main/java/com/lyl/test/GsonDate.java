package com.lyl.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by lyl
 * Date 2018/12/19 21:30
 */
public class GsonDate {
    private String name;

    private Date birthday;

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        GsonDate dgt1 = new GsonDate();
        dgt1.setName("Lance");
        dgt1.setBirthday(new Date(537465600000l));

        GsonDate dgt2 = new GsonDate();
        dgt2.setName("Azure");
        dgt2.setBirthday(new Date(573235200000l));

        Map<String, Object> dgtMap = new Hashtable<String, Object>();
        dgtMap.put(dgt1.getName(), gson.toJson(dgt1));
        dgtMap.put(dgt2.getName(), gson.toJson(dgt2));
        dgtMap.put("Description", "This is a DateGsonTest map.");

        String dgtMapStr = gson.toJson(dgtMap);
        System.out.println(dgtMapStr);

        Map<String, Object> dgtMapTemp = gson.fromJson(dgtMapStr, new TypeToken<Hashtable<String, Object>>() {
        }.getType());

        System.out.println("The json string of Lance:" + dgtMapTemp.get("Lance"));
        System.out.println("The json string of Azure:" + dgtMapTemp.get("Azure"));
        System.out.println("The Description:" + dgtMapTemp.get("Description"));

        GsonDate Lance = gson.fromJson(dgtMapTemp.get("Lance").toString(), GsonDate.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
