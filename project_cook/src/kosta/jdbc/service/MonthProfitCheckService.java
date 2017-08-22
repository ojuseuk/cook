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
		Map<Integer, Integer> map = WorkerDao.profitMonthCheck(wc.keySet().hashCode());
		
//		System.out.println(wc.get(wc.keySet().hashCode()));
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		System.out.println(" -------------------------------------------");
		while (it.hasNext()) {
//			Profit profit = (Profit) it.next();
			Entry<Integer, Integer> entry = it.next();
			
			System.out.printf("| %10d | %2d월 |", entry.getKey(), entry.getValue());
//			System.out.printf("| %-10s | %10d | %10s |", profit.getCookName(), profit.getProfitSales(), profit.getProfitDay());
//			System.out.printf("| %-10s | %10d | %10d | %10s |", profit.getCookName(), profit.getProfitSales(), profit.getProfitMargin(), profit.getProfitDay());
			System.out.println();
			System.out.println(" -------------------------------------------");
		}

	}

}
