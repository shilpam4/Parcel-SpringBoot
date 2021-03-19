package com.example.parcelbatch.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.example.parcelbatch.entities.FilteredParcel;

public class FilteredParcelRowMapper implements RowMapper<FilteredParcel> {

	@Override
	public FilteredParcel mapRow(ResultSet rs, int rowNum) throws SQLException {
		FilteredParcel filteredParcel = new FilteredParcel();
		filteredParcel.setParcelName(rs.getString("parcel_name"));
		filteredParcel.setOrderedDtm(rs.getDate("ordered_dtm"));
		filteredParcel.setAadharOfUser(rs.getString("aadhar_Of_User"));
		return filteredParcel;
	}

}
