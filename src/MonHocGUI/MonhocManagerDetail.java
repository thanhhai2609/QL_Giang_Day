package MonHocGUI;

import java.io.IOException;
import java.util.*;

import QLMH.Major;
import MonHocGUI.MonHocGUI;



public class MonhocManagerDetail extends Major implements MonhocManager {
	Scanner sc = new Scanner(System.in);
	
	@Override
	public boolean addMonhoc(Major c) {
		add(c, MonHocGUI.list);
		try {
			FileMonhoc.binaryOutputFile(MonHocGUI.list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public boolean editMonhoc(Major c) {
		System.out.println("Monhoc is edit: " + c.getMonhoc_id());
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
		c.setNameMJ(newNamesv);
		System.out.println("Type Year: ");
		int newDiem = Integer.parseInt(sc.nextLine());
		c.setYear(newDiem);
		return true;
	}
	@Override
	public boolean delMonhoc(Major c) {
		for (Major com : MonHocGUI.list) {
			if (com.equals(c)) {
				MonHocGUI.list.remove(c);
				return true;
			}
		}
		return false;
	}
	@Override
	public List<Major> searchMonhoc(String name) {
		List<Major> com = new ArrayList<>();
		name = name.toLowerCase();
		for (Major c : MonHocGUI.list) {
			if (c.getMonhoc_name().toLowerCase().contains(name))
				com.add(c);
		}
		return com;
	}
	public List<Major> searchMonhoc(double price) {
		List<Major> com = new ArrayList<>();
		for (Major c : MonHocGUI.list) {
			if (c.getMonhoc_price() == price)
				com.add(c);
		}
		return com;
	}
	public List<Major> searchMonhocbyNameMJ(String namesv) {
		List<Major> com = new ArrayList<>();
		for (Major c : MonHocGUI.list) {
			if (c.getNameMJ().compareToIgnoreCase(namesv) == 0)
				com.add(c);
		}
		return com;
	}
	public List<Major> searchMonhocbyNamHoc(int year) {
		List<Major> com = new ArrayList<>();
		for (Major c : MonHocGUI.list) {
			if (c.getYear() == year)
				com.add(c);
		}
		return com;
	}
	@Override
	public List<Major> sortedMonhoc(double price) {
		List<Major> com = new ArrayList<>();
		for(Major c : MonHocGUI.list) {
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
	public List<Major> sortedMonhoc(String namesv) {
		List<Major> com = new ArrayList<>();
		for(Major c : MonHocGUI.list) {
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
	public int indexOfMonhoc(int id) {
		for (int i = 0; i < MonHocGUI.list.size(); i++) {
			if (MonHocGUI.list.get(i).getMonhoc_id() == id)
				return i;
		}
		return -1;
	}
	public boolean checkMonhoc(Major com, List<Major> list) {
		for (Major c : list) {
			if (com.getMonhoc_id() == c.getMonhoc_id()) {
				return true;
			}
		}
		return false;
	}
	public static void printMonhoc(Major[] com) {
		for(Major c:com) {
			System.out.println(c);
		}	
	}
	
	public void printMonhoc(List<Major> com) {
		com.forEach(c -> System.out.println(c));
	}
}
class sortedByPrice implements Comparator<Major> {

	@Override
	public int compare(Major c1, Major c2) {
		return (int) (c1.getMonhoc_price() - c2.getMonhoc_price());
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

