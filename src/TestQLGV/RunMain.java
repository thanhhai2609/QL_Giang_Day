package TestQLGV;
import java.io.IOException;
import java.util.*;

import QLGV.Major;
import GiangvienGUI.FileGiangvien;

public class RunMain {

	public static List<Major> generatedMonhoc(int n) {
		String[] configName = {"Khoa học máy tính", "Hệ thống thông tin", "Kỹ thuật phần mềm", "Khoa học máy tính", "Công nghệ thông tin",
							"Khoa học máy tính", "Khoa học máy tính", "Khoa học máy tính", "Khoa học máy tính", "Công nghệ thông tin",
							"Hệ thống thông tin", "Hệ thống thông tin", "Hệ thống thông tin", "Kỹ thuật phần mềm", "Công nghệ thông tin", "Công nghệ thông tin",
							"Hệ thống thông tin", "Khoa học máy tính", "Khoa học máy tính", "Hệ thống thông tin", "Công nghệ thông tin",
							"Công nghệ thông tin", "Kỹ thuật phần mềm ", "Khoa học máy tính", "Hệ thống thông tin"};
		String[] nameGV = {"Lê Văn Thuỳ", "Hà Mạnh Đào", "Nguyễn Thanh Hải", "Bùi Văn Tú", "Nguyễn Thị Nhung",
							"Nguyễn Văn Hà", "Đào Trọng Hợp", "Vũ Thị Tuyết Mai", "Nguyễn Bá Nghiễn", "Nguyễn Thị Thanh Huyền",
							"Nguyễn Mạnh Cường", "Nguyễn Văn Quỳnh", "Lê Thu Hương", "Hoàng Yến Hoa", "Nguyễn Thị Yến", "Hoàng Quang Huy",
							"Nguyễn Văn Hiệp", "Nguyễn Văn Tú", "Nguyễn Thị Mỹ Bình", "Lê Tiến Thành", "Nguyễn Thị Dương",
							"Ngô Thị Tâm", "Phan Văn Thành", "Nguyễn Tiến Đạt", "Phạm Hồng Phước"};
                Major[] list = new Major[n];
		List<Major> com = Arrays.asList(list);
		for(int i = 0; i < n; i++) {
			list[i] = new Major();
			int indexNamesv = (int) (Math.random() * configName.length);
                        int indexNameGV = (int) (Math.random() * nameGV.length);
			list[i].setGiangvien_id(100 + i + 1);
			list[i].setGiangvien_name(nameGV[indexNameGV]);
			list[i].setGiangvien_price((int)(((Math.random())*(5-0)+1))*1000000);
			list[i].setGiangvien_credits(1 + (int)((Math.random())*(5-0)+1));
			list[i].setNameMJ(configName[indexNamesv]);
			list[i].setYear((int)((Math.random())*(0-5)+2022));	
		}
		return com;
	}
	public static void main(String[] args) {
		List<Major> list = RunMain.generatedMonhoc(20);
		for(Major com : list) {
			System.out.println(com.toString());
		}
		try {
			FileGiangvien.binaryOutputFile(list);
			FileGiangvien.binaryInputFile("Giangvien.bin", list.size());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}