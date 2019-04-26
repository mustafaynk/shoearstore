package com.shoeARstore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class  MainActivity extends Fragment implements BaseSliderView.OnSliderClickListener,NavigationView.OnNavigationItemSelectedListener {

    public static String id = "id";
    SliderLayout mDemoSlider;
    public static String server_url="http://konyacaldereliler.com/ShoeArStore/";//http://konyayazibelenkoyu.com/shoearstore/ ... http://konyacaldereliler.com/ShoeArStore/  ... http://10.0.2.2/shoearstore/

    SharedPreferences prefs;
    String kullaniciid;

    private ArrayList<Beanlist> Bean;
    private GroomingRecyclerViewAdapter baseAdapter;

    private Context context;
    float positionY;

    Typeface fonts1,fonts2,fonts3,fonts4;
    EditText searchtext;
    ImageView QReader;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main,container,false);

        searchtext = (EditText) view.findViewById(R.id.searchtext);
        QReader=(ImageView)  view.findViewById(R.id.ivQReader);

        prefs =getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid=prefs.getString("id","0");

        //      ********Listview Header Fontları*********

        fonts1 = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(),
                "fonts/OpenSans-Regular.ttf");
        fonts2 = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(),
                "fonts/OpenSans-Semibold.ttf");

        fonts3 = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(),
                "fonts/Roboto-Medium.ttf");

        fonts4 = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(),
                "fonts/Roboto-Regular.ttf");

        searchtext.setTypeface(fonts1);

        QReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //         ********Slider*********

        mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);
        new getData(getActivity()){
            @Override
            protected void onPostExecute(String s) {
                try {
                    if(s!=null){
                        JSONArray jsonArray=new JSONArray(s);
                        JSONObject jsonObject;
                        for (int i=0;i<jsonArray.length();i++)
                        {
                            TextSliderView textSliderView = new TextSliderView(c);
                            jsonObject=jsonArray.getJSONObject(i);
                            String path=jsonObject.getString("ImagePath").replace("\\","/");
                            textSliderView
                                    //  .description(name)
                                    .image(server_url+path)
                                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
                                    .setOnSliderClickListener((BaseSliderView.OnSliderClickListener) context);
                            textSliderView.bundle(new Bundle());
                            textSliderView.getBundle().putString("extra", jsonObject.getString("ImageName"));
                            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                                @Override
                                public void onSliderClick(BaseSliderView slider) {
                                    Toast.makeText(getActivity().getApplicationContext(), slider.getBundle().getString("extra"), Toast.LENGTH_SHORT).show();
                                }
                            });
                            mDemoSlider.addSlider(textSliderView);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(server_url+"slidermaincategory.php","slider","kosulyok");

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        //         ********Kategoriler********
        final LinearLayout layout=(LinearLayout) view.findViewById(R.id.analinearlayout);
        final String[] kategori={"En Yeniler","Çok Beğenilenler","Çok Yorumlananlar"};
        new getData(getActivity()){
            @Override
            protected void onPostExecute(String s) {
                try {
                    if(s!=null){
                        JSONArray jsonArray=new JSONArray(s);
                        JSONObject jsonObject = null;
                        for (int i=0;i<jsonArray.length();i++)
                        {
                            jsonObject=jsonArray.getJSONObject(i);
                            final TextView textView=new TextView(getActivity());
                            textView.setText(jsonObject.getString("CategoryName"));
                            textView.setId(jsonObject.getInt("Id"));
                            textView.setPadding(0,25,0,25);
                            textView.setTextSize(20);
                            textView.setTypeface(fonts2);
                            LinearLayout liste=new LinearLayout(getActivity());
                            liste.setOrientation(LinearLayout.HORIZONTAL);
                            liste.setPadding(20,0,0,0);
                            final RecyclerView recyclerView1=new RecyclerView(getActivity());
                            for(int j=0;j<kategori.length;j++){
                                final TextView listeeleman=new TextView(getActivity());
                                listeeleman.setText(kategori[j]);
                                listeeleman.setId(j);
                                if(j==0){
                                    listeeleman.setBackgroundColor(Color.WHITE);
                                    final Typeface typeface=Typeface.create("arial-black",Typeface.BOLD);//sans-serif-light
                                    listeeleman.setTypeface(typeface);
                                    listeeleman.setTextColor(Color.parseColor("#24deb6"));
                                    listeeleman.setY(listeeleman.getY()-12);
                                }
                                else{
                                    listeeleman.setBackgroundColor(Color.parseColor("#f2f3f4"));//f2f3f4
                                    listeeleman.setTextColor(Color.BLACK);
                                    listeeleman.setTypeface(fonts4);
                                }
                                listeeleman.setTextSize(15);
                                listeeleman.setPadding(10,10,10,10);
                                listeeleman.setOnClickListener(new View.OnClickListener() {
                                    @SuppressLint("ResourceType")
                                    @Override
                                    public void onClick(View v) {
                                        kontrol(v.getId(),v);
                                        adapterGonder(textView.getId(),((TextView) v).getText().toString(),recyclerView1);
                                    }
                                });
                                liste.addView(listeeleman);
                                liste.invalidate();
                                positionY=listeeleman.getY();
                            }
                            adapterGonder(jsonObject.getInt("Id"),kategori[0],recyclerView1);
                            recyclerView1.setHasFixedSize(true);
                            recyclerView1.setId(i+1);
                            LinearLayoutManager rManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
                            recyclerView1.setLayoutManager(rManager);
                            layout.addView(textView);
                            layout.addView(liste);
                            layout.addView(recyclerView1);
                            layout.invalidate();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(server_url+"category.php","maincategory","kosulyok");
        return view;
    }

    private void adapterGonder(int id, String subcategory, final RecyclerView recyclerView) {
        String kosul = null;
        if(subcategory.equals("En Yeniler")){//Çok Satanlar
            kosul="DateOrder";
        }else if(subcategory.equals("En Çok Beğenilenler")){//En çok beğenilenler
            kosul="RatingOrder";
        }else if(subcategory.equals("En Çok Yorumlananlar")){//En Çok Yorumlananlar
            kosul="CommentOrder";
        }
        new getData(getActivity()){
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
                        JSONObject jsonObject=null;
                        jsonArray=new JSONArray(s);
                        for(int i=0;i<jsonArray.length();i++){
                            jsonObject=jsonArray.getJSONObject(i);
                            String path=jsonObject.getString("Resim").replace("\\","/");
                            image.add(server_url+path);
                            name.add(jsonObject.getString("ProductName"));
                            price.add(jsonObject.getString("LastPrice"));
                            cutprice.add(jsonObject.getString("FirstPrice"));
                            float fark=Float.parseFloat(jsonObject.getString("FirstPrice"))-Float.parseFloat(jsonObject.getString("LastPrice"));
                            int indirim= (int) ((fark*100)/Float.parseFloat(jsonObject.getString("FirstPrice")));
                            discount.add("%"+String.valueOf(indirim));
                            ratingtext.add(jsonObject.getString("Comment"));
                            if(jsonObject.getString("Rating").equals("null")){
                                rating.add("0");
                            }else{
                            rating.add(jsonObject.getString("Rating"));
                            }
                            favorites.add(jsonObject.getString("Favorites"));
                            id.add(jsonObject.getString("StockCode"));
                        }
                        gonder(image,name,price,cutprice,discount,ratingtext,rating,id,favorites,recyclerView);
                        dialog.dismiss();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    baseAdapter=null;
                }
                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(server_url+"sirala.php",String.valueOf(id),kullaniciid+"-"+kosul);
    }

    private void gonder(ArrayList<String> image, ArrayList<String> title, ArrayList<String> price, ArrayList<String> cutprice, ArrayList<String> discount
            , ArrayList<String> ratingtext, ArrayList<String> rating, ArrayList<String> id, ArrayList<String> favorites, RecyclerView recyclerView) {
        Bean=new ArrayList<Beanlist>();
        for(int i=0;i<image.size();i++){
            Beanlist Beanlist = new Beanlist(image.get(i)
                    , title.get(i), price.get(i), cutprice.get(i), discount.get(i), ratingtext.get(i)
                    ,Float.parseFloat(rating.get(i)) ,id.get(i),favorites.get(i));
            Bean.add(Beanlist);
        }
        baseAdapter = new GroomingRecyclerViewAdapter(getActivity(), getActivity(), Bean) {
        };
        //*********************Recyler View Click******************************************************
        if(baseAdapter!=null) {
            baseAdapter.setOnItemClickListener(new GroomingRecyclerViewAdapter.MyClickListener() {
                @Override
                public void onItemClick(int position, View v) {
                    TextView id = (TextView) v.findViewById(R.id.id);
                    Intent gec = new Intent(getActivity(), ProductDetailActivity.class);
                    gec.putExtra("StockCode",id.getText().toString());
                    startActivity(gec);
                }
            });
        }
        //**************************************************************************************************
        recyclerView.setAdapter(baseAdapter);
    }

    private void kontrol(int id, View v) {
        LinearLayout parent= (LinearLayout) v.getParent();
        for (int i=0;i<parent.getChildCount();i++){
            TextView textView=(TextView) parent.getChildAt(i);
            if(textView.getId()==id){
                final Typeface typeface=Typeface.create("arial-black",Typeface.BOLD_ITALIC);//sans-serif-light
                textView.setBackgroundColor(Color.WHITE);
                textView.setTypeface(typeface);
                textView.setTextColor(Color.parseColor("#24deb6"));
                textView.setY(positionY-12);
            }else{
                textView.setTextColor(Color.BLACK);
                textView.setBackgroundColor(Color.parseColor("#f2f3f4"));//f2f3f4
                textView.setY(positionY);
                textView.setTypeface(fonts4);
            }
        }
    }

    public static MainActivity newInstance(){
        MainActivity fragment=new MainActivity();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
