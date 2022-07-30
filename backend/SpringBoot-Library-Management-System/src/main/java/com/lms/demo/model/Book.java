package com.lms.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("books")
public class Book {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    @DBRef
    private List<Category> categories;

    private Integer stock;

}
