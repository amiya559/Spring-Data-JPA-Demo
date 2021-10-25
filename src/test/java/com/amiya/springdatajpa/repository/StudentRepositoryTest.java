package com.amiya.springdatajpa.repository;

import com.amiya.springdatajpa.entity.Guardian;
import com.amiya.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("arrout@gmail.com")
                .firstName("Amiya")
                .lastName("Rout")
                // .guardianName("Niru")
                // .guardianEmail("niru@gmail.com")
                // .guardianMobile("85956789")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("niru@gmail.com")
                .name("Niru")
                .mobile("98765543365")
                .build();

        Student student = Student.builder()
                .firstName("Asish")
                .lastName("Rout")
                .emailId("asish@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Asish");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("a");
        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Niru");
        System.out.println(students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("ar@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("ar@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("ar@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("ar@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("Amiya Rout", "ar@gmail.com");
    }

}