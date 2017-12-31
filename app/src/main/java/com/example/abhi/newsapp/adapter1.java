package com.example.abhi.newsapp;

import android.content.Context;
import android.support.design.widget.Snackbar;
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

    private ViewGroup context;
    public adapter1(List<obj1> music, ViewGroup c){
        this.context=c;
        this.l=music;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_content1,parent,false);
        return new adapter1.myholder1(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final adapter1.myholder1 myholder= (adapter1.myholder1) holder;
            obj1 o=l.get(position);
            myholder.txt1.setText(o.txtv);
            myholder.img.setImageResource(o.img);
            myholder.crdv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v,myholder.txt1.getText(),Snackbar.LENGTH_SHORT).show();
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
