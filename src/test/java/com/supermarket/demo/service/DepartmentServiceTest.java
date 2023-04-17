package com.supermarket.demo.service;

import com.supermarket.demo.entity.Department;
import com.supermarket.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
       Department department =
                Department.builder()
                        .department_name("IT")
                        .department_adress("Calle falsa 123")
                        .department_code("23234")
                        .department_id(3L)
                        .build();

               Mockito.when(departmentRepository.findByDepartmentName("IT"))
                       .thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on Valida Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        String departmentAdress = "Calle falsa 123";
        String departmentCode =  "23234";
        Long departmentId = (3L);

        Department found =
                departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartment_name());
        assertEquals(departmentAdress, found.getDepartment_adress());
        assertEquals(departmentCode, found.getDepartment_code());
        assertEquals(departmentId, found.getDepartment_id());

    }
}