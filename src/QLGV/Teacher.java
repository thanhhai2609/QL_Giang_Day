package QLGV;

import java.io.Serializable;
import java.util.Scanner;


public class Teacher implements Serializable {
	public static final int GIANGVIEN_ID = 0;
	public static final String GIANGVIEN_NAME = "No giangvien name";
	public static final double GIANGVIEN_PRICE = 0;
	public static final int GIANGVIEN_CREDITS = 0;
	
	private int giangvien_id;
	private String giangvien_name;
	private double giangvien_price;
	private int giangvien_credits;
	
	public Teacher() {
		this(Teacher.GIANGVIEN_ID, Teacher.GIANGVIEN_NAME, Teacher.GIANGVIEN_PRICE, Teacher.GIANGVIEN_CREDITS);
	}
	
	public Teacher(int giangvien_id, String giangvien_name, double giangvien_price, int giangvien_credits) {
	    this.giangvien_id = giangvien_id;
	    this.giangvien_name = giangvien_name;
	    this.giangvien_price = giangvien_price;
	    this.giangvien_credits = giangvien_credits;
	}

	public int getGiangvien_id() {
		return giangvien_id;
	}

	public void setGiangvien_id(int giangvien_id) {
		this.giangvien_id = giangvien_id;
	}

	public String getGiangvien_name() {
		return giangvien_name;
	}

	public void setGiangvien_name(String giangvien_name) {
		this.giangvien_name = giangvien_name;
	}

	public double getGiangvien_price() {
		return giangvien_price;
	}

	public void setGiangvien_price(double giangvien_price) {
		this.giangvien_price = giangvien_price;
	}

	public int getGiangvien_credits() {
		return giangvien_credits;
	}

	public void setGiangvien_credits(int giangvien_credits) {
		this.giangvien_credits = giangvien_credits;
	}

	@Override
	public String toString() {
		return "giangvien_id=" + giangvien_id + ", giangvien_name=" + giangvien_name + ", giangvien_price="
				+ giangvien_price + ", giangvien_credits=" + giangvien_credits ;
	}
	public void input() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Type ID: ");
		giangvien_id = Integer.parseInt(sc.nextLine());
		System.out.println("Type Name: ");
		giangvien_name = sc.nextLine();
		System.out.println("Type Price: ");
		giangvien_price = Double.parseDouble(sc.nextLine());
		System.out.println("Type Total: ");
                giangvien_credits = Integer.parseInt(sc.nextLine());
	}
}
