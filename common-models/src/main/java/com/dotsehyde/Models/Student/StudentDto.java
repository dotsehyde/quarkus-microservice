package com.dotsehyde.Models.Student;

import jakarta.validation.constraints.*;

import java.util.Date;

public record StudentDto() {

    public record StudentCreate(
           @NotEmpty String name,
           @Email(message = "Invalid email") String email,
           @NotEmpty String password
    ) {
    }

    public record StudentData(
            Long id,
            String name,
            String email,
            Date createdAt,
            Date updatedAt
    ) {
        static public StudentData from(Student s) {
            return new StudentData(
                    s.getId(),
                    s.getName(),
                    s.getEmail(),
                    s.getCreatedAt(),
                    s.getUpdatedAt()
            );
        }
    }
}
