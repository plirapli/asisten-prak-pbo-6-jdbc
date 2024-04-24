package jdbcapp;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection connect;      // Digunakan untuk menghubungkan ke DB.
    static Statement statement;     // Digunakan untuk melakukan query.
    static ResultSet rs;            // Digunakan untuk menyimpan hasil query.

    public static void main(String[] args) {
        try {
            // Menghubungkan program ke MySQL berdasarkan konfigurasi pada file "Connector.java";
            connect = new Connector().conn;

            // Membuat objek statement.
            statement = connect.createStatement();

            /* 
                Menyimpan query database ke dalam varibel "query".
                Dalam hal ini, kita akan mengambil seluruh data mahasiswa pada tabel "students".
            */
            String query = "SELECT * FROM students";

            // Mengeksekusi query dan menyimpannya ke dalam variabel "rs".
            rs = statement.executeQuery(query);
            
            /* 
                Karena hasil query berupa array, supaya dapat mencetak semua data student,
                Kita perlu melakukan looping (perulangan) untuk mencetak tiap-tiap elemen.
            */
            while (rs.next()) {
                // Mencetak tiap-tiap data mahasiswa.
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nama: " + rs.getString("nama"));
                System.out.println("NIM: " + rs.getString("nim"));
                System.out.println("");
            }

            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
            connect.close();
        } catch (Exception e) {
            // Menampilkan pesan error jika terjadi adanya error.
            System.out.println("Error: " + e.getMessage());
        }
    }
}
