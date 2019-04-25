package com.io.ba.service;

import com.io.ba.dao.UserEntryDao;
import com.io.ba.dao.UserEntryDaoImpl;
import com.io.ba.model.CustomerDetails;

public class UserEntryServiceImpl implements UserEntryService {
	UserEntryDao ts = new UserEntryDaoImpl();
	public int register(CustomerDetails cd) {
		// TODO Auto-generated method stub
		return ts.register(cd);
	}

	public boolean isAadharNoCorrect(String aadharNo) {
		// TODO Auto-generated method stub
		if(aadharNo.length() == 12)
			return true;
		else
			return false;
	}

	public boolean isMobileNoCorrect(String mobileNo) {
		// TODO Auto-generated method stub
		if(mobileNo.length() == 10)
			return true;
		else
			return false;
	}

	public CustomerDetails login(int id, String password) {
		// TODO Auto-generated method stub
		return ts.login(id, password);
	}
	
	

}
