package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

//    public CourseJpaRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    public void insert(Course course) {
        System.out.println("Inserting course: " + course);
        entityManager.merge(course);
    }

    public Course selectById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = selectById(id);
        entityManager.remove(course);
    }

    public void update(Course course) {
        entityManager.merge(course);
    }

    public void runPreDefQuery() {
        entityManager.createNativeQuery(
                """
                        INSERT INTO course (id, name, author)
                        VALUES (1, 'Spring', 'in28minutes');
                        """
        ).executeUpdate();
    }

    public void selectAll() {
        System.out.println("Selecting all courses: ");
        entityManager.createQuery("select c from course c", Course.class)
                .getResultList()
                .forEach(System.out::println);
        System.out.println("End of selecting all courses");
    }


    public void deleteCourse(Course course) {
        entityManager.remove(entityManager.find(Course.class, course.getId()));
    }
}
