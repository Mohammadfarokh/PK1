package programmierkurs1;

import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Medium implements Comparable<Medium>{
	private int id;
	private String title;
	private int jahr;
	private static int anz;
	private static final long serialVersionUID = -3746734897979679688L;
	
	Medium(String title, int jahr){
		this.title = title;
		this.jahr = jahr;
		this.id = anz;
		anz++;
	}
	
	public int compareTo(Medium m) {
		if (this.getJahr() > m.getJahr()) {
			return 1;
		} else if (this.getJahr() < m.getJahr()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	
	public int alter() {
		return LocalDate.now().getYear() - this.getJahr();
	}
	
	public abstract void druckDaten(OutputStream os);

	@Override
	public int hashCode() {
		return Objects.hash(jahr, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medium other = (Medium) obj;
		return jahr == other.jahr && Objects.equals(title, other.title);
		
	}
	
}
