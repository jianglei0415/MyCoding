package com.springboot.chapter12.util;

import com.springboot.chapter12.pojo.DatabaseRole;
import com.springboot.chapter12.pojo.DatabaseUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/1 13:45
 */
public class Change {
    public static UserDetails changeToUser(DatabaseUser dbUser, List<DatabaseRole> roleList) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (DatabaseRole role : roleList) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
            authorityList.add(authority);
        }
        UserDetails userDetails = new User(dbUser.getUserName(), dbUser.getPwd(), authorityList);
        return userDetails;

    }
}
