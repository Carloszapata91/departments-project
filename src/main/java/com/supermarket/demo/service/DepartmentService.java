package com.supermarket.demo.service;

import com.supermarket.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long department_id) throws Exception;

    public void deleteDepartmentById(Long department_id) throws Exception;

    Department updateDepartment(Long department_Id, Department department) throws Exception;

    public Department fetchDepartmentByName(String department_name);

    List <Department> fetchDepartmentByAdressIgnoreCase(String department_adress);

    List<Department> saveAll(List<Department> departments);
}
