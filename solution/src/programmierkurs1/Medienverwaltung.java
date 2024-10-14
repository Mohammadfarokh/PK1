package programmierkurs1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class Medienverwaltung{
	//for schleife
//	private Medium[] list = new Medium[10];
//	private int anz = 0;
//	
//	public void aufnehmen(Medium m) {
//		if(anz == list.length) {
//			System.out.println("Die Liste ist voll");
//		}else {
//		for(int i = 0; i < list.length; i++) {
//			if (list[i] == null){
//				list[i] = m;
//				anz++;
//			}
//		}
//	}
//}
//	public void zeigeMedien() {
//		for(int i = 0; i < list.length; i++) {
//			if(list[i]!=null) {
//			list[i].druckDaten();
//			}
//		}
//	}
//	
//	public void sucheNeuesMedium() {
//		int pos = -1;
//		for(int i = 0; i < list.length; i++) {
//			if(list[i] != null && i == 0) {
//				pos = i;
//			}
//			if(list[i] != null && i != 0) {
//				if(pos != -1 && list[i].alter() < list[pos].alter()) {
//					pos = i;
//				}
//			}
//		}
//		if(pos != -1) {
//			list[pos].druckDaten();
//		}
//	}
//	
//	public double berechneErscheiungsjahr() {
//		double summe = 0.0;
//		for(int i = 0; i < anz; i++) {
//			summe += list[i].getJahr();
//		}
//		if (anz != 0) {
//			return summe / (double)anz;
//		}
//		return summe;
//	}
	
//	 nicht typsicher----------------------------------
//	private LinkedList list = new LinkedList();
//	Medium n;
//	
//	public void aufnehmen(Medium m) {
//		list.add(m);
//	}
//	
//	public void zeigeMedien() {
//		for (Object m :  list) {
//			n = (Medium) m;
//			n.druckDaten();;
//		}
//	}
//	
//	public void sucheNeuesMedium() {
//	Medium res = null;
//	//Medium a;
//	if(!list.isEmpty()) {
//		res = (Medium) list.getFirst();
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			 n = (Medium) it.next();
//			if(res.alter() > n.alter()) {
//				res = n;
//			}
//		}
//	}
//	if (res != null) {
//		res.druckDaten();
//	}
//}
//	
//	public double berechneErscheiungsjahr() {
//		double summe = 0.0;
//		int anz = 0;
//		for (Object m :  list) {
//			n =(Medium) m;
//			summe += n.getJahr();
//			anz++;
//		}
//		if (anz != 0) {
//			return summe / (double)anz;
//		}
//		return summe;
//	}
	
	//typischer------------------------------
	private LinkedList<Medium> list = new LinkedList();
	Medium n;
	private String pfad = "/home/miescha/Insync/"
			+ "mohammad.farokh003@stud.fh-dortmund.de/OneDrive Biz/4_Semester/"
			+ "p1k/medienlist";
	private File file = new File(pfad);
	
	//Serialisierung
	public void speichern() {
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		}catch(IOException exp) {
			exp.printStackTrace();
		}
	}
	
	public void laden() {
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			LinkedList<Medium> tmp = (LinkedList<Medium>) ois.readObject();
			list.addAll(tmp);
			
		}catch(IOException exp) {
			exp.printStackTrace();
		}  catch(ClassNotFoundException exp) {
			exp.printStackTrace();
		}
	}
	
	public void aufnehmen(Medium m) {
		list.add(m);
	}
	
	public void zeigeMedien(OutputStream os) {
	Collections.sort(list);
	for (Medium m :  list) {
		m.druckDaten(os);
	}
}
	
	public void sucheNeuesMedium() {
	Medium res = null;
	Medium a;
	if(!list.isEmpty()) {
		res =  list.getFirst();
		Iterator<Medium> it = list.iterator();
		while(it.hasNext()) {
			a = it.next();
			if(res.alter() > a.alter()) {
				res = a;
			}
		}
	}
	if (res != null) {
		res.druckDaten(System.out);
	}
}
	
	public double berechneErscheiungsjahr() {
	double summe = 0.0;
	int anz = 0;
	for (Medium m :  list) {
		summe += m.getJahr();
		anz++;
	}
	if (anz != 0) {
		return summe / (double)anz;
	}
	return summe;
}


	
	
	
	
	
	
	
}

