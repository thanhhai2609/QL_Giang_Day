package TestQLMH;
import java.io.IOException;
import java.util.*;

import QLMH.Major;
import MonHocGUI.FileMonhoc;

public class RunMain {

	public static List<Major> generatedMonhoc(int n) {
                String[] nameSJ ={"Lập trình hướng đối tượng", "Lập trình java", "Lập trình dot.net", "Nhập môn lập trình", "Tin học căn bản",
				  "Phân tích thiết kế phần mềm", "Trí tuệ nhân tạo", "Cấu trúc dữ liệu và giải thuật", "Lập trình nhúng", "Hoá học đại cương",
				  "Mạng máy tính", "Tính toán hiệu năng cao", "Lập trình C#", "Lập trình web bằng java", "Toán rời rạc", "Xác suất",
				  "Thống kê", "Giải tích", "Đại số tuyến tính", "Nhập môn công nghệ phần mềm", "Thực tập cơ sở ngành",
				  "Tối ưu hoá", "Học máy", "Đặc tả phần mềm", "Lập trình game"
                };
		String[] configName = {"Khoa học máy tính", "Hệ thống thông tin", "Kỹ thuật phần mềm", "Khoa học máy tính", "Công nghệ thông tin",
							"Khoa học máy tính", "Khoa học máy tính", "Khoa học máy tính", "Khoa học máy tính", "Công nghệ thông tin",
							"Hệ thống thông tin", "Hệ thống thông tin", "Hệ thống thông tin", "Kỹ thuật phần mềm", "Công nghệ thông tin", "Công nghệ thông tin",
							"Hệ thống thông tin", "Khoa học máy tính", "Khoa học máy tính", "Hệ thống thông tin", "Công nghệ thông tin",
							"Công nghệ thông tin", "Kỹ thuật phần mềm ", "Khoa học máy tính", "Hệ thống thông tin"};
		Major[] list = new Major[n];
		List<Major> com = Arrays.asList(list);
		for(int i = 0; i < n; i++) {
			list[i] = new Major();
			int indexNamesv = (int) (Math.random() * configName.length);
                        int indexNameSJ = (int) (Math.random() * nameSJ.length);
			list[i].setMonhoc_id(100 + i + 1);
			list[i].setMonhoc_name(nameSJ[indexNameSJ]);
			list[i].setMonhoc_price((int)(((Math.random())*(5-0)+1))*1000000);
			list[i].setMonhoc_credits(1 + (int)((Math.random())*(5-0)+1));
			list[i].setNameMJ(configName[indexNamesv]);
			list[i].setYear((int)((Math.random())*(0-5)+2027));	
		}
		return com;
	}
	public static void main(String[] args) {
		List<Major> list = RunMain.generatedMonhoc(20);
		for(Major com : list) {
			System.out.println(com.toString());
		}
		try {
			FileMonhoc.binaryOutputFile(list);
			FileMonhoc.binaryInputFile("Monhoc.bin", list.size());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}