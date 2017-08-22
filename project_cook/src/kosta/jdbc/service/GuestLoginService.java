package kosta.jdbc.service;

import java.util.Scanner;

import kosta.jdbc.dao.GuestDao;

public class GuestLoginService implements Service {

	@Override
	public void execute(Scanner sc) {
		String s = null;
		String guestId = null;
		while (true) {
			System.out.println("아이디, 비밀번호 입력");
			
			sc.nextLine();
			guestId = sc.nextLine();
			int guestPwd = sc.nextInt();
			
			s = GuestDao.logIn(guestId, guestPwd);
			
			if ("로그인 성공".equals(s)) {
				break;
			} else {
				System.out.println(s);
			}
		}
		
		
		System.out.println("1. 음식점 목록 보기, 2. 주문 목록 조회");
		switch (sc.nextInt()) {
		case 1:
			CookListService cookList =  new CookListService();
			cookList.execute(sc, guestId);			
			break;
		case 2:
			RateListViewService rateListViewService = new RateListViewService();
			rateListViewService.execute(sc, guestId);
			break;
		default:
			break;
		}

		
	}

}
