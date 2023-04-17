package com.supermarket.demo.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;

    @NotBlank(message = "Introduzca el nombre del departamento")
    @Length(max = 15, min = 5)
    private String department_name;
    private String department_adress;
    private String department_code;

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
