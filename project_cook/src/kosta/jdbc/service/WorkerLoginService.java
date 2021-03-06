package kosta.jdbc.service;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import kosta.jdbc.dao.WorkerDao;

public class WorkerLoginService implements Service {

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("직원 번호를 입력해주세요");
		Map<Integer, Integer> map = WorkerDao.workerLogin(sc.nextInt()); // 직원 번호
		
		Set<Integer> key = map.keySet();
		
		for (Integer integer : key) {
			if(integer != 0){
//				System.out.println("직원 로그인 성공");
				
				WorkerLoginMenuService workerLoginMenu = new WorkerLoginMenuService();
				workerLoginMenu.execute(sc, map);
				
				map.remove(0);
				
				
			}else {
				System.out.println("직원 로그인 실패");
			}
		}

		
		
		
	} // end of execute

} // end of class
