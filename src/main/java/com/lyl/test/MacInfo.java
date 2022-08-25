package com.lyl.test;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**

 * <p> Description : MacInfo.java
 *
 * @author : liuyuanlong
 * @date : 2020/11/16 10:29
 */
public class MacInfo {
    public static List<String> getLocalhostIp() {
        List<String> ips = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
            InetAddress ia = null;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    ia = ias.nextElement();
                    System.out.println("getHostName=" + ia.getHostName());
                    System.out.println("getHostAddress=" + ia.getHostAddress());
                    System.out.println("getCanonicalHostName=" + ia.getCanonicalHostName());
                    if (ia instanceof Inet6Address) {
                        continue;
                    }
                    if ("127.0.0.1".equals(ia.getHostAddress())) {
                        continue;
                    }
                    ips.add(ia.getHostAddress());
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        return ips;
    }

    public static void main(String[] args) {
        getLocalhostIp();
    }
}
