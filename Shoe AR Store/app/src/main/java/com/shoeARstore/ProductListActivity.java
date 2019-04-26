package com.shoeARstore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class ProductListActivity extends AppCompatActivity {

    private ExpandableHeightGridView gridview;
    private ExpandableHeightListView listview;
    private ArrayList<Beanlist>Bean;
    private ListviewAdapter baseAdapter;
    private Spinner sirala;

    private String maincategoryid="yok";
    private String subcategoryid="yok";
    private String subsubcategoryid="yok";

    SharedPreferences prefs;
    String kullaniciid;

///////////////////////////////
    ImageView gridviewicon,listviewicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);


        prefs =getApplicationContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid=prefs.getString("id","0");

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ImageView backbutton=(ImageView) toolbar.findViewById(R.id.buttonexit);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bean = new ArrayList<Beanlist>();
        sirala=(Spinner) findViewById(R.id.sirala);

        if(getIntent().getExtras()!=null){
            String[] idler=getIntent().getExtras().getString("categoryid").split("-");
            maincategoryid=idler[0];
            subcategoryid=idler[1];
            subsubcategoryid=idler[2];
        }


        final ArrayAdapter<String> siralaAdapter=new ArrayAdapter<String>(ProductListActivity.this,R.layout.siralaitemlayout, Arrays.asList(getResources().getStringArray(R.array.siralaitemproduct))){
            @Override
            public boolean isEnabled(int position) {
                if(position==0){
                    return false;
                }else{
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view=super.getDropDownView(position, convertView, parent);
                TextView tv=(TextView) view;
                if(position==0){
                    tv.setTextColor(Color.GRAY);
                }else{
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        siralaAdapter.setDropDownViewResource(R.layout.siralaitemlayout);
        sirala.setAdapter(siralaAdapter);

        sirala.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected=(String) parent.getItemAtPosition(position);
                if(selected.equals("Fiyata Göre Azalan")){
                    adapterSirala("downprice");
                }else if (selected.equals("Fiyata Göre Artan")){
                    adapterSirala("upprice");
                }else if (selected.equals("Yorum Sayısı")){
                    adapterSirala("comment");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//              ********GRIDVIEW***********

        new getData(ProductListActivity.this){
            @Override
            protected void onPostExecute(String s) {
                if(s!=null) {
                    ArrayList<String> image=new ArrayList<>();
                    ArrayList<String> name=new ArrayList<>();
                    ArrayList<String> price=new ArrayList<>();
                    ArrayList<String> cutprice=new ArrayList<>();
                    ArrayList<String> discount=new ArrayList<>();
                    ArrayList<String> ratingtext=new ArrayList<>();
                    ArrayList<String> rating=new ArrayList<>();
                    ArrayList<String> id=new ArrayList<>();
                    ArrayList<String> favorites=new ArrayList<>();
                    JSONArray jsonArray = null;
                    try {
                        JSONObject jsonObject;
                        jsonArray=new JSONArray(s);
                        for(int i=0;i<jsonArray.length();i++){
                            jsonObject=jsonArray.getJSONObject(i);
                            String path=jsonObject.getString("resim").replace("\\","/");
                            image.add(MainActivity.server_url+path);
                            name.add(jsonObject.getString("ProductName"));
                            price.add(jsonObject.getString("LastPrice"));
                            cutprice.add(jsonObject.getString("FirstPrice"));
                            int sonfiyat=(int) Float.parseFloat(jsonObject.getString("FirstPrice"));
                            int ilkfiyat=(int) Float.parseFloat(jsonObject.getString("LastPrice"));
                            int fark=sonfiyat-ilkfiyat;
                            Integer indirim=Integer.parseInt(String.valueOf((fark*100)/sonfiyat));
                            discount.add("%"+String.valueOf(indirim));
                            ratingtext.add(jsonObject.getString("Comment"));
                            rating.add(jsonObject.getString("Rating"));
                            id.add(jsonObject.getString("StockCode"));
                            favorites.add(jsonObject.getString("Favorites"));
                        }
                        gonder(image,name,price,cutprice,discount,ratingtext,rating,id,favorites);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(MainActivity.server_url+"productslist.php",kullaniciid+"-"+maincategoryid,subcategoryid+"-"+subsubcategoryid);





        gridview = (ExpandableHeightGridView)findViewById(R.id.gridview);
        baseAdapter = new ListviewAdapter(this,ProductListActivity.this, Bean,R.layout.grid_productlist) {
        };
        gridview.setAdapter(baseAdapter);

//        /        ********LISTVIEW***********


        listview = (ExpandableHeightListView)findViewById(R.id.listview);
        baseAdapter = new ListviewAdapter(this,ProductListActivity.this, Bean,R.layout.listview_productlist) {
        };
        listview.setAdapter(baseAdapter);

//        ***********Grid - list view **********

        gridviewicon = (ImageView) findViewById(R.id.gridviewicon);
        listviewicon = (ImageView)findViewById(R.id.listviewicon);


        gridviewicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listviewicon.setVisibility(View.VISIBLE);
                gridviewicon.setVisibility(View.GONE);
                listview.setVisibility(View.VISIBLE);
                gridview.setVisibility(View.GONE);

            }
        });

        listviewicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listviewicon.setVisibility(View.GONE);
                gridviewicon.setVisibility(View.VISIBLE);
                listview.setVisibility(View.GONE);
                gridview.setVisibility(View.VISIBLE);

            }
        });
    }

    private void adapterSirala(String kosul) {
        if(kosul.equals("upprice")){
            Collections.sort(Bean,sortByUpPrice);
        }else if(kosul.equals("downprice")){
            Collections.sort(Bean,sortByDownPrice);
        }else if(kosul.equals("comment")){
            Collections.sort(Bean,sortByComment);
        }

        baseAdapter = new ListviewAdapter(this,ProductListActivity.this, Bean,R.layout.listview_productlist) {
        };
        listview.setAdapter(baseAdapter);
        baseAdapter = new ListviewAdapter(this,ProductListActivity.this, Bean,R.layout.grid_productlist) {
        };
        gridview.setAdapter(baseAdapter);
    }

    Comparator<Beanlist> sortByDownPrice = new Comparator<Beanlist>() {
        @Override
        public int compare(Beanlist lhs, Beanlist rhs) {
            Float fiyat1=Float.parseFloat(lhs.getPrice());
            Float fiyat2=Float.parseFloat(rhs.getPrice());
            if(fiyat1<=fiyat2){
                return degistir(lhs,rhs);
            }
            return -1;
        }
    };
    Comparator<Beanlist> sortByUpPrice = new Comparator<Beanlist>() {
        @Override
        public int compare(Beanlist lhs, Beanlist rhs) {
            Float fiyat1=Float.parseFloat(lhs.getPrice());
            Float fiyat2=Float.parseFloat(rhs.getPrice());
            if(fiyat1>fiyat2){
                return degistir(lhs,rhs);
            }
            return -1;
        }
    };
    Comparator<Beanlist> sortByComment = new Comparator<Beanlist>() {
        @Override
        public int compare(Beanlist lhs, Beanlist rhs) {
            int yorumsayi1=Integer.parseInt(lhs.getRatingtext());
            int yorumsayi2=Integer.parseInt(rhs.getRatingtext());
            if(yorumsayi1<=yorumsayi2){
                return degistir(lhs,rhs);
            }
            return -1;
        }
    };

    private int degistir(Beanlist lhs, Beanlist rhs) {
        //Güncelleme 1
        lhs.getTitle().compareTo (rhs.getTitle());
        lhs.getCutprice().compareTo(rhs.getCutprice());
        lhs.getDiscount().compareTo(rhs.getDiscount());
        lhs.getId().compareTo(rhs.getId());
        lhs.getImage().compareTo(rhs.getImage());
        lhs.getPrice().compareTo(rhs.getPrice());
        String.valueOf(lhs.getRating()).compareTo(String.valueOf(rhs.getRating()));
        lhs.getRatingtext().compareTo(rhs.getRatingtext());
        return 1;
    }

    private void gonder(ArrayList<String> image, ArrayList<String> title, ArrayList<String> price, ArrayList<String> cutprice, ArrayList<String> discount
            , ArrayList<String> ratingtext, ArrayList<String> rating, ArrayList<String> id, ArrayList<String> favorites) {
        Bean=new ArrayList<Beanlist>();
        for(int i=0;i<image.size();i++){
            Beanlist BeanlistList = new Beanlist(image.get(i)
                    , title.get(i), price.get(i), cutprice.get(i), discount.get(i), ratingtext.get(i)
                    ,Float.parseFloat(rating.get(i)) ,id.get(i),favorites.get(i));
            Bean.add(BeanlistList);

        }
        baseAdapter = new ListviewAdapter(this,ProductListActivity.this, Bean,R.layout.listview_productlist) {
        };

        listview.setAdapter(baseAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=(TextView) view.findViewById(R.id.id);
                Intent gec = new Intent(ProductListActivity.this, ProductDetailActivity.class);
                gec.putExtra("StockCode",textView.getText().toString());
                startActivity(gec);
            }
        });
        baseAdapter = new ListviewAdapter(this,ProductListActivity.this, Bean,R.layout.grid_productlist) {
        };
        gridview.setAdapter(baseAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=(TextView) view.findViewById(R.id.id);
                Intent gec = new Intent(ProductListActivity.this, ProductDetailActivity.class);
                gec.putExtra("StockCode",textView.getText().toString());
                startActivity(gec);
            }
        });
    }
}
