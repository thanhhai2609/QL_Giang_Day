package MonHocGUI;

import java.util.*;

import QLMH.Major;

public interface MonhocManager {
	  boolean addMonhoc(Major c);

	  boolean editMonhoc(Major c);

	  boolean delMonhoc(Major c);

	  List<Major> searchMonhoc(String name);

	  List<Major> sortedMonhoc(double price);
}
