package com.dio.managerpeoplenapi.repository;

import com.dio.managerpeoplenapi.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
