package com.study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.dao.ITransaction1Dao;
import com.study.spring.dao.ITransaction2Dao;

@Service
public class BuyTicketService implements IBuyTicketService {

	@Autowired
	ITransaction1Dao transaction1;
	@Autowired
	ITransaction2Dao transaction2;

	@Override
	public int buy(String consumerId, int amount, String error) {

		try {
			transaction1.pay(consumerId, amount);

			transaction2.pay(consumerId, amount);
			
			return 1;
		} catch(Exception e) {
			return 0;
		}
	}

}