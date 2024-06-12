package com.simpleCrudOperation.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.simpleCrudOperation.model.Student;

import jakarta.annotation.PostConstruct;

@Repository
public class StudentRepoImp implements StudentRepo {
    protected Connection con;
    protected PreparedStatement pt;
    protected ResultSet rs;
    List<Student> list;
    
    @PostConstruct
    public void getConnect() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "root");
    }

    @Override
    public boolean insertStudentData(Student model) {
        try{
            if(con!=null){
                pt=con.prepareStatement("insert into student(id,name,lname,mark) values(?,?,?,?)");
                pt.setInt(1, model.getId());
                pt.setString(2, model.getName());
                pt.setString(3, model.getLname());
                pt.setInt(4, model.getMark());
                int v=pt.executeUpdate();
                return (v>0)?true:false;
            }else{
                System.out.println("not connected");
            }
            return true;
        }catch(Exception ex){
            System.out.println("error in repo insert data"+ex);
            return false;
        }
    }

    @Override
    public boolean deleteStudentData(int id) {
        try{
        if(con!=null){
            pt=con.prepareStatement("delete from student where id=?");
            pt.setInt(1, id);
            int v=pt.executeUpdate();
            System.out.println(v);
            return (v>0)?true:false;
        }else{
            System.out.println("not connected");
        }
        return true;
    }catch(Exception ex){
        System.out.println("error in repo delete data"+ex);
        return false;
    }
}

    @Override
    public List<Student> showList() {
        try{
            list=new ArrayList<Student>();
        if(con!=null){
            pt=con.prepareStatement("select *from student");
            rs=pt.executeQuery();
            
            while(rs.next()){
                Student model=new Student();
                model.setId(rs.getInt(1));
                model.setName(rs.getString(2));
                model.setLname(rs.getString(3));
                model.setMark(rs.getInt(4));
                list.add(model);

            }
        }else{
            System.out.println("not connected");
        }
            return list;
        }catch(Exception ex){
            System.out.println("error in show data"+ex);
            return null;
        }
        
    }

    @Override
    public boolean updateStudentData(Student model, int id) {
       try{
            if(con!=null){
                pt=con.prepareStatement("update student set id=?,name=?,lname=?,mark=? where id=?");
                pt.setInt(1, model.getId());
                pt.setString(2, model.getName());
                pt.setString(3, model.getLname());
                pt.setInt(4, model.getMark());
                pt.setInt(5, id);
                int v=pt.executeUpdate();
                return (v>0)?true:false;
            }
            return true;
       }catch(Exception ex){
            System.out.println("some problem in update section");
            return false;
       }
        
    }

}
