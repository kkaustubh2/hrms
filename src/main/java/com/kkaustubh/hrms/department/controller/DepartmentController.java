package com.kkaustubh.hrms.department.controller;

import com.kkaustubh.hrms.department.dto.DepartmentRequest;
import com.kkaustubh.hrms.department.dto.DepartmentResponse;
import com.kkaustubh.hrms.department.service.DepartmentService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public DepartmentResponse createDepartment(@RequestBody DepartmentRequest request) {
        return departmentService.createDepartment(request);
    }

    @GetMapping
    public List<DepartmentResponse> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentResponse getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentResponse updateDepartment(
        @PathVariable Long id, @RequestBody DepartmentRequest request) {
        return departmentService.updateDepartment(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
