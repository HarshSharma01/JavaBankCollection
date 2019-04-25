package com.io.ba.dao;

import java.util.ArrayList;

import com.io.ba.model.CustomerDetails;
import com.io.ba.utility.AadhaarAlreadyExistsException;

public class UserEntryDaoImpl implements UserEntryDao {
	int accNo = 101;
	int transId = 1001;
	static ArrayList<CustomerDetails> customerList = new ArrayList<CustomerDetails>();
	
	public int register(CustomerDetails cd) {
		// TODO Auto-generated method stub
		int c = 0;
		
		for (CustomerDetails customerDetails : customerList) {
	
			if(customerDetails.getAadharNo().equals(cd.getAadharNo())) {
				c++;
			}
				
		}
		
		if(c == 0) {
			cd.setAccountNo(accNo);
			customerList.add(new CustomerDetails(cd.getAccountNo(),cd.getFirstName(),cd.getLastName(),cd.getEmailId(),cd.getPassword(),cd.getPancardNo(),cd.getAadharNo(),cd.getAddress(),cd.getMobileNo(),cd.getBalance()));
			
		}
		else
		{
			try {
				throw new AadhaarAlreadyExistsException();
			} catch (AadhaarAlreadyExistsException e) {
				// TODO Auto-generated catch block

			}
		}
		return accNo++;
	}
		
	public CustomerDetails login(int id, String password) {
		// TODO Auto-generated method stub
		CustomerDetails cd = null;
		for (CustomerDetails customerDetails : customerList) {
			if(customerDetails.getAccountNo() == id && customerDetails.getPassword().equals(password))
			{
				cd = new CustomerDetails();
				cd.setAccountNo(id);
				cd.setFirstName(customerDetails.getFirstName());
				cd.setLastName(customerDetails.getLastName());
				cd.setEmailId(customerDetails.getEmailId());
				cd.setPancardNo(customerDetails.getPancardNo());
				cd.setAadharNo(customerDetails.getAadharNo());
				cd.setAddress(customerDetails.getAddress());
				cd.setMobileNo(customerDetails.getMobileNo());
				cd.setBalance(customerDetails.getBalance());
				break;
			}
		}
		return cd;
	}

	
}
