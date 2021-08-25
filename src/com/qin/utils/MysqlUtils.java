package com.qin.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class MysqlUtils {
    public static DataSource dataSource;
    static {
        try {
            InputStream rs = MysqlUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(rs);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        if (dataSource!=null){
            return dataSource;
        }else {
            return null;
        }
    }
}
