package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJpaRepository courseRepository;
//    @Autowired
//    private CourseJdbcRepository courseRepository;

    @Autowired
    private CourseSpringDataJpaRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running the CommandLineRunner");
//        courseRepository.runPreDefQuery();
//        courseRepository.selectAll();
//        courseRepository.insert(new Course(2, "Spring Boot", "in28minutes"));
//        courseRepository.selectAll();
//        courseRepository.deleteCourse(new Course(1, "Spring", "in28minutes"));
//        courseRepository.selectAll();
//        courseRepository.deleteById(2);
//        courseRepository.selectAll();
//        System.out.println(courseRepository.selectById(1));

        courseRepository.save(new Course(1, "Spring", "in28minutes"));
        courseRepository.save(new Course(2, "Spring Boot", "in28minutes"));
        courseRepository.save(new Course(3, "Spring Boot Web", "in28minutes"));

        courseRepository.findAll().forEach(System.out::println);

        System.out.println(courseRepository.findById(1L));

        courseRepository.deleteById(1L);

        courseRepository.findAll().forEach(System.out::println);

        System.out.println(courseRepository.findById(1L));

        courseRepository.save(new Course(2, "Spring Boot", "in28minutes"));

        courseRepository.findAll().forEach(System.out::println);

        System.out.println(courseRepository.count());

        System.out.println(courseRepository.existsById(2L));

        System.out.println(courseRepository.findByAuthor("in28minutes"));

        System.out.println(courseRepository.findByAuthor("Spring Boot"));

        System.out.println(courseRepository.findByName("Spring Boot"));

    }
}
