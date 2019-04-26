package com.shoeARstore;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class ListviewAdapter extends BaseAdapter {

    Context context;

    ArrayList<Beanlist>bean;
    Typeface fonts1,fonts2;
    RatingBar ratingbar;
    Activity main;
    int listelayout;
    SharedPreferences prefs;
    String kullaniciid;



    public ListviewAdapter(Activity activity,Context context, ArrayList<Beanlist> bean,int listelayout) {

        this.main = activity;
        this.context = context;
        this.bean = bean;
        this.listelayout=listelayout;
    }

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        prefs =context.getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid=prefs.getString("id","-1");

        fonts1 =  Typeface.createFromAsset(context.getAssets(),
                "fonts/MavenPro-Regular.ttf");

        fonts2 = Typeface.createFromAsset(context.getAssets(),
                "fonts/MavenPro-Regular.ttf");

        final ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(listelayout,null);//R.layout.listview_productlist
            viewHolder = new ViewHolder();

            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.price = (TextView) convertView.findViewById(R.id.price);
            viewHolder.cutprice = (TextView) convertView.findViewById(R.id.cutprice);
            viewHolder.discount = (TextView) convertView.findViewById(R.id.discount);
            viewHolder.ratingtext = (TextView) convertView.findViewById(R.id.ratingtext);
            viewHolder.fav1 = (ImageView) convertView.findViewById(R.id.fav1);
            viewHolder.fav2 = (ImageView) convertView.findViewById(R.id.fav2);
            viewHolder.id=(TextView) convertView.findViewById(R.id.id);


            viewHolder.title.setTypeface(fonts1);
            viewHolder.price.setTypeface(fonts1);
            viewHolder.cutprice.setTypeface(fonts1);
            viewHolder.discount.setTypeface(fonts1);
            viewHolder.ratingtext.setTypeface(fonts1);



//        ***********ratingBar**********
            ratingbar = (RatingBar) convertView.findViewById(R.id.ratingbar);
            LayerDrawable stars = (LayerDrawable) ratingbar.getProgressDrawable();
            stars.getDrawable(2).setColorFilter(Color.parseColor("#f8d64e"), PorterDuff.Mode.SRC_ATOP);


            convertView.setTag(viewHolder);

            viewHolder.cutprice.setPaintFlags(viewHolder.cutprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }
        final Beanlist bean = (Beanlist)getItem(position);

        Picasso.with(context).load(bean.getImage()).into(viewHolder.image);
        //viewHolder.image.setImageResource(bean.getImage());
        viewHolder.title.setText(bean.getTitle());
        if(bean.getPrice().equals("0")) {
            viewHolder.price.setText(bean.getCutprice()+"₺");
            viewHolder.cutprice.setText("0");
            viewHolder.cutprice.setVisibility(View.INVISIBLE);
            viewHolder.discount.setText("%0");
        }else{
            viewHolder.price.setText(bean.getPrice()+"₺");
            viewHolder.cutprice.setText(bean.getCutprice()+"₺");
            viewHolder.discount.setText(bean.getDiscount());
        }
        if(bean.getFavorites().equals("1")){
            viewHolder.fav2.setVisibility(View.VISIBLE);
            viewHolder.fav1.setVisibility(View.GONE);
        }
        viewHolder.ratingtext.setText("("+bean.getRatingtext()+")");
        ratingbar.setRating(bean.getRating());
        viewHolder.mSmallBang = SmallBang.attach2Window(main);
        viewHolder.id.setText(bean.getId().toString());


        viewHolder.fav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!kullaniciid.equals("-1")) {
                    viewHolder.fav2.setVisibility(View.VISIBLE);
                    viewHolder.fav1.setVisibility(View.GONE);
                    like(v);
                    new getData(context) {
                        @Override
                        protected void onPostExecute(String s) {
                            if (!s.equals("")) {
                                Toast.makeText(context, "Ürün Başarıyla Favorilere Eklendi...", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Ürün Favorilere Eklenemedi...", Toast.LENGTH_SHORT).show();
                            }
                            dialog.dismiss();
                            super.onPostExecute(s);
                        }
                    }.execute(MainActivity.server_url + "favorites.php", kullaniciid, bean.getId() + "-add");
                }else {
                    Toast.makeText(context, "Lütfen Giriş Yapınız!!!", Toast.LENGTH_SHORT).show();
                }
            }

            public void like(View view){
                viewHolder.fav2.setImageResource(R.drawable.f4);
                viewHolder.mSmallBang.bang(view);
                viewHolder.mSmallBang.setmListener(new SmallBangListener() {
                    @Override
                    public void onAnimationStart() {

                    }

                    @Override
                    public void onAnimationEnd() {

                    }


                });
            }

        });


        viewHolder.fav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!kullaniciid.equals("-1")) {
                    viewHolder.fav2.setVisibility(View.GONE);
                    viewHolder.fav1.setVisibility(View.VISIBLE);
                    new getData(context) {
                        @Override
                        protected void onPostExecute(String s) {
                            if (!s.equals("")) {
                                Toast.makeText(context, "Ürün Başarıyla Favorilerden Çıkarıldı...", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Ürün Favorilerden Çıkarılamadı...", Toast.LENGTH_SHORT).show();
                            }
                            dialog.dismiss();
                            super.onPostExecute(s);
                        }
                    }.execute(MainActivity.server_url + "favorites.php", kullaniciid, bean.getId() + "-delete");
                }else{
                    Toast.makeText(context, "Lütfen Giriş Yapınız!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return convertView;
    }

    private class ViewHolder {
        ImageView image;
        TextView title;
        TextView price;
        TextView cutprice;
        TextView discount;
        TextView id;
        TextView ratingtext;
        ImageView fav1;
        ImageView fav2;
        SmallBang mSmallBang;


    }
}



