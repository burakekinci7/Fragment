package com.flashex.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frame extends Fragment {

    public static EditText edtFName,edtFSurname;
    Button btnFSend;
    public static Frame frameF;
    public static Bundle bundle;
    public static MainActivity mainActivity2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frame_edit,container,false);

        edtFName=view.findViewById(R.id.edit_frame_name);
        edtFSurname=view.findViewById(R.id.edit_frame_surname);
        btnFSend=view.findViewById(R.id.btn_frame_send);

        frameF=new Frame();
        bundle=new Bundle();

        btnFSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //veriyi activiteye gondercek
                String name=edtFName.getText().toString();
                String surname=edtFSurname.getText().toString();

                MainActivity.mainActivityGetInfo(name,surname);
            }
        });

        return view;
    }

    public Frame infoGet(String name,String surname){
        bundle.putString("name",name);
        bundle.putString("surname",surname);

        frameF.setArguments(bundle);

        edtFName.setText(bundle.getString("name"));
        edtFSurname.setText(bundle.getString("surname"));

        return frameF;
    }
}
