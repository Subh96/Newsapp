package com.example.abhi.newsapp;

import android.content.Context;
import android.content.Intent;
import android.drm.DrmStore;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abhi.newsapp.R;
import com.example.abhi.newsapp.obj;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhi on 15/10/17.
 */

public class adapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<obj> l= new ArrayList();

    public Context c;

    private LayoutInflater li;

    public adapter2(Context c,List<obj> l){

        this.c=c;
        li=LayoutInflater.from(c);
        this.l=l;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v=li.inflate(R.layout.recycle_content,parent,false);
        myholder holder=new myholder(v);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        myholder myholder= (adapter2.myholder) holder;
        final obj p=l.get(position);
        Picasso.with(c).load(p.urltoimg).into(myholder.img);
        myholder.txt1.setText(p.title);
        myholder.txt2.setText(p.description);
        myholder.txt3.setText("Author:-"+" "+p.author);
        myholder.txt4.setText("Read More");
        myholder.txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser= new Intent(c,webview.class);
                browser.putExtra("Url",p.urltoarticle);
                c.startActivity(browser);
            }
        });
        myholder.txt1.setTypeface(Typeface.SERIF,Typeface.BOLD);
        myholder.txt2.setTypeface(Typeface.SERIF);
        myholder.txt3.setTypeface(Typeface.DEFAULT_BOLD);
        myholder.txt4.setTypeface(null,Typeface.BOLD_ITALIC);
    }

    @Override
    public int getItemCount() {
        return l.size();
    }

    class myholder extends RecyclerView.ViewHolder{

        TextView txt1,txt2,txt3,txt4;
        ImageView img;

        public myholder(View itemView){
            super(itemView);
            txt1= (TextView) itemView.findViewById(R.id.author);
            txt2= (TextView) itemView.findViewById(R.id.title);
            txt3= (TextView) itemView.findViewById(R.id.description);
            txt4= (TextView) itemView.findViewById(R.id.uri);
            img= (ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}
