package kosta.jdbc.service;

import java.util.List;
import java.util.Scanner;

import kosta.jdbc.dao.CookDao;
import kosta.jdbc.dao.MenuDao;
import kosta.jdbc.dto.Cook;

public class CookListService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	public void execute(Scanner sc, String guestId) {
		List<Cook> list = CookDao.cookList();
//		System.out.println(list);
		
		System.out.println("-------------------------------------------------------------");
		System.out.printf("| %2s | %-16s | %-4s | %-8s | %-3s |\n", "번호", "음식점명", "분류", "도시", "시군구");
		System.out.println("-------------------------------------------------------------");
		
		for (Cook c : list) {
//			System.out.format("%2d | %10s|%3s|%5s|%3s\n", c.getCookNum(), c.getCookName().trim(), c.getCookType().trim(), c.getCookState().trim(), c.getCookCity().trim());
//			System.out.printf("%2d | %-16s | %-3s | %-5s | %-3s\n", c.getCookNum(), c.getCookName(), c.getCookType().trim(), c.getCookState().trim(), c.getCookCity().trim());
			System.out.printf("| %4d ", c.getCookNum());
			System.out.printf("| %-10s ", c.getCookName());
			for (int i = 0; i < 10 - c.getCookName().length(); i++) {
				System.out.printf(" ");
			}
			System.out.printf("| %-3s ", c.getCookType());
			for (int i = 0; i < 3 - c.getCookType().length(); i++) {
				System.out.printf(" ");
			}
			System.out.printf("| %-5s ", c.getCookState());
			for (int i = 0; i < 5 - c.getCookState().length(); i++) {
				System.out.printf(" ");
			}
			System.out.printf("| %-3s ", c.getCookCity());
			for (int i = 0; i < 3 - c.getCookCity().length(); i++) {
				System.out.printf(" ");
			}
			System.out.print("|\n");
			System.out.println("-------------------------------------------------------------");
		}
		
		MenuListService menuList = new MenuListService();
		menuList.execute(sc, guestId);
	}
}
