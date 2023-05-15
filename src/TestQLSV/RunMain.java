package TestQLSV;
import java.io.IOException;
import java.util.*;

import QLSV.Sinhvien;
import SinhVienGUI.FileSinhvien;

public class RunMain {

	public static List<Sinhvien> generatedSinhvien(int n) {
		String[] configName = {"Nguyen Van A", "Nguyen Van An", "Ho Van A", "Tran Thi Lan", "Ly Thi Lanh",
							"Ho Thi Hanh", "Ho Van Y", "Ho Ronaldo", "Dang Van Messi", " Le Van DO",
							"Que Ngoc Hai", "Nguyen Quang Hai", "Tran Dinh Trong", "nguyen Thanh Chung", "A Lo", "Dang Thu Giang",
							"Dang Van Lam", "Tran Nguyen Manh", "Pham Quang Linh", "Phan Van Duc", "NguyenTien Tu",
							"Phan Thi Diep", "Ly Thanh ", "To Hoai", "Nguyen Anh"};
                String[] nameSJ ={"Lập trình hướng đối tượng", "Lập trình java", "Lập trình dot.net", "Nhập môn lập trình", "Tin học căn bản",
				  "Phân tích thiết kế phần mềm", "Trí tuệ nhân tạo", "Cấu trúc dữ liệu và giải thuật", "Lập trình nhúng", "Hoá học đại cương",
				  "Mạng máy tính", "Tính toán hiệu năng cao", "Lập trình C#", "Lập trình web bằng java", "Toán rời rạc", "Xác suất",
				  "Thống kê", "Giải tích", "Đại số tuyến tính", "Nhập môn công nghệ phần mềm", "Thực tập cơ sở ngành",
				  "Tối ưu hoá", "Học máy", "Đặc tả phần mềm", "Lập trình game"
                };
		Sinhvien[] list = new Sinhvien[n];
		List<Sinhvien> com = Arrays.asList(list);
		for(int i = 0; i < n; i++) {
			list[i] = new Sinhvien();
			int indexNamesv = (int) (Math.random() * configName.length);
                        int indexNameSJ = (int) (Math.random() * nameSJ.length);
			list[i].setMonhoc_id(100 + i + 1);
			list[i].setMonhoc_name(nameSJ[indexNameSJ]);
			list[i].setMonhoc_price((int)(((Math.random())*(5-0)+1))*100000);
			list[i].setMonhoc_credits(1 + (int)((Math.random())*(5-0)+1));
			list[i].setNamesv(configName[indexNamesv]);
			list[i].setMark( (int)((Math.random())*(10-0)+1));	
		}
		return com;
	}
	public static void main(String[] args) {
		List<Sinhvien> list = RunMain.generatedSinhvien(20);
		for(Sinhvien com : list) {
			System.out.println(com.toString());
		}
		try {
			FileSinhvien.binaryOutputFile(list);
			FileSinhvien.binaryInputFile("Sinhvien.bin", list.size());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}