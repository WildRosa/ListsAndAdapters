package com.example.laba2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import android.app.Activity;
import android.app.Person;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.content.Intent;

import androidx.annotation.RequiresApi;

public class MainActivity extends Activity {

    ArrayList<Employee> employees = new ArrayList<Employee>();

    String Date1 = "26.05.2021";
    String Date2 =  "11.09.2019";
    String Date3 =  "12.09.2018";
    DateFormat df=new SimpleDateFormat("dd.MM.yyyy");
    Date date1 = df.parse(Date1);
    Date date2 = df.parse(Date2);
    Date date3 = df.parse(Date3);


    BoxAdapter boxAdapter;
    LinearLayout linearLayout1;
    ListView lvMain;
    final int REQUEST_CODE = 1;
    int pos;
    int i;
    int check;
    private static final String STATE_LIST = "State Adapter Data";
    String name = "", position = "", _date = "";
    int department;

    public MainActivity() throws ParseException {
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // создаем адаптер
        boxAdapter = new BoxAdapter(this, employees);
        fillData();
        // настраиваем список
        lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        registerForContextMenu(lvMain);


        lvMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                pos = parent.getPositionForView(view);
                return false;
            }
        });


    }

    ;




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, v.getId(), 0, "Добавить");
        menu.add(0, v.getId(), 0, "Удалить");
        menu.add(0, v.getId(), 0, "Изменить");
        menu.add(0, v.getId(), 0, "Отсортировать");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onContextItemSelected(MenuItem item) {


        if (item.getTitle() == "Добавить") {

           // boxAdapter.notifyDataSetChanged();
            check = 1;
            Intent intent = new Intent(this, AddActivity.class);
            startActivityForResult(intent, 1);


        }

        if(item.getTitle() == "Изменить"){

            check = 0;
            name = employees.get(pos).getName();
            position = employees.get(pos).getPosition();
            department = employees.get(pos).getDepartment_number();
            //_date = employees.get(pos).getDate_work().toString();
            Date d = employees.get(pos).getDate_work();
            _date = df.format(d).toString();
            Intent intent = new Intent(this, EditActivity.class);


            intent.putExtra("name", name);
            intent.putExtra("position", position);
            intent.putExtra("department", department);
            intent.putExtra("date", _date);


            startActivityForResult(intent, 1);



        }

        if (item.getTitle() == "Удалить") {


            employees.remove(pos);
            boxAdapter.notifyDataSetChanged();

        }

        if (item.getTitle() == "Отсортировать") {
            Collections.sort(employees, Employee.DepartmentComparator);
            boxAdapter.notifyDataSetChanged();
        }

        return super.onOptionsItemSelected(item);
    }


    // генерируем данные для адаптера
    void fillData() {


        employees.add(new Employee("Азаренко Елена Анатольевна", 12, "Директор", date1));
        employees.add(new Employee("Столяренко Светлана Дмитриевна", 5, "Секретарь", date2));
        employees.add(new Employee("Масляков Адрей Олегович", 5, "Уборщик", date3));


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {return;}

            name = data.getStringExtra("name");
            department = data.getIntExtra("department", 0);
            position = data.getStringExtra("position");
            _date = data.getStringExtra("number");
            Date _Date = null;
            try {
                _Date = df.parse(_date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
           if(check == 1) employees.add(new Employee(name, department, position, _Date));
           else if(check == 0) employees.set(pos,  new Employee(name, department, position, _Date));
            boxAdapter.notifyDataSetChanged();

    }
}