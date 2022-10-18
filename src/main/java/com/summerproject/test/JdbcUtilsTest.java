package com.summerproject.test;

import com.summerproject.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(JdbcUtils.getConnection());
            JdbcUtils.close(connection);
        }
    }

}
