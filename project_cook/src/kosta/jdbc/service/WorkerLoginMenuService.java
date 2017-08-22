package kosta.jdbc.service;

import java.util.Map;
import java.util.Scanner;

public class WorkerLoginMenuService implements Service {
	@Override
	public void execute(Scanner sc) {
	
	}
	
	public void execute(Scanner sc, Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		
		System.out.println();
		System.out.println("1. 매출확인 2. 평가확인 3. 메뉴추가 4. 메뉴삭제");
		int n = sc.nextInt();
		
		switch(n) {
		case 1 : 
			System.out.println("1. 일별매출액 2. 월별매출액 3. 월별 순이익");
			int n2 = sc.nextInt();
			
			switch(n2) {
			case 1 : 
				ProfitCheckService pcs = new ProfitCheckService();
				pcs.profitCheck(map.keySet().hashCode());
				break;
			case 2 :
				MonthProfitCheckService monthProfitCheck = new MonthProfitCheckService();
				monthProfitCheck.execute(sc, map.get(1));
				break;
			case 3 :
				MonthMarginCheckService monthMarginCheck = new MonthMarginCheckService();
				monthMarginCheck.execute(sc, map.get(1));
				break;
			}
			break;
		case 2 :
			
			break;
		case 3 :
			MenuInsertService menuInsert = new MenuInsertService();
			menuInsert.execute(sc);
			break;
		case 4 :
			MenuDeleteService menuDelete = new MenuDeleteService();
			menuDelete.execute(sc);
			break;
		}
		

	}

}
