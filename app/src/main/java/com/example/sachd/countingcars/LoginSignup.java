package com.example.sachd.countingcars;

import android.content.Intent;
import android.os.Trace;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.security.KeyStore;

public class LoginSignup extends AppCompatActivity implements View.OnClickListener{

    Button b1,b2,b3,b4;
    //    boolean b=false;
    Fragment fragment=null;
    //FragmentManager manager = getSupportFragmentManager();
    //FragmentTransaction transaction = manager.beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        b1=(Button)findViewById(R.id.login);
        b2=(Button)findViewById(R.id.signup);
        b3=(Button)findViewById(R.id.cont);
        b4=(Button)findViewById(R.id.login2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.drawermenu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.customer)
        {
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b4.setVisibility(View.INVISIBLE);
            b2.setEnabled(true);
            b3.setVisibility(View.VISIBLE);
            b3.setEnabled(true);
            return true;
        }
        else if(id==R.id.Mechanic)
        {
            b1.setVisibility(View.INVISIBLE);
            b4.setVisibility(View.VISIBLE);
            b2.setVisibility(View.INVISIBLE);
            b2.setEnabled(false);
            b3.setVisibility(View.INVISIBLE);
            b3.setEnabled(false);
            FragmentManager manager2 = getSupportFragmentManager();
            FragmentTransaction transaction2 = manager2.beginTransaction();
            fragment=new Blank();
            transaction2.replace(R.id.output,fragment);
            manager2.popBackStack();
            transaction2.commit();
            return true;
        }
        return true;
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.login || view.getId()==R.id.login2){
            //fragment=null;
            fragment= new Login();
        }
        else if(view.getId()==R.id.signup){
            //fragment=null;
            fragment= new SignUp();
        }

        if (view.getId() == R.id.login || view.getId() == R.id.signup || view.getId()==R.id.login2)
        {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.output, fragment);
            manager.popBackStack();
            transaction.commit();
        } else {
            Intent i=new Intent(this,MainActivity.class);
            i.putExtra("main-channel", "test-main-channel");
            startActivity(i);
        }
    }
}
