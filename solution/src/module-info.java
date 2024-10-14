/**
 * 
 */
/**
 * @author miescha
 *
 */
module programmierkurs1 {
	requires java.desktop;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	opens programmierkurs1 to javafx.controls, javafx.base, javafx.graphics;
}