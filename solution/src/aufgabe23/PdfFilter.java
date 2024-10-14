package aufgabe23;

import java.io.File;

public class PdfFilter implements FileFilter {

	@Override
	public boolean accept(File f) {
		// TODO Auto-generated method stub
		  // Konvertiere den Dateinamen in Kleinbuchstaben
        String lowercaseName = f.getName().toLowerCase();

        // Überprüfe, ob der Dateiname auf ".pdf" endet
        return lowercaseName.endsWith(".pdf");
	}

}
