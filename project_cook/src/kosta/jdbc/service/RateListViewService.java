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
		
		System.out.println(" ---------------------------------------------------------------------------------------");
		System.out.println("| 고객 아이디 | 주문 번호  | 음식점 이름    | 메뉴 이름       | 메뉴 가격  | 주문 날짜  |");
		System.out.println(" ---------------------------------------------------------------------------------------");
		for (Rate r : list) {
//			System.out.format("%2d | %10s|%3s|%5s|%3s\n", c.getCookNum(), c.getCookName().trim(), c.getCookType().trim(), c.getCookState().trim(), c.getCookCity().trim());
//			System.out.printf("%2d | %-16s | %-3s | %-5s | %-3s\n", c.getCookNum(), c.getCookName(), c.getCookType().trim(), c.getCookState().trim(), c.getCookCity().trim());
//			System.out.printf("%s | %d | %s | %s | %d | %s\n", r.getGuest_id(), r.getMenu_num(), r.getMenu_name(), r.getCook_name(), r.getRatePirce(), r.getRate_day());
			System.out.printf("| %-11s", r.getGuest_id());
			System.out.printf(" | %10d", r.getRate_num());
			
			System.out.printf(" | %-10s", r.getMenu_name());
			for (int i = 0; i < 4 - r.getMenu_name().length(); i++) {
				System.out.printf(" ");
			}
			System.out.printf(" | %-10s", r.getCook_name());
			for (int i = 0; i < 5 - r.getCook_name().length(); i++) {
				System.out.printf(" ");
			}
			System.out.printf(" | %10d", r.getRatePirce());
			System.out.printf(" | %-10s |\n", r.getRate_day());
			System.out.println(" ---------------------------------------------------------------------------------------");
//			for (int i = 0; i < 5 - r.getCook_name().length(); i++) {
//				System.out.printf(" ");
//			}
		}
		
		
	}

}
