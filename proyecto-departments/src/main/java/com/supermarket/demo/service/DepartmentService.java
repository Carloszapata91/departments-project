package com.supermarket.demo.service;

import com.supermarket.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();
}
