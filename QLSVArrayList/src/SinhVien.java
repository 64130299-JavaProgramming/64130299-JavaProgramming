
public class SinhVien {
	private String maSV;
	private String hoTen;
	private int tuoi;
	private float dtb;
	
	
	public SinhVien(String maSV, String hoTen, int tuoi, float dtb) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.dtb = dtb;
	}
	


	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public float getDtb() {
		return dtb;
	}
	public void setDtb(float dtb) {
		this.dtb = dtb;
	}


	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoTen=" + hoTen + ", tuoi=" + tuoi + ", dtb=" + dtb + "]";
	}
	
	
	
}
