package GiangvienGUI;

import java.util.*;

import QLGV.Major;

public interface GiangvienManager {
	  boolean addGiangvien(Major c);

	  boolean editGiangvien(Major c);

	  boolean delGiangvien(Major c);

	  List<Major> searchGiangvien(String name);

	  List<Major> sortedGiangvien(double price);
}
