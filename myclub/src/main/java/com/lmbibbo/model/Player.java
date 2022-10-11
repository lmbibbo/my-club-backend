package com.lmbibbo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private Integer playerId;
    private Integer memberNumber;
    private String name;
    private IdentityCard dni;
    private Address address;
    private LocalDateTime created;
    @Indexed(unique = true)
    @NotEmpty(message = "Email cannot be empty o null")
    private String email;
}
