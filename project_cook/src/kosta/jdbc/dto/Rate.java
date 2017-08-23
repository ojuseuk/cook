package kosta.jdbc.dto;

import java.util.Date;

public class Rate {
	private int rate_num;
	private String guest_id;
	private int menu_num;
	private int cook_num;
	private int rate_grade;
	private String rate_review;
	private String rate_worker;
	private Date rate_day;
	private String 	cook_name;
	private String menu_name;
	private int ratePirce;
	private int rateMargin;
	
	public Rate() {
		// TODO Auto-generated constructor stub
	}

	public Rate(int rate_num, String guest_id, int menu_num, int cook_num, int rate_grade, String rate_review,
			String rate_worker, Date rate_day) {
		super();
		this.rate_num = rate_num;
		this.guest_id = guest_id;
		this.menu_num = menu_num;
		this.cook_num = cook_num;
		this.rate_grade = rate_grade;
		this.rate_review = rate_review;
		this.rate_worker = rate_worker;
		this.rate_day = rate_day;
	}

	public int getRate_num() {
		return rate_num;
	}

	public void setRate_num(int rate_num) {
		this.rate_num = rate_num;
	}

	public String getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(String guest_id) {
		this.guest_id = guest_id;
	}

	public int getMenu_num() {
		return menu_num;
	}

	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}

	public int getCook_num() {
		return cook_num;
	}

	public void setCook_num(int cook_num) {
		this.cook_num = cook_num;
	}

	public int getRate_grade() {
		return rate_grade;
	}

	public void setRate_grade(int rate_grade) {
		this.rate_grade = rate_grade;
	}

	public String getRate_review() {
		return rate_review;
	}

	public void setRate_review(String rate_review) {
		this.rate_review = rate_review;
	}

	public String getRate_worker() {
		return rate_worker;
	}

	public void setRate_worker(String rate_worker) {
		this.rate_worker = rate_worker;
	}

	public Date getRate_day() {
		return rate_day;
	}

	public void setRate_day(Date rate_day) {
		this.rate_day = rate_day;
	}

	public String getCook_name() {
		return cook_name;
	}

	public void setCook_name(String cook_name) {
		this.cook_name = cook_name;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getRatePirce() {
		return ratePirce;
	}

	public void setRatePirce(int ratePirce) {
		this.ratePirce = ratePirce;
	}

	public int getRateMargin() {
		return rateMargin;
	}

	public void setRateMargin(int rateMargin) {
		this.rateMargin = rateMargin;
	}

	@Override
	public String toString() {
		return "Rate [rate_num=" + rate_num + ", guest_id=" + guest_id + ", menu_num=" + menu_num + ", cook_num="
				+ cook_num + ", rate_grade=" + rate_grade + ", rate_review=" + rate_review + ", rate_worker="
				+ rate_worker + ", rate_day=" + rate_day + ", cook_name=" + cook_name + ", menu_name=" + menu_name
				+ ", ratePirce=" + ratePirce + ", rateMargin=" + rateMargin + "]";
	}

}
