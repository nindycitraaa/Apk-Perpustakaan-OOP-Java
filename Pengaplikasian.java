/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOKLET-1
 */

   

import java.util.Scanner;

public class Pengaplikasian {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int temp = 0;
        do {
            Siswa siswa = new Siswa();
            Petugas petugas = new Petugas();
            Buku buku = new Buku();
            Laporan laporan = new Laporan();
            Peminjaman peminjaman = new Peminjaman();

            laporan.Laporan(buku);          
            laporan.Laporan(siswa);
            laporan.Laporan(peminjaman, buku);

            peminjaman.setProsesPeminjaman(siswa, peminjaman, buku, laporan);
            laporan.Laporan(buku);           
            laporan.Laporan(siswa);
            System.out.println("Lanjutkan atau Matikan 1 : 99");
            temp = myObj.nextInt();
        } while (temp != 99);
        System.exit(0);
    }
}

