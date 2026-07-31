package com.kkaustubh.hrms.department.service;

import com.kkaustubh.hrms.department.dto.DepartmentRequest;
import com.kkaustubh.hrms.department.dto.DepartmentResponse;
import java.util.List;

public interface DepartmentService {
    DepartmentResponse createDepartment(DepartmentRequest request);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse getDepartmentById(Long id);

    DepartmentResponse updateDepartment(Long id, DepartmentRequest request);

    void deleteDepartment(Long id);
}
