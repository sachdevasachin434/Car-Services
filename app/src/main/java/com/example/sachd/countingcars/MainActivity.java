package com.example.sachd.countingcars;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected, View.OnClickListener {
    TextView mname, mage, mex, mprice;
    public int index;
    ArrayList<String> aname, aage, aex, pno, price;
    Button mcall;
    ViewPager viewPager;
    int images[] = {R.drawable.vp1, R.drawable.vpp2, R.drawable.vp4, R.drawable.vp5};
    MyCustomPagerAdapter myCustomPagerAdapter;

    String str;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcall = (Button) findViewById(R.id.mcall);
        mcall.setOnClickListener(this);
        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.customtoast, (ViewGroup) findViewById(R.id.custom_toast_layout));

        Intent i2 = getIntent();
        if (i2.getStringExtra("main-channel") == null) {
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.FILL, 0, 0);
            toast.setView(layout);
            toast.show();
            Intent i = new Intent(this, LoginSignup.class);
            startActivity(i);
        } else {

            viewPager = (ViewPager) findViewById(R.id.viewPager);

            myCustomPagerAdapter = new MyCustomPagerAdapter(MainActivity.this, images);
            viewPager.setAdapter(myCustomPagerAdapter);
        }
            mname = findViewById(R.id.mname);
            mage = findViewById(R.id.mage);
            mex = findViewById(R.id.mex);
            mprice=findViewById(R.id.price);
//        mcall=findViewById(R.id.mcall);

            aname = new ArrayList<String>();
            aname.add("Ramesh Singh");
            aname.add("Rohit Kumar");
            aname.add("Sagal Mehta");
            aname.add("Sachin");

            aage = new ArrayList<String>();
            aage.add("Age - 29 Years");
            aage.add("Age - 22 Years");
            aage.add("Age - 20 Years");
            aage.add("Age - 27 Years");

            aex = new ArrayList<String>();
            aex.add("Experience - 5 Years");
            aex.add("Experience - 3 Years");
            aex.add("Experience - 6 Years");
            aex.add("Experience - 2 Years");

            pno = new ArrayList<String>();
            pno.add("8222032220");
            pno.add("7206159959");
            pno.add("9729932599");
            pno.add("9896880610");

            price = new ArrayList<String>();
            price.add("1000");
            price.add("60");
            price.add("800");
            price.add("5000");

            if (findViewById(R.id.layout_portrait) != null) {
                FragmentManager fm = this.getSupportFragmentManager();
                fm.beginTransaction()
                        .hide(fm.findFragmentById(R.id.detail_frag))
                        .show(fm.findFragmentById(R.id.list_frag))
                        .commit();
            }
            if (findViewById(R.id.layout_land) != null) {
                FragmentManager fm = this.getSupportFragmentManager();
                fm.beginTransaction()
                        .show(fm.findFragmentById(R.id.detail_frag))
                        .show(fm.findFragmentById(R.id.list_frag))
                        .commit();
            }

        }

        //
        @Override

        // Defining the interface onItemSelected.
        public void onItemSelected ( int index){
            mname.setText(aname.get(index));
            mex.setText(aex.get(index));
            mage.setText(aage.get(index));
            mprice.setText(price.get(index));
            if (findViewById(R.id.layout_portrait) != null) {
                FragmentManager fm = this.getSupportFragmentManager();
                fm.beginTransaction()
                        .show(fm.findFragmentById(R.id.detail_frag))
                        .hide(fm.findFragmentById(R.id.list_frag))
                        .addToBackStack(null)
                        .commit();
            }
        }
        public void onPhoneSelected ( int index)
        {
            str = pno.get(index);
        }


//
//    public void onAgeSelected(int index) {
//        mage.setText(aage.get(index));
//    }

        @Override
        public void onClick (View view){

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + str));
            startActivity(intent);
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

        }
}