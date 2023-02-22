package com.example.laba2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import java.util.Date;

public class AddActivity extends Activity {
    EditText name;
    EditText department;
    EditText position;
    EditText date;
    Button clear4, clear1, clear2, clear3, buttonOK;
    TextView Error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


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


        OnClickListener clickOK = new OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Department =  department.getText().toString();
                String Position = position.getText().toString();
                String Date = date.getText().toString();

                Intent intent = new Intent();
                if(Name.length() != 0 && Department.length() != 0 && Position.length() != 0 && Date.length() != 0 ) {

                    int finalDepartment = Integer.parseInt(Department);
                    intent.putExtra("name", Name);
                    intent.putExtra("department", finalDepartment);
                    intent.putExtra("position", Position);
                    intent.putExtra("number", Date);
                    setResult(RESULT_OK, intent);
                    AddActivity.this.finish();
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