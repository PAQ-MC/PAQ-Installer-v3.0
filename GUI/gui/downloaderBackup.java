/**
 * 
 */
package gui;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.FlowLayout;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author IsaacWheeler
 * 
 */
public class downloaderBackup {
	private static JFrame frm;
	private static  File file;
	private static ImageIcon[] img;
	private static JLabel loadingImage;
	private static JLabel loadingStatus;

	public static void download(String site, File _file) throws IOException{
		file = _file;
		
		loadimages();
		guiBuilder();
		
		downloader(site);
		
		frm.dispose();
	}
	
	
	public static void guiBuilder() {
		
		frm = new JFrame();
		JLabel textLabel;
		if (file.getName().length() > 20) {
			textLabel = new JLabel("Downloading: "
					+ file.getName().subSequence(0, 20) + "...",
					SwingConstants.CENTER);
		} else {
			textLabel = new JLabel("Downloading: " + file.getName(),
					SwingConstants.CENTER);
		}
		frm.add(textLabel);
		loadingImage = new JLabel("", SwingConstants.CENTER);
		loadingImage.setIcon(img[0]);
		frm.add(loadingImage);
		loadingStatus = new JLabel("Downloaded: 0%", SwingConstants.CENTER);
		frm.add(loadingStatus);
		frm.setVisible(true);
		frm.setLayout(new FlowLayout());
		frm.setSize(300, 150);
		frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private static void downloader(String site) throws IOException {
		URL url = new URL(site);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		int filesize = connection.getContentLength();
		int totalDataRead = 0;
		try (java.io.BufferedInputStream in = new java.io.BufferedInputStream(
				connection.getInputStream())) {
			java.io.FileOutputStream fos = new java.io.FileOutputStream(
					file.toString());
			try (java.io.BufferedOutputStream bout = new BufferedOutputStream(
					fos, 1024)) {
				byte[] data = new byte[1024];
				int i;
				int j = 1;
				while ((i = in.read(data, 0, 1024)) >= 0) {
					totalDataRead = totalDataRead + i;
					bout.write(data, 0, i);
					
					/*
					if(j <= 30 ){
						loadingImage.setIcon(img[j]);
						j++;
					}else{
						loadingImage.setIcon(img[0]);
						j = 1;
					}
					*/
					
					int percent = Math.abs((totalDataRead * 100) / filesize);
					loadingStatus.setText("Downloaded: " + percent + "%");
					
				}
			}
		}

	}

	private static void loadimages() {
		ImageIcon[] imgtmp = {
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step1.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step2.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step3.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step4.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step5.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step6.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step7.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step8.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step9.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step10.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step11.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step12.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step13.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step14.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step15.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step16.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step17.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step18.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step19.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step20.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step21.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step22.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step23.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step24.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step25.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step26.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step27.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step28.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step29.png")),
				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step30.png")),

				new ImageIcon(
						PAQInstallerV3.class
								.getResource("/gui/loadingImages/step31.png")) };
		img = imgtmp;

	}

}
