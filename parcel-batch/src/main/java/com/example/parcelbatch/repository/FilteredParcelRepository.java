package com.example.parcelbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.parcelbatch.entities.FilteredParcel;

@Repository
public interface FilteredParcelRepository
		extends JpaRepository<FilteredParcel, Integer>, CrudRepository<FilteredParcel, Integer> {

}
