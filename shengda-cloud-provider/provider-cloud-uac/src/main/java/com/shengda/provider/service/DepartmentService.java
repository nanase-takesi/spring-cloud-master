package com.shengda.provider.service;

import com.shengda.dto.DepartmentDto;
import com.shengda.provider.model.domain.Department;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author takesi
 * @date 2020-03-23
 */
public interface DepartmentService extends IService<Department> {

    /**
     * 新增部门
     *
     * @param departmentDto departmentDto
     */
    void add(DepartmentDto departmentDto);
}
