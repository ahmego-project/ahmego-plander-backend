package com.bangshinchul.backend.SalesManagement.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class SalesInfoHistoryMapperProvider {

    public String findSalesInfoHistoryItemByDate(@Param("userId") Long id, @Param("date") String date) {
        String sql = new SQL() {{
            SELECT(
                    "DATE_FORMAT(sh.sales_date, '%Y-%m-%d') AS sales_date"
                    , "st.type_name AS type"
                    , "sh.amount"
                    , "sh.user_id"
            );
            FROM("sales_info_history");
            INNER_JOIN("sales_type_info st on st.id = sh.type");
            WHERE("sales_date = #{date}");
            WHERE("user_id = #{id}");
        }}.toString();
        StringBuilder builder = new StringBuilder(sql);
        return builder.toString();
    }

    public String findSalesInfoHistoryByDate(@Param("userId") Long id, @Param("startAt") String startAt, @Param("endAt") String endAt) {
        String sql = new SQL() {{
            SELECT(
                    "DATE_FORMAT(sh.sales_date, '%Y-%m-%d') AS sales_date"
                    , "st.type_name AS type"
                    , "sh.amount"
                    , "sh.user_id"
            );
            FROM("sales_info_history");
            INNER_JOIN("sales_type_info st on st.id = sh.type");
            WHERE("sales_date BETWEEN #{startAt} AND #{endAt}");
            WHERE("user_id = #{id}");
        }}.toString();
        StringBuilder builder = new StringBuilder(sql);
        return builder.toString();
    }
}
