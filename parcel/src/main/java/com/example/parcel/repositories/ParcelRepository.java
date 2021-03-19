package com.example.parcel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.parcel.entities.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Integer>, CrudRepository<Parcel, Integer> {
}
