/*
-----------------------------------------------------
	Nama Program 	: SIP.java
	Dipanggil Oleh	: -
	Keterangan 		: Program Splash dengan Logo dan Baris Progress
	Dibuat Oleh		: AEndF@2008, Versi Update
-----------------------------------------------------
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class SIP extends JWindow {
	private Dimension 		dimensi		= Toolkit.getDefaultToolkit().getScreenSize();
	private JLabel 			lblLogo		= new JLabel(new ImageIcon ("Gambar/logobaru.jpg"));
	private JProgressBar 	barisProgres= new JProgressBar();

	private int 			time 		= 0;
	private Timer 			timer;

	public SIP () {
 		Color Warna = Color.pink;

		barisProgres.setValue(0);
		barisProgres.setPreferredSize(new Dimension(100,15));
		barisProgres.setBackground(Color.yellow);
		barisProgres.setForeground(Color.red);
		barisProgres.setStringPainted(true);
		barisProgres.setBorder(new LineBorder (Warna, 1));
		lblLogo.setBorder (new LineBorder (Warna, 1));
		
		getContentPane().add(lblLogo, BorderLayout.NORTH);
		getContentPane().add(barisProgres,BorderLayout.CENTER);
		
		timer=new Timer(50,new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				time++;
				barisProgres.setValue(time);
				if(barisProgres.getPercentComplete()==1.0){
					timer.stop();
					setVisible(false);
					new menu_utama();
				}	
			}
		});
		timer.start();
		
		pack();
		setLocation (dimensi.width / 2 - getWidth() / 2, dimensi.height / 2 - getHeight() / 2);	
		show();
	}

	public static void main (String args[]) { 
		new SIP (); 
	}
}