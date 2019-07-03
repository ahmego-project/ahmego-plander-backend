package com.bangshinchul.backend.SalesManagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface SalesInfoHistoryMapper {
    @SelectProvider(type = SalesInfoHistoryMapperProvider.class, method = "findSalesInfoHistoryItemByDate")
    List<SalesInfoHistoryDTO> findSalesInfoHistoryItemByDate(@Param("userId") Long id, @Param("date") String date);

    @SelectProvider(type = SalesInfoHistoryMapperProvider.class, method = "findSalesInfoHistoryByDate")
    List<SalesInfoHistoryDTO> findSalesInfoHistoryByDate(@Param("userId") Long id, @Param("startAt") String startAt, @Param("endAt") String endAt);
}
