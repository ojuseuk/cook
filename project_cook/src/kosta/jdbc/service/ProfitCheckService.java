package kosta.jdbc.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import kosta.jdbc.dao.WorkerDao;
import kosta.jdbc.dto.Profit;

public class ProfitCheckService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public void profitCheck(int workerNum){
		
//		Map<String, List<Profit>> map = WorkerDao.profitCheck(workerNum);
		List<Profit> list = WorkerDao.profitCheck(workerNum);
//		Set<String> key = map.keySet();
		
//		System.out.println(key);
//		for (String list : key) {
//			System.out.println(map.get(list));
//			
//		}
//		
		Iterator<Profit> it = list.iterator();
		int n = 0;
		while (it.hasNext()) {
			Profit profit = (Profit) it.next();
			while (n == 0) {
				System.out.println(" -------------------------");
				System.out.printf("| %-18s ", profit.getCookName());
				for (int i = 0; i < 5 - profit.getCookName().length(); i++) {
					System.out.printf(" ");
				}
				System.out.printf("|\n");
				System.out.println(" -------------------------");
				System.out.printf("| %-5s | %-8s |\n", "일별매출액", "날짜");
				System.out.println(" -------------------------");
				n++;
			}
			System.out.printf("| %10d | %10s |", profit.getProfitSales(), profit.getProfitDay());
//			System.out.format("| %-10s | %10d | %10d | %10s |", profit.getCookName(), profit.getProfitSales(), profit.getProfitMargin(), profit.getProfitDay());
			System.out.println();
			System.out.println(" -------------------------");
		}
	}

}
