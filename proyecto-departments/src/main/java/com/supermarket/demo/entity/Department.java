package com.supermarket.demo.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Data
@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;
    private String department_name;
    private String department_adress;
    private String department_code;

    public Department(Long departmentId, String departmentName, String departmentAdress, String departmentCode) {
        this.department_id = departmentId;
        this.department_name = departmentName;
        this.department_adress = departmentAdress;
        this.department_code = departmentCode;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + department_id +
                ", departmentName='" + department_name + '\'' +
                ", departmentAdress='" + department_adress + '\'' +
                ", departmentCode='" + department_code + '\'' +
                '}';
    }
}
