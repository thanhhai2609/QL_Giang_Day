package QLMH;

import java.io.Serializable;
import java.util.*;

public class Major extends Subject implements Serializable {
	public static final String NAMEMJ =  "No name";
	public static final int YEAR = 2000;
	
	private String nameMJ;
	private int year;
	
	public Major() {
		this(Major.MONHOC_ID, Major.MONHOC_NAME, Major.MONHOC_PRICE, Major.MONHOC_CREDITS, Major.NAMEMJ, Major.YEAR);
	}
	public Major(int monhoc_id, String monhoc_name, double monhoc_price, int monhoc_credits, String nameMJ, int year) {
		super(monhoc_id, monhoc_name, monhoc_price, monhoc_credits);
		this.nameMJ = nameMJ;
		this.year = year;
	}

	public String getNameMJ() {
		return nameMJ;
	}
	public void setNameMJ(String nameMJ) {
		this.nameMJ = nameMJ;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return " MonHoc ["+super.toString() + ", nameMJ =" + nameMJ + ", year ="+ year + "]";
	}
	
	public void input() {
		Scanner sc =new Scanner(System.in);
		super.input();
		System.out.println("Type NameMJ: ");
		nameMJ = sc.nextLine();
		System.out.println("Type Year: ");
		year = Integer.parseInt(sc.nextLine());
	}
}
