package com.example.btsqlitevenha;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterDuLieuSinhVien extends BaseAdapter {

    Context context;
    ArrayList<DuLieuSinhVien> arrayList;

    public AdapterDuLieuSinhVien(Context context, ArrayList<DuLieuSinhVien> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHoder{
        TextView tvID, tvTen, tvNgaySinh, tvTruong, tvQue, tvSDT, tvEmail, tvGioiTinh;
        ImageView ivEdit, ivClear;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHoder hoder;

        if(view == null){
            hoder = new ViewHoder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_sinh_vien_moder, null);

            hoder.tvID = view.findViewById(R.id.tvID);
            hoder.tvTen = view.findViewById(R.id.tvHoTen);
            hoder.tvNgaySinh = view.findViewById(R.id.tvNgaySinh);
            hoder.tvTruong = view.findViewById(R.id.tvTruongHoc);
            hoder.tvQue = view.findViewById(R.id.tvQue);
            hoder.tvSDT = view.findViewById(R.id.tvSDT);
            hoder.tvEmail = view.findViewById(R.id.tvMail);
            hoder.tvGioiTinh = view.findViewById(R.id.tvGioiTinh);
            hoder.ivClear = view.findViewById(R.id.ivClear);
            hoder.ivEdit = view.findViewById(R.id.ivEdit);

            view.setTag(hoder);
        }else{
            hoder = (ViewHoder) view.getTag();
        }

        final DuLieuSinhVien duLieuSinhVien = arrayList.get(i);

        hoder.tvID.setText(duLieuSinhVien.getId()+"");
        hoder.tvTen.setText(duLieuSinhVien.getHoTen());
        hoder.tvNgaySinh.setText(duLieuSinhVien.getNgaySinh());
        hoder.tvTruong.setText(duLieuSinhVien.getTenTruong());
        hoder.tvQue.setText(duLieuSinhVien.getQueQuan());
        hoder.tvSDT.setText(duLieuSinhVien.getSDT());
        hoder.tvEmail.setText(duLieuSinhVien.getEmail());
        hoder.tvGioiTinh.setText(duLieuSinhVien.getGioiTinh()+"");


        hoder.ivClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);

                dialog.setMessage("Bạn có muốn xóa sinh viên "+duLieuSinhVien.getHoTen()+" không ??");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.databaseSinhVien.xoaDL(duLieuSinhVien.getId());

                        arrayList.clear();
                        arrayList.addAll(MainActivity.databaseSinhVien.layData());
                        notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });

        hoder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.sua_tt_sinh_vien);


                final EditText etTen = dialog.findViewById(R.id.etHoTen);
                final EditText etNgaySinh = dialog.findViewById(R.id.etNgaySinh);
                final EditText etTruong = dialog.findViewById(R.id.etTruongHoc);
                final EditText etQue = dialog.findViewById(R.id.etQue);
                final EditText etSDT = dialog.findViewById(R.id.etSDT);
                final EditText etEmail = dialog.findViewById(R.id.etEmail);
                final RadioButton rbNam = dialog.findViewById(R.id.rbNamm);
                final RadioButton rbNu = dialog.findViewById(R.id.rbNuu);
                Button btHuy = dialog.findViewById(R.id.btHuy);
                Button btXacNhan = dialog.findViewById(R.id.btXacNhan);


                etTen.setText(duLieuSinhVien.getHoTen());
                etNgaySinh.setText(duLieuSinhVien.getNgaySinh());
                etTruong.setText(duLieuSinhVien.getTenTruong());
                etQue.setText(duLieuSinhVien.getQueQuan());
                etSDT.setText(duLieuSinhVien.getSDT());
                etEmail.setText(duLieuSinhVien.getEmail());

                btHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                btXacNhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int gioiTinh = duLieuSinhVien.getGioiTinh();
                        String ten = etTen.getText().toString();
                        String ngaySinh = etNgaySinh.getText().toString();
                        String tenTruong = etTruong.getText().toString();
                        String queQuan = etQue.getText().toString();
                        String sdt = etSDT.getText().toString();
                        String mail = etEmail.getText().toString();

                        if(rbNam.isChecked()){
                            gioiTinh = 1;
                        }else if(rbNu.isChecked()){
                            gioiTinh = 0;
                        }
                        DuLieuSinhVien sinhVien1 = new DuLieuSinhVien(ten, ngaySinh, tenTruong, queQuan, sdt, mail, gioiTinh);
                        sinhVien1.setId(duLieuSinhVien.getId());
//
                        //sửa đối tượng tại vi tris thứ i
                        arrayList.set(i,sinhVien1);
                        MainActivity.databaseSinhVien.suaDL(sinhVien1, duLieuSinhVien.getId());
                        notifyDataSetChanged();

                        dialog.dismiss();

                    }
                });
                dialog.show();

            }
        });


        return view;
    }
}
