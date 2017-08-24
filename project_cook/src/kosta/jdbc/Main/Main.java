package kosta.jdbc.Main;

import java.util.InputMismatchException;
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
		int num=0;

		
		while(true){
			System.out.println("1. 고객 로그인 2.고객 회원가입 3. 직원 로그인 4. 직원 회원가입 5. 종료");
			try{
				num = sc.nextInt();

				switch (num) {
				case 1:
					service = new GuestLoginService();
					service.execute(sc);
					break;
				case 2 :
					service = new GuestSignupService();
					service.execute(sc);
					break;
				case 3 :
					service = new WorkerLoginService();
					service.execute(sc);
					break;
				case 4:
					service = new WorkerSignUpService();
					service.execute(sc);
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("1~5사이 숫자를 입력해주세요");
					break;
				}
			
			}catch(InputMismatchException e){
				System.out.println("숫자만 입력해 주세요");
				sc.nextLine();
			}
		}
	}

}
