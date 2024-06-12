package com.simpleCrudOperation.repository;

import java.util.List;

import com.simpleCrudOperation.model.Student;

public interface StudentRepo {
    public boolean insertStudentData(Student model);
    public List<Student> showList();
    public boolean deleteStudentData(int id);
    public boolean updateStudentData(Student model,int id);
}
