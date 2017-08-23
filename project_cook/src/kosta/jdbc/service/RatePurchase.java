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
	
	public void execute(Scanner sc, int menuNum, int cookNum, int ratePrice, String guestId, int rateMargin){

		System.out.println(menuNum + " " + guestId + " " + cookNum + " " + ratePrice);
		int result = RateDao.ratePurchase(menuNum, cookNum, ratePrice, guestId, rateMargin);
		
		if(result == 3){
			System.out.println("구입 성공");
			System.out.println("수익 업데이트");
		}else if(result == 4) {
			System.out.println("구입 성공");
			System.out.println("수익 추가");
		}else {
			System.out.println("구입 실패");
		}
		
	}

}
