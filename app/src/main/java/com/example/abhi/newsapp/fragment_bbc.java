package com.example.abhi.newsapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by abhi on 22/10/17.
 */

public class fragment_bbc extends Fragment {

    private String url="https://newsapi.org/v1/articles?source=bbc-news&apiKey=5d583239048a4d9dab08936b75f89128";

    protected List<obj> data;
    RecyclerView recyclerView;
    private LinearLayoutManager manager;
    public adapter2 madapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.activity_fragment_one, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        getjson();
        return view;
    }
    public void getjson(){
        data= new ArrayList<>();
        final ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.setTitle("Wait a second");
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
        final Thread th=new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request=new Request.Builder().url(url).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(),"Fail to connect to server",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String s=response.body().string();
                        try {
                            JSONObject jobj = new JSONObject(s);
                            String status = jobj.getString("status");
                            String source = jobj.getString("source");
                            JSONArray jsonArray = jobj.getJSONArray("articles");

                            // Extract data from json and store into ArrayList as class objects

                            for (int i = 0; i < jsonArray.length(); i++) {
                                try {
                                    JSONObject json_data = jsonArray.getJSONObject(i);
                                    obj news = new obj();
                                    news.author = json_data.getString("author");
                                    news.title = json_data.getString("title");
                                    news.description = json_data.getString("description");
                                    news.urltoarticle = json_data.getString("url");
                                    news.urltoimg = json_data.getString("urlToImage");
                                    String d = json_data.getString("publishedAt");
                                    data.add(news);
                                } catch (final Exception e) {
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getActivity(),"string"+" "+e, Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }
                            }

                            // Setup and Handover data to recyclerview

                        } catch (final JSONException e) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getActivity(),"String2"+" "+e, Toast.LENGTH_LONG).show();
                                }
                            });
                            Log.e("tag", e.getMessage());


                        }

                        /*MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"Strng"+" "+data,Toast.LENGTH_LONG).show();
                            }
                        });*/
                        getActivity().runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                try{
                                    if(progressDialog.isShowing()){
                                        progressDialog.dismiss();
                                    }
                                    madapter = new adapter2(getActivity(), data);
                                    recyclerView.setAdapter(madapter);
                                    manager = new LinearLayoutManager(getActivity());
                                    recyclerView.setLayoutManager(manager);
                                    recyclerView.setAdapter(madapter);
                                }
                                catch (final Exception e){
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getActivity(),"kuchbhi"+" "+e.getMessage(),Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            }
        });
        th.start();
    }


}
