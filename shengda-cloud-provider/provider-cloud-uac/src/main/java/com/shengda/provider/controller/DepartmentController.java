package com.shengda.provider.controller;

import com.shengda.base.wrapper.WrapMapper;
import com.shengda.base.wrapper.Wrapper;
import com.shengda.core.support.BaseController;
import com.shengda.dto.DepartmentDto;
import com.shengda.dto.DepartmentUpdateDto;
import com.shengda.provider.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author takesi
 * @date 2020-03-24
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/department")
public class DepartmentController extends BaseController {

    private final DepartmentService departmentService;

    /**
     * 查询部门树形列表
     *
     * @return Wrapper
     */
    @GetMapping(value = "/list")
    public Wrapper listDepartment() {
        return WrapMapper.ok();
    }

    /**
     * 查询部门及员工列表
     *
     * @return
     */
    @GetMapping(value = "/employee/list")
    public Wrapper listDepartmentEmployee() {
        return WrapMapper.ok();
    }

    /**
     * 根据部门名称查询部门及员工列表
     *
     * @param name departmentName
     * @return
     */
    @GetMapping(value = "/{name}/employee/list")
    public Wrapper listDepartmentEmployee(@PathVariable String name) {
        return WrapMapper.ok();
    }

    @PostMapping(value = "/add")
    public Wrapper addDepartment(@RequestBody DepartmentDto departmentDto) {
        departmentService.add(departmentDto);
        return WrapMapper.ok();
    }

    @PutMapping(value = "/update")
    public Wrapper updateDepartment(@RequestBody DepartmentUpdateDto departmentUpdateDto) {
        return WrapMapper.ok();
    }

    @DeleteMapping(value = "/{id}/delete")
    public Wrapper deleteDepartment(@PathVariable Long id) {
        return WrapMapper.ok();
    }

}
