package com.example.abhi.newsapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhi on 31/12/17.
 */

public class adapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<obj1> l= new ArrayList();
    public FragmentManager fm;
    private ViewGroup context;
    public adapter1(List<obj1> music, ViewGroup c ){
        this.context=c;
        this.l=music;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_content1,parent,false);
        return new adapter1.myholder1(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final adapter1.myholder1 myholder= (adapter1.myholder1) holder;
            final obj1 o=l.get(position);
            myholder.txt1.setText(o.txtv);
            myholder.img.setImageResource(o.img);
            myholder.txt1.setTypeface(Typeface.SERIF,Typeface.BOLD);
            myholder.crdv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Fragment f=new fragment_bbc();
                        Bundle bundle=new Bundle();
                    if (o.txtv.equals("Daily Mail")){
                        bundle.putString("source","daily-mail");}
                    if (o.txtv.equals("CNN News")){
                        bundle.putString("source","cnn");}
                    if (o.txtv.equals("Al Jazeera")){
                        bundle.putString("source","al-jazeera-english");}
                    if (o.txtv.equals("BBC News")){
                        bundle.putString("source","bbc-news");}
                    if (o.txtv.equals("The Verge")){
                        bundle.putString("source","the-verge");}
                    if (o.txtv.equals("Bloomberg")){
                        bundle.putString("source","bloomberg");}
                    if (o.txtv.equals("Ars Technica")){
                        bundle.putString("source","ars-technica");}
                    if (o.txtv.equals("Mtv News")){
                        bundle.putString("source","mtv-news");}
                    if (o.txtv.equals("Business_Insider")){
                        bundle.putString("source","business-insider");}
                    if (o.txtv.equals("ESPN")){
                        bundle.putString("source","espn");}
                    if (o.txtv.equals("BBC Sports")){
                        bundle.putString("source","bbc-sport");}
                    if (o.txtv.equals("Fox Sports")){
                        bundle.putString("source","fox-sports");}
                    if (o.txtv.equals("ESPN Cric Info")){
                        bundle.putString("source","espn-cric-info");}
                    if (o.txtv.equals("Fox Sports")){
                        bundle.putString("source","fox-sports");}
                    if (o.txtv.equals("The Economist")){
                        bundle.putString("source","the-economist");}
                    if (o.txtv.equals("CNBC News")){
                        bundle.putString("source","cnbc");}
                    if (o.txtv.equals("MTV News (UK)")){
                        bundle.putString("source","mtv-news-uk");}
                    if (o.txtv.equals("Football Italia")){
                        bundle.putString("source","football-italia");}
                    if (o.txtv.equals("Hacker News")){
                        bundle.putString("source","hacker-news");}
                    if (o.txtv.equals("The Hindu")){
                        bundle.putString("source","the-hindu");}
                    if (o.txtv.equals("The Times of India")){
                        bundle.putString("source","the-times-of-india");}
                    if (o.txtv.equals("Techcrunch")){
                        bundle.putString("source","techcrunch");}
                    else{
                        bundle.putString("source","the-hindu");
                    }
                        f.setArguments(bundle);
                        AppCompatActivity activity=(AppCompatActivity)v.getContext();
                        FragmentManager manager= activity.getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.news,f,"News").addToBackStack(null);
                        transaction.commit();

                }
            });
    }

    @Override
    public int getItemCount() {
        return l.size();
    }

    class myholder1 extends RecyclerView.ViewHolder{


        TextView txt1;
        ImageView img;
        CardView crdv;

        public myholder1(View itemView){
            super(itemView);
            txt1=(TextView) itemView.findViewById(R.id.txtv);
            img= (ImageView) itemView.findViewById(R.id.imageView1);
            crdv= (CardView) itemView.findViewById(R.id.card_view1);
        }
    }
}
