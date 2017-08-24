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

		int result = RateDao.ratePurchase(menuNum, cookNum, ratePrice, guestId, rateMargin);
		
		if(result == 3){
//			System.out.println("구입 성공");
//			System.out.println("음식점 수익이 증가되었습니다.");
		}else if(result == 4) {
//			System.out.println("구입 성공");
//			System.out.println("음식점 수익이 추가되었습니다.");
		}else {
			System.out.println("구입 실패");
		}
		
	}

}
