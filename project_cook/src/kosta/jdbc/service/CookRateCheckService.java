package kosta.jdbc.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import kosta.jdbc.dao.WorkerDao;
import kosta.jdbc.dto.Rate;

public class CookRateCheckService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	public void execute(Scanner sc, int cookNum) {
		// TODO Auto-generated method stub
		List<Rate> list = WorkerDao.cookRateCheck(cookNum);
		
//		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
		Iterator<Rate> it = list.iterator();
		
		int n = 0;
		int n2 = 0;
		while (it.hasNext()) {
			Rate r = it.next();
			while (n == 0) {
				System.out.println(" -------------------------");
				System.out.printf("| %-18s ", r.getCook_name());
				for (int i = 0; i < 5 - r.getCook_name().length(); i++) {
					System.out.printf(" ");
				}
				System.out.printf("|\n");
				System.out.println(" -------------------------");
				System.out.printf("| %3s | %-13s |\n", "평점", "리뷰");
				System.out.println(" -------------------------");
				n++;
			}
			System.out.printf("| %5d | %-15s ", r.getRate_grade(), r.getRate_review());
//			while (n2 == 0) {
//				for (int i = 0; i < 10  - r.getRate_review().length(); i++) {
//					System.out.printf(" ");
//				}
//				n2++;
//			}
			System.out.printf("|\n");
			System.out.println(" -------------------------");
		}

	}

}
