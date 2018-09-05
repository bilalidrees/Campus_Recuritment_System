package com.example.bilalidrees.crs;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Company_Adapter extends ArrayAdapter<job_data> {


    public Company_Adapter(@NonNull Context context, int resource, @NonNull List<job_data> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.student_listview, parent, false);
        }

        TextView sname = (TextView) convertView.findViewById(R.id.List_name_View);
        TextView fname= (TextView) convertView.findViewById(R.id.List_f_name);


        job_data message = getItem(position);


        sname.setText( message.req_company_name);
        fname.setText( message.req_job_title);

        return convertView;
    }
}
