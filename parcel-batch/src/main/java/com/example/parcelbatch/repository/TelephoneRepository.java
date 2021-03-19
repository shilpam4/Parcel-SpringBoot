package com.example.parcelbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.parcelbatch.entities.Telephone;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Integer> {

}
