package com.example.bilalidrees.crs;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Student_Adapter extends ArrayAdapter<Student_Data> {


    public Student_Adapter(@NonNull Context context, int resource, @NonNull List<Student_Data> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.student_listview, parent, false);
        }

        TextView sname = (TextView) convertView.findViewById(R.id.List_name_View);
        TextView fname= (TextView) convertView.findViewById(R.id.List_f_name);


            Student_Data message = getItem(position);

            sname.setText(message.student_name);
            fname.setText(message.student_fathername);

        return convertView;
    }
}

