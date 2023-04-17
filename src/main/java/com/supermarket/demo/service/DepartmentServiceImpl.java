package com.supermarket.demo.service;

import com.supermarket.demo.entity.Department;
import com.supermarket.demo.repository.DepartmentRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long department_id) throws Exception {
        try{
            var a = departmentRepository.findById(department_id).get();
                    }
        catch(Exception e){
            throw new Exception("Valor de id no encontrado");
        }
        return departmentRepository.findById(department_id).get();
    }

    @Override
    public void deleteDepartmentById(Long department_id) throws Exception {
        try{
            departmentRepository.deleteById(department_id);
        }
        catch(Exception e){
            throw new Exception("Valor de id no encontrado");
        }
    }

    @Override
    public Department updateDepartment(Long department_Id, Department department) throws Exception {
        //Department depDB = departmentRepository.findById(department_Id).get();
        try {
            Department depDB = departmentRepository.findById(department_Id).get();

            if (Objects.nonNull(department.getDepartment_name()) &&
                    !"".equalsIgnoreCase(department.getDepartment_name())) {
                depDB.setDepartment_name(department.getDepartment_name());
            }

            if (Objects.nonNull(department.getDepartment_code()) &&
                    !"".equalsIgnoreCase(department.getDepartment_code())) {
                depDB.setDepartment_code(department.getDepartment_code());
            }

            if (Objects.nonNull(department.getDepartment_adress()) &&
                    !"".equalsIgnoreCase(department.getDepartment_adress())) {
                depDB.setDepartment_adress(department.getDepartment_adress());
            }
        }catch(Exception e){
            throw new Exception("Valor de id no encontrado");
        }
        return departmentRepository.save(departmentRepository.findById(department_Id).get());
    }

    @Override
    public Department fetchDepartmentByName(String department_name) {
        return departmentRepository.findByDepartmentName(department_name);
    }

    @Override
    public List <Department> fetchDepartmentByAdressIgnoreCase(String department_adress) {
        return departmentRepository.finByDepartmentAdress(department_adress);
    }

    @Override
    public List<Department> saveAll(List<Department> departments) {
        return departmentRepository.saveAll(departments);
    }
}
