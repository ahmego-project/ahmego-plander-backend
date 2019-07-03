package com.bangshinchul.backend.common.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int active = 1;

//    private Long createdAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();

//    private Long updatedAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();

    private LocalDateTime createdAt = LocalDateTime.now(ZoneOffset.UTC);

    private LocalDateTime updatedAt = LocalDateTime.now(ZoneOffset.UTC);

    public Long getId() {
        return this.id;
    }
}
