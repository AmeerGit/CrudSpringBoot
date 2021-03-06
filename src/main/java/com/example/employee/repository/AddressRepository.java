package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
    
}
