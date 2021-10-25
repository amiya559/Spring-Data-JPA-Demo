package com.amiya.springdatajpa.repository;

import com.amiya.springdatajpa.entity.Course;
import com.amiya.springdatajpa.entity.Student;
import com.amiya.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Sagar")
                .lastName("Pradhan")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Soman")
                .lastName("Sahu")
                .build();

        Student student = Student.builder()
                .firstName("Suman")
                .lastName("Bansaal")
                .emailId("suman@gmail.com")
                .build();


        Course course = Course.builder()
                .title("AI")
                .credit(15)
                .teacher(teacher)
                .students(List.of(student))
                .build();

        courseRepository.save(course);
    }




}