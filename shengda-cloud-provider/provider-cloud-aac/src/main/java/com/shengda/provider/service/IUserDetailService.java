package com.shengda.provider.service;

import com.shengda.core.exception.MobileNotFountException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author takesi
 * @date 2020-03-27
 */
public interface IUserDetailService extends UserDetailsService {

    /**
     * loadUserByMobile
     *
     * @param mobile mobile
     * @return UserDetails
     * @throws MobileNotFountException mobileNotFountException
     */
    UserDetails loadUserByMobile(String mobile) throws MobileNotFountException;

}
