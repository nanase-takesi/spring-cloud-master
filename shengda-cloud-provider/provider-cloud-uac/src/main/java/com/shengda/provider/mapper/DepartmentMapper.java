package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shengda.provider.model.domain.Department;
import com.shengda.vo.DepartmentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author takesi
 * @date 2020-03-23
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 查询全部部门
     *
     * @param state state
     * @return List<DepartmentVo>
     */
    List<DepartmentVo> queryAll(@Param("state") Boolean state);

}
