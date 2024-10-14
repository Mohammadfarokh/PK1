package aufgabe25;

import java.io.File;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File from = new File("/home/miescha/Insync/mohammad.farokh003@stud.fh-dortmund.de/OneDrive Biz/4_Semester/pk1/praktikum/programmierkurs1/bin/aufgabe25/from");
		File to = new File("/home/miescha/Insync/mohammad.farokh003@stud.fh-dortmund.de/OneDrive Biz/4_Semester/pk1/praktikum/programmierkurs1/bin/aufgabe25/to");
		Koppieren k = new Koppieren();
//		try {
//			k.copy(from, to);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			k.cat(from);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
