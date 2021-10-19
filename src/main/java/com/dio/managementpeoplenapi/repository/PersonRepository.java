package com.dio.managementpeoplenapi.repository;

import com.dio.managementpeoplenapi.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
