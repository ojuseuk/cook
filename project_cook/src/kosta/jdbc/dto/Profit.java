package kosta.jdbc.dto;

import java.util.Date;

public class Profit {
	private int profitNum;
	private int cookNum;
	private int profitSales;
	private int profitMargin;
	private Date profitDay;
	private String cookName;
	
	public Profit() {
		// TODO Auto-generated constructor stub
	}

	public Profit(int profitNum, int cookNum, int profitSales, int profitMargin, Date profitDay, String cookName) {
		super();
		this.profitNum = profitNum;
		this.cookNum = cookNum;
		this.profitSales = profitSales;
		this.profitMargin = profitMargin;
		this.profitDay = profitDay;
		this.cookName = cookName;
	}



	public int getProfitNum() {
		return profitNum;
	}

	public void setProfitNum(int profitNum) {
		this.profitNum = profitNum;
	}

	public int getCookNum() {
		return cookNum;
	}

	public void setCookNum(int cookNum) {
		this.cookNum = cookNum;
	}

	public int getProfitSales() {
		return profitSales;
	}

	public void setProfitSales(int profitSales) {
		this.profitSales = profitSales;
	}

	public int getProfitMargin() {
		return profitMargin;
	}

	public void setProfitMargin(int profitMargin) {
		this.profitMargin = profitMargin;
	}

	public Date getProfitDay() {
		return profitDay;
	}

	public void setProfitDay(Date profitDay) {
		this.profitDay = profitDay;
	}

	public String getCookName() {
		return cookName;
	}

	public void setCookName(String cookName) {
		this.cookName = cookName;
	}

	@Override
	public String toString() {
		return "Profit [profitNum=" + profitNum + ", cookNum=" + cookNum + ", profitSales=" + profitSales
				+ ", profitMargin=" + profitMargin + ", profitDay=" + profitDay + ", cookName=" + cookName + "]";
	}

	
}
