package com.simpleCrudOperation.model;

import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class Student {
    
    private int id;
    private String name;
    private String lname;
    private int mark;

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", lname=" + lname + ", mark=" + mark + "]";
    }

    
}
