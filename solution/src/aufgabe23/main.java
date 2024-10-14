package aufgabe23;

import java.io.File;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("/home/miescha/Insync/mohammad.farokh003@stud.fh-dortmund.de/OneDrive Biz/4_Semester/pk1");
		FileTree ft = new FileTree(new DirPrinter());
		ft.treverse(f);
	}

}
