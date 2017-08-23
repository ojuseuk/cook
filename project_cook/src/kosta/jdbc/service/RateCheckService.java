package kosta.jdbc.service;

import java.util.Map;
import java.util.Scanner;

public class RateCheckService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public void execute(Scanner sc, Map<Integer, Integer> wc) {
		// TODO Auto-generated method stub
		System.out.println("1. 직원평가확인 2. 음식점평가확인");
		int n = sc.nextInt();
		switch(n) {
		case 1 : 
			WorkerRateCheckService workerRateCheck = new WorkerRateCheckService();
			workerRateCheck.execute(sc, wc.keySet().hashCode());
			break;
		case 2 :
			CookRateCheckService cookRateCheck = new CookRateCheckService();
//			System.out.println(wc.get(1));
			cookRateCheck.execute(sc, wc.get(wc.keySet().hashCode()));
			break;
		}

	}
	
}
