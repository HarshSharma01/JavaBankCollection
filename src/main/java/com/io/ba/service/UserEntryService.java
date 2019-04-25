package com.io.ba.service;

import com.io.ba.model.CustomerDetails;

public interface UserEntryService {
	int register(CustomerDetails cd);
	boolean isAadharNoCorrect(String aadharNo);
	boolean isMobileNoCorrect(String mobileNo);
	CustomerDetails login(int id,String password);
}
