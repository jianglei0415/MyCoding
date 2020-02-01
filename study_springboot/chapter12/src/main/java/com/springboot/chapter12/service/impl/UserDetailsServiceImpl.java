package com.springboot.chapter12.service.impl;

import com.springboot.chapter12.pojo.DatabaseRole;
import com.springboot.chapter12.pojo.DatabaseUser;
import com.springboot.chapter12.service.UserRoleService;
import com.springboot.chapter12.util.Change;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/1 13:41
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRoleService userRoleService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        DatabaseUser dbUser = userRoleService.getUserByName(s);
        List<DatabaseRole> roleList = userRoleService.findRolesByUserName(s);
        return Change.changeToUser(dbUser, roleList);
    }
}
