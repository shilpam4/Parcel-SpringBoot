package com.example.parcel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import com.example.parcel.entities.Address;
import com.example.parcel.entities.Parcel;
import com.example.parcel.entities.Telephone;
import com.example.parcel.repositories.AddressRepository;
import com.example.parcel.repositories.ParcelRepository;
import com.example.parcel.repositories.TelephoneRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional
public class ParcelServiceImpl implements ParcelService {

	private final ParcelRepository parcelRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	TelephoneRepository telephoneRepository;

	public static final String ParcelERRORMSG = "Parcel_NOT_FOUND";

	@Autowired
	public ParcelServiceImpl(ParcelRepository parcelRepository) {
		this.parcelRepository = parcelRepository;
	}

	@Override
	public List<Parcel> getAllParcels() {
		return this.parcelRepository.findAll();
	}

	@Override
	public Parcel getParcelById(int ParcelId) {
		// return this.ParcelRepository.findById(ParcelId).get();
		return this.parcelRepository.findById(ParcelId).orElse(null);
	}

	@Override
	public List<Parcel> getParcelByName(String name) {
		List<Parcel> ParcelDatabase = this.parcelRepository.findAll();
		List<Parcel> ParcelName = new ArrayList<>();
		for (Parcel p : ParcelDatabase) {
			if (p.getParcelName().equalsIgnoreCase(name)) {
				ParcelName.add(p);
			}
		}
		return ParcelName;
	}

	@Override
	public String createParcel(Parcel Parcel) {
		String msgString = "ID_IS_AUTOGENERATED";
		int defaultId = 0;
		int counter = Parcel.getParcelId();
		for (Address a : Parcel.getAddresses())
			counter += a.getAddressId();
		for (Telephone t : Parcel.getTelephones())
			counter += t.getTelephoneId();
		if (counter != defaultId)
			return "cannot created";
		parcelRepository.save(Parcel);
		msgString = "Parcel is  created and id " + Parcel.getParcelId();
		return msgString;
	}

//	@Override
//	public String updateParcel(int parcelId, Parcel parcel) {
//		List<Parcel> parceldb = parcelRepository.findAll();
//		if (this.parcelRepository.existsById(parcelId)) {
//			for (Parcel p : parceldb) {
//				if (p.getParcelId() == parcelId) {
//					parcel.setParcelId(p.getParcelId());
//					parcel.setParcelName(p.getParcelName());
//					parcel.setOrderedDtm(p.getOrderedDtm());
//					parcel.setAadharOfUser(p.getAadharOfUser());
//					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//					parcel.setLast_modified_dtm(timestamp);
//					this.parcelRepository.save(p);
//					return "created";
//				}
//			}
//		}
//		return helperNotFoundErrorHandler("xyzzyxabcd");
//	}

	@Override
	public String updateAddress(Address address, int parcelId, int addressId) {
		String msgString = "Parcel not allowed to update others address";
		int defaultId = 0;
		Parcel parcel = parcelRepository.findById(parcelId).get();
		if (parcel != null) {
			if (addressRepository.existsById(addressId) && address.getAddressId() == defaultId) {
				List<Address> a = parcel.getAddresses();
				List<Integer> aid = new ArrayList<>(a.size());
				for (Address ad : a)
					aid.add(ad.getAddressId());
				if (aid.contains(addressId)) {
					address.setAddressId(addressId);
					address.setParcel(parcel);
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					address.setLast_modified_dtm(timestamp);
					this.addressRepository.save(address);
				} else {
					return helperUnauthorizedErrorHandler(msgString);
				}
			} else {
				msgString = "Invalid_Address_Details";
				return helperUnauthorizedErrorHandler(msgString);
			}
			msgString = "Address is updated successfully, Address Id " + address.getAddressId();
			return msgString;
		} else {
			return helperNotFoundErrorHandler(ParcelERRORMSG);
		}
	}

