package com.amiya.springdatajpa.repository;

import com.amiya.springdatajpa.entity.Course;
import com.amiya.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseSpring = Course.builder()
                .title("Spring")
                .credit(10)
                .build();

        Course coursePython = Course.builder()
                .title("Django")
                .credit(5)
                .build();

        Course courseDataScience = Course.builder()
                .title("Data Science")
                .credit(10)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Anadi")
                .lastName("Sethi")
                // .courses(List.of(courseSpring, coursePython, courseDataScience))
                .build();

        teacherRepository.save(teacher);
    }

}