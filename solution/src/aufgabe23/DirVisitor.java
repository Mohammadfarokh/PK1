package aufgabe23;

import java.io.File;

public interface DirVisitor {
	public void enter(File f);
	public void visitFile(File f);
	public void exit(File f);
}
