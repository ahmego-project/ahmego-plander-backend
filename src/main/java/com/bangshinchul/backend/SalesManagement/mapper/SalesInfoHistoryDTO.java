package com.bangshinchul.backend.SalesManagement.mapper;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SalesInfoHistoryDTO {
    private String salesDate;
    private String type;
    private BigInteger amount;
    private Long userId;
}
