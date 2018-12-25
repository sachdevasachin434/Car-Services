package com.example.sachd.countingcars;


import android.content.ContentValues;
import android.content.Intent;
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
public class SignUp extends Fragment implements View.OnClickListener{
    EditText Name,Email,Mobile,Uid,Pass;
    Button b1;
    View view;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;



    public SignUp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        b1 = (Button) view.findViewById(R.id.sign);
        Name=(EditText)view.findViewById(R.id.name);
        Email=(EditText)view.findViewById(R.id.mail);
        Mobile=(EditText)view.findViewById(R.id.mobile);
        Uid=(EditText)view.findViewById(R.id.uid);
        Pass=(EditText)view.findViewById(R.id.pass);
        b1.setOnClickListener(this);
        return(view);
    }

    @Override
    public void onClick(View view) {
        str1=Name.getText().toString();
        str2=Email.getText().toString();
        str3=Mobile.getText().toString();
        str4=Uid.getText().toString();
        str5=Pass.getText().toString();
        if(str1==null || str2==null ||str3==null||str4==null||str5==null)
        {Toast.makeText(getContext(),"Please Enter All The Fields", Toast.LENGTH_LONG).show();}
        else {
            CCDB dbhelper=new CCDB(view.getContext());
            SQLiteDatabase db = dbhelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("username", str4);
            values.put("password", str5);
            values.put("email", str2);
            values.put("mobile", str3);
            values.put("name", str1);
            long err = db.insert("user", null, values);
            if (err == -1) {
                Toast.makeText(view.getContext(), "Some error occurred", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Signed Up Successfully", Toast.LENGTH_LONG).show();
            }
            db.close();

            }
    }
}