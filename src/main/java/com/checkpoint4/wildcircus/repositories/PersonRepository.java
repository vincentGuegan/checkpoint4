package com.checkpoint4.wildcircus.repositories;

import com.checkpoint4.wildcircus.entities.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{

}