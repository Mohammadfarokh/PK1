package programmierkurs1;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Objects;

public class Audio extends Medium{
	
	private static final long serialVersionUID = 4848732524446303302L;
	private String interpret;
	private int dauer;

	Audio(String title, int jahr, String interpret, int dauer) {
		super(title, jahr);
		this.interpret = interpret;
		this.dauer = dauer;
	}
	

	public String getInterpret() {
		return interpret;
	}


	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}


	public int getDauer() {
		return dauer;
	}


	public void setDauer(int dauer) {
		this.dauer = dauer;
	}


	@Override
	public void druckDaten(OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.printf("Id = %d \"%s\" von %s aus %d "
				+ "Spieldauer %d sek.", super.getId(),  super.getTitle(), 
				this.interpret,  super.getJahr(), this.dauer);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dauer, interpret);
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
		Audio other = (Audio) obj;
		return dauer == other.dauer && Objects.equals(interpret, other.interpret);
	}
	
	

}
