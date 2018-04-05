import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


public class formSuratEdaran extends JFrame{
	
	JLabel lblKodeKegiatan = new JLabel("Kode Kegiatan: ");
	JTextField txtKodeKegiatan = new JTextField();
	JLabel lblNoSurat = new JLabel("No.Surat: ");
	JTextField txtNoSurat = new JTextField();
	JLabel lblRT = new JLabel("RT: ");
	String[] arrRT = {"RT","1","2","3","4","5","6","7","8","9","10"};
	JComboBox cbRT = new JComboBox(arrRT);
	JLabel lblRW = new JLabel("RW: ");
	String[] arrRW = {"RW","1","2","3","4","5","6","7","8","9","10"};
	JComboBox cbRW = new JComboBox(arrRW);
	JLabel lblTglSurat = new JLabel("Tanggal Surat: ");
	String[] arrTgl = {"Tanggal","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	JComboBox cbTgl = new JComboBox(arrTgl);
	String[] arrBln = {"Bulan","Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"};
	JComboBox cbBln = new JComboBox(arrBln);
	String[] arrThn = {"Tahun","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015"};
	JComboBox cbThn = new JComboBox(arrThn);
	JLabel lblPerihal = new JLabel("Perihal: ");
	JTextField txtPerihal = new JTextField();
	JButton cmdTambah = new JButton("Tambah");
	JButton cmdHapus = new JButton("Hapus");
	JButton cmdSimpan = new JButton("Simpan");
	
	//deklarasi objek tabel
  	String[] strJdl = {"KdK","NoSurat","RT","RW","TglSurat","Perihal"};
	DefaultTableModel tabMode;
	JTable tabelEdaran = new JTable();
	JScrollPane spTabelEdaran = new JScrollPane();
	
	
	public formSuratEdaran(){
		
		setSize(600,500);
		setLocationRelativeTo(this);
		setTitle("Surat Edaran");
		
		lblKodeKegiatan.setBounds(20,20,100,25);
		txtKodeKegiatan.setBounds(130,20,100,25);
		lblNoSurat.setBounds(20,50,100,25);
		txtNoSurat.setBounds(130,50,100,25);
		lblRT.setBounds(20,80,100,25);
		cbRT.setBounds(130,80,100,25);
		lblRW.setBounds(20,120,100,25);
		cbRW.setBounds(130,120,100,25);
		lblTglSurat.setBounds(20,150,100,25);
		cbTgl.setBounds(130,150,100,25);
		cbBln.setBounds(240,150,100,25);
		cbThn.setBounds(350,150,100,25);
		lblPerihal.setBounds(20,180,100,25);
		txtPerihal.setBounds(130,180,210,25);
		cmdTambah.setBounds(130,220,100,25);
		cmdHapus.setBounds(240,220,100,25);
		cmdSimpan.setBounds(350,220,100,25);
		
		// instansiasi objek tabel
		tabMode = new DefaultTableModel(null,strJdl);
		tabelEdaran.setModel(tabMode);
		spTabelEdaran.getViewport().add(tabelEdaran);
		tabelEdaran.setEnabled(true);
		spTabelEdaran.setBounds (20, 250, 550, 100);	//batasan scroll.
		
		getContentPane().setLayout(null);
		getContentPane().add(lblKodeKegiatan);
		getContentPane().add(txtKodeKegiatan);
		getContentPane().add(lblNoSurat);
		getContentPane().add(txtNoSurat);
		getContentPane().add(lblRT);
		getContentPane().add(cbRT);
		getContentPane().add(lblRW);
		getContentPane().add(cbRW);
		getContentPane().add(lblTglSurat);
		getContentPane().add(cbTgl);
		getContentPane().add(cbBln);
		getContentPane().add(cbThn);
		getContentPane().add(lblPerihal);
		getContentPane().add(txtPerihal);
		getContentPane().add(cmdTambah);
		getContentPane().add(cmdHapus);
		getContentPane().add(cmdSimpan);
		getContentPane().add(spTabelEdaran);
		
		tampilketabel();
		
		
		setVisible(true);
	}
	
	// menampilkan data ke tabel
 	void tampilketabel(){
		try{
			hapusTabel();
	   		Koneksi ObjKoneksi = new Koneksi();
	   		Connection con = ObjKoneksi.bukaKoneksi();
	   		Statement st = con.createStatement();
			String sql = "SELECT * FROM formSuratEdaran";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				 		
				String vKdK = rs.getString("KdK");
				String vNoSurat = rs.getString("NoSrt");
				String vRT = rs.getString("RT");
				String vRW = rs.getString("RW");
				String vTglSurat = rs.getString("TglSrt");
				String vPerihal = rs.getString("Perihal");
				
				String[] data = {"",vKdK,vNoSurat,vRT,vRW,vTglSurat,vPerihal};
				tabMode.addRow(data);	
				resetNo();
			}
	   		rs.close();
 	  		con.close();
 	  		//tampil(); //dipanggil saat tabel di doble click
		}
		catch(Exception e){
		}
 	}
	
	// mengatur kembali penomoran tabel
	void resetNo(){
		int brs = tabMode.getRowCount();
		for(int i=0;i<brs;i++){
			String no = String.valueOf(i+1);
			tabMode.setValueAt(no+".",i,0);
		}
	}
	
	// mengosongkan isi tabel
	void hapusTabel(){
		int brs = tabMode.getRowCount();
		for(int i=0;i<brs;i++){
			tabMode.removeRow(0);
		}
	}
	
	public static void main (String[] args){
		new formSuratEdaran();
	}
}

