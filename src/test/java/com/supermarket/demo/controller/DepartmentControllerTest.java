package com.supermarket.demo.controller;

import com.supermarket.demo.entity.Department;
import com.supermarket.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .department_adress("Calle sin numero")
                .department_code("54552")
                .department_name("Servicios")
                .department_id(4L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        //Se mockea la entrada al endpoint
        Department inputDepartment = Department.builder()
                .department_adress("Calle sin numero")
                .department_code("54552")
                .department_name("Servicios")
                .build();

        //Se mockea la respuesta
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        //Se mockea el endpoint
        mockMvc.perform(MockMvcRequestBuilders.post ("/api/v1/createDepartment")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"department_name\": \"Servicios\",\n" +
                        "        \"department_adress\": \"Calle sin numero\",\n" +
                        "        \"department_code\": 54552\n" +
                        "    }"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentByID() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById( 1L))
            .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get ("/api/v1/getDepartmentById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.department_name")
                .value(department.getDepartment_name()));
    }
}