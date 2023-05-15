package QLGV;

import java.io.Serializable;
import java.util.*;

public class Major extends Teacher implements Serializable {
	public static final String NAMEMJ =  "No name";
	public static final int YEAR = 2000;
	
	private String nameMJ;
	private int year;
	
	public Major() {
		this(Major.GIANGVIEN_ID, Major.GIANGVIEN_NAME, Major.GIANGVIEN_PRICE, Major.GIANGVIEN_CREDITS, Major.NAMEMJ, Major.YEAR);
	}
	public Major(int giangvien_id, String giangvien_name, double giangvien_price, int giangvien_credits, String nameMJ, int year) {
		super(giangvien_id, giangvien_name, giangvien_price, giangvien_credits);
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
		return " GiangVien ["+super.toString() + ", nameMJ =" + nameMJ + ", year ="+ year + "]";
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
