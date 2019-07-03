package com.bangshinchul.backend.SalesManagement.mapper;

import com.bangshinchul.backend.BackendApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SalesTypeInfoMapperProviderTest extends BackendApplicationTests {

    @Autowired
    SalesTypeInfoMapper salesTypeInfoMapper;

    @Test
    public void findAllByTypeName() {

    }

    @Test
    public void insertTypeInfo() {
        salesTypeInfoMapper.insertTypeInfo("CASH"); // 현금 매출 타입
        salesTypeInfoMapper.insertTypeInfo("CARD"); // 카드 매출 타입
        salesTypeInfoMapper.insertTypeInfo("GIFT"); // 상품권 매출 타입
        salesTypeInfoMapper.insertTypeInfo("PRODUCT"); // 전판 매출 타입
    }
}