package com.example.demojpa.repositories;

import com.example.demojpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonRepository extends JpaRepository<Person, Long> , JpaSpecificationExecutor {
}
