package kosta.jdbc.dto;

public class Menu {
	private int menuNum;
	private int cookNum;
	private String menuName;
	private int menuPrice;
	private	int menuFirst;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	public Menu(int menuNum, int cookNum, String menuName, int menuPrice, int menuFirst) {
		super();
		this.menuNum = menuNum;
		this.cookNum = cookNum;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuFirst = menuFirst;
	}
	public Menu(int menuNum, String menuName, int menuPrice) {
		super();
		this.menuNum = menuNum;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	public int getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(int menuNum) {
		this.menuNum = menuNum;
	}

	public int getCookNum() {
		return cookNum;
	}

	public void setCookNum(int cookNum) {
		this.cookNum = cookNum;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public int getMenuFirst() {
		return menuFirst;
	}

	public void setMenuFirst(int menuFirst) {
		this.menuFirst = menuFirst;
	}

	@Override
	public String toString() {
		return "Menu [menuNum=" + menuNum + ", cookNum=" + cookNum + ", menuName=" + menuName + ", menuPrice="
				+ menuPrice + ", menuFirst=" + menuFirst + "]";
	}
	
}
