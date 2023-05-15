package GiangvienGUI;

import java.io.IOException;
import java.util.*;

import QLGV.Major;
import GiangvienGUI.GiangvienGUI;



public class GiangvienManagerDetail extends Major implements GiangvienManager {
	Scanner sc = new Scanner(System.in);
	
	@Override
	public boolean addGiangvien(Major c) {
		add(c, GiangvienGUI.list);
		try {
			FileGiangvien.binaryOutputFile(GiangvienGUI.list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public boolean editGiangvien(Major c) {
		System.out.println("Giangvien is edit: " + c.getGiangvien_id());
		System.out.println("Type Name: ");
		String newName = sc.nextLine();
		c.setGiangvien_name(newName);
		System.out.println("Type Price: ");
		double newPrice = Double.parseDouble(sc.nextLine());
		c.setGiangvien_price(newPrice);
		System.out.println("Type Total: ");
		int newTotal = Integer.parseInt(sc.nextLine());
		c.setGiangvien_credits(newTotal);
		System.out.println("Type Namesv: ");
		String newNamesv = sc.nextLine();
		c.setNameMJ(newNamesv);
		System.out.println("Type Year: ");
		int newDiem = Integer.parseInt(sc.nextLine());
		c.setYear(newDiem);
		return true;
	}
	@Override
	public boolean delGiangvien(Major c) {
		for (Major com : GiangvienGUI.list) {
			if (com.equals(c)) {
				GiangvienGUI.list.remove(c);
				return true;
			}
		}
		return false;
	}
	@Override
	public List<Major> searchGiangvien(String name) {
		List<Major> com = new ArrayList<>();
		name = name.toLowerCase();
		for (Major c : GiangvienGUI.list) {
			if (c.getGiangvien_name().toLowerCase().contains(name))
				com.add(c);
		}
		return com;
	}
	public List<Major> searchGiangvien(double price) {
		List<Major> com = new ArrayList<>();
		for (Major c : GiangvienGUI.list) {
			if (c.getGiangvien_price() == price)
				com.add(c);
		}
		return com;
	}
	public List<Major> searchGiangvienbyNameMJ(String namesv) {
		List<Major> com = new ArrayList<>();
		for (Major c : GiangvienGUI.list) {
			if (c.getNameMJ().compareToIgnoreCase(namesv) == 0)
				com.add(c);
		}
		return com;
	}
	public List<Major> searchGiangvienbyNamHoc(int year) {
		List<Major> com = new ArrayList<>();
		for (Major c : GiangvienGUI.list) {
			if (c.getYear() == year)
				com.add(c);
		}
		return com;
	}
	@Override
	public List<Major> sortedGiangvien(double price) {
		List<Major> com = new ArrayList<>();
		for(Major c : GiangvienGUI.list) {
			if(c.getGiangvien_price() >= price) {
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
	public List<Major> sortedGiangvien(String namesv) {
		List<Major> com = new ArrayList<>();
		for(Major c : GiangvienGUI.list) {
			if(c.getNameMJ().compareToIgnoreCase(namesv) >= 0) {
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
				Collections.sort(com, new sortedByNameMJ());
				break;
			case 2:
				Collections.sort(com, new sortedByNameMJ().reversed());
				break;
			default:
				System.out.println("Type Error!");
		    	break;
			}
		}
		return com;
	}
	public boolean add(Major c, List<Major> list) {
		list.add(c);
		return true;
	}
	public int indexOfGiangvien(int id) {
		for (int i = 0; i < GiangvienGUI.list.size(); i++) {
			if (GiangvienGUI.list.get(i).getGiangvien_id() == id)
				return i;
		}
		return -1;
	}
	public boolean checkGiangvien(Major com, List<Major> list) {
		for (Major c : list) {
			if (com.getGiangvien_id() == c.getGiangvien_id()) {
				return true;
			}
		}
		return false;
	}
	public static void printGiangvien(Major[] com) {
		for(Major c:com) {
			System.out.println(c);
		}	
	}
	
	public void printGiangvien(List<Major> com) {
		com.forEach(c -> System.out.println(c));
	}
}
class sortedByPrice implements Comparator<Major> {

	@Override
	public int compare(Major c1, Major c2) {
		return (int) (c1.getGiangvien_price() - c2.getGiangvien_price());
	}
}
class sortedByNameMJ implements Comparator<Major>{

	@Override
	public int compare(Major c1, Major c2) {
		String nameMJ1 = c1.getNameMJ();
		String nameMJ2 = c2.getNameMJ();
		
		byte at = (byte)nameMJ1.lastIndexOf(" ");
		if(at != -1) {
			nameMJ1 = nameMJ1.substring(at + 1);
		}
		at = (byte)nameMJ2.lastIndexOf(" ");
		if(at != -1) {
			nameMJ2 = nameMJ2.substring(at + 1);
		}
		return nameMJ1.compareToIgnoreCase(nameMJ2);
	}
}

