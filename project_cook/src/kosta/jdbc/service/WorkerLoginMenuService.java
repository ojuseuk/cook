package kosta.jdbc.service;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class WorkerLoginMenuService implements Service {
	@Override
	public void execute(Scanner sc) {
	
	}
	
	public void execute(Scanner sc, Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		
//		System.out.println();
		int n =0;
		do{
			try{
				System.out.println("1. 매출확인 2. 평가확인 3. 메뉴추가 4. 메뉴삭제 5. 기본화면으로");
				n = sc.nextInt();
				
				switch(n) {
				case 1 :
					int n2 = 0;
					do{
						try{
							System.out.println("1. 일별매출액 2. 월별매출액 3. 월별순이익 4. 뒤로가기");
							n2 = sc.nextInt();
						
							switch(n2) {
							case 1 : 
								ProfitCheckService pcs = new ProfitCheckService();
								pcs.profitCheck(map.keySet().hashCode());
								break;
							case 2 :
								MonthProfitCheckService monthProfitCheck = new MonthProfitCheckService();
								monthProfitCheck.execute(sc, map);
								break;
							case 3 :
								MonthMarginCheckService monthMarginCheck = new MonthMarginCheckService();
								monthMarginCheck.execute(sc, map);
								break;
							case 4:
								System.out.println("뒤로가기");
								break;
							default:
								System.out.println("1~4까지 숫자만 입력해주세요");
								break;
							}
							}catch(InputMismatchException e){
								System.out.println("숫자만 입력해주세요");
								sc.nextLine();
							}
						}while(n2 != 4);
					break;
				case 2 :
					RateCheckService rateCheck = new RateCheckService();
					rateCheck.execute(sc, map);
					break;
				case 3 :
					MenuInsertService menuInsert = new MenuInsertService();
					menuInsert.execute(sc);
					break;
				case 4 :
					MenuDeleteService menuDelete = new MenuDeleteService();
					menuDelete.execute(sc, map);
					break;
				case 5:
					System.out.println("기본화면으로");
					break; 
				default:
					System.out.println("1~4까지 숫자만 입력해주세요");
					break;
				}
			}catch(InputMismatchException e){
				System.out.println("숫자만 입력해주세요");
				sc.nextLine();
			}
	
		}while(n != 5);
	}
}
