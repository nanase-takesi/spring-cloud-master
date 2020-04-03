package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shengda.provider.model.domain.Role;
import com.shengda.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author takesi
 * @date 2020-03-27
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * queryByUserId
     *
     * @param userId userId
     * @return List<RoleVo>
     */
    List<RoleVo> queryByUserId(@Param("userId") Long userId);

}
