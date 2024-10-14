package programmierkurs1;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Objects;

public class Bild extends Medium{
	
	private static final long serialVersionUID = -1014777443279857241L;
	private String ort;

	Bild(String title, int jahr, String ort) {
		super(title, jahr);
		this.ort = ort;
	}
	

	public String getOrt() {
		return ort;
	}


	public void setOrt(String ort) {
		this.ort = ort;
	}


	@Override
	public void druckDaten(OutputStream os) {
		// TODO Auto-generated method stub
		PrintWriter pw = new PrintWriter(os);
		pw.printf( "ID = %d \"%s\" aufgenommen im Jahr %d in %s", super.getId(), super.getTitle(),
				super.getJahr(),this.ort );
		pw.flush();
	}

	//warum ist sie anders implementiert als in Medium?
	//warum ist der Haschwert negativ?
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ort);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bild other = (Bild) obj;
		return Objects.equals(ort, other.ort);
	}
	
	

}
