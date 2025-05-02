package com.dotsehyde;

import com.dotsehyde.Models.Student.Student;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Singleton;

@Singleton
public class StudentRepo implements PanacheRepository<Student> {
    public Student findByName(String name) {
        return find("name", name).firstResult();
    }

    public Student findByEmail(String email) {
        return find("email", email).firstResult();
    }
}
