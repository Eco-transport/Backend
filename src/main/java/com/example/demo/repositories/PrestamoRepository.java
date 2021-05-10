package com.example.demo.repositories;

import com.example.demo.models.PrestamoModel;

import org.springframework.data.repository.CrudRepository;




public interface PrestamoRepository extends CrudRepository<PrestamoModel, Long>{
    
}