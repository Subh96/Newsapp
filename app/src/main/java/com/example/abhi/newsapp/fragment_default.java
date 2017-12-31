package com.example.abhi.newsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by abhi on 31/12/17.
 */

public class fragment_default extends Fragment {

    RecyclerView recyclerView;
    public List<obj1> list;
    adapter1 ad;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_fragment_two, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle1);
        list=new  ArrayList();
        obj1 o1=new obj1(R.mipmap.ic_alza,"Al Jazeera");
        list.add(o1);
        obj1 o2=new obj1(R.mipmap.ic_bbc,"BBC News");
        list.add(o2);
        obj1 o3=new obj1(R.mipmap.ic_cnn,"CNN News");
        list.add(o3);
        obj1 o4=new obj1(R.mipmap.ic_mail,"Daily Mail");
        list.add(o4);

        int No_of_coloumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), No_of_coloumns));
        //modelList = getAllaudiofromdevice();
        ad = new adapter1(list, (ViewGroup) view);
        recyclerView.setAdapter(ad);
        return view;
    }
}