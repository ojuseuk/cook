package kosta.jdbc.service;

import java.util.Scanner;

import kosta.jdbc.dao.MenuDao;
import kosta.jdbc.dao.WorkerDao;
import kosta.jdbc.dto.Menu;

public class MenuInsertService implements Service{

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("메뉴 번호를 입력하세요");
		int num = sc.nextInt();
		System.out.println("음식점 번호 입력를 입력하세요");
		int menuNum = sc.nextInt();
		System.out.println("메뉴 이름을 입력하세요");
		String menuName = sc.next();
		System.out.println("판매 가격을 입력하세요");
		int menuPrice = sc.nextInt();
		System.out.println("원가를 입력하세요");
		int menuFirst = sc.nextInt();
		
		Menu menu = new Menu(num, menuNum, menuName, menuPrice, menuFirst);
		int result = MenuDao.menuInsert(menu);
		
		if(result != 0){
			System.out.println("메뉴 추가 성공");
		}else {
			System.out.println("메뉴 추가 실패");
		}
		
	}

}
