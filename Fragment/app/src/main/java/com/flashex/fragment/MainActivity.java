package com.flashex.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static Frame frame;
    public static MainActivity mainActivity;
    Button button;
    public static EditText edtName,edtSurname;
    public static Bundle mainBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame=new Frame();
        mainBundle=new Bundle();
        getSupportFragmentManager().beginTransaction().replace(R.id.table_layout,frame).commit();
        button=findViewById(R.id.btn_send);
        edtName=findViewById(R.id.edit_name);
        edtSurname=findViewById(R.id.edit_surname);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtName.getText().toString();
                String surname=edtSurname.getText().toString();

                frame.infoGet(name,surname);

            }
        });
    }

    public static MainActivity mainActivityGetInfo(String name,String surname){
        mainBundle.putString("mainName",name);
        mainBundle.putString("mainSurname",surname);

        edtName.setText(mainBundle.getString("mainName"));
        edtSurname.setText(mainBundle.getString("mainSurname"));

        return mainActivity;
    }



}