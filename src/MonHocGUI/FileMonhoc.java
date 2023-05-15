package MonHocGUI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import QLMH.Major;

public class FileMonhoc {
	public static void binaryOutputFile(List<Major> list) throws IOException {
		
		FileOutputStream outFile = new FileOutputStream("MonHoc.bin");
		
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		
		out.writeInt(list.size());
		for(Major com : list) {
			out.writeObject(com);
		}
		out.close();
	}
	
	public static List<Major> binaryInputFile(String name, int n) throws IOException, ClassNotFoundException {
		FileInputStream inFile = new FileInputStream(name);
		ObjectInputStream in = new ObjectInputStream(inFile);
		
		in.readInt();
		List<Major> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add((Major) in.readObject());
		}
		in.close();
		return list;
	}
	
	public static int countObject() throws IOException {
		FileInputStream inFile = new FileInputStream("Monhoc.bin");
		ObjectInputStream in = new ObjectInputStream(inFile);
		int count = in.readInt();
		in.close();
		return count;
	}
	
	public static Major findMonhocinFile(int id) {
		for (Major com : MonHocGUI.list) {
			if (com.getMonhoc_id() == id) {
				return com;
			}
		}
		return null;
	}
}
