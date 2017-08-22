package kosta.jdbc.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import kosta.jdbc.dao.WorkerDao;
import kosta.jdbc.dto.Profit;

public class MonthProfitCheckService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public void execute(Scanner sc, int workerNum) {
		// TODO Auto-generated method stub
		List<Profit> list = WorkerDao.profitMonthCheck(workerNum);
		
		Iterator<Profit> it = list.iterator();
		System.out.println(" -------------------------------------------");
		while (it.hasNext()) {
			Profit profit = (Profit) it.next();
			
			System.out.printf("| %-10s | %10d | %10s |", profit.getCookName(), profit.getProfitSales(), profit.getProfitDay());
//			System.out.printf("| %-10s | %10d | %10d | %10s |", profit.getCookName(), profit.getProfitSales(), profit.getProfitMargin(), profit.getProfitDay());
			System.out.println();
			System.out.println(" -------------------------------------------");
		}

	}

}
