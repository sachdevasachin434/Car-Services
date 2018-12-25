package com.example.sachd.countingcars;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {

    ItemSelected activity;
    public interface ItemSelected
    {
        void onItemSelected(int index);
        void onPhoneSelected(int index);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity=(ItemSelected)context; //hume main activity se fragment ke interface ke functions ko define karne ke liye banaya hai.
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> data=new ArrayList<String>();
        data.add("1.Gear Repair");
        data.add("2.Tyre Puncture");
        data.add("3.Regular car service");
        data.add("4.Dent Paint");

        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data));
//        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data));
//        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data));
        if(this.getActivity().findViewById(R.id.layout_land)!=null){
        activity.onItemSelected(0);}
    }

    @Override
    public void onListItemClick(ListView l, View v,int position, long id) {
        activity.onItemSelected(position);
        activity.onPhoneSelected(position);
    }
}
