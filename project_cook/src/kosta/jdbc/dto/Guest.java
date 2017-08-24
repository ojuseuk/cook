package kosta.jdbc.dto;

public class Guest {
	private String guestId;
	private String guestPwd;
	private String guestName;
	private String guestState;
	private String guestCity;
	private int guestMoney;
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getGuestPwd() {
		return guestPwd;
	}
	public void setGuestPwd(String guestPwd) {
		this.guestPwd = guestPwd;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestState() {
		return guestState;
	}
	public void setGuestState(String guestState) {
		this.guestState = guestState;
	}
	public String getGuestCity() {
		return guestCity;
	}
	public void setGuestCity(String guestCity) {
		this.guestCity = guestCity;
	}
	public int getGuestMoney() {
		return guestMoney;
	}
	public void setGuestMoney(int guestMoney) {
		this.guestMoney = guestMoney;
	}
	@Override
	public String toString() {
		return "Guest [GuestId=" + guestId + ", GuestPwd=" + guestPwd + ", GuestName=" + guestName + ", GuestState="
				+ guestState + ", GuestCity=" + guestCity + ", GuestMoney=" + guestMoney + "]";
	}
	public Guest(String guestId, String guestPwd, String guestName, String guestState, String guestCity, int guestMoney) {
		super();
		this.guestId = guestId;
		this.guestPwd = guestPwd;
		this.guestName = guestName;
		this.guestState = guestState;
		this.guestCity = guestCity;
		this.guestMoney = guestMoney;
	}
}
