package com.dotsehyde;

import com.dotsehyde.Models.Student.Student;
import com.dotsehyde.Models.Student.StudentDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StudentService {
    @Inject
    StudentRepo studentRepo;

    @Transactional
    public StudentDto.StudentData createStudent(StudentDto.StudentCreate s) {
        var student = new Student();
        student.setName(s.name());
        student.setEmail(s.email());
        student.setPassword(s.password());
        studentRepo.persistAndFlush(student);
        return StudentDto.StudentData.from(student);
    }

    public StudentDto.StudentData getStudent(Long id) {
        var student = studentRepo.findById(id);
        if (student == null) {
            return null;
        }
        return StudentDto.StudentData.from(student);
    }

    public Student findByName(String name) {
        return studentRepo.findByName(name);
    }
}
