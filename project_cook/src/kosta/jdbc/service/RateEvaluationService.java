package kosta.jdbc.service;

import java.util.List;
import java.util.Scanner;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import kosta.jdbc.dao.RateDao;
import kosta.jdbc.dto.Worker;

public class RateEvaluationService implements Service {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public void execute(Scanner sc,int cookNum ,int rateNum) {
		// TODO Auto-generated method stub

		System.out.println("평점을 입력해주세요.");
		int rateGrade = sc.nextInt();
		sc.nextLine();
		System.out.println("리뷰를 입력해주세요.");
		String rateReview = sc.nextLine();
		System.out.println("존재하는 직원");
		List<Worker> list = RateDao.workerView(cookNum);
		System.out.println("  -----------------");
		for(Worker w : list){
			System.out.print(" | " + w.getWorkerName());
			
		}
		System.out.println(" | ");
		System.out.println("  -----------------");
		
		System.out.println("직원 이름을 입력해주세요");
		String rateWorker = sc.nextLine();
		String rateWorkerName = "없음";
		for(Worker w : list){
			
			if(w.getWorkerName().equals(rateWorker)){
				rateWorkerName = rateWorker;
			}
		}
		System.out.println("1: " + rateGrade +" "+ rateReview + " " + rateWorkerName + " " + rateNum);
		int result = RateDao.rateEvaluation(rateGrade, rateReview, rateWorkerName, rateNum);
		// 0이면 주문 목록에 데이터가 없는데 입력했을때
		// 1이면 직원 이름을 입력안하고 평점과 리뷰만 넣고 rate를 수정
		// 2이면 직원 이름을 입력했을 때 직원이 존재해서 rate, worker_bonus 수정
		// 3이면 직원 이름을 입력했는데 직원이 존재 하지 않고 rate를 수정
		
		if(result == 0){
			System.out.println("수정 실패");
		}else if(result == 1){
			System.out.println("평점과 리뷰를 작성하셨습니다.");
		}else if(result == 2){
			System.out.println("평점, 리뷰, 직원평가를 작성 하셨습니다");
		}else if(result == 3){
			System.out.println("평점, 리뷰를 작성성공");
			System.out.println("그런 이름의 직원은 존재하지않습니다.");
		}
		
		
	}

}
