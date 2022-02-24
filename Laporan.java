/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOKLET-1
 */

public class Laporan {
   



    public void Laporan(Buku buku) {
        int x = buku.getJmlBuku();
        System.out.println();

        System.out.println("==== Tabel Buku ====");
        System.out.println("Nama Buku   \tStok  \tHarga Pinjam");
        for (int i = 0; i < x; i++) {
            System.out.println(buku.getNamaBuku(i) +"   \t"+ buku.getStok(i) +"   \t"+ buku.getHarga(i)+"/minggu");
        }
    }

    public void Laporan(Siswa siswa) {
        int x = siswa.getJmlSiswa();
        System.out.println();

        System.out.println("==== Tabel Siswa ====");
        System.out.println("Nama Siswa   \tAlamat   \tTelepon \tStatus");
        for (int i = 0; i < x; i++) {
            System.out.println(siswa.getNama(i) +"   \t"+ siswa.getAlamat(i) +"   \t"+ siswa.getTelepon(i) +"   \t"+ siswa.getStatus(i));
        }
    }

    public void Laporan(Peminjaman peminjaman, Buku buku) {
        int x = peminjaman.getJmlPeminjaman();
        System.out.println();

        System.out.println("==== Tabel Transaksi ====");
        System.out.println("Nama Buku   \tBanyak \tHarga Pinjam \tJumlah");
        int total = 0;
        for (int i = 0; i < x; i++) {
            int jumlah = peminjaman.getBanyaknya(i) * buku.getHarga(peminjaman.getIdBuku(i));
            total += jumlah;
            System.out.println(buku.getNamaBuku(peminjaman.getIdBuku(i)) +"   \t"+ peminjaman.getBanyaknya(i) +"   \t"+ buku.getHarga(peminjaman.getIdBuku(i))+"/minggu" +"   \t"+ jumlah);

        }
        System.out.println("Total Peminjaman : " + total);
    }

} 

