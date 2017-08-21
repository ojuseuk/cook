package kosta.jdbc.Main;

import java.util.Scanner;

import kosta.jdbc.service.GuestLoginService;
import kosta.jdbc.service.GuestSignupService;
import kosta.jdbc.service.MenuDeleteService;
import kosta.jdbc.service.MenuInsertService;
import kosta.jdbc.service.Service;
import kosta.jdbc.service.WorkerLoginService;
import kosta.jdbc.service.WorkerSignUpService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("메인");
		
		Scanner sc = new Scanner(System.in);
		Service service = null;
		
		System.out.println("1. 메뉴 추가 2.고객 회원가입 3. 고객 로그인 4. 메뉴 삭제 5. 직원 회원가입 6. 직원 로그인");
		switch (sc.nextInt()) {
		case 1:
			service = new MenuInsertService();
			service.execute(sc);
			break;
		case 2 :
			service = new GuestSignupService();
			service.execute(sc);
			break;
		case 3 :
			service = new GuestLoginService();
			service.execute(sc);
			break;
		case 4:
			service = new MenuDeleteService();
			service.execute(sc);
			break;
		case 5:
			service = new WorkerSignUpService();
			service.execute(sc);
			break;
		case 6:
			service = new WorkerLoginService();
			service.execute(sc);
		default:
			break;
		}
	}

}
