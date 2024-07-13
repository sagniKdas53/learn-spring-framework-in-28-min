package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Getter
@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Course course) {
        jdbcTemplate.update("insert into course (id, name, author) " + "values(?,  ?, ?)",
                course.getId(), course.getName(), course.getAuthor());
    }

    public void selectAll() {
        jdbcTemplate.query("select * from course", (rs, rowNum) ->
                        new Course(rs.getLong("id"), rs.getString("name"), rs.getString("author")))
                .forEach(System.out::println);
    }

    public Course selectById(long id) {
/*        return jdbcTemplate.queryForObject("select * from course where id = ?", new Object[]{id},
                (rs, rowNum) -> new Course(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("author")));*/
        return jdbcTemplate.queryForObject("select * from course where id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Course.class));
/*        return jdbcTemplate.query("select * from course where id = ?", new Object[]{id},
                (rs, rowNum) -> new Course(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("author"))
        ).get(0);*/
    }

    public void deleteById(long id) {
        jdbcTemplate.update("delete from course where id = ?", id);
    }

    public void deleteCourse(Course cs) {
        jdbcTemplate.update("delete from course where id = ?", cs.getId());

    }

    public void runPreDefQuery() {
        jdbcTemplate.update(
                """
                        INSERT INTO course (id, name, author)
                        VALUES (1, 'Spring', 'in28minutes');
                        """
        );
    }

}
