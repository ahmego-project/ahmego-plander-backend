package com.bangshinchul.backend.SalesManagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface SalesTypeInfoMapper {

    @SelectProvider(type = SalesTypeInfoMapperProvider.class, method = "findAllByTypeName")
    SalesTypeInfoDTO findAllByTypeName(String typeName);

    @SelectProvider(type = SalesTypeInfoMapperProvider.class, method = "insertTypeInfo")
    SalesTypeInfoDTO insertTypeInfo(String typeName);

}
