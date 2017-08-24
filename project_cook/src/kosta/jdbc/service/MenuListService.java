package kosta.jdbc.service;

import java.util.List;
import java.util.Scanner;

import kosta.jdbc.dao.CookDao;
import kosta.jdbc.dao.MenuDao;
import kosta.jdbc.dto.Menu;

public class MenuListService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	public void execute(Scanner sc, String guestId) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("음식점 번호를 선택하세요");
		int num = sc.nextInt();

		List<Menu>list = MenuDao.menuList(num);
		
//		System.out.println(list);
		
		System.out.println("---------------------------------------");
		System.out.printf("| %2s | %-17s | %4s |\n", "번호", "음식명", "가격");
		System.out.println("---------------------------------------");
		
		int a = 1;
		for (Menu m : list) {
			System.out.printf("| %4d ", a++);
			System.out.printf("| %-10s ", m.getMenuName());
			for (int i = 0; i < 10 - m.getMenuName().length(); i++) {
				System.out.printf(" ");
			}
			System.out.printf("| %6d |\n", m.getMenuPrice());
			System.out.println("---------------------------------------");
		}
		System.out.println();
		System.out.println("구입할 메뉴 번호를 선택하세요");
		int number = sc.nextInt();
		int menuNum = list.get(number-1).getMenuNum();
		int cookNum = list.get(number-1).getCookNum();
		int ratePrice = list.get(number-1).getMenuPrice();
		int rateMargin = list.get(number-1).getMenuFirst();
		
		RatePurchase ratePurchase = new RatePurchase();
		ratePurchase.execute(sc, menuNum, cookNum, ratePrice, guestId, rateMargin);
		
	} // end of execute

}
