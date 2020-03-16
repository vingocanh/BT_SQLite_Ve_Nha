package com.example.btsqlitevenha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HienThiDanhSachsvModel extends AppCompatActivity {

    ListView lvDS;
//    ArrayList<DuLieuSinhVien> arrayListHienThi;
//    AdapterDuLieuSinhVien adapterDuLieuSinhVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_danh_sachsv_model);

        lvDS = findViewById(R.id.lvDanhSach);

//        arrayListHienThi = MainActivity.databaseSinhVien.layData();
//
//        adapterDuLieuSinhVien = new AdapterDuLieuSinhVien(this, arrayListHienThi);

        MainActivity.arrayListSinhVien = MainActivity.databaseSinhVien.layData();
        MainActivity.adapterDuLieuSinhVien = new AdapterDuLieuSinhVien(this, MainActivity.arrayListSinhVien);

        lvDS.setAdapter(MainActivity.adapterDuLieuSinhVien);


    }
}
