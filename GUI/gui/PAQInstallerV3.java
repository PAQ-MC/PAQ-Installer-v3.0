/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/

/***
	Created By Isaac Wheeler
*/

package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JToggleButton;

import client.start;
import common.Main;

import java.awt.Window.Type;

public class PAQInstallerV3 {

	public JFrame frame;
	public static PAQInstallerV3 window;
	private JToggleButton tglbtnInstall;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new PAQInstallerV3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PAQInstallerV3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 803, 576);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PAQInstallerV3.class.getResource("/gui/PAQLogo.png")));
		lblNewLabel.setBounds(182, 74, 468, 177);
		frame.getContentPane().add(lblNewLabel);
		
		tglbtnInstall = new JToggleButton("");
		tglbtnInstall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					start.cstart();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		tglbtnInstall.setSelectedIcon(new ImageIcon(PAQInstallerV3.class.getResource("/gui/paq_buttons_Installing.png")));
		tglbtnInstall.setIcon(new ImageIcon(PAQInstallerV3.class.getResource("/gui/Install1.png")));
		tglbtnInstall.setRolloverIcon(new ImageIcon(PAQInstallerV3.class.getResource("/gui/paq_buttons_Install_over.png")));
		tglbtnInstall.setBounds(159, 307, 504, 125);
		frame.getContentPane().add(tglbtnInstall);
	}
}
