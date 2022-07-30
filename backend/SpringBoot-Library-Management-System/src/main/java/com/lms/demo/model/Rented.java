package com.lms.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("rented")
public class Rented {

    @Id
    private String id;

    @DBRef
    private Book book;

    @DBRef
    private User user;
    
}
