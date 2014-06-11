package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JTextPane;

public class gui {
	static JTextPane textArea;

	public static void main() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		StdDraw.setCanvasSize(600, 300);
		StdDraw.frame.setLocation(dim.width / 2 - StdDraw.frame.getSize().width
				/ 2, dim.height / 2 - StdDraw.frame.getSize().height / 2 - 130);

		StdDraw.picture(0.5, 0.7, "PAQLogo.png");
		StdDraw.picture(0.3, 0.25, "Install1.png", .3, .2);
		// StdDraw.picture(0.49, 0.25, "ForceUpdate1.png", .3, .2);
		StdDraw.picture(0.7, 0.25, "exit1.png", .3, .2);
		StdDraw.picture(0.5, 0.00, "copywrite1.png");
	}
}
