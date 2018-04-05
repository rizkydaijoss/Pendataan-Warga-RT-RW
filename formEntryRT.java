import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class formEntryRT extends JFrame{
	JLabel lblKodeRT = new JLabel("Kode RT: ");
	JTextField txtKodeRT = new JTextField();
	JButton cmdCari = new JButton("Cari");
	JLabel lblNamaKetua = new JLabel("Nama Ketua: ");
	JTextField txtNamaKetua = new JTextField();
	JLabel lblPeriode = new JLabel("Periode: ");
	JTextField txtPeriode = new JTextField();
	JButton cmdTambah = new JButton("Tambah");
	JButton cmdHapus = new JButton("Hapus");
	JButton cmdSimpan = new JButton("Simpan");
	
	//deklarasi objek tabel
  	String[] strJdl = {"KdRT","Ketua","Periode"};
	DefaultTableModel tabMode;
	JTable tabelRT = new JTable();
	JScrollPane spTabelRT = new JScrollPane();
	
	
	public formEntryRT(){
		
		setSize(500,300);
		setLocationRelativeTo(this);
		setTitle("Form Entry RT");
		
		lblKodeRT.setBounds(20,20,100,25); 
		txtKodeRT.setBounds(130,20,100,25);
		cmdCari.setBounds(240,20,100,25);
		lblNamaKetua.setBounds(20,50,100,25); 
		txtNamaKetua.setBounds(130,50,210,25);
		lblPeriode.setBounds(20,80,100,25); 
		txtPeriode.setBounds(130,80,210,25);
		cmdTambah.setBounds(130,120,100,25);
		cmdHapus.setBounds(240,120,100,25);
		cmdSimpan.setBounds(350,120,100,25);
		getContentPane().setLayout(null);
		getContentPane().add(lblKodeRT);
		getContentPane().add(txtKodeRT);
		getContentPane().add(cmdCari);
		getContentPane().add(lblNamaKetua);
		getContentPane().add(txtNamaKetua);
		getContentPane().add(lblPeriode);
		getContentPane().add(txtPeriode);
		getContentPane().add(cmdTambah);
		getContentPane().add(cmdHapus);
		getContentPane().add(cmdSimpan);
		getContentPane().add(spTabelRT);
		
		tampilketabel();
		
		// instansiasi objek tabel
		tabMode = new DefaultTableModel(null,strJdl);
		tabelRT.setModel(tabMode);
		spTabelRT.getViewport().add(tabelRT);
		tabelRT.setEnabled(true);
		spTabelRT.setBounds (20, 150, 430, 100);	//batasan scroll.
		
		setVisible(true);
	}
	
	// menampilkan data ke tabel
 	void tampilketabel(){
		try{
			hapusTabel();
	   		Koneksi ObjKoneksi = new Koneksi();
	   		Connection con = ObjKoneksi.bukaKoneksi();
	   		Statement st = con.createStatement();
			String sql = "SELECT * FROM formEntryRT";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				 		
				String vKdRT = rs.getString("KdRT");
				String vKetua = rs.getString("Ketua");
				String vPeriode = rs.getString("Periode");
				String[] data = {"",vKdRT,vKetua,vPeriode};
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
		new formEntryRT();
	}
}