	@Override
	public String updateTelephone(Telephone telephone, int ParcelId, int telephoneId) {
		String msgString = "Parcel not allowed to update others telephone";
		int defaultId = 0;
		Parcel Parcel = parcelRepository.findById(ParcelId).get();
		if (Parcel != null) {
			if (telephoneRepository.existsById(telephoneId) && telephone.getTelephoneId() == defaultId) {
				List<Telephone> t = Parcel.getTelephones();
				List<Integer> tid = new ArrayList<>(t.size());
				for (Telephone tl : t)
					tid.add(tl.getTelephoneId());
				if (tid.contains(telephoneId)) {
					telephone.setTelephoneId(telephoneId);
					telephone.setParcel(Parcel);
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					telephone.setLast_modified_dtm(timestamp);
					this.telephoneRepository.save(telephone);
				} else {
					return helperUnauthorizedErrorHandler(msgString);
				}
			} else {
				msgString = "Invalid_Telephone_Details";
				return helperUnauthorizedErrorHandler(msgString);
			}
			msgString = "Telephone is updated successfully, Telephone Id" + telephone.getTelephoneId();
			return msgString;
		} else {
			return helperNotFoundErrorHandler(ParcelERRORMSG);
		}
	}

	@Override
	public String createAddress(Address address, int ParcelId) {
		String msgString = "ID_IS_AUTOGENERATED_CAN'T_BE_UPDATED";
		int defaultId = 0;
		if (address.getAddressId() != defaultId)
			return helperUnauthorizedErrorHandler(msgString);
		if (parcelRepository.existsById(ParcelId)) {
			Parcel Parcel = parcelRepository.findById(ParcelId).get();
			address.setParcel(Parcel);
		} else {
			return helperNotFoundErrorHandler(ParcelERRORMSG);
		}
		this.addressRepository.save(address);
		msgString = "Address is created with id" + address.getAddressId();
		return msgString;
	}

	@Override
	public String createTelephone(Telephone telephone, int parcelId) {
		String msgString = "ID_IS_AUTOGENERATED_CAN'T_BE_UPDATED";
		int defaultId = 0;
		if (telephone.getTelephoneId() != defaultId)
			return helperUnauthorizedErrorHandler(msgString);
		if (parcelRepository.existsById(parcelId)) {
			Parcel Parcel = parcelRepository.findById(parcelId).get();
			telephone.setParcel(Parcel);
		} else {
			return helperNotFoundErrorHandler(ParcelERRORMSG);
		}
		this.telephoneRepository.save(telephone);
		msgString = "telephone is created with id" + telephone.getTelephoneId();
		return msgString;
	}

	@Override
	public String deleteParcel(int parcelId) {
		Parcel Parcel = this.parcelRepository.findById(parcelId).get();

		if (Parcel != null) {
			parcelRepository.delete(Parcel);
			return "Parcel is deleted successfully with " + parcelId;
		}
		return helperNotFoundErrorHandler(ParcelERRORMSG);
	}

	@Override
	public String deleteAddress(int parcelId, int addressId) {
		if (!this.parcelRepository.existsById(parcelId)) {
			return helperNotFoundErrorHandler(ParcelERRORMSG);
		}
		String msgString = "ADDRESS NOT FOUND";
		Address address = this.addressRepository.findById(addressId).get();
		if (address == null || address.getParcel().getParcelId() != parcelId)
			return helperNotFoundErrorHandler(msgString);

		this.addressRepository.deleteById(addressId);
		msgString = "Parcel with Parcel id " + " with address id " + addressId + "is deleted successfully";
		return msgString;
	}

	@Override
	public String deleteTelephone(int parcelId, int telephoneId) {
		if (!this.parcelRepository.existsById(parcelId)) {
			return helperNotFoundErrorHandler(ParcelERRORMSG);
		}
		String msgString = "TELEPHONE NOT FOUND";
		Telephone telephone = this.telephoneRepository.findById(telephoneId).get();
		if (telephone == null || telephone.getParcel().getParcelId() != parcelId)
			return msgString;

		this.telephoneRepository.deleteById(telephoneId);
		msgString = "Parcel with Parcel id " + "with telephone id " + telephoneId + "is deleted successfully";
		return msgString;
	}

	private String helperUnauthorizedErrorHandler(String msgString) {
		return "{\n\t\"errorCode\": 401, \n\t\"message\": \"UNAUTHORIZED ACCESS " + msgString + ":\t\n";
	}

	private String helperNotFoundErrorHandler(String msgString) {
		return "{\n\t\"errorCode\": 404, \n\t\"message\": \"NOT FOUND " + msgString + ":\t\n";
	}
}
