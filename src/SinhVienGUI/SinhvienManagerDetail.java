package SinhVienGUI;

import java.io.IOException;
import java.util.*;

import QLSV.Sinhvien;



public class SinhvienManagerDetail extends Sinhvien implements SinhvienManager {
	Scanner sc = new Scanner(System.in);
	
	@Override
	public boolean addSinhvien(Sinhvien c) {
		add(c, SinhvienGUI.list);
		try {
			FileSinhvien.binaryOutputFile(SinhvienGUI.list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public boolean editSinhvien(Sinhvien c) {
		System.out.println("Sinhvien is edit: " + c.getMonhoc_id());
		System.out.println("Type Name: ");
		String newName = sc.nextLine();
		c.setMonhoc_name(newName);
		System.out.println("Type Price: ");
		double newPrice = Double.parseDouble(sc.nextLine());
		c.setMonhoc_price(newPrice);
		System.out.println("Type Total: ");
		int newTotal = Integer.parseInt(sc.nextLine());
		c.setMonhoc_credits(newTotal);
		System.out.println("Type Namesv: ");
		String newNamesv = sc.nextLine();
		c.setNamesv(newNamesv);
		System.out.println("Type Mark: ");
		int newDiem = Integer.parseInt(sc.nextLine());
		c.setMark(newDiem);
		return true;
	}
	@Override
	public boolean delSinhvien(Sinhvien c) {
		for (Sinhvien com : SinhvienGUI.list) {
			if (com.equals(c)) {
				SinhvienGUI.list.remove(c);
				return true;
			}
		}
		return false;
	}
	@Override
	public List<Sinhvien> searchSinhvien(String name) {
		List<Sinhvien> com = new ArrayList<>();
		name = name.toLowerCase();
		for (Sinhvien c : SinhvienGUI.list) {
			if (c.getMonhoc_name().toLowerCase().contains(name))
				com.add(c);
		}
		return com;
	}
	public List<Sinhvien> searchSinhvien(double price) {
		List<Sinhvien> com = new ArrayList<>();
		for (Sinhvien c : SinhvienGUI.list) {
			if (c.getMonhoc_price() == price)
				com.add(c);
		}
		return com;
	}
	public List<Sinhvien> searchSinhvienbyNamesv(String namesv) {
		List<Sinhvien> com = new ArrayList<>();
		for (Sinhvien c : SinhvienGUI.list) {
			if (c.getNamesv().compareToIgnoreCase(namesv) == 0)
				com.add(c);
		}
		return com;
	}
	public List<Sinhvien> searchSinhvienbyDiem(int mark) {
		List<Sinhvien> com = new ArrayList<>();
		for (Sinhvien c : SinhvienGUI.list) {
			if (c.getMark() == mark)
				com.add(c);
		}
		return com;
	}
	@Override
	public List<Sinhvien> sortedSinhvien(double price) {
		List<Sinhvien> com = new ArrayList<>();
		for(Sinhvien c : SinhvienGUI.list) {
			if(c.getMonhoc_price() >= price) {
				com.add(c);
			}
		}
		if(com.isEmpty()) {
			return null;
		} else {
			System.out.println("Type 1: increasing || 2: decreasing");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				Collections.sort(com, new sortedByPrice());
				break;
			case 2:
				Collections.sort(com, new sortedByPrice().reversed());
				break;
			default:
				System.out.println("Type Error!");
		    	break;
			}
		}
		return com;
	}
	public List<Sinhvien> sortedSinhvien(String namesv) {
		List<Sinhvien> com = new ArrayList<>();
		for(Sinhvien c : SinhvienGUI.list) {
			if(c.getNamesv().compareToIgnoreCase(namesv) >= 0) {
				com.add(c);
			}
		}
		if(com.isEmpty()) {
			return null;
		} else {
			System.out.println("Type 1: increasing || 2: decreasing");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				Collections.sort(com, new sortedByNamesv());
				break;
			case 2:
				Collections.sort(com, new sortedByNamesv().reversed());
				break;
			default:
				System.out.println("Type Error!");
		    	break;
			}
		}
		return com;
	}
	public boolean add(Sinhvien c, List<Sinhvien> list) {
		list.add(c);
		return true;
	}
	public int indexOfSinhvien(int id) {
		for (int i = 0; i < SinhvienGUI.list.size(); i++) {
			if (SinhvienGUI.list.get(i).getMonhoc_id() == id)
				return i;
		}
		return -1;
	}
	public boolean checkSinhvien(Sinhvien com, List<Sinhvien> list) {
		for (Sinhvien c : list) {
			if (com.getMonhoc_id() == c.getMonhoc_id()) {
				return true;
			}
		}
		return false;
	}
	public static void printSinhvien(Sinhvien[] com) {
		for(Sinhvien c:com) {
			System.out.println(c);
		}	
	}
	
	public void printSinhvien(List<Sinhvien> com) {
		com.forEach(c -> System.out.println(c));
	}
}
class sortedByPrice implements Comparator<Sinhvien> {

	@Override
	public int compare(Sinhvien c1, Sinhvien c2) {
		return (int) (c1.getMonhoc_price() - c2.getMonhoc_price());
	}
}
class sortedByNamesv implements Comparator<Sinhvien>{

	@Override
	public int compare(Sinhvien c1, Sinhvien c2) {
		String namesv1 = c1.getNamesv();
		String namesv2 = c2.getNamesv();
		
		byte at = (byte)namesv1.lastIndexOf(" ");
		if(at != -1) {
			namesv1 = namesv1.substring(at + 1);
		}
		at = (byte)namesv2.lastIndexOf(" ");
		if(at != -1) {
			namesv2 = namesv2.substring(at + 1);
		}
		return namesv1.compareToIgnoreCase(namesv2);
	}
}

