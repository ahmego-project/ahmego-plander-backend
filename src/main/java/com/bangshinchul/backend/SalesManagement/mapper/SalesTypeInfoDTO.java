package com.bangshinchul.backend.SalesManagement.mapper;

import com.bangshinchul.backend.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SalesTypeInfoDTO extends BaseEntity {
    private String typeName;
}
