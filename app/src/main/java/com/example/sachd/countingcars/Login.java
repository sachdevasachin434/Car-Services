package com.example.sachd.countingcars;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment implements View.OnClickListener{
    EditText uid,pass;
    Button b1;
    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        uid = (EditText) v.findViewById(R.id.et1);
        pass=(EditText)v.findViewById(R.id.et2);
        b1=(Button)v.findViewById(R.id.log);
        b1.setOnClickListener(this);
        return (v);
    }

    @Override
    public void onClick(View view) {
//        Toast.makeText(view.getContext(), "Hello Sachin", Toast.LENGTH_SHORT).show();
        String user=uid.getText().toString();
        String passw=pass.getText().toString();

        if (user.isEmpty() || passw.isEmpty()) {
            Toast.makeText(view.getContext(), "Please enter the username and password", Toast.LENGTH_SHORT).show();
        } else {
            CCDB dbhelper=new CCDB(view.getContext());
            SQLiteDatabase db = dbhelper.getReadableDatabase();
            Cursor mCursor = db.rawQuery("select count(*) from user where username = '"+user+"' and password = '"+passw+"'",null);
            if (mCursor != null) {
                mCursor.moveToFirst();
                int cnt = mCursor.getInt(0);
                if (cnt > 0) {
//                    Toast.makeText(view.getContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(view.getContext(),MainActivity.class);
                    i.putExtra("main-channel", "test-main-channel");
                    startActivity(i);
                } else {
                    Toast.makeText(view.getContext(), "Wrong Username or Password !!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(view.getContext(), "Some error occurred", Toast.LENGTH_SHORT).show();
            }
            //Toast.makeText(view.getContext(), "Wrong Username or Password !", Toast.LENGTH_SHORT).show();
        }


        CCDB ccdb=new CCDB(view.getContext());


    }
}
