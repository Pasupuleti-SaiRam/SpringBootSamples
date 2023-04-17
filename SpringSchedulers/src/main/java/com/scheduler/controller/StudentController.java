package com.scheduler.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.entity.Student;
import com.scheduler.service.StudentService;



@RestController
public class StudentController {

    
    @Autowired
	StudentService service;
	
@GetMapping("/getStudentbyId/{stuid}")	
 public Student getStudent(@PathVariable int stuid) {
	 return service.getStudent(stuid);
 }

@PostMapping("/addStudent")
 public Student addStudent(@RequestBody Student student)
 {
	 return service.addStudent(student);
 }


@GetMapping("/getAllStudents")	
public List<Student> getAllStudents() {
	 return service.getAllStudents();
}

}
