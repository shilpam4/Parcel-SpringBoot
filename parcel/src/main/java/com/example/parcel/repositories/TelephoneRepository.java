package com.example.parcel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.parcel.entities.Telephone;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Integer> {

}
