package kosta.jdbc.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kosta.jdbc.dao.MenuDao;
import kosta.jdbc.dao.WorkerDao;
import kosta.jdbc.dto.Menu;

public class MenuDeleteService implements Service {

	@Override
	public void execute(Scanner sc) {
		
	}
	
	public void execute(Scanner sc, Map<Integer, Integer> wc) {
		// TODO Auto-generated method stub

		List<Menu>list = MenuDao.menuList(wc.get(wc.keySet().hashCode()));
		
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
		
		System.out.println("메뉴 번호를 입력해주세요");
		int result = MenuDao.menuDelete(sc.nextInt());
		
		if(result != 0){
			System.out.println("메뉴 삭제에 성공하셨습니다");
		}else {
			System.out.println("메뉴 삭제에 실패하셨습니다");
		}
		
	}

}
