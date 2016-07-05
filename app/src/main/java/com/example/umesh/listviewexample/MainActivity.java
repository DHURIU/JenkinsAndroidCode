package com.example.umesh.listviewexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listStd ;
    TextView errMsg ;
    public static ArrayList<Student> studentsArray ;
    StudentAdapter sAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Student Listing");
        listStd = (ListView) findViewById(R.id.listStd);
        errMsg = (TextView) findViewById(R.id.errMsg);

        studentsArray = new ArrayList<Student>();
        sAdapter = new StudentAdapter(this, studentsArray);
        listStd.setAdapter(sAdapter);
        /*Student stdObj = new Student();
        stdObj.setRollnumber("1");
        stdObj.setStdName("Amar J Dhuri");
        studentsArray.add(stdObj);*/


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (studentsArray.size() > 0) {
            errMsg.setVisibility(View.GONE);
            listStd.setVisibility(View.VISIBLE);
        }else{
            errMsg.setVisibility(View.VISIBLE);
            listStd.setVisibility(View.GONE);
        }
        sAdapter.notifyDataSetChanged();
    }

    public class StudentAdapter extends BaseAdapter {

        Context context ;
        ArrayList<Student> studentslist;
        LayoutInflater inflater;

        public StudentAdapter(Context context, ArrayList<Student> studentslist){
            this.context = context;
            this.studentslist = studentslist;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return studentslist.size();
        }

        @Override
        public Object getItem(int position) {
            return studentslist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            Holder holder = new Holder();
            if(convertView == null) {
                convertView = inflater.inflate(R.layout.list_row, parent, false);
                holder.txtRoll = (TextView) convertView.findViewById(R.id.stdRollTxt);
                holder.txtName = (TextView) convertView.findViewById(R.id.stdName);
                holder.rel = (RelativeLayout) convertView.findViewById(R.id.relView);
                holder.delStdBtn = (Button) convertView.findViewById(R.id.delStdBtn);
                convertView.setTag(holder);
            }else{
                holder = (Holder) convertView.getTag();
            }
            int postionVal = position + 1 ;
            holder.txtRoll.setText(String.valueOf(postionVal)+".");
            holder.txtName.setText(studentslist.get(position).getStdName());
            holder.delStdBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    studentsArray.remove(position);
                    if (studentsArray.size() > 0) {
                        errMsg.setVisibility(View.GONE);
                        listStd.setVisibility(View.VISIBLE);
                    }else{
                        errMsg.setVisibility(View.VISIBLE);
                        listStd.setVisibility(View.GONE);
                    }
                    sAdapter.notifyDataSetChanged();
                }
            });


            return convertView;
        }
    }

    public class Holder {
        TextView txtRoll, txtName ;
        Button delStdBtn ;
        RelativeLayout rel ;

    }

    public void addStudent(View v) {
        Intent addStdView = new Intent(MainActivity.this, AddStudents.class);
        startActivity(addStdView);
    }

    public void deleteStd(View v){

    }

}
