package kr.or.ddit.lprod.vo;

public class LprodVO {
	private int LPROD_ID;
	private String LPROD_GU;
	private String LPROD_NM;
	public int getLPROD_ID() {
		return LPROD_ID;
	}
	public void setLPROD_ID(int lPROD_ID) {
		LPROD_ID = lPROD_ID;
	}
	public String getLPROD_GU() {
		return LPROD_GU;
	}
	public void setLPROD_GU(String lPROD_GU) {
		LPROD_GU = lPROD_GU;
	}
	public String getLPROD_NM() {
		return LPROD_NM;
	}
	public void setLPROD_NM(String lPROD_NM) {
		LPROD_NM = lPROD_NM;
	}
	@Override
	public String toString() {
		return "LprodVO [LPROD_ID=" + LPROD_ID + ", LPROD_GU=" + LPROD_GU + ", LPROD_NM=" + LPROD_NM + "]";
	}
	
	
}
