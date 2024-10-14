package aufgabe23;

import java.io.File;

public class DirPrinter implements DirVisitor{
	private String indent;
	private PdfFilter filter;
	
	public DirPrinter() {
		indent = "";
		filter = new PdfFilter();
	}
	@Override
	public void enter(File f) {
		// TODO Auto-generated method stub
		System.out.printf("%s[%s]%n", indent, f.getName());
		indent = indent + "   ";
	}

	@Override
	public void visitFile(File f) {
		// TODO Auto-generated method stub
		if(filter.accept(f)) {
			System.out.printf("%s%s%n", indent, f.getName());
		}
	}

	@Override
	public void exit(File f) {
		// TODO Auto-generated method stub
		indent = indent.substring(3);
	}

}
