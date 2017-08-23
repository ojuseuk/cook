package kosta.jdbc.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kosta.jdbc.dao.WorkerDao;
import kosta.jdbc.dto.Profit;

public class MonthMarginCheckService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public void execute(Scanner sc, Map<Integer, Integer> wc) {
		// TODO Auto-generated method stub
		List<Profit> list = WorkerDao.marginMonthCheck(wc.keySet().hashCode());
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
				System.out.printf("| %-5s | %9s |\n", "월별순이익", "月");
				System.out.println(" -------------------------");
				n++;
			}
			int result = 0;
			result = profit.getMonthProfitSum() - profit.getMonthMarginSum() - profit.getWorkerSalesSum();
//			System.out.println(profit.getMonthProfitSum());
//			System.out.println(profit.getMonthMarginSum());
//			System.out.println(profit.getWorkerSalesSum());
			result = result / 2;
			System.out.printf("| %10d | %10s |", result, profit.getDal());
			System.out.println();
			System.out.println(" -------------------------");
		}

	}

}
