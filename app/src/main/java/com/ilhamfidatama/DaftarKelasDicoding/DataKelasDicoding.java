package com.ilhamfidatama.DaftarKelasDicoding;

import java.util.ArrayList;

public class DataKelasDicoding {
    public static String[][] data =new String[][]{
            {"Belajar Membuat Aplikasi Android untuk Pemula", "Pemula", "Reguler", "https://www.dicoding.com/academies/51", String.valueOf( R.drawable.android )},
            {"Menjadi Android Developer Expert", "Menengah", "Picodiploma", "https://www.dicoding.com/academies/14", String.valueOf( R.drawable.android )},
            {"Memulai Pemrograman Dengan Kotlin", "Pemula", "Reguler", "https://www.dicoding.com/academies/80", String.valueOf( R.drawable.kotlin )},
            {"Kotlin Android Developer Expert", "Menengah", "Picodiploma", "https://www.dicoding.com/academies/55", String.valueOf( R.drawable.kotlin )},
            {"Menjadi Flutter Developer Expert", "Menengah", "Picodiploma", "https://www.dicoding.com/academies/110", String.valueOf( R.drawable.flutter )}
    };

    public static ArrayList<KelasDicoding> getListKelasDicoding(){
        KelasDicoding kelas;
        ArrayList<KelasDicoding> listKelas = new ArrayList<>();

        for (String[] dataKelas:data) {
            kelas = new KelasDicoding();
            kelas.setKelas( dataKelas[0] );
            kelas.setLevel( dataKelas[1] );
            kelas.setTipeKelas( dataKelas[2] );
            kelas.setLink( dataKelas[3] );
            kelas.setGambar( dataKelas[4] );

            listKelas.add( kelas );
        }

        return listKelas;
    }
}
