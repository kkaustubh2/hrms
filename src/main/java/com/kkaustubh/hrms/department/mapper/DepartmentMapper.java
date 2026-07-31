package com.kkaustubh.hrms.department.mapper;

import com.kkaustubh.hrms.department.dto.DepartmentRequest;
import com.kkaustubh.hrms.department.dto.DepartmentResponse;
import com.kkaustubh.hrms.department.entity.Department;

public class DepartmentMapper {
    public static Department toEntity(DepartmentRequest request) {
        return Department.builder().name(request.getName()).build();
    }

    public static DepartmentResponse toResponse(Department department) {
        return DepartmentResponse.builder()
            .id(department.getId())
            .name(department.getName())
            .build();
    }
}
