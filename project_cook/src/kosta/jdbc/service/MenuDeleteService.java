package kosta.jdbc.service;

import java.util.Scanner;

import kosta.jdbc.dao.MenuDao;
import kosta.jdbc.dao.WorkerDao;

public class MenuDeleteService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

		
		System.out.println("메뉴 번호 입력");
		int result = MenuDao.menuDelete(sc.nextInt());
		
		if(result != 0){
			System.out.println("메뉴 삭제 성공");
		}else {
			System.out.println("메뉴 삭제 실패");
		}
		
	}

}
