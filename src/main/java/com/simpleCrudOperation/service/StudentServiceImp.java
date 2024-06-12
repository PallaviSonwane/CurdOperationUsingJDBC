package com.simpleCrudOperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleCrudOperation.model.Student;
import com.simpleCrudOperation.repository.StudentRepo;

@Service
public class StudentServiceImp implements StudentService{

        @Autowired
        private StudentRepo repo;
   
    @Override
    public boolean insertStudentData(Student model) {
        return repo.insertStudentData(model);
     }

    @Override
    public boolean deleteStudentData(int id) {
        return repo.deleteStudentData(id);
    }

    @Override
    public List<Student> showList() {
        return  repo.showList();
    }

    @Override
    public boolean updateStudentData(Student model, int id) {
        return repo.updateStudentData(model, id);
    }

}
