package programmierkurs1;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class Menu extends Exception {
	public static Medienverwaltung mv = new Medienverwaltung();
	 

	public static void main(String[] args) throws InputMismatchException {
		// TODO Auto-generated method stub
		String titel;
		String jahr;
		String interpret;
		String dauer;
		String ort;
		int opt = 0;
		Scanner sc = new Scanner(System.in);
		do { System.out.println("Medienverwaltung\n"
				+ "1. Audio aufnehmen\n"
				+ "2. Bild aufnehmen\n"
				+ "3. Zeige alle Medien\n"
				+ "4. Medienliste in Datei schreiben\n"
				+ "5. Zeige neues Medium\n"
				+ "6. Berechne durchschnittliches Erscheinungsjahr\n"
				+ "7. Speichern\n"
				+ "8. Laden\n"
				+ "9. Beenden\n"
				+ "Bitte Menuepunkt waehlen:");	
		try {
			opt = sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Option darf nicht eine Buschtabe sein.");
			sc.next();
		}
		}while(opt < 1 || opt > 9);
		switch(opt) {
		case 1: //String titel, int jahr, String interpret, int dauer
			titel = JOptionPane.showInputDialog(null, "Geben Sie den Titel ein");
			int jahrInt = 0;
			boolean ok = false;
			do {
				try {
					 jahr = JOptionPane.showInputDialog(null, "Geben Sie das Jahr ein");
					jahrInt = Integer.parseInt(jahr);
					ok = true;
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Bitte gültiges Jahr eingeben");
					//ok = false;
				}
			}while(!ok);
			 interpret = JOptionPane.showInputDialog(null, "Geben Sie den Interpret ein");
			ok = false;
			int dauerInt = 0;
			do {
				try {
					dauer = JOptionPane.showInputDialog(null, "Geben Sie die Dauer ein");
					dauerInt = Integer.parseInt(dauer);
					ok = true;
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Bitte gültige Dauer eingeben");
				}
			}while(!ok);
			Audio audio = new Audio(titel, jahrInt, interpret, dauerInt);
			mv.aufnehmen(audio);
			break;
		case 2: //String titel, int jahr, String ort
			String titel2 = JOptionPane.showInputDialog(null, "Geben Sie den Titel ein");
			
			int jahrInt2 = 0;
			boolean ok2 = false;
			do {
				try {
					String jahr2 = JOptionPane.showInputDialog(null, "Geben Sie das Jahr ein");
					jahrInt2 = Integer.parseInt(jahr2);
					ok2 = true;
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Bitte gültiges Jahr eingeben");
				}
			}while(!ok2);
			
			ort = JOptionPane.showInputDialog(null, "Geben Sie den Ort ein");
			Bild bild = new Bild(titel2, jahrInt2, ort);
			mv.aufnehmen(bild);
			break;
		case 3:
			mv.zeigeMedien(System.out);
			break;
		case 4:
			medienInDateiSchreiben(mv);
			break;
		case 5:
			mv.sucheNeuesMedium();
			break;
		case 6:
			System.out.println(mv.berechneErscheiungsjahr());
			break;
		case 7:
			mv.speichern();
			break;
		case 8:
			mv.laden();
			break;
		case 9:
			System.out.println("Programm beendet");
			break;
		default:
			System.out.println("Bitte eone Zahl zwischen 1-9 auswählen");
		}
		if(opt <= 5 && opt >=1) {
			main(args);
		}else {
			System.out.println("The Programm has stopped");
		}
	}
	
	public static void medienInDateiSchreiben(Medienverwaltung mv) {
		boolean ok = false;
		File file = null;
		do {
			try {
				String dateiname = JOptionPane.showInputDialog(null,"Bitte Dateiname eingeben");
				if(dateiname == null){
					return;
				}
				if(dateiname.isEmpty()) {
					throw new EmptyFileException();
				}
				file = new File(dateiname + ".txt");
			}catch(EmptyFileException exp) {
				int auswahl = JOptionPane.showConfirmDialog(null,"Dateiname ist leer! Neuen Dateinamen wählen?", "Hinweis", JOptionPane.YES_NO_OPTION);
				if( auswahl == JOptionPane.NO_OPTION ) {
					return;
				} else { // Yes
					ok = false;
				}
			}
			if(file != null) {
				try(OutputStream os = new FileOutputStream(file);
						PrintStream ps = new PrintStream(os)){
					mv.zeigeMedien(ps);
					ok = true;
				}catch(IOException exp) {
					exp.printStackTrace();
				}
			}
		}while(!ok);
		
	}

}
