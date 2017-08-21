package kosta.jdbc.service;

import java.util.Scanner;

import kosta.jdbc.dao.GuestDao;

public class GuestLoginService implements Service {

	@Override
	public void execute(Scanner sc) {
		String s = null;
		
		while (true) {
			System.out.println("아이디, 비밀번호 입력");
			
			sc.nextLine();
			String guestId = sc.nextLine();
			int guestPwd = sc.nextInt();
			
			s = GuestDao.logIn(guestId, guestPwd);
			
			System.out.println(s);
			if ("로그인 성공".equals(s)) {
				break;
			}
		}
	}

}
