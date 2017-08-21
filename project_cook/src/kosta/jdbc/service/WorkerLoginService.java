package kosta.jdbc.service;

import java.util.Scanner;

import kosta.jdbc.dao.WorkerDao;

public class WorkerLoginService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("직원 번호를 입력하세요");
		int workerNum = WorkerDao.workerLogin(sc.nextInt()); // 직원 번호
		
		if(workerNum != 0){
			System.out.println("직원 로그인 성공");
		}else {
			System.out.println("직원 로그인 실패");
		}
		
	} // end of execute

} // end of class
