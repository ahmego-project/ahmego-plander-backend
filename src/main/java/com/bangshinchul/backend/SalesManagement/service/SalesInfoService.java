package com.bangshinchul.backend.SalesManagement.service;


import com.bangshinchul.backend.SalesManagement.mapper.SalesInfoHistoryDTO;

import java.util.List;
import java.util.zip.DataFormatException;


public interface SalesInfoService {
    List<SalesInfoHistoryDTO> findSalesInfoHistoryItemByDate(Long id, String date) throws DataFormatException;
}
