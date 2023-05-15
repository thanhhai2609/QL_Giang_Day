package QLSV;

import java.io.Serializable;
import java.util.*;

public class Sinhvien extends Monhoc implements Serializable {
	public static final String NAMESV =  "No name";
	public static final int MARK = 0;
	
	private String namesv;
	private int mark;
	
	public Sinhvien() {
		this(Sinhvien.MONHOC_ID, Sinhvien.MONHOC_NAME, Sinhvien.MONHOC_PRICE, Sinhvien.MONHOC_CREDITS, Sinhvien.NAMESV, Sinhvien.MARK);
	}
	public Sinhvien(int monhoc_id, String monhoc_name, double monhoc_price, int monhoc_credits, String namesv, int mark) {
		super(monhoc_id, monhoc_name, monhoc_price, monhoc_credits);
		this.namesv = namesv;
		this.mark = mark;
	}

	public String getNamesv() {
		return namesv;
	}
	public void setNamesv(String namesv) {
		this.namesv = namesv;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return " Sinhvien ["+super.toString() + ", namesv =" + namesv + ", mark ="
				+ mark + "]";
	}
	
	public void input() {
		Scanner sc =new Scanner(System.in);
		super.input();
		System.out.println("Type Namesv: ");
		namesv = sc.nextLine();
		System.out.println("Type Mark: ");
		mark = Integer.parseInt(sc.nextLine());
	}
}
