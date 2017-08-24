package kosta.jdbc.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import kosta.jdbc.dao.GuestDao;

public class GuestLoginService implements Service {

	@Override
	public void execute(Scanner sc) {
		String s = null;
		String guestId = null;
		while (true) {
			System.out.println("아이디, 비밀번호를 입력해주세요");
			
			sc.nextLine();
			guestId = sc.nextLine();
			String guestPwd = sc.next();
			
			s = GuestDao.logIn(guestId, guestPwd);
			
			if ("로그인 성공".equals(s)) {
				break;
			} else {
				System.out.println(s);
			}
		}
		
		int num = 0;
		do{
			try{
				System.out.println("1. 음식점 목록 조회 2. 주문 목록 조회 3. 로그아웃");
				num = sc.nextInt();
				switch (num) {
				case 1:
					CookListService cookList =  new CookListService();
					cookList.execute(sc, guestId);			
					break;
				case 2:
					RateListViewService rateListViewService = new RateListViewService();
					rateListViewService.execute(sc, guestId);
					break;
				case 3:
					System.out.println("로그아웃");
					break;
				default:
					System.out.println("1~3의 숫자를 입력해주세요");
					sc.nextLine();
					break;
				}
			}catch(InputMismatchException e){
				System.out.println("숫자만 입력해주세요");
				sc.nextLine();
			}
		}while(num != 3);

		
	}

}
