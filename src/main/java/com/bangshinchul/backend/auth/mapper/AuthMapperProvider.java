package com.bangshinchul.backend.auth.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
public class AuthMapperProvider {

    public String findByUsernameAndPassword(@Param("username") String username, @Param("password") String password) {
        String sql = new SQL() {{
            SELECT(
                    "*"
            );
            FROM("auth");
            WHERE("username = #{username}");
            WHERE("password = #{password}");
        }}.toString();
        StringBuilder builder = new StringBuilder(sql);
        return builder.toString();
    }

    public String findUsernameByUsername(@Param("username") String username) {
        String sql = new SQL() {{
            SELECT("username");
            FROM("auth");
            WHERE("username = #{username}");
        }}.toString();
        return new StringBuilder(sql).toString();
    }
}
