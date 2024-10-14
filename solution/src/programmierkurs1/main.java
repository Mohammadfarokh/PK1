package programmierkurs1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Audio a1 = new Audio("It Means Nothing",2021,"Stereophonics",229);
		Bild b1 = new Bild("Gebaeude FB Informatik",2020,"Dortmund");
		Audio a2 = new Audio("It Means Nothing",2019,"Stereophonics",229);
		Bild b2= new Bild("Gebaeude FB Informatik",2018,"Dortmund");
		
//		a1.druckDaten();
//		b1.druckDaten();
//		System.out.println(a1.alter());
//		Audio a2 = new Audio("It Means Nothing",2007,"Stereophonics",229);
//		System.out.println(a1.equals(a2));
//		System.out.println(a1.equals(b1));
//		System.out.println(a1.hashCode());
//		System.out.println(a2.hashCode());
		Medienverwaltung mv = new Medienverwaltung();
		mv.aufnehmen(a1);
		mv.aufnehmen(a2);
		mv.aufnehmen(b1);
		mv.aufnehmen(b2);
//		//mv.zeigeMedien();
//		mv.sucheNeuesMedium();
//		System.out.println(mv.berechneErscheiungsjahr());
		//mv.zeigeMedien();
		//System.out.format("%2$s\n%1$s\n%3$s","Beta","Alpha","Gamma");
	}

}
