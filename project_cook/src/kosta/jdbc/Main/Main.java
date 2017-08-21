package kosta.jdbc.Main;

import java.util.Scanner;

import kosta.jdbc.service.MenuInsertService;
import kosta.jdbc.service.Service;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메인");
		
		Scanner sc = new Scanner(System.in);
		Service service = null;
		
		System.out.println("1. 메뉴 추가");
		switch (sc.nextInt()) {
		case 1:
			service = new MenuInsertService();
			service.execute(sc);
			break;

		default:
			break;
		}
	}

}
