/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOKLET-1
 */

   

import java.util.ArrayList;
import java.util.Scanner;

public class Peminjaman {

    private ArrayList<Integer> idSiswa = new ArrayList<Integer>();
    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();

    public Peminjaman() {
        this.idSiswa.add(0);
        this.idBuku.add(0);
        this.banyak.add(2);

        this.idSiswa.add(1);
        this.idBuku.add(1);
        this.banyak.add(1);
    }

    public void setProsesPeminjaman(Siswa siswa, Peminjaman peminjaman, Buku buku, Laporan laporan) {
        Scanner myObj = new Scanner(System.in);
        System.out.println();

        System.out.println("<<<< Mulai Meminjam >>>");
        System.out.println("Masukkan Id Siswa : ");
        int idSiswa = myObj.nextInt();
        if(siswa.getStatus(idSiswa) == false){
            System.out.println("Selamat datang " + siswa.getNama(idSiswa) + " Di Perpustakaan ");
            System.out.println("Mohon maaf anda tidak bisa melakukan peminjaman buku");
            System.exit(0);
        }
        System.out.println("Selamat datang " + siswa.getNama(idSiswa) + " Di Perpustakaan ");
        ArrayList<Integer> idBuku = new ArrayList<Integer>();
        ArrayList<Integer> banyak = new ArrayList<Integer>();

        int i = 0;
        int temp = 0;
        do {
            System.out.println("Masukkan Kode Buku : ");
            temp = myObj.nextInt();
            if (temp != 99) {
                idBuku.add(temp);
                System.out.println(buku.getNamaBuku(idBuku.get(i)) + " sebanyak : ");
                banyak.add(myObj.nextInt());
                if(banyak.get(i) > buku.getStok(idBuku.get(i))){
                    System.out.println("Sisa stok buku tidak mencukupi");
                    System.exit(0);
                }
                i++;
            }
        } while (temp != 99);

        System.out.println("Transaksi Peminjaman Buku " + siswa.getNama(idSiswa) + " Sebagai berikut ");
        System.out.println("Nama Buku \tBanyak \tHargaPinjam \tJumlah");

        int total = 0;
        int x = idBuku.size();
        for (int j = 0; j < x; j++) {
            int jumlah = banyak.get(j) * buku.getHarga(idBuku.get(j));
            total += jumlah;
            System.out.println(buku.getNamaBuku(idBuku.get(j)) + "  \t" + banyak.get(j) + "  \t" + buku.getHarga(idBuku.get(j)) + "     \t" + jumlah);
            peminjaman.setPeminjaman(buku, idSiswa, idBuku.get(j), banyak.get(j));
        }
        System.out.println("Total Peminjaman : " + total);
        siswa.editStatus(idSiswa, siswa.getStatus(idSiswa) == false);
        System.out.println("Status " + siswa.getNama(idSiswa) + " = "+ siswa.getStatus(idSiswa));
        if (siswa.getStatus(idSiswa) == true) {
            System.out.println("Dapat Meminjam Buku");
        } else {
            System.out.println("Tidak Dapat Meminjam Buku");
        }

        System.out.println("Apakah kamu ingin mengembalikan buku ? \n   Angka 1 : Yes  \n   Angka 2 : No");
        int answer = myObj.nextInt();
        if (answer == 1) {
            siswa.editStatus(idSiswa, true);
            System.out.println("Status " + siswa.getNama(idSiswa) + " = " +siswa.getStatus(idSiswa));
            for (int j = 0; j < x; j++) {
                peminjaman.setPengembalian(buku, idSiswa, idBuku.get(j), banyak.get(j));
            }
        }else{
            System.out.println("Anda Belum Mengembalikan Buku");
            laporan.Laporan(buku);
            laporan.Laporan(siswa);
            System.exit(0);          
        }
    }
    public void setPeminjaman(Buku buku, int idSiswa, int idBuku, int banyaknya){
        this.idSiswa.add(idSiswa);
        this.idBuku.add(idBuku);
        this.banyak.add(banyaknya);
        buku.editStok(idBuku, buku.getStok(idBuku) - banyaknya);
    }
    
    public void setPengembalian(Buku buku, int idSiswa, int idBuku, int banyaknya){
        this.idSiswa.add(idSiswa);
        this.idBuku.add(idBuku);
        this.banyak.add(banyaknya);
        buku.editStok(idBuku, buku.getStok(idBuku) + banyaknya);
    }
    
    public int getIdSiswa(int id){
        return this.idSiswa.get(id);
    }
    
    public int getIdBuku(int id){
        return this.idBuku.get(id);
    }
    
    public int getBanyaknya(int id){
        return this.banyak.get(id);
    }
    
    public int getJmlPeminjaman(){
        return this.idSiswa.size();
    }
} 

