package org.zerock.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC2 {
    public static void main(String[] args)throws Exception{

        long start = System.currentTimeMillis();
        String url ="jdbc:oracle:thin:@192.168.0.4:1521:XE";

        for (int i = 0; i < 100; i++) {

                try {
                    Connection con =
                            DriverManager.getConnection(url, "teamspring", "teamspring");
                    System.out.println(con);

                    PreparedStatement pstmt =
                            con.prepareStatement("select sysdate from dual");
                    ResultSet resultSet = pstmt.executeQuery();

                    resultSet.next();

                    System.out.println(resultSet.getString(1));

                    //pstmt는 아웃풋 쪽 속함 먼저 해주어야함
                    pstmt.close();
                    con.close();

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        long end = System.currentTimeMillis();

        System.out.println(end - start);
        }//end for


    }


