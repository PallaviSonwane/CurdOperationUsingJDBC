
package com.simpleCrudOperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simpleCrudOperation.model.Student;
import com.simpleCrudOperation.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@ComponentScan(basePackages = {"com.simpleCrudOperation"})
@RestController
@RequestMapping("/api/v1/student")
public class StudentApplication {
    @Autowired
    private StudentService service;

    @PostMapping("/addstudent")
    public void addstudent(@RequestBody Student student)
    {
            System.out.println((service.insertStudentData(student))?"insert data sussessfully":"not inserted");
    }

    @GetMapping("/getstudents")
    public List<Student> showAllStudent(){
       return service.showList();
    }

    @DeleteMapping("/deletestudent/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        boolean b=service.deleteStudentData(id);
        System.out.println(b?"record deleted":"not deleted");
    }

    @PutMapping("/updatestudent/{id}")
    public void putMethodName(@PathVariable("id") int id, @RequestBody Student model) {
        boolean b=service.updateStudentData(model, id);
        System.out.println(b?"data updated":"not updated");
    }
   

}
