package com.nbicc.bugtrapper.utils;

import com.nbicc.bugtrapper.config.MyConfig;

import java.sql.*;

/**
 * Created by daniel on 2017/6/27 0027.
 */
public class MysqlUtil {
    public static Connection conn = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;
    public  void intialized(){

        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            String url = MyConfig.MYSQL_URL;
            conn = DriverManager.getConnection(url, MyConfig.MYSQL_USR_NAME, MyConfig.MYSQL_PWD);
            stmt = conn.createStatement();

        } catch (ClassNotFoundException e) {
            System.out.println( "path" + e  );
        } catch (SQLException e ){
            System.out.println( "error:" + e );
        }

    }
    public ResultSet find(String sql) throws SQLException {
        close();
        if (rs==null||stmt==null||conn==null){
            this.intialized();
        }
        return stmt.executeQuery(sql);
    }
    public static void close(){

            try {
                if( rs != null ) {
                    rs.close();
                }
                if( stmt != null ) {
                    stmt.close();
                }
                if( conn != null ) {
                    conn.close();
                }
            } catch( SQLException e ) {
                System.out.println( "error:" + e );
            }

    }
    public enum MySqlUtilSingleton{
        INSTANCE;
        public MysqlUtil build(){
            MysqlUtil util = new MysqlUtil();
            util.intialized();
            return  util;
        }
    }
}
