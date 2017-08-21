package kosta.jdbc.service;

import java.util.Scanner;

import kosta.jdbc.dao.WorkerDao;
import kosta.jdbc.dto.Worker;

public class WorkerSignUpService implements Service{

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("번호입력");
		int workerNum = sc.nextInt();
		System.out.println("음식점 코드 입력");
		int cookNum = sc.nextInt();
		System.out.println("이름 입력");
		String workerName = sc.next();
		System.out.println("월급 입력");
		int wrokerSales = sc.nextInt();
		
		Worker worker = new Worker(workerNum, cookNum, workerName, wrokerSales);
		int result = WorkerDao.workerSignUp(worker);
		
		if(result != 0){
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
	}
	
}