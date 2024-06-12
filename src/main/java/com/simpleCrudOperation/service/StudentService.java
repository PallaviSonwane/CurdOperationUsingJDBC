package com.simpleCrudOperation.service;

import java.util.List;

import com.simpleCrudOperation.model.Student;

public interface StudentService {
    public boolean insertStudentData(Student model);
    public List<Student> showList();
    public boolean deleteStudentData(int id);
    public boolean updateStudentData(Student model, int id);
}
