package com.lms.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Document("users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    private String id;

    @NotBlank
    private String username;

    @Indexed(unique = true)
    @Email
    private String email;

    private Long phoneNumber;

    @NotBlank
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, Long phoneNumber, String password) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}
