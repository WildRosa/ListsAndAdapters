package com.example.laba2;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditActivity extends  Activity {

    EditText name;
    EditText department;
    EditText position;
    EditText date;
    Button clear4, clear1, clear2, clear3, buttonOK;
    TextView Error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        name = (EditText) findViewById(R.id.etName);
        department = (EditText) findViewById(R.id.etDepatment);
        position = (EditText) findViewById(R.id.etPosition);
        date = (EditText) findViewById(R.id.etDate);
        buttonOK = (Button) findViewById(R.id.btnOK);
        clear4 = (Button) findViewById(R.id.btnClear4);
        clear1 = (Button) findViewById(R.id.btnClear1);
        clear2 = (Button) findViewById(R.id.btnClear2);
        clear3 = (Button) findViewById(R.id.btnClear3);
        Error = (TextView) findViewById(R.id.textError);

        String Name = getIntent().getStringExtra("name");
        String Position = getIntent().getStringExtra("position");
        int finalDepartment = getIntent().getIntExtra("department", 0);
        String Department = finalDepartment + "";
        String Date = getIntent().getStringExtra("date");

        name.setText(Name);
        department.setText(Department);
        position.setText(Position);
        date.setText(Date);




    OnClickListener clickOK = new OnClickListener() {
        @Override
        public void onClick(View view) {
            String _Name = name.getText().toString();
            String _Department =  department.getText().toString();
            String _Position = position.getText().toString();
            String _Date = date.getText().toString();

            Intent intent = new Intent();
            if(_Name.length() != 0 && _Department.length() != 0 && _Position.length() != 0 && _Date.length() != 0 ) {

                int _finalDepartment = Integer.parseInt(_Department);
                intent.putExtra("name", _Name);
                //intent.putExtra("department", Department);
                intent.putExtra("department", _finalDepartment);
                intent.putExtra("position", _Position);
                intent.putExtra("number", _Date);
                setResult(RESULT_OK, intent);
                EditActivity.this.finish();
            }
            else{
                Error.setVisibility(View.VISIBLE);
            }
        }
    };
        buttonOK.setOnClickListener(clickOK);

    OnClickListener clickClear1 = new OnClickListener() {
        @Override
        public void onClick(View view) {
            name.getText().clear();
        }
    };
        clear1.setOnClickListener(clickClear1);

    OnClickListener clickClear2 = new OnClickListener() {
        @Override
        public void onClick(View view) {
            department.getText().clear();
        }
    };
        clear2.setOnClickListener(clickClear2);

    OnClickListener clickClear3 = new OnClickListener() {
        @Override
        public void onClick(View view) {
            position.getText().clear();
        }
    };
        clear3.setOnClickListener(clickClear3);

    OnClickListener clickClear4 = new OnClickListener() {
        @Override
        public void onClick(View view) {
            date.getText().clear();
        }
    };
        clear4.setOnClickListener(clickClear4);


}


}
