package com.example.parcelbatch.config;

import java.sql.Timestamp;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.parcelbatch.entities.Address;
import com.example.parcelbatch.entities.FilteredParcel;
import com.example.parcelbatch.entities.Parcel;
import com.example.parcelbatch.entities.Telephone;
import com.example.parcelbatch.repository.ParcelRepository;

@Component
public class FilteredParcelProcessor implements ItemProcessor<FilteredParcel, FilteredParcel>, StepExecutionListener {

	private Logger logger = LoggerFactory.getLogger(FilteredParcelProcessor.class);

	@Autowired
	private ParcelRepository parcelRepository;

	@Override
	public void beforeStep(StepExecution stepExecution) {
		logger.debug("FilteredParcel Processor Intialize");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		logger.debug("FilteredParcel Processor completed");
		return ExitStatus.COMPLETED;
	}

	@Override
	public FilteredParcel process(FilteredParcel item) throws Exception {
		if (item == null)
			return null;
		List<Parcel> p = parcelRepository.findAll();
		Timestamp ats = null, tts = null;

		for (int i = 0; i < p.size(); i++) {
			if (item.getParcelName().equalsIgnoreCase(p.get(i).getParcelName())
					&& item.getOrderedDtm().compareTo(p.get(i).getOrderedDtm()) == 0
					&& item.getAadharOfUser().equalsIgnoreCase(p.get(i).getAadharOfUser())) {
				Address a = latestAddress(p.get(i).getAddresses());
				Telephone t = latestTelephone(p.get(i).getTelephones());
				if (a != null) {
					if (ats == null || a.getLast_modified_dtm().after(ats)) {
						ats = a.getLast_modified_dtm();
						item.setStreet(a.getStreet());
						item.setCountry(a.getCountry());
						item.setState(a.getState());
						item.setCity(a.getCity());
						item.setFlatno(a.getFlatno());
					}
				}
				if (t != null) {
					if (tts == null || t.getLast_modified_dtm().after(tts)) {
						tts = t.getLast_modified_dtm();
						item.setArea_code(t.getArea_code());
						item.setCountry_code(t.getCountry_code());
						item.setCntrl_number(t.getCntrl_number());
						item.setUnique_number(t.getUnique_number());
					}
				}
			}
		}

		logger.debug("process records for parcel" + item.toString());
		return item;
	}

	private Address latestAddress(List<Address> addresses) {
		if (addresses.isEmpty()) {
			return null;
		}
		Address latestAddress = addresses.get(0);
		for (int i = 1; i < addresses.size(); i++) {
			if (addresses.get(i).getLast_modified_dtm().after(latestAddress.getLast_modified_dtm())) {
				latestAddress = addresses.get(i);
			}
		}
		return latestAddress;
	}

	private Telephone latestTelephone(List<Telephone> telephones) {
		if (telephones.isEmpty()) {
			return null;}
		Telephone latestTelephone = telephones.get(0);
		for (int i = 1; i < telephones.size(); i++) {
			if (telephones.get(i).getLast_modified_dtm().after(latestTelephone.getLast_modified_dtm())) {
				latestTelephone = telephones.get(i);
			}
		}
		return latestTelephone;
	}

}
