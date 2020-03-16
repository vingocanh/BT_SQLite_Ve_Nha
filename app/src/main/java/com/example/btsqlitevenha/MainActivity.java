package com.example.btsqlitevenha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etTen, etNgaySinh, etTruongHoc, etQueQuan, etSDT, etMail;
    RadioButton rbNam, rbNu;
    Button btThem, btXem;
    public static DatabaseSinhVien databaseSinhVien;
    public static ArrayList<DuLieuSinhVien> arrayListSinhVien;
    public static AdapterDuLieuSinhVien adapterDuLieuSinhVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseSinhVien = new DatabaseSinhVien(this);

        anhXa();
        xuLy();
    }

    public void anhXa(){
        etTen = findViewById(R.id.etHoTen);
        etNgaySinh = findViewById(R.id.etNTN);
        etTruongHoc = findViewById(R.id.etTH);
        etQueQuan = findViewById(R.id.etQueQuan);
        etSDT = findViewById(R.id.etsdt);
        etMail = findViewById(R.id.etEmail);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        btThem = findViewById(R.id.btNhapLieu);
        btXem = findViewById(R.id.btxemDS);
    }

    public void xuLy(){
        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int gioiTinh = 1;
                String ten = etTen.getText().toString();
                String ngaySinh = etNgaySinh.getText().toString();
                String tenTruong = etTruongHoc.getText().toString();
                String queQuan = etQueQuan.getText().toString();
                String sdt = etSDT.getText().toString();
                String mail = etMail.getText().toString();

                if(rbNu.isChecked()){
                    gioiTinh = 0;
                }
                DuLieuSinhVien duLieuSinhVien = new DuLieuSinhVien(ten, ngaySinh, tenTruong, queQuan, sdt, mail, gioiTinh);

                if(duLieuSinhVien != null){
                    Toast.makeText(MainActivity.this, "Thêm DL Thành công", Toast.LENGTH_SHORT).show();
                }

                databaseSinhVien.themDL(duLieuSinhVien);

                etTen.setText("");
                etNgaySinh.setText("");
                etTruongHoc.setText("");
                etQueQuan.setText("");
                etSDT.setText("");
                etMail.setText("");
            }
        });

        btXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HienThiDanhSachsvModel.class);

                startActivity(intent);
            }
        });
    }
}
