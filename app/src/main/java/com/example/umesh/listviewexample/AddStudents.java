package com.example.umesh.listviewexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddStudents extends AppCompatActivity {

    EditText stdNameTxt, stdAddressTxt, stdCityTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students2);
        setTitle("Add Students");

        stdNameTxt = (EditText) findViewById(R.id.stdNameTxt);
        stdAddressTxt = (EditText) findViewById(R.id.stdAddressTxt);
        stdCityTxt = (EditText) findViewById(R.id.stdCityTxt);

    }

    public void addStudentRecords(View v) {
        Student stdObj = new Student();
        stdObj.setStdName(stdNameTxt.getText().toString());
        int arraycount = MainActivity.studentsArray.size() + 1;
        stdObj.setRollnumber(String.valueOf(arraycount+"."));
        MainActivity.studentsArray.add(stdObj);
        finish();
    }
}
