package jdbcapp;

import java.sql.*;

public class Connector {
    /* 
        Menyimpan informasi database ke dalam sebuah variabel.
        Pada contoh ini kita menggunakan database bernama "upnvy".
     */
    String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    String nama_db = "upnvy";
    String url_db = "jdbc:mysql://localhost:3306/" + nama_db;
    String username_db = "root";
    String password_db = "";

    Connection conn;
    
    // Mencoba menghubungkan program kita dengan ke database MySQL.
    public Connector() {
        try {
            System.out.println(url_db);
            
            // 1. Register driver yang akan dipakai
            Class.forName(jdbc_driver);
            
            // 2. Buat koneksi ke database
            conn = DriverManager.getConnection(url_db, username_db, password_db);

            // 3. Menampilkan pesan "Connection Success" jika berhasil terhubung ke database.
            System.out.println("Connection Success");
        } catch (ClassNotFoundException | SQLException exception) {
            // Menampilkan pesan error ketika MySQL gagal terhubung.
            System.out.println("Connection Failed: " + exception.getLocalizedMessage());
        }
    }
}
