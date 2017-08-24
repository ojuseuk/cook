package kosta.jdbc.dto;

public class Worker {
	private int workerNum;
	private int cookNum;
	private String workerName;
	private int workerSales;
	private int workerBonus;
	
	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public Worker(int cookNum, String workerName, int workerSales) {
		super();
		this.cookNum = cookNum;
		this.workerName = workerName;
		this.workerSales = workerSales;
	}

	public int getWorkerNum() {
		return workerNum;
	}

	public void setWorkerNum(int workerNum) {
		this.workerNum = workerNum;
	}

	public int getCookNum() {
		return cookNum;
	}

	public void setCookNum(int cookNum) {
		this.cookNum = cookNum;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public int getWorkerSales() {
		return workerSales;
	}

	public void setWorkerSales(int workerSales) {
		this.workerSales = workerSales;
	}

	public int getWorkerBonus() {
		return workerBonus;
	}

	public void setWorkerBonus(int workerBonus) {
		this.workerBonus = workerBonus;
	}

	@Override
	public String toString() {
		return "Worker [workerNum=" + workerNum + ", cookNum=" + cookNum + ", workerName=" + workerName
				+ ", workerSales=" + workerSales + ", workerBonus=" + workerBonus + "]";
	}
	
}
