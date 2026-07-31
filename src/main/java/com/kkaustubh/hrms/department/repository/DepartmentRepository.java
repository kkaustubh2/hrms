package com.kkaustubh.hrms.department.repository;

import com.kkaustubh.hrms.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {}
