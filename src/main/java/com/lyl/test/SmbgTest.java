package com.lyl.test;

import com.hierynomus.msfscc.fileinformation.FileIdBothDirectoryInformation;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.DiskShare;

import java.io.IOException;

/**
 
 * <p> Description : SmbgTest
 *
 * @author : liuyuanlong
 * @date : 2022/6/24 15:14
 */
public class SmbgTest {

    public static void main(String[] args) throws IOException {
        SMBClient client = new SMBClient();

        try (Connection connection = client.connect("172.16.20.66")) {
            AuthenticationContext ac = new AuthenticationContext("zettakit", "zettakit".toCharArray(), "");
            Session session = connection.authenticate(ac);

            // Connect to Share
            // \\192.168.2.3\temp\临时数据\共享目录    对应“temp”
            try (DiskShare share = (DiskShare) session.connectShare("d")) {
                // \\192.168.2.3\temp\临时数据\共享目录    对应“\临时数据\共享目录”
                for (FileIdBothDirectoryInformation f : share.list("tools")) {
                    System.out.println("File : " + f.getFileName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
