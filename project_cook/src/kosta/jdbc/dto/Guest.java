package kosta.jdbc.dto;

public class Guest {
	private String guestId;
	private int guestPwd;
	private String guestName;
	private String guestState;
	private String guestCity;
	private int guestMoney;
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		guestId = guestId;
	}
	public int getGuestPwd() {
		return guestPwd;
	}
	public void setGuestPwd(int guestPwd) {
		guestPwd = guestPwd;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		guestName = guestName;
	}
	public String getGuestState() {
		return guestState;
	}
	public void setGuestState(String guestState) {
		guestState = guestState;
	}
	public String getGuestCity() {
		return guestCity;
	}
	public void setGuestCity(String guestCity) {
		guestCity = guestCity;
	}
	public int getGuestMoney() {
		return guestMoney;
	}
	public void setGuestMoney(int guestMoney) {
		guestMoney = guestMoney;
	}
	@Override
	public String toString() {
		return "Guest [GuestId=" + guestId + ", GuestPwd=" + guestPwd + ", GuestName=" + guestName + ", GuestState="
				+ guestState + ", GuestCity=" + guestCity + ", GuestMoney=" + guestMoney + "]";
	}
	public Guest(String guestId, int guestPwd, String guestName, String guestState, String guestCity, int guestMoney) {
		super();
		guestId = guestId;
		guestPwd = guestPwd;
		guestName = guestName;
		guestState = guestState;
		guestCity = guestCity;
		guestMoney = guestMoney;
	}
}
