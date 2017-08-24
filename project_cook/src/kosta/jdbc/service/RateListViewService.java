package kosta.jdbc.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import kosta.jdbc.dao.RateDao;
import kosta.jdbc.dto.Cook;
import kosta.jdbc.dto.Rate;

public class RateListViewService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public void execute(Scanner sc, String guestId){
		
		List<Rate> list = RateDao.rateListView(guestId);
		
//		Iterator<Rate> it = list.iterator();
		
		System.out.println(" ------------------------------------------------------------------------------------------");
		System.out.println("| 고객 아이디 |  주문 번호 | 메뉴 이름         | 음식점 이름     |  메뉴 가격 |  주문 날짜 |");
		System.out.println(" ------------------------------------------------------------------------------------------");
		for (Rate r : list) {
			System.out.printf("| %-11s", r.getGuest_id());
			System.out.printf(" | %10d", r.getRate_num());
			
			System.out.printf(" | %-10s", r.getMenu_name());
			for (int i = 0; i < 7 - r.getMenu_name().length(); i++) {
				System.out.printf(" ");
			}
			System.out.printf(" | %-10s", r.getCook_name());
			for (int i = 0; i < 5 - r.getCook_name().length(); i++) {
				System.out.printf(" ");
			}
			System.out.printf(" | %10d", r.getRatePirce());
			System.out.printf(" | %-10s |\n", r.getRate_day());
			System.out.println(" ------------------------------------------------------------------------------------------");
		}
		
		System.out.print("평가할 주문번호 입력해주세요 : ");
		int num = sc.nextInt();
		
		int cookNum = 0;
		int rateNum = 0;
		for(Rate r : list){
			
			if(r.getRate_num() == num){
				cookNum = r.getCook_num();
				rateNum = r.getRate_num();
			}
		}
		
		RateEvaluationService rateEvaluationService = new RateEvaluationService();
		rateEvaluationService.execute(sc, cookNum, rateNum);
		
		
	} // end of execute

} //end of class
