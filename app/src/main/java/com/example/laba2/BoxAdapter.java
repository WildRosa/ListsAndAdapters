package com.example.laba2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewOnReceiveContentListener;
import java.util.Date;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

public class BoxAdapter extends BaseAdapter {
    public static final int IDM_OPEN = 101;
    public static final int IDM_SAVE = 102;

    DateFormat df=new SimpleDateFormat("dd.MM.yyyy");



    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Employee> objects;
    BoxAdapter(Context context, ArrayList<Employee> employees) {
        ctx = context;
        objects = employees;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }




    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        Employee p = getProduct(position);


        ((TextView) view.findViewById(R.id.tvName)).setText(p.getName());
        ((TextView) view.findViewById(R.id.tvNumber)).setText(p.getDepartment_number() + "");
        ((TextView) view.findViewById(R.id.tvPosition)).setText(p.getPosition() );
        ((TextView) view.findViewById(R.id.tvDate)).setText(df.format(p.getDate_work()));
        LinearLayout menuList = (LinearLayout) view.findViewById(R.id.linearLayout1);

        return view;
    }
    // товар по позиции
    Employee getProduct(int position) {
        return ((Employee) getItem(position));
    }





}