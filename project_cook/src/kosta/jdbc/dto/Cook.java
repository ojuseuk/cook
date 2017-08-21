package kosta.jdbc.dto;

public class Cook {
	private int cookNum;
	private String cookName;
	private String cookType;
	private String cookState;
	private String cookCity;
	public Cook(int cookNum, String cookName, String cookType, String cookState, String cookCity) {
		super();
		this.cookNum = cookNum;
		this.cookName = cookName;
		this.cookType = cookType;
		this.cookState = cookState;
		this.cookCity = cookCity;
	}
	@Override
	public String toString() {
		return "Cook [cookNum=" + cookNum + ", cookName=" + cookName + ", cookType=" + cookType + ", cookState="
				+ cookState + ", cookCity=" + cookCity + "]";
	}
	public int getCookNum() {
		return cookNum;
	}
	public void setCookNum(int cookNum) {
		this.cookNum = cookNum;
	}
	public String getCookName() {
		return cookName;
	}
	public void setCookName(String cookName) {
		this.cookName = cookName;
	}
	public String getCookType() {
		return cookType;
	}
	public void setCookType(String cookType) {
		this.cookType = cookType;
	}
	public String getCookState() {
		return cookState;
	}
	public void setCookState(String cookState) {
		this.cookState = cookState;
	}
	public String getCookCity() {
		return cookCity;
	}
	public void setCookCity(String cookCity) {
		this.cookCity = cookCity;
	}

}
