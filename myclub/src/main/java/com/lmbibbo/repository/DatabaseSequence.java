package com.lmbibbo.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class DatabaseSequence {

    @Id
    String id;
    Long seq;
}
