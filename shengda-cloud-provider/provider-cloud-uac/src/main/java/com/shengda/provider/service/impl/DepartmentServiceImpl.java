package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.dto.DepartmentDto;
import com.shengda.provider.mapper.DepartmentMapper;
import com.shengda.provider.model.domain.Department;
import com.shengda.provider.model.enums.DepartmentState;
import com.shengda.provider.service.DepartmentService;
import com.shengda.util.CachedBeanCopierUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 * @date 2020-03-23
 */
@Service
@AllArgsConstructor
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    private final DepartmentMapper departmentMapper;

    @Override
    public void add(DepartmentDto departmentDto) {
        Department department = CachedBeanCopierUtils.copyBean(departmentDto, Department.class);
        assert department != null;
        if (department.getParentId() == null) {
            department.setParentId(0L);
        }
        department.setState(DepartmentState.ENABLE.getValue());
        departmentMapper.insert(department);
    }
}
