package kosta.jdbc.service;

import java.util.Scanner;

import kosta.jdbc.dao.WorkerDao;
import kosta.jdbc.dto.Menu;

public class MenuInsertService implements Service{

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("번호 입력");
		int num = sc.nextInt();
		System.out.println("음식점 코드 입력");
		int menuNum = sc.nextInt();
		System.out.println("요리 이름 입력");
		String menuName = sc.next();
		System.out.println("판매 가격 입력");
		int menuPrice = sc.nextInt();
		System.out.println("원가 입력");
		int menuFirst = sc.nextInt();
		
		Menu menu = new Menu(num, menuNum, menuName, menuPrice, menuFirst);
		int result = WorkerDao.menuInsert(menu);
		
		if(result != 0){
			System.out.println("메뉴 추가 성공");
		}else {
			System.out.println("메뉴 추가 실패");
		}
		
	}

}
