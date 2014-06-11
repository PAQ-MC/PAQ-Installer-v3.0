package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

public class Gui {
	static JTextPane textArea;

	public static void consolegui() {
		JFrame frame = new JFrame("Information consol, please ignore");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		textArea = new JTextPane();
		textArea.setPreferredSize(new Dimension(600, 300));

		textArea.setAutoscrolls(true);

		frame.add(new JScrollPane(textArea));
		MessageConsole mc = new MessageConsole(textArea);
		mc.redirectOut(null, System.out);
		mc.redirectErr(Color.RED, System.out);

		frame.pack();
		frame.setVisible(true);
		System.out.println("Output Redirected for users info please do not copy me i am in a log file");
	}

	private static void updateTextArea(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

			}
		});
	}

	private static void redirectSystemStreams() {
		OutputStream out = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				updateTextArea(String.valueOf((char) b));
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				updateTextArea(new String(b, off, len));
			}

			@Override
			public void write(byte[] b) throws IOException {
				write(b, 0, b.length);
			}
		};

		System.setOut(new PrintStream(out, true));
		System.setErr(new PrintStream(out, true));
	}
}
