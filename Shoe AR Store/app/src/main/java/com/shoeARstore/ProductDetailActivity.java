package com.shoeARstore;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import yorumlarsayfasi.YorumlarActivity;


public class ProductDetailActivity extends AppCompatActivity {

    ImageView plus,minus;
    TextView productname,newprice,oldprice,ratingtext,productdetail1,cartno,addtocart,yorumsayisi,ratingsayi;
    RatingBar ratingbar;
    ImageView favbuttonpasif,favbuttonaktif;

    private RecyclerView rv2;
    private ArrayList<Beanlist> Bean1;
    private GroomingRecyclerViewAdapter baseAdapter1;
    private Context context;
    private  SliderLayout mDemoSlider;
    LinearLayout review;
    String stockcode="30000000002",shoesize="";
    int productid;
    Typeface typeface;
    SharedPreferences prefs;
    String kullaniciid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetail);

        prefs =getApplicationContext().getSharedPreferences("login",Context.MODE_PRIVATE);
        kullaniciid=prefs.getString("id","0");
        if(getIntent().getExtras()!=null){
            stockcode=getIntent().getExtras().getString("StockCode");
        }

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ImageView sharebutton=(ImageView) toolbar.findViewById(R.id.sharingproduct);
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent=new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody=MainActivity.server_url+"urundetayi/?Prodcut="+stockcode;
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(sharingIntent,"Ürünü Paylaş"));
            }
        });
        favbuttonpasif=(ImageView) toolbar.findViewById(R.id.fav1);
        favbuttonaktif=(ImageView) toolbar.findViewById(R.id.fav2);
        favbuttonpasif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kullaniciid.equals("0")){
                    Toast.makeText(ProductDetailActivity.this, "Lütfen Giriş Yapınız!!!", Toast.LENGTH_SHORT).show();
                }else{
                    new getData(ProductDetailActivity.this){
                        @Override
                        protected void onPostExecute(String s) {
                            if(!s.equals("")){
                                Toast.makeText(c, "Ürün Başarıyla Favorilere Eklendi...", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(c, "Ürün Favorilere Eklenemedi...", Toast.LENGTH_SHORT).show();
                            }
                            dialog.dismiss();
                            super.onPostExecute(s);
                        }
                    }.execute(MainActivity.server_url+"favorites.php",kullaniciid,stockcode+"-add");
                    favbuttonaktif.setVisibility(View.VISIBLE);
                    favbuttonpasif.setVisibility(View.GONE);
                }
            }
        });
        favbuttonaktif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kullaniciid.equals("0")){
                    Toast.makeText(ProductDetailActivity.this, "Lütfen Giriş Yapınız!!!", Toast.LENGTH_SHORT).show();
                }else {
                    new getData(ProductDetailActivity.this) {
                        @Override
                        protected void onPostExecute(String s) {
                            if (!s.equals("")) {
                                Toast.makeText(c, "Ürün Başarıyla Favorilerden Çıkarıldı...", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(c, "Ürün Favorilerden Çıkarılamadı...", Toast.LENGTH_SHORT).show();
                            }
                            dialog.dismiss();
                            super.onPostExecute(s);
                        }
                    }.execute(MainActivity.server_url + "favorites.php", kullaniciid, stockcode + "-delete");
                    favbuttonpasif.setVisibility(View.VISIBLE);
                    favbuttonaktif.setVisibility(View.GONE);
                }
            }
        });
    //*************Tanımlamalar************

        productname=(TextView) findViewById(R.id.productname);
        newprice=(TextView) findViewById(R.id.newprice);
        ratingtext=(TextView) findViewById(R.id.ratingtext);
        productdetail1=(TextView) findViewById(R.id.productdetail1);
        addtocart=(TextView) findViewById(R.id.addtocartbutton);
        oldprice = (TextView) findViewById(R.id.oldprice);
        plus = (ImageView)findViewById(R.id.plus);
        minus = (ImageView)findViewById(R.id.minus);
        cartno = (TextView) findViewById(R.id.cartno);
        ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        rv2 = (RecyclerView)findViewById(R.id.rv2);
        review=(LinearLayout) findViewById(R.id.reviews);
        yorumsayisi=(TextView) findViewById(R.id.yorum);
                ratingsayi=(TextView) findViewById(R.id.comments);
                //**********TOOLBAR************

                ImageView back=(ImageView) findViewById(R.id.backbutton);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

                //*******Ürünü Sepete Ekle*******
                addtocart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!shoesize.equals("") && !kullaniciid.equals("0")){

                            new getData(ProductDetailActivity.this){
                                @Override
                                protected String doInBackground(String... params) {String login_url=params[0];
                                    String kullaniciid=params[1];
                                    String stockcode=params[2];
                                    String piece=params[3];
                                    String size=params[4];
                                    String islem=params[5];
                                    InputStream is=null;
                                    String line;
                                    try {
                                        URL url=new URL(login_url);
                                        HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();

                                        httpURLConnection.setRequestMethod("POST");
                                        httpURLConnection.setDoOutput(true);
                                        httpURLConnection.setDoInput(true);
                                        OutputStream outputStream=httpURLConnection.getOutputStream();
                                        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                                        String post_data= URLEncoder.encode("tabload","UTF-8")+"="+URLEncoder.encode(kullaniciid,"UTF-8")+"&"+
                                                URLEncoder.encode("stockcode","UTF-8")+"="+URLEncoder.encode(stockcode,"UTF-8")+"&"+
                                                URLEncoder.encode("piece","UTF-8")+"="+URLEncoder.encode(piece,"UTF-8")+"&"+
                                                URLEncoder.encode("size","UTF-8")+"="+URLEncoder.encode(size,"UTF-8")+"&"+
                                                URLEncoder.encode("kosul","UTF-8")+"="+URLEncoder.encode(islem,"UTF-8");
                                        bufferedWriter.write(post_data);
                                        bufferedWriter.flush();
                                        bufferedWriter.close();
                                        outputStream.close();

                                        is=new BufferedInputStream(httpURLConnection.getInputStream());

                                        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
                                        StringBuffer sb=new StringBuffer();

                                        if(bufferedReader!=null)
                                        {
                                            while ((line=bufferedReader.readLine())!=null)
                                            {
                                                sb.append(line+"\n");
                                            }
                                        }else{
                                            return  null;
                                        }
                                        return sb.toString();

                                    } catch (MalformedURLException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }finally {
                                        try {
                                            if(is!=null){
                                                is.close();
                                            }

                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    return null;
                                }

                                @Override
                                protected void onPostExecute(String s) {
                                    if(!s.equals("") && s!=null){
                                        Toast.makeText(c, "Ürün Başarıyla Sepete Eklendi...", Toast.LENGTH_SHORT).show();
                                        Intent gec=new Intent(c,HomeFragment.class);
                                        gec.putExtra("fragment","4");
                                        startActivity(gec);
                                    }
                                    else{
                                        Toast.makeText(c, "Ürün Sepete Eklenemedi!!!", Toast.LENGTH_SHORT).show();
                                    }
                                    dialog.dismiss();
                                    super.onPostExecute(s);
                                }
                            }.execute(MainActivity.server_url+"cartlist.php",kullaniciid,stockcode,cartno.getText().toString(),shoesize,"add");
                        }
                        else{
                            if(kullaniciid.equals("0")){
                                uyari("Lütfen Giriş Yapınız");
                            }
                            else{
                                uyari("Lütfen Ayakkabı Numarasını Seçiniz!!!");
                            }
                        }
            }
        });



    //******************************

    //***********Rating Bar**********

        LayerDrawable stars = (LayerDrawable) ratingbar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_ATOP);


    //*********RECYCLERVIEWS*********
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rv2.setLayoutManager(mLayoutManager1);
        Bean1 = new ArrayList<Beanlist>();
        typeface = Typeface.create("arial-black", Typeface.BOLD_ITALIC);//sans-serif-light
        urundetayGetir(stockcode);


     //**********YORUMLAR**************
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gec=new Intent(ProductDetailActivity.this, YorumlarActivity.class);
                gec.putExtra("stockcode",stockcode);
                startActivity(gec);
            }
        });
    //*******Eski Fiyat Üzeri Çizilmesi********

        oldprice.setPaintFlags(oldprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

    //********Ürün Adet Sayısı Artırıp Azaltma*************

        final int[] number = {1};

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number[0] == 1){
                    cartno.setText("" + number[0]);
                }

                if (number[0] > 1){

                    number[0] -=1;
                    cartno.setText(""+ number[0]);
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number[0]++;
                cartno.setText(String.valueOf(number[0]));
            }
        });
    }




    private void urundetayGetir(String stockcode){

        final LinearLayout productnumbers=(LinearLayout) findViewById(R.id.productnumbers);
        productnumbers.removeAllViews();
        final LinearLayout productcolors=(LinearLayout) findViewById(R.id.productcolors);
        productcolors.removeAllViews();
        mDemoSlider = (SliderLayout) findViewById(R.id.productimage);
        mDemoSlider.removeAllSliders();
        final LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(5,5,5,5);
        new getData(ProductDetailActivity.this){
            @Override
            protected void onPostExecute(String s) {
                if(s!=null){
                    JSONArray jsonArray= null;
                    int id=0;
                    try {
                        int yorumsayi = 0;
                        jsonArray = new JSONArray(s);
                        JSONObject jsonObject;
                        for (int i=0;i<jsonArray.length();i++) {
                            jsonObject = jsonArray.getJSONObject(i);
                            if(i==0) {
                                productname.setText(jsonObject.getString("ProductName"));
                                if(jsonObject.getString("LastPrice").equals("0")){
                                    oldprice.setVisibility(View.INVISIBLE);
                                    newprice.setText(jsonObject.getString("FirstPrice")+"₺");
                                }else {
                                    oldprice.setText(jsonObject.getString("FirstPrice")+"₺");
                                    oldprice.setTextSize(15);
                                    oldprice.setTypeface(typeface);
                                    newprice.setText(jsonObject.getString("LastPrice")+"₺");
                                }
                                newprice.setTextSize(20);
                                newprice.setTypeface(typeface);
                                productid=jsonObject.getInt("Id");

                                productdetail1.setText(Html.fromHtml(jsonObject.getString("Explanation").toString()));
                                String numbers = jsonObject.getString("ProductOptions");

                                for (String number : numbers.split("/")) {
                                    String[] numaralar=number.split("=");
                                    if(!(numaralar[1].equals("0"))){
                                        TextView textView = new TextView(getApplicationContext());
                                        textView.setText(numaralar[0].replace("Numara","").replace("_",","));
                                        textView.setId(id);
                                        textView.setBackgroundResource(R.drawable.productcolorback);
                                        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
                                        textView.setTextColor(getResources().getColor(R.color.Tex));
                                        textView.setTextSize(25);
                                        textView.setLayoutParams(params);
                                        textView.setTypeface(typeface);
                                        textView.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                kontrol(v.getId(),v);
                                                shoesize=((TextView)v).getText().toString();
                                            }
                                        });
                                        productnumbers.addView(textView);
                                        productnumbers.invalidate();
                                        id++;
                                    }
                                }
                                renkGetir(jsonObject.getString("ProductName"),productcolors,id);
                                sameGetProduct(jsonObject.getString("MainCategoryId"),jsonObject.getString("SubCategoryId"));//benzer ürün getir
                            }
                            if(i==1) {
                                String path = jsonObject.getString("ImagePath");
                                path=path.replace("\\", "/");
                                //************Slider*****************
                                for (String picture : path.split(",")) {
                                    TextSliderView textSliderView = new TextSliderView(getApplicationContext());
                                    textSliderView
                                            //  .description(name)
                                            .image(MainActivity.server_url+picture)
                                            .setScaleType(BaseSliderView.ScaleType.CenterInside)
                                            .setOnSliderClickListener((BaseSliderView.OnSliderClickListener) context);
                                    textSliderView.bundle(new Bundle());
                                    textSliderView.getBundle().putString("extra", "name");
                                    textSliderView.getBundle().putString("path", MainActivity.server_url+picture);
                                    textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                                        @Override
                                        public void onSliderClick(BaseSliderView slider) {
                                            LinearLayout.LayoutParams size=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                                            AlertDialog.Builder builder=new AlertDialog.Builder(ProductDetailActivity.this);
                                            final ImageView imageView=new ImageView(ProductDetailActivity.this);
                                            imageView.setLayoutParams(size);
                                            Picasso.with(ProductDetailActivity.this).load(slider.getBundle().getString("path")).into(imageView);
                                            builder.setView(imageView);
                                            builder.setCancelable(false);
                                            builder.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            });
                                            AlertDialog alertDialog=builder.create();
                                            alertDialog.show();
                                            //alertDialog.getWindow().setLayout(1000,1000);
                                        }
                                    });
                                    mDemoSlider.addSlider(textSliderView);
                                }

                                //*****************************************
                            }
                            if(i==2){
                                yorumsayi=jsonObject.getInt("Comment");
                                yorumsayisi.setText("("+String.valueOf(yorumsayi)+")");
                            }
                            if (i==3){
                                ratingsayi.setText("("+String.valueOf(yorumsayi)+")");
                                ratingbar.setRating(Float.parseFloat(jsonObject.getString("Rating")));
                            }if(i==4){
                                if(jsonObject.getString("Favorites").equals("1")){
                                    favbuttonaktif.setVisibility(View.VISIBLE);
                                    favbuttonpasif.setVisibility(View.GONE);
                                }else{
                                    favbuttonpasif.setVisibility(View.VISIBLE);
                                    favbuttonaktif.setVisibility(View.GONE);
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(MainActivity.server_url+"productsdetail.php",kullaniciid,stockcode);
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.getPagerIndicator().setDefaultIndicatorColor(Color.RED, Color.GRAY);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        baseAdapter1 = new GroomingRecyclerViewAdapter(this,ProductDetailActivity.this, Bean1) {
        };
        rv2.setAdapter(baseAdapter1);
    }

    private void sameGetProduct(String maincategoryid,String subCategoryId) {
        new getData(ProductDetailActivity.this){
            @Override
            protected void onPostExecute(String s) {
                if(s!=null) {
                    ArrayList<String> image=new ArrayList<>();
                    ArrayList<String> name=new ArrayList<>();
                    ArrayList<String> price=new ArrayList<>();
                    ArrayList<String> cutprice=new ArrayList<>();
                    ArrayList<String> discount=new ArrayList<>();
                    ArrayList<String> ratingtext=new ArrayList<>();
                    ArrayList<Float> rating=new ArrayList<>();
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
                            rating.add(Float.parseFloat(jsonObject.getString("Rating")));
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
        }.execute(MainActivity.server_url+"productslist.php",kullaniciid+"-"+maincategoryid,subCategoryId+"-yok");
    }

    private void gonder(ArrayList<String> image, ArrayList<String> name, ArrayList<String> price, ArrayList<String> cutprice, ArrayList<String> discount, ArrayList<String> ratingtext, ArrayList<Float> rating, ArrayList<String> id, ArrayList<String> favorites) {
        for(int i=0;i<image.size();i++){
            Beanlist bean1 = new Beanlist(image.get(i), name.get(i), price.get(i), cutprice.get(i),discount.get(i), ratingtext.get(i),rating.get(i),id.get(i),favorites.get(i));
            Bean1.add(bean1);
        }
        baseAdapter1 = new GroomingRecyclerViewAdapter(ProductDetailActivity.this,ProductDetailActivity.this, Bean1);
        rv2.setAdapter(baseAdapter1);
    }

    private void renkGetir(String productName, final LinearLayout productcolors, final int id) {
        new getData(ProductDetailActivity.this){
            @Override
            protected void onPostExecute(String s) {
                if(s!=null){
                    int id1=id;
                    JSONArray jsonArray= null;
                    try{
                        final LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(5,5,5,5);
                        LinearLayout.LayoutParams resimolcu=new LinearLayout.LayoutParams(80, 80);
                        jsonArray=new JSONArray(s);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            LinearLayout renk=new LinearLayout(getApplicationContext());
                            renk.setBackgroundResource(R.drawable.productnumberback);
                            renk.setLayoutParams(params);
                            renk.setId(id1);
                            renk.setTag(jsonObject.getString("StockCode"));
                            final ImageView colorbox=new ImageView(getApplicationContext());
                            colorbox.setId(jsonObject.getInt("StockCode"));
                            String path = jsonObject.getString("Resim");
                            path=path.replace("\\", "/");
                            Picasso.with(ProductDetailActivity.this).load(MainActivity.server_url+path).into(colorbox);
                            //resimolcu.gravity= Gravity.CENTER;
                            resimolcu.setMargins(10,10,10,10);
                            resimolcu.width=80;
                            resimolcu.height=80;
                            colorbox.setLayoutParams(resimolcu);
                            colorbox.setVisibility(View.VISIBLE);
                            colorbox.invalidate();
                            renk.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    resimkontrol(v.getId(),v);
                                    urundetayGetir(String.valueOf(v.getTag()));
                                }
                            });
                            renk.addView(colorbox);
                            renk.invalidate();
                            productcolors.addView(renk);
                            productcolors.invalidate();
                            id1++;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(MainActivity.server_url+"getir.php","RenkGetir",productName);
    }

    private void resimkontrol(int id, View v) {
        LinearLayout parent= (LinearLayout) v.getParent();
        for (int i=0;i<parent.getChildCount();i++){
            LinearLayout child=(LinearLayout) parent.getChildAt(i);
            if(child.getId()==id){
                child.setBackgroundResource(R.drawable.productnumberclick);
            }else{
                child.setBackgroundResource(R.drawable.productnumberback);
            }
        }
    }

    private void kontrol(int id, View v) {
        LinearLayout parent= (LinearLayout) v.getParent();
        for (int i=0;i<parent.getChildCount();i++){
            TextView textView=(TextView) parent.getChildAt(i);
            if(textView.getId()==id){
                textView.setBackgroundResource(R.drawable.productnumberclick);
            }else{
                textView.setBackgroundResource(R.drawable.productcolorback);
            }
        }
    }
    public void uyari(String alert){
        AlertDialog.Builder builder = new AlertDialog.Builder(ProductDetailActivity.this);
        builder.setTitle("Hatalı İşlem");
        builder.setMessage(alert);
        builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}