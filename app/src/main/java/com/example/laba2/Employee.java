package com.example.laba2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
public class Employee {

    private String name;
    private int department_number;
    private String position;
    private Date date_work;



    Employee(String _name, int _department_number, String _position, Date _date_work) {
        this.name = _name;
        this.department_number = _department_number;
        this.position = _position;
        this.date_work = _date_work;

    }

    public String getName() {return name;}
    public int getDepartment_number() {return department_number;}
    public String getPosition() {return position;}
    public Date getDate_work() {return date_work;}

    public void setName(String Name){ this.name = Name;}
    public void setDepartment_number(int Department_number) {this.department_number = Department_number;}
    public void setPosition(String Position) {this.position = Position;}
    public void setDate_work(Date Date_work) {this.date_work = Date_work;}
    public static Comparator<Employee> DepartmentComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee p1, Employee p2) {
            int c = p1.getDate_work().compareTo(p2.getDate_work());
            if (c == 0)
                c = p1.getName().compareToIgnoreCase(p2.getName());

            return c;
        }
    };

}