package com.shengda.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shengda.provider.model.domain.User;
import com.shengda.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author takesi
 * @date 2020-03-27
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * queryByUsername
     *
     * @param username username
     * @return UserVo
     */
    UserVo queryByUsername(@Param("username") String username);

    /**
     * queryByMobile
     *
     * @param mobile mobile
     * @return UserVo
     */
    UserVo queryByMobile(@Param("mobile") String mobile);
}
