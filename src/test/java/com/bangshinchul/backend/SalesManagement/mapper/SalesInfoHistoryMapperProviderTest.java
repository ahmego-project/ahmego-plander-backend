package com.bangshinchul.backend.SalesManagement.mapper;

import com.bangshinchul.backend.BackendApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class SalesInfoHistoryMapperProviderTest extends BackendApplicationTests {

    @Autowired
    SalesInfoHistoryMapper salesInfoHistoryMapper;

    @Test
    public void findSalesInfoHistoryItemByDate() {
        Long id = Long.parseLong("4");
        String date = "2019-06-01";
        List<SalesInfoHistoryDTO> result = salesInfoHistoryMapper.findSalesInfoHistoryItemByDate(id, date);
        log.info("result : {}", result);
    }

    @Test
    public void findSalesInfoHistoryByDate() {
    }
}