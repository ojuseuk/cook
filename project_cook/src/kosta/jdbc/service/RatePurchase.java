package kosta.jdbc.service;

import java.util.List;
import java.util.Scanner;

import kosta.jdbc.dao.RateDao;
import kosta.jdbc.dto.Menu;

public class RatePurchase implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public void execute(Scanner sc, int menuNum, int cookNum, int ratePrice, String guestId){

		System.out.println(menuNum + " " + " " + cookNum + " " + ratePrice);
		int result = RateDao.ratePurchase(menuNum, cookNum, ratePrice, guestId);
		
		if(result != 0){
			System.out.println("구입 성공");
		}else {
			System.out.println("구입 실패");
		}
		
	}

}
