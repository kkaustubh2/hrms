package com.kkaustubh.hrms.department.service.impl;

import com.kkaustubh.hrms.department.entity.Department;
import com.kkaustubh.hrms.department.repository.DepartmentRepository;
import com.kkaustubh.hrms.department.service.DepartmentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department existingDepartment = departmentRepository.findById(id).orElse(null);

        if (existingDepartment == null) {
            return null;
        }

        existingDepartment.setName(department.getName());

        return departmentRepository.save(existingDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
