package com.supermarket.demo.controller;

import com.supermarket.demo.entity.Department;
import com.supermarket.demo.repository.DepartmentRepository;
import com.supermarket.demo.service.DepartmentService;
import com.supermarket.demo.service.DepartmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @PostMapping("/createDepartment")
    public Department saveDepartment(@RequestBody Department department){

        return departmentService.saveDepartment(department);
    };

    @GetMapping("/getAllDepartments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }


}
