package com.bangshinchul.backend.SalesManagement.service;

import com.bangshinchul.backend.SalesManagement.mapper.SalesInfoHistoryDTO;
import com.bangshinchul.backend.SalesManagement.mapper.SalesInfoHistoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SalesInfoServiceImpl implements SalesInfoService {

    @Autowired
    private SalesInfoHistoryMapper salesInfoHistoryMapper;

    @Override
    public List<SalesInfoHistoryDTO> findSalesInfoHistoryItemByDate(Long userId, String date) {
        return salesInfoHistoryMapper.findSalesInfoHistoryItemByDate(userId, date);
    }
}
