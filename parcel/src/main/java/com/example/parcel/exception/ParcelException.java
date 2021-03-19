package com.example.parcel.exception;

public class ParcelException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public ParcelException(String errorMesaage) {
		super(errorMesaage);
	}

}
