package com.bangshinchul.backend.SalesManagement.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class SalesTypeInfoMapperProvider {

    public String findAllByTypeName(@Param("typeName") String typeName) {
        String sql = new SQL() {{
            SELECT(
                    "*"
            );
            FROM("sales_type_name");
            WHERE("typeName = #{typeName}");
        }}.toString();
        StringBuilder builder = new StringBuilder(sql);
        return builder.toString();
    }

    public String insertTypeInfo(@Param("typeName") String typeName) {
        String sql = new SQL() {{
            INSERT_INTO("sales_type_info");
            VALUES("type_name", typeName);
        }}.toString();
        StringBuilder builder = new StringBuilder(sql);
        return builder.toString();
    }

}
