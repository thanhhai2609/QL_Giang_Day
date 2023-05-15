package QLMH;

import java.io.Serializable;
import java.util.Scanner;

public class Subject implements Serializable {
	public static final int MONHOC_ID = 0;
	public static final String MONHOC_NAME = "No monhoc name";
	public static final double MONHOC_PRICE = 0;
	public static final int MONHOC_CREDITS = 0;
	
	private int monhoc_id;
	private String monhoc_name;
	private double monhoc_price;
	private int monhoc_credits;
	
	public Subject() {
		this(Subject.MONHOC_ID, Subject.MONHOC_NAME, Subject.MONHOC_PRICE, Subject.MONHOC_CREDITS);
	}
	
	public Subject(int monhoc_id, String monhoc_name, double monhoc_price, int monhoc_credits) {
	    this.monhoc_id = monhoc_id;
	    this.monhoc_name = monhoc_name;
	    this.monhoc_price = monhoc_price;
	    this.monhoc_credits = monhoc_credits;
	}

	public int getMonhoc_id() {
		return monhoc_id;
	}

	public void setMonhoc_id(int monhoc_id) {
		this.monhoc_id = monhoc_id;
	}

	public String getMonhoc_name() {
		return monhoc_name;
	}

	public void setMonhoc_name(String monhoc_name) {
		this.monhoc_name = monhoc_name;
	}

	public double getMonhoc_price() {
		return monhoc_price;
	}

	public void setMonhoc_price(double monhoc_price) {
		this.monhoc_price = monhoc_price;
	}

	public int getMonhoc_credits() {
		return monhoc_credits;
	}

	public void setMonhoc_credits(int monhoc_credits) {
		this.monhoc_credits = monhoc_credits;
	}

	@Override
	public String toString() {
		return "monhoc_id=" + monhoc_id + ", monhoc_name=" + monhoc_name + ", monhoc_price="
				+ monhoc_price + ", monhoc_credits=" + monhoc_credits ;
	}
	public void input() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Type ID: ");
		monhoc_id = Integer.parseInt(sc.nextLine());
		System.out.println("Type Name: ");
		monhoc_name = sc.nextLine();
		System.out.println("Type Price: ");
		monhoc_price = Double.parseDouble(sc.nextLine());
		System.out.println("Type Total: ");
		monhoc_credits = Integer.parseInt(sc.nextLine());
	}
}
