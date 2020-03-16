package com.example.btsqlitevenha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseSinhVien extends SQLiteOpenHelper {

    private static String Database_Name = "QuanLySinhVien";
    private static String Table_Name = "SinhVien";
    private static String ID = "ID";
    private static String HoTen = "hoTen";
    private static String NgaySinh = "ngaySinh";
    private static String TruongHoc = "truongHoc";
    private static String QueQuan = "queQuan";
    private static String SDT = "sdt";
    private static String Email = "gmail";
    private static String GioiTinh = "gioiTinh";
    public DatabaseSinhVien(@Nullable Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String truyVanDL = "CREATE TABLE "+Table_Name+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                            +HoTen+" VARCHAR(200), "
                            +NgaySinh+" VARCHAR(100), "
                            +TruongHoc+" VARCHAR(200), "
                            +QueQuan+" VARCHAR(150), "
                            +SDT+" VARCHAR(100), "
                            +Email+" VARCHAR(200), "
                            +GioiTinh+" INTEGER)";
        sqLiteDatabase.execSQL(truyVanDL);
    }

    public void themDL(DuLieuSinhVien sinhVien){
        SQLiteDatabase database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        //contentValues.put(ID, sinhVien.getId());
        contentValues.put(HoTen, sinhVien.getHoTen());
        contentValues.put(NgaySinh, sinhVien.getNgaySinh());
        contentValues.put(TruongHoc, sinhVien.getTenTruong());
        contentValues.put(QueQuan, sinhVien.getQueQuan());
        contentValues.put(SDT, sinhVien.getSDT());
        contentValues.put(Email, sinhVien.getEmail());
        contentValues.put(GioiTinh, sinhVien.getGioiTinh());

        database.insert(Table_Name, null, contentValues);

        database.close();
    }

    public ArrayList<DuLieuSinhVien> layData(){
        ArrayList<DuLieuSinhVien> duLieuSinhViens = new ArrayList<>();

        String layDL = "SELECT * FROM "+Table_Name;

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(layDL, null);

        while (cursor.moveToNext()){
            DuLieuSinhVien sinhVien = new DuLieuSinhVien();

            sinhVien.setId(cursor.getInt(0));
            sinhVien.setHoTen(cursor.getString(1));
            sinhVien.setNgaySinh(cursor.getString(2));
            sinhVien.setTenTruong(cursor.getString(3));
            sinhVien.setQueQuan(cursor.getString(4));
            sinhVien.setSDT(cursor.getString(5));
            sinhVien.setEmail(cursor.getString(6));
            sinhVien.setGioiTinh(cursor.getInt(7));

            duLieuSinhViens.add(sinhVien);
        }

        database.close();
        return duLieuSinhViens;
    }

    public int xoaDL(int id){

        SQLiteDatabase database = getWritableDatabase();

        return database.delete(Table_Name, ID +" = ?", new String[]{String.valueOf(id)});
    }

    public int suaDL(DuLieuSinhVien sinhVien, int id){
        SQLiteDatabase database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(HoTen, sinhVien.getHoTen());
        contentValues.put(NgaySinh, sinhVien.getNgaySinh());
        contentValues.put(TruongHoc, sinhVien.getTenTruong());
        contentValues.put(QueQuan, sinhVien.getQueQuan());
        contentValues.put(SDT, sinhVien.getSDT());
        contentValues.put(Email, sinhVien.getEmail());
        contentValues.put(GioiTinh, sinhVien.getGioiTinh());

        return database.update(Table_Name, contentValues, ID + " = ?", new String[]{String.valueOf(id)});
        }

//    public void delete(){
//        ArrayList<DuLieuSinhVien> duLieuSinhViens = new ArrayList<>();
//
//        SQLiteDatabase database = getWritableDatabase();
//
//        String delete = "DELETE "+Table_Name+" WHERE ID = ";
//
//    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
