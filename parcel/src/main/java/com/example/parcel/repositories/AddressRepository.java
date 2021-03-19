package com.example.parcel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.parcel.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
