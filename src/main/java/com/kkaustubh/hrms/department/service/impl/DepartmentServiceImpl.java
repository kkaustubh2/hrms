package com.kkaustubh.hrms.department.service.impl;

import com.kkaustubh.hrms.department.dto.DepartmentRequest;
import com.kkaustubh.hrms.department.dto.DepartmentResponse;
import com.kkaustubh.hrms.department.entity.Department;
import com.kkaustubh.hrms.department.mapper.DepartmentMapper;
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
    public DepartmentResponse createDepartment(DepartmentRequest request) {
        Department department = DepartmentMapper.toEntity(request);

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.toResponse(savedDepartment);
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        return departmentRepository.findAll().stream().map(DepartmentMapper::toResponse).toList();
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow();

        return DepartmentMapper.toResponse(department);
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, DepartmentRequest request) {
        Department department = departmentRepository.findById(id).orElseThrow();

        department.setName(request.getName());

        Department updatedDepartment = departmentRepository.save(department);

        return DepartmentMapper.toResponse(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
