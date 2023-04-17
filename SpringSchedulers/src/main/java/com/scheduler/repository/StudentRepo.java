package com.scheduler.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scheduler.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	List<Student> findByActiveFalse();

}
