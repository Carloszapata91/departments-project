package com.supermarket.demo.repository;

import com.supermarket.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT c FROM Department c WHERE c.department_name = :department_name")  //ORDER BY department_id DESC
    public Department findByDepartmentName(@Param("department_name") String department_name);

    @Query(value="SELECT * FROM Department c WHERE c.department_adress = :department_adress", nativeQuery = true)
    List<Department> finByDepartmentAdress(@Param("department_adress") String departmentAdress);
}
