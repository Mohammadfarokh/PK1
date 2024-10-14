package aufgabe25;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Koppieren {
	private RandomAccessFile read;
	private RandomAccessFile write;

	public void copy(File from, File to) throws IOException {
		try {
			  read = new RandomAccessFile(from, "r");
			  write = new RandomAccessFile(to, "rw");
			  for(int i = 0; (i = read.read())!= -1;) {
				  write.write(i);
			  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			read.close();
			write.close();
		}
	}
	
	public void cat(File from) throws IOException{
		String res;
		try {
			read = new RandomAccessFile(from,"r");
			while((res=read.readLine())!= null) {
				System.out.println(res);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			read.close();
		}
	}
}
