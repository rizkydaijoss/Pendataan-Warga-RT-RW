import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class formEntryWarga extends JFrame{
	JLabel lblKodeWarga = new JLabel("Kode Warga: ");
	JTextField txtKodeWarga = new JTextField();
	JButton cmdCari = new JButton("Cari");
	JLabel lblRT = new JLabel("RT: ");
	String[] arrRT = {"RT","1","2","3","4","5","6","7","8","9","10"};
	JComboBox cbRT = new JComboBox(arrRT);
	JLabel lblRW = new JLabel("RW: ");
	String[] arrRW = {"RW","1","2","3","4","5","6","7","8","9","10"};
	JComboBox cbRW = new JComboBox(arrRW);
	JLabel lblNoRmh = new JLabel("No Rumah: ");
	String[] arrNoRmh = {"No","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50"};
	JComboBox cbNoRmh = new JComboBox(arrNoRmh);
	JLabel lblNIK = new JLabel("NIK: ");
	JTextField txtNIK = new JTextField();
	JLabel lblNmLengkap = new JLabel("Nama Lengkap: ");
	JTextField txtNmLengkap = new JTextField();
	JLabel lblTglLahir = new JLabel("Tanggal Lahir: ");
	String[] arrTgl = {"Tanggal","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	JComboBox cbTgl = new JComboBox(arrTgl);
	String[] arrBln = {"Bulan","Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"};
	JComboBox cbBln = new JComboBox(arrBln);
	String[] arrThn = {"Tahun","1945","1946","1947","1948","1949","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015"};
	JComboBox cbThn = new JComboBox(arrThn);
	JLabel lblJK = new JLabel("Jenis Kelamin: ");
	JRadioButton rbPria = new JRadioButton("Pria",false);
	JRadioButton rbWanita = new JRadioButton("Wanita",false);
	JLabel lblStatus = new JLabel("Status: ");
	String[] arrStatus = {"Belum Menikah","Menikah"};
	JComboBox cbStatus = new JComboBox(arrStatus);
	JLabel lblAgama = new JLabel("Agama: ");
	String[] arrAgama = {"Islam","Kristen","Protestan","Katholik","Hindu","Buddha","Konghucu"};
	JComboBox cbAgama = new JComboBox(arrAgama);
	JLabel lblNoTlpRmh = new JLabel("No Tlp Rumah: ");
	JTextField txtNoTlpRmh = new JTextField();
	JLabel lblTlp = new JLabel("Telepon: ");
	JTextField txtTlp = new JTextField();
	JButton cmdTambah = new JButton("Tambah");
	JButton cmdHapus = new JButton("Hapus");
	JButton cmdSimpan = new JButton("Simpan");
	ButtonGroup bgJK = new ButtonGroup();
	
	//deklarasi objek tabel
  	String[] strJdl = {"KdW","RT","RW","NoRmh","NIK","Nama","Lahir","JK","Status","Agama","NoTlpRmh","No.Tlp"};
	DefaultTableModel tabMode;
	JTable tabelWarga = new JTable();
	JScrollPane spTabelWarga = new JScrollPane();
	
	public formEntryWarga(){
		
		setSize(750,650);
		setLocationRelativeTo(this);
		setTitle("Form Entry Warga");
		
		bgJK.add(rbPria);
		bgJK.add(rbWanita);
		
		lblKodeWarga.setBounds(20,20,100,25);
		txtKodeWarga.setBounds(130,20,100,25);
		cmdCari.setBounds(240,20,100,25);
		lblRT.setBounds(20,50,100,25);
		cbRT.setBounds(130,50,100,25);
		lblRW.setBounds(20,80,100,25);
		cbRW.setBounds(130,80,100,25);
		lblNoRmh.setBounds(20,120,100,25);
		cbNoRmh.setBounds(130,120,100,25);
		lblNIK.setBounds(20,150,100,25);
		txtNIK.setBounds(130,150,210,25);
		lblNmLengkap.setBounds(20,180,100,25); 
		txtNmLengkap.setBounds(130,180,210,25);
		lblTglLahir.setBounds(20,220,100,25); 
		cbTgl.setBounds(130,220,100,25);
		cbBln.setBounds(240,220,100,25);
		cbThn.setBounds(350,220,100,25);
		lblJK.setBounds(20,250,100,25); 
		rbPria.setBounds(130,250,100,25);
		rbWanita.setBounds(230,250,100,25);
		lblStatus.setBounds(20,280,100,25); 
		cbStatus.setBounds(130,280,100,25);
		lblAgama.setBounds(20,320,100,25); 
		cbAgama.setBounds(130,320,100,25);
		lblNoTlpRmh.setBounds(20,350,100,25); 
		txtNoTlpRmh.setBounds(130,350,210,25);
		lblTlp.setBounds(20,380,100,25); 
		txtTlp.setBounds(130,380,210,25);
		cmdTambah.setBounds(130,420,100,25);
		cmdHapus.setBounds(240,420,100,25);
		cmdSimpan.setBounds(350,420,100,25);
		
		// instansiasi objek tabel
		tabMode = new DefaultTableModel(null,strJdl);
		tabelWarga.setModel(tabMode);
		spTabelWarga.getViewport().add(tabelWarga);
		tabelWarga.setEnabled(true);
		spTabelWarga.setBounds (20, 460, 700, 100);	//batasan scroll.
		
		getContentPane().setLayout(null);
		getContentPane().add(lblKodeWarga);
		getContentPane().add(txtKodeWarga);
		getContentPane().add(cmdCari);
		getContentPane().add(lblRT);
		getContentPane().add(cbRT);
		getContentPane().add(lblRW);
		getContentPane().add(cbRW);
		getContentPane().add(lblNoRmh);
		getContentPane().add(cbNoRmh);
		getContentPane().add(lblNIK);
		getContentPane().add(txtNIK);
		getContentPane().add(lblNmLengkap);
		getContentPane().add(txtNmLengkap);
		getContentPane().add(lblTglLahir);
		getContentPane().add(cbTgl);
		getContentPane().add(cbBln);
		getContentPane().add(cbThn);
		getContentPane().add(lblJK);
		getContentPane().add(rbPria);
		getContentPane().add(rbWanita);
		getContentPane().add(lblStatus);
		getContentPane().add(cbStatus);
		getContentPane().add(lblAgama);
		getContentPane().add(cbAgama);
		getContentPane().add(lblNoTlpRmh);
		getContentPane().add(txtNoTlpRmh);
		getContentPane().add(lblTlp);
		getContentPane().add(txtTlp);
		getContentPane().add(cmdTambah);
		getContentPane().add(cmdHapus);
		getContentPane().add(cmdSimpan);
		getContentPane().add(spTabelWarga);
		
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
			String sql = "SELECT * FROM formEntryWarga";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				 		
				String vKdW = rs.getString("Kd");
				String vRT = rs.getString("RT");
				String vRW = rs.getString("RW");
				String vNoRmh = rs.getString("NoRmh");
				String vNIK = rs.getString("NIK");
				String vNama = rs.getString("NmLgkp");
				String vLahir = rs.getString("TglLhr");
				String vJK = rs.getString("JK");
				String vStatus = rs.getString("Stts");
				String vAgama = rs.getString("Agama");
				String vNoTlpRmh = rs.getString("NoTpRmh");
				String vNoTlp = rs.getString("noTlp");
				String[] data = {"",vKdW,vRT,vRW,vNoRmh,vNIK,vNama,vLahir,vJK,vStatus,vAgama,vNoTlpRmh,vNoTlp};
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
		new formEntryWarga();
	}
}

