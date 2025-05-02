package com.dotsehyde.Models.Student;

import java.util.Date;

public record StudentDto() {

    public record StudentCreate(
            String name,
            String email,
            String password
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
