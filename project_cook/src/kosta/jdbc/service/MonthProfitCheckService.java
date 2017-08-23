package kosta.jdbc.service;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import kosta.jdbc.dao.WorkerDao;
import kosta.jdbc.dto.Profit;

public class MonthProfitCheckService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public void execute(Scanner sc, Map<Integer, Integer> wc) {
		// TODO Auto-generated method stub
//		Map<Integer, Integer> map = WorkerDao.profitMonthCheck(wc.keySet().hashCode());
		
//		System.out.println(wc.get(wc.keySet().hashCode()));
//		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		
		List<Profit> list = WorkerDao.profitMonthCheck(wc.keySet().hashCode());
		Iterator<Profit> it = list.iterator();
		int n = 0;
		while (it.hasNext()) {
			Profit profit = (Profit) it.next();
//			Entry<Integer, Integer> entry = it.next();
			while (n == 0) {
				System.out.println(" -------------------------");
				System.out.printf("| %-18s ", profit.getCookName());
				for (int i = 0; i < 5 - profit.getCookName().length(); i++) {
					System.out.printf(" ");
				}
				System.out.printf("|\n");
				System.out.println(" -------------------------");
				System.out.printf("| %-5s | %9s |\n", "월별매출액", "月");
				System.out.println(" -------------------------");
				n++;
			}
			System.out.printf("| %10d | %10s |", profit.getMonthProfitSum(), profit.getDal());
//			System.out.printf("| %10d | %8d월 |", entry.getKey(), entry.getValue());
//			System.out.printf("| %-10s | %10d | %10s |", profit.getCookName(), profit.getProfitSales(), profit.getProfitDay());
//			System.out.printf("| %-10s | %10d | %10d | %10s |", profit.getCookName(), profit.getProfitSales(), profit.getProfitMargin(), profit.getProfitDay());
			System.out.println();
			System.out.println(" -------------------------");
		}

	}

}
