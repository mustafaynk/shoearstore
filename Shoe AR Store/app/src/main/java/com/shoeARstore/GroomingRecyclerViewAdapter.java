package com.shoeARstore;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class GroomingRecyclerViewAdapter extends RecyclerView
        .Adapter<GroomingRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Beanlist>bean;
    Activity main;

    SharedPreferences prefs;
    String kullaniciid;
    private static MyClickListener myClickListener;
    private Context context;



    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {



        ImageView image;
        TextView title;
        TextView price;
        TextView cutprice;
        TextView discount;
        TextView ratingtex;
        ImageView fav1,fav2;
        RatingBar ratingbar;
        TextView id;
        private SmallBang mSmallBang;



        public DataObjectHolder(View itemView) {
            super(itemView);


            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            cutprice = (TextView) itemView.findViewById(R.id.cutprice);
            discount = (TextView) itemView.findViewById(R.id.discount);
            ratingtex = (TextView) itemView.findViewById(R.id.ratingtext);
            id=(TextView) itemView.findViewById(R.id.id);

            cutprice.setPaintFlags(cutprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


//        ***********ratingBar**********
            ratingbar = (RatingBar) itemView.findViewById(R.id.ratingbar);
            LayerDrawable stars = (LayerDrawable) ratingbar.getProgressDrawable();
            stars.getDrawable(2).setColorFilter(Color.parseColor("#f8d64e"), PorterDuff.Mode.SRC_ATOP);

            fav1 = (ImageView)itemView.findViewById(R.id.fav1);
            fav2 = (ImageView)itemView.findViewById(R.id.fav2);


            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }

    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public GroomingRecyclerViewAdapter(Activity activity,Context context, ArrayList<Beanlist> bean) {
        this.main = activity;
        this.context = context;
        this.bean = bean;
    }



    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);
        prefs =context.getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid=prefs.getString("id","-1");
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }
    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {

        //  holder.icon.setImageResource(mDataset.get(position).get());

        Picasso.with(main).load(bean.get(position).getImage()).into(holder.image);
        //holder.image.setImageResource(bean.get(position).getImage());
        holder.title.setText(bean.get(position).getTitle());

        if(bean.get(position).getPrice().equals("0")) {
            holder.price.setText(bean.get(position).getCutprice()+"₺");
            holder.cutprice.setVisibility(View.INVISIBLE);
            holder.discount.setText("%0");
        }else{
            holder.price.setText(bean.get(position).getPrice()+"₺");
            holder.cutprice.setText(bean.get(position).getCutprice()+"₺");
            holder.discount.setText(bean.get(position).getDiscount());
        }

        holder.ratingtex.setText("("+bean.get(position).getRatingtext()+")");
        holder.ratingbar.setRating(bean.get(position).getRating());
        holder.id.setText(bean.get(position).getId());
        if(bean.get(position).getFavorites().equals("1")){
            holder.fav2.setVisibility(View.VISIBLE);
            holder.fav1.setVisibility(View.GONE);
        }

        holder.mSmallBang = SmallBang.attach2Window(main);
//ekleme
        holder.fav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!kullaniciid.equals("-1")){
                    holder.fav2.setVisibility(View.VISIBLE);
                    holder.fav1.setVisibility(View.GONE);
                    like(v);
                    new getData(context){
                        @Override
                        protected void onPostExecute(String s) {
                            if(!s.equals("")){
                                Toast.makeText(context, "Ürün Başarıyla Favorilere Eklendi...", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(context, "Ürün Favorilere Eklenemedi...", Toast.LENGTH_SHORT).show();
                            }
                            dialog.dismiss();
                            super.onPostExecute(s);
                        }
                    }.execute(MainActivity.server_url+"favorites.php",kullaniciid,bean.get(position).getId()+"-add"); 
                }else{
                    Toast.makeText(context, "Lütfen Giriş Yapınız!!!", Toast.LENGTH_SHORT).show();
                }
                
            }

            public void like(View view){
                holder.fav2.setImageResource(R.drawable.f4);
                holder.mSmallBang.bang(view);
                holder.mSmallBang.setmListener(new SmallBangListener() {
                    @Override
                    public void onAnimationStart() {

                    }

                    @Override
                    public void onAnimationEnd() {

                    }


                });
            }

        });
//silme
        holder.fav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!kullaniciid.equals("-1")) {
                    holder.fav2.setVisibility(View.GONE);
                    holder.fav1.setVisibility(View.VISIBLE);
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
                    }.execute(MainActivity.server_url + "favorites.php", kullaniciid, bean.get(position).getId() + "-delete");
                }else{
                    Toast.makeText(context, "Lütfen Giriş Yapınız!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }





    public void deleteItem(int index) {
        bean.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return bean.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }






}
