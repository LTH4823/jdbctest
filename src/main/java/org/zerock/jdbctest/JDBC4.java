package org.zerock.jdbctest;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class JDBC4 {
    public static void main(String[] args) throws Exception {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:oracle:thin:@192.168.0.4:1521:XE");
        config.setUsername("leetest");
        config.setPassword("leetest");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {

            try {
                Connection con = ds.getConnection();
                System.out.println(con);
                String sql = "insert into tbl_item_test01(ino, seller,itemName,price) values (?, ?, ?, ?)";

                PreparedStatement pstmt =
                        con.prepareStatement(sql);

                pstmt.setInt(1, i+5);
                pstmt.setString(2, "df");
                pstmt.setString(3, "MG진");
                pstmt.setInt(4, 42000);
                pstmt.executeUpdate();

                //pstmt는 아웃풋 쪽 속함 먼저 해주어야함
                pstmt.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
        System.out.println(end - start);
        }
    }//end for

}

