package kosta.jdbc.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import kosta.jdbc.dao.WorkerDao;

public class WorkerRateCheckService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public void execute(Scanner sc, int workerNum) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = WorkerDao.workerRateCheck(workerNum);
		
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
		
		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			System.out.println(" ---------------------");
			System.out.printf("| %-6s | %3s |\n", "이름", "추천횟수");
			System.out.println(" ---------------------");
			System.out.printf("| %-5s | %8d |\n", entry.getKey(), entry.getValue());
			System.out.println(" ---------------------");
		}

	}

}
