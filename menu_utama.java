//Sistem Informasi Data Warga Perumahan Duta Bintaro Cluster Sanur
//Rizki Setyawan
//1411501321
//Bismillah


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu_utama extends JFrame implements ActionListener{
	
	//JLabel lbltxt = new JLabel("Sistem Informasi Data Warga ");
	
	//Menu Bar
	JMenuBar mnuBar = new JMenuBar();
	
	//Menu File
	JMenu mnuFile = new JMenu("File");
	//Menu Anak dari File
	JMenuItem mnuEntryRW = new JMenuItem("Entry RW");
	JMenuItem mnuEntryRT = new JMenuItem("Entry RT");
	JMenuItem mnuEntryWarga = new JMenuItem("Entry Warga");
	JMenuItem mnuKeluar = new JMenuItem("Keluar", new ImageIcon("Gambar/exit.jpg"));
	
	//Menu Transaksi
	JMenu mnuTransaksi = new JMenu("Transaksi");
	//Menu Anak dari Transaksi
	JMenuItem mnuCetakSuratPengantar = new JMenuItem("Cetak Surat Pengantar");
	JMenuItem mnuSuratEdaran = new JMenuItem("Entry Surat Edaran");
	JMenuItem mnuKegiatanRWRT = new JMenuItem("Entry Kegiatan RW/RT");
	JMenuItem mnuCetakKwitansi = new JMenuItem("Cetak Kwitansi");
	
	//Menu Laporan
	JMenu mnuLaporan = new JMenu("Laporan");
	//Menu Anak dari Laporan
	JMenuItem mnuCetakLaporanSuratPengantar = new JMenuItem("Cetak Laporan Surat Pengantar");
	JMenuItem mnuCetakLaporanSuratEdaran = new JMenuItem("Cetak Laporan Surat Edaran");
	JMenuItem mnuCetakLaporanKegiatanRWRT = new JMenuItem("Cetak Laporan Kegiatan RW/RT");
	JMenuItem mnuCetakLaporanKwitansi = new JMenuItem("Cetak Laporan Kwitansi");
	JMenuItem mnuCetakLaporanRekap = new JMenuItem("Cetak Laporan Rekap");
	
	//Menu Help
	JMenu mnuHelp = new JMenu("Help");
	//Menu Anak dari Help
	JMenuItem mnuAbout = new JMenuItem("About");
	

	public menu_utama(){
		setSize(600,400);
		setLocationRelativeTo(this);
		setTitle("Sistem Data Warga Duta Bintaro Cluster Sanur");
		
		//lbltxt.setBounds(230,200,100,25);
		//lbltxt.setFont(new Font("Arial",Font.BOLD,20));
		//getContentPane().add(lbltxt);
		
		
		setJMenuBar(mnuBar);
		//Menu File
		mnuBar.add(mnuFile);
		mnuBar.setBackground(Color.green);
		//Menu Anak dari File
		mnuFile.add(mnuEntryRW);
		mnuFile.add(mnuEntryRT);
		mnuFile.add(mnuEntryWarga);
		mnuFile.addSeparator(); //membuat garis horizontal
		mnuFile.add(mnuKeluar);
		
		// Mengatur penggunaan shortcut pada menu menu Fulldown
		mnuKeluar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK)); 
		
		// Mengatur tombol Alt pada menu Fulldown
		mnuFile.setMnemonic('F');
		mnuTransaksi.setMnemonic('T');
		mnuLaporan.setMnemonic('L');
		mnuHelp.setMnemonic('H');
		mnuKeluar.setMnemonic('K');
		
		// Mengatur menu Fulldown agar mengerti saat di click
		mnuKeluar.addActionListener(this);
		mnuEntryRW.addActionListener(this);
		mnuEntryRT.addActionListener(this);
		mnuEntryWarga.addActionListener(this);
		mnuCetakSuratPengantar.addActionListener(this);
		mnuSuratEdaran.addActionListener(this);
		mnuKegiatanRWRT.addActionListener(this);
		mnuCetakKwitansi.addActionListener(this);
		mnuCetakLaporanSuratPengantar.addActionListener(this);
		mnuCetakLaporanSuratEdaran.addActionListener(this);
		mnuCetakLaporanKegiatanRWRT.addActionListener(this);
		mnuCetakLaporanKwitansi.addActionListener(this);
		mnuCetakLaporanRekap.addActionListener(this);
		mnuAbout.addActionListener(this);
		
		//Menu Transaksi
		mnuBar.add(mnuTransaksi);
		//Menu Anak dari Transaksi
			//mnuTransaksi.add(mnuCetakSuratPengantar);
		mnuTransaksi.add(mnuSuratEdaran);
		mnuTransaksi.add(mnuKegiatanRWRT);
			//mnuTransaksi.add(mnuCetakKwitansi);
		
		//Menu Laporan
		mnuBar.add(mnuLaporan);
		//Menu Anak dari Laporan
			//mnuLaporan.add(mnuCetakLaporanSuratPengantar);
		mnuLaporan.add(mnuCetakLaporanSuratEdaran);
		mnuLaporan.add(mnuCetakLaporanKegiatanRWRT);
			//mnuLaporan.add(mnuCetakLaporanKwitansi);
			//mnuLaporan.add(mnuCetakLaporanRekap);
		
		//getContentPane().add(lbltxt);
		
		//Menu Help
		mnuBar.add(mnuHelp);
		//Menu Anak dari Help
		mnuHelp.add(mnuAbout);
		
	
		setVisible(true);
	}
	
	//fungsi untuk keluar
	public void actionPerformed(ActionEvent ae){
		if (ae.getSource()==mnuKeluar){
			System.exit(0);
		}
		
		if (ae.getSource()==mnuEntryRW){
			new formEntryRW();
		}
		
		if (ae.getSource()==mnuEntryRT){
			new formEntryRT();
		}
		
		if (ae.getSource()==mnuEntryWarga){
			new formEntryWarga();
		}
		
		/*if (ae.getSource()==mnuCetakSuratPengantar){
			new formCetakSuratPengantar();
		}*/
		
		if (ae.getSource()==mnuSuratEdaran){
			new formSuratEdaran();
		}
		
		if (ae.getSource()==mnuKegiatanRWRT){
			new formKegiatanRWRT();
		}
		
		/*if (ae.getSource()==mnuCetakKwitansi){
			new formCetakKwitansi();
		}*/
		
		/*if (ae.getSource()==mnuCetakLaporanSuratPengantar){
			new formCetakLaporanSuratPengantar();
		}*/
		
		if (ae.getSource()==mnuCetakLaporanSuratEdaran){
			new formCetakLaporanSuratEdaran();
		}
		
		if (ae.getSource()==mnuCetakLaporanKegiatanRWRT){
			new formCetakLaporanKegiatanRWRT();
		}
		
		/*if (ae.getSource()==mnuCetakLaporanKwitansi){
			new formCetakLaporanKwitansi();
		}*/
		
		/*if (ae.getSource()==mnuCetakLaporanRekap){
			new formCetakLaporanRekap();
		}*/
		
		if (ae.getSource()==mnuAbout){
			new formAbout();
		}
	}
	
	public static void main(String [] args){
			new menu_utama();
	}
}	
