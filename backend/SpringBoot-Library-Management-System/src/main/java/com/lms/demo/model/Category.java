package com.lms.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("genres")
public class Category {
    
    @Id
    private String id;

    @Indexed(unique = true)
    private String categoryName;

}
