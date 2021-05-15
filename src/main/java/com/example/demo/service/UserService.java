package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;


@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    /* public UserService( UserRepository userRepository ){
        this.userRepository = userRepository;
    } */


    public User findByUsername( String username ){
        return userRepository.findByUsername( username );
    }

    public void save( User user ){
        userRepository.save( user );
    }

    public boolean isRightUser( User user ){
        boolean correctness = user.getNames( ) != null && user.getPassword( ) != null && user.getUsername( ) != null &&
                user.getSurnames( ) != null && user.getIdentityNumber( ) != null && user.getEmail( ) != null && user.getUserPhone( ) != null
                && user.getSecurityQuestion( ) != null && user.getSecurityAnswer( ) != null && user.getUserState() != null;
        if( correctness ){
            correctness = !user.getNames( ).trim( ).isEmpty( )
                    && !user.getPassword( ).trim( ).isEmpty( )
                    && !user.getUsername( ).trim( ).isEmpty( )
                    && !user.getSurnames( ).trim( ).isEmpty( )
                    && !user.getIdentityNumber().isEmpty( )
                    && !user.getEmail().isEmpty( )
                    && !user.getUserPhone().isEmpty( )
                    && !user.getSecurityQuestion().isEmpty( )
                    && !user.getSecurityAnswer().isEmpty( )
                    && !user.getUserState().isEmpty( );
        }
        return correctness;
    }

}