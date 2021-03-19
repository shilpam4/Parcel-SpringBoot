package com.example.parcel.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.parcel.entities.Address;
import com.example.parcel.entities.Parcel;
import com.example.parcel.entities.Telephone;

@Service
public interface ParcelService {

	List<Parcel> getAllParcels();

	Parcel getParcelById(int parcelId);

	String createParcel(Parcel parcel);

	List<Parcel> getParcelByName(String name);

	String updateAddress(Address address, int parcelId, int addressId);

	String updateTelephone(Telephone telephone, int parcelId, int telephoneId);

	String createAddress(Address address, int parcelId);

	String createTelephone(Telephone telephone, int parcelId);

	String deleteParcel(int parcelId);

	String deleteAddress(int parcelId, int addressId);

	String deleteTelephone(int parcelId, int telephoneId);

//	String updateParcel(int parcelId, Parcel parcel);

}