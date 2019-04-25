package com.io.ba.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.io.ba.dao.TransactionDaoImpl;
import com.io.ba.dao.UserEntryDaoImpl;
import com.io.ba.model.CustomerDetails;

class UserEntryDaoImplTest {

	static UserEntryDaoImpl user;
	static CustomerDetails cd;
	static TransactionDaoImpl td;
	static int accNo1;
	static int accNo2;

	@BeforeAll
	public static void init() {
		td = new TransactionDaoImpl();
		user = new UserEntryDaoImpl();
		cd = new CustomerDetails();
		cd.setFirstName("Kunal");
		cd.setLastName("Sharma");
		cd.setEmailId("kunal@mail.com");
		cd.setPassword("kunal");
		cd.setPancardNo(1234345L);
		cd.setAadharNo("234567890125");
		cd.setAddress("hyd");
		cd.setMobileNo("9160749833");
		cd.setBalance(1000);
		accNo1 = user.register(cd);
		cd.setFirstName("Kavya");
		cd.setLastName("Sharma");
		cd.setEmailId("kavya");
		cd.setPassword("kavya");
		cd.setPancardNo(1234345L);
		cd.setAadharNo("234567890126");
		cd.setAddress("hyd");
		cd.setMobileNo("9160749833");
		cd.setBalance(0);
		accNo2 = user.register(cd);
	}

	@Test
	void testRegister() {
		cd.setFirstName("Dinesh");
		cd.setLastName("Sharma");
		cd.setEmailId("dinesh");
		cd.setPassword("dinesh");
		cd.setPancardNo(1234345L);
		cd.setAadharNo("234567890129");
		cd.setAddress("hyd");
		cd.setMobileNo("9160749833");
		cd.setBalance(0);
		int id = user.register(cd);
		assertEquals(103, id);
	}

	@Test
	void testLogin() {
		CustomerDetails c = new CustomerDetails();
		c = user.login(101, "kunal");
		assertEquals(accNo1, c.getAccountNo());
	}

	@Test
	void testWithdraw() {
		assertEquals(700, td.withdraw(accNo1, 300, 1000));
	}

	@Test
	void testDeposit() {
		assertEquals(1300, td.deposit(accNo1, 300, 1000));
	}

	@Test
	void testFundTransfer() {
		
		assertEquals(900, td.fundTransfer(accNo1, accNo2, 100));
	}

}
