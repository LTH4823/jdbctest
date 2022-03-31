package org.zerock.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC1 {

    public static void main(String[] args) throws Exception{
        System.out.println("test1.........");

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url ="jdbc:oracle:thin:@192.168.0.4:1521:XE";

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Connection con =
                            DriverManager.getConnection(url, "teamspring", "teamspring");

                    System.out.println(con);
                    con.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }).start();
        }//end for
    }
}