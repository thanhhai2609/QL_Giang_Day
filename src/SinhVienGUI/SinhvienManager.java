package SinhVienGUI;

import java.util.*;

import QLSV.Sinhvien;

public interface SinhvienManager {
	  boolean addSinhvien(Sinhvien c);

	  boolean editSinhvien(Sinhvien c);

	  boolean delSinhvien(Sinhvien c);

	  List<Sinhvien> searchSinhvien(String name);

	  List<Sinhvien> sortedSinhvien(double price);
}
