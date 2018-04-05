/*
-----------------------------------------------------
	Nama Program 	: Koneksi.java
	Dipanggil Oleh	: Semua program yang terhubung database
	Keterangan 		: Program koneksi database dengan Ms. Access
	Dibuat Oleh		: AEndF@2008, Versi Update
-----------------------------------------------------
*/

import java.sql.*;

public class Koneksi {
  	public Koneksi()  {
  	}
  	
	public Connection bukaKoneksi() throws SQLException  {
        Connection con = null;
     	try {
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      	    con=DriverManager.getConnection("jdbc:odbc:Warga","jdbc:odbc:Edaran","");
		    return con;
		}
    	catch (SQLException se) {
      	    System.out.println("No Connection Open");
      	    return null;
    	}
        catch (Exception ex) {
      	   System.out.println("Cound not open connection");
      	   return null;
    	}
  	}
}