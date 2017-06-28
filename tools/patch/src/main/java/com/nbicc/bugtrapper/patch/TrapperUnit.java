package com.nbicc.bugtrapper.patch;

import com.nbicc.bugtrapper.utils.MysqlUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
public class TrapperUnit {
    public static int tid(){

        MysqlUtil mysqlUtil = MysqlUtil.MySqlUtilSingleton.INSTANCE.build();
        String sql = "select * from trapper_unit where device_id = '00040000000000e0'";
        try {
            ResultSet rs = mysqlUtil.find(sql);
            if (rs.next()){
                return rs.getInt("t_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
