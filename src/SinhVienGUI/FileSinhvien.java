package SinhVienGUI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import QLSV.Sinhvien;

public class FileSinhvien {
	public static void binaryOutputFile(List<Sinhvien> list) throws IOException {
		
		FileOutputStream outFile = new FileOutputStream("Sinhvien.bin");
		
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		
		out.writeInt(list.size());
		for(Sinhvien com : list) {
			out.writeObject(com);
		}
		out.close();
	}
	
	public static List<Sinhvien> binaryInputFile(String name, int n) throws IOException, ClassNotFoundException {
		FileInputStream inFile = new FileInputStream(name);
		ObjectInputStream in = new ObjectInputStream(inFile);
		
		in.readInt();
		List<Sinhvien> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add((Sinhvien) in.readObject());
		}
		in.close();
		return list;
	}
	
	public static int countObject() throws IOException {
		FileInputStream inFile = new FileInputStream("Sinhvien.bin");
		ObjectInputStream in = new ObjectInputStream(inFile);
		int count = in.readInt();
		in.close();
		return count;
	}
	
	public static Sinhvien findSinhvieninFile(int id) {
		for (Sinhvien com : SinhvienGUI.list) {
			if (com.getMonhoc_id() == id) {
				return com;
			}
		}
		return null;
	}
}
