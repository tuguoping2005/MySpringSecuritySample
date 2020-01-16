package com.funtl.oauth2.server.config.service;

import com.funtl.oauth2.server.domain.TbPermission;
import com.funtl.oauth2.server.domain.TbUser;
import com.funtl.oauth2.server.service.TbPermissionService;
import com.funtl.oauth2.server.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    TbUserService userService;

    @Autowired
    TbPermissionService permissionService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser tbUser = userService.getByUsername(username);

        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();

        if (tbUser !=null){
            List<TbPermission> tbPermissions = permissionService.selectByUserId(tbUser.getId());

            for (TbPermission p: tbPermissions) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(p.getEnname());
                grantedAuthorities.add(grantedAuthority);
            }
        }

        return new User(tbUser.getUsername(),tbUser.getPassword(),grantedAuthorities);
    }
}
