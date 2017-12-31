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
        obj1 o5=new obj1(R.mipmap.ic_bloomberg,"Bloomberg");
        list.add(o5);
        obj1 o6=new obj1(R.mipmap.ic_nbc,"CNBC News");
        list.add(o6);
        obj1 o7=new obj1(R.mipmap.ic_ars_technica,"Ars Technica");
        list.add(o7);
        obj1 o8=new obj1(R.mipmap.ic_verge,"The Verge");
        list.add(o8);
        obj1 o9=new obj1(R.mipmap.ic_foxsports,"Fox Sports");
        list.add(o9);
        obj1 o10=new obj1(R.mipmap.ic_espn,"ESPN");
        list.add(o10);
        obj1 o11=new obj1(R.mipmap.ic_espncric,"ESPN Cric Info");
        list.add(o11);
        obj1 o12=new obj1(R.mipmap.ic_bbcs,"BBC Sports");
        list.add(o12);
        obj1 o13=new obj1(R.mipmap.ic_mtvnews,"Mtv News");
        list.add(o13);
        obj1 o14=new obj1(R.mipmap.ic_econo,"The Economist");
        list.add(o14);
        obj1 o15=new obj1(R.mipmap.ic_hindu,"The Hindu");
        list.add(o15);
        obj1 o16=new obj1(R.mipmap.ic_hacker,"Hacker News");
        list.add(o16);
        obj1 o17=new obj1(R.mipmap.ic_timesofindia,"The Times of India");
        list.add(o17);
        obj1 o18=new obj1(R.mipmap.ic_tech,"Techcrunch");
        list.add(o18);


        int No_of_coloumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), No_of_coloumns));
        ad = new adapter1(list, (ViewGroup) view);
        recyclerView.setAdapter(ad);
        return view;
    }
}