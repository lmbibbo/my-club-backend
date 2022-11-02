package com.lmbibbo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@AllArgsConstructor
public class Player {
    @Transient
    public static final String SEQUENCE_NAME = "players_sequence";
    @Id
    private Long playerId;
    private Integer memberNumber;
    private String name;
    private IdentityCard dni;
    private Address address;
    private LocalDateTime created;
}
