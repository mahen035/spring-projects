package com.ps.springboot.respository;
import com.ps.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudName(String name);

    @Query(nativeQuery = true, value = "SELECT * from Student where age = (select max(age) from Student)")
    Student findOldestStudent();
}
