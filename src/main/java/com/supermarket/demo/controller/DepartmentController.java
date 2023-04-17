package com.supermarket.demo.controller;

import com.supermarket.demo.entity.Department;
import com.supermarket.demo.repository.DepartmentRepository;
import com.supermarket.demo.service.DepartmentService;
import com.supermarket.demo.service.DepartmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @PostMapping("/createDepartment")
    public Department saveDepartment(@Valid @RequestBody Department department){

        return departmentService.saveDepartment(department);
    };

    @PostMapping("/createBatchDepartment")
    public List <Department> saveNewBatch (@RequestBody List<Department> departments){
        return departmentService.saveAll(departments);
    }

    @GetMapping("/getAllDepartments")
    public List<Department> fetchDepartmentList(){

        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/getDepartmentById/{department_id}")
    public Department fetchDepartmentByID(@PathVariable Long department_id) throws Exception {
        log.info("Recuperando un departamento por ID");
        return departmentService.fetchDepartmentById(department_id);
    }

    @DeleteMapping("/deleteDepartmentById/{department_id}")
    public String deleteDeparmentById(@PathVariable Long department_id) throws Exception {
        departmentService.deleteDepartmentById(department_id);
        return "Department deleted succesfully!!!";
    }

    @PutMapping("/updateDepartmentById/{department_id}")
    public Department updateDepartment(@PathVariable Long department_id, @RequestBody Department department) throws Exception {
        return departmentService.updateDepartment(department_id,department);
    }

   @GetMapping("/getDepartmentByName/{department_name}")
    public Department fetchDepartmentByNameIgnoreCase(@PathVariable String department_name) {
        log.info("Recuperando un departamento por Name");
        return departmentService.fetchDepartmentByName(department_name);
    }

    @GetMapping("/getDepartmentByAdress/{department_adress}")
    public List<Department> fetchDepartmentByAdressIgnoreCase(@PathVariable String department_adress) {
        log.info("Recuperando un departamento por Adress");
        return departmentService.fetchDepartmentByAdressIgnoreCase(department_adress);
    }

}
