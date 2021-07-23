package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;
import java.util.*;


@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    /* public UserService( UserRepository userRepository ){
        this.userRepository = userRepository;
    } */

    
    
    public ArrayList<User> findAllUsers(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public User findById( Integer id ){
        return userRepository.findById( id ).orElse( null );
    }





    public User findByUsername( String username ){
        return userRepository.findByUsername( username );
    }

    public User findByEmail( String email){
        return userRepository.findByEmail( email );
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