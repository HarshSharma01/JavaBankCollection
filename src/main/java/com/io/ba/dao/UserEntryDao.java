package com.io.ba.dao;

import com.io.ba.model.CustomerDetails;

public interface UserEntryDao {
	int register(CustomerDetails cd);
	CustomerDetails login(int id,String password);
}
