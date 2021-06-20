package com.example.demo.auth.service;

import com.example.demo.auth.model.*;
import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service( "userDetailsService" )
public class UserDetailsServiceImpl implements UserDetailsService{

    private UserService userService;

    public UserDetailsServiceImpl( UserService userService ){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername( String username ){
        User user = userService.findByUsername( username );
        if( user == null ){
            throw new UsernameNotFoundException( "" );
        }
        return new UserDetailsImpl( user );
    }

}