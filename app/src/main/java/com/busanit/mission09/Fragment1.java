package com.busanit.mission09;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_1, container);
        EditText editName = rootView.findViewById(R.id.editName);
        EditText editAge = rootView.findViewById(R.id.editAge);
        Button btnBirth = rootView.findViewById(R.id.btnBirth);
        Button btnSave = rootView.findViewById(R.id.btnSave);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DATE);
        btnBirth.setText(year + ". "+month+". "+day);

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                btnBirth.setText(year+". "+(month+1)+". "+dayOfMonth);
            }
        };

        btnBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editAge.getText().toString().equals("")){
                    if (Integer.parseInt(editAge.getText().toString())>200){
                        Toast.makeText(getContext(), "나이를 확인하세요.",
                        Toast.LENGTH_SHORT).show();
                    } else {
                        DatePickerDialog dialog = new DatePickerDialog(getContext(), listener,
                                (year-Integer.parseInt(editAge.getText().toString())+1), (month-1),day);
                        dialog.show();
                    }
                } else {
                    Toast.makeText(getContext(), "이름과 나이를 입력하세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "이름 : "+editName.getText().toString()+
                        ", 나이 : "+editAge.getText().toString()+", 생년월일 : "+btnBirth.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}