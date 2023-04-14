package com.supermarket.demo.repository;

import com.supermarket.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <Department, Long>{
}
