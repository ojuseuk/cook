package kosta.jdbc.service;

import java.util.Scanner;

import javax.crypto.SecretKey;

import kosta.jdbc.dao.GuestDao;
import kosta.jdbc.dto.Guest;
import kosta.jdbc.security.Conversion;
import kosta.jdbc.security.Encoding;
import kosta.jdbc.security.PasswordSalt;
import kosta.jdbc.security.SecurityKey;

public class GuestSignupService implements Service {

	@Override
	public void execute(Scanner sc) {
		System.out.println("아이디, 비밀번호, 이름, 도시, 시군구, 소지금 입력");
		
//		sc.nextLine();
		String guestId = sc.next();
		String guestPwd = sc.next();
//		sc.nextLine();
		String guestName = sc.next();
		String guestState = sc.next();
		String guestCity = sc.next();
		int guestMoney = sc.nextInt();
		
		// DAO 클래스의 학생정보추가 메소드를 호출
		int result = GuestDao.signUp(new Guest(guestId, guestPwd, guestName, guestState, guestCity, guestMoney));
		
		// 결과 처리
		if(result != 0) {
			System.out.println("고객정보 추가 성공");
		} else {
			System.out.println("고객정보 추가 실패");
		}
		
		

	}

}
