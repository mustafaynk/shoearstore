package com.shoeARstore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class CartListBaseAdapter extends BaseAdapter {

    Context context;

    ArrayList<CartListBeanlist>bean;

    Typeface fonts1,fonts2;





    public CartListBaseAdapter(Context context, ArrayList<CartListBeanlist> bean) {
        this.context = context;
        this.bean = bean;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        fonts1 =  Typeface.createFromAsset(context.getAssets(),
                "fonts/MavenPro-Regular.ttf");

        fonts2 = Typeface.createFromAsset(context.getAssets(),
                "fonts/MavenPro-Regular.ttf");

        ViewHolder viewHolder = null;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.cart_list,null);

            viewHolder = new ViewHolder();
            viewHolder.deletebutton=(ImageView) convertView.findViewById(R.id.deleteitem);
            viewHolder.image = (ImageView)convertView.findViewById(R.id.image);
            viewHolder.title = (TextView)convertView.findViewById(R.id.title);
            viewHolder.price = (TextView)convertView.findViewById(R.id.price);
            viewHolder.stockcode=(TextView) convertView.findViewById(R.id.productstockcode);
            viewHolder.text = (TextView)convertView.findViewById(R.id.text);
            viewHolder.title.setTypeface(fonts2);
            viewHolder.min=(ImageView) convertView.findViewById(R.id.min);
            viewHolder.plus=(ImageView) convertView.findViewById(R.id.plus);
            viewHolder.size=(TextView) convertView.findViewById(R.id.size);
            viewHolder.id=(TextView) convertView.findViewById(R.id.id);
            viewHolder.totalprice=(TextView) convertView.findViewById(R.id.totalprice);
            viewHolder.text.setTypeface(fonts1);
            viewHolder.price.setTypeface(fonts2);
            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView id=(TextView) ((LinearLayout) v.getParent()).findViewById(R.id.id);
                new getData(context){
                    @Override
                    protected void onPostExecute(String s) {
                        if(!s.equals("") && s!=null){
                            Toast.makeText(c, "Ürün Sepetten Çıkarıldı...", Toast.LENGTH_SHORT).show();
                            Intent gec=new Intent(c,HomeFragment.class);
                            gec.putExtra("fragment","4");
                            c.startActivity(gec);
                        }else {
                            Toast.makeText(c, "Ürün Sepetten Çıkarılamadı!!!", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                        super.onPostExecute(s);
                    }
                }.execute(MainActivity.server_url+"cartlist.php",id.getText().toString(),"delete");
            }
        });

        CartListBeanlist bean = (CartListBeanlist)getItem(position);
        Picasso.with(context).load(bean.getImage()).into(viewHolder.image);
        viewHolder.title.setText(bean.getTitle());
        viewHolder.stockcode.setText(bean.getStockcode());
        Float toplamfiyat=Float.parseFloat(bean.getPiece())*Float.parseFloat(bean.getPrice());
        viewHolder.totalprice.setText(toplamfiyat+" ₺");
        viewHolder.price.setText(bean.getPrice()+" ₺");
        viewHolder.text.setText(bean.getPiece());
        viewHolder.size.setText(bean.getSize());
        viewHolder.id.setText(bean.getId());

        final ViewHolder finalViewHolder = viewHolder;
        final int[] number = {Integer.parseInt(bean.getPiece())};
        viewHolder.min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number[0] == 1){
                    finalViewHolder.text.setText("" + number[0]);
                }

                if (number[0] > 1){
                    number[0] -=1;
                    finalViewHolder.text.setText(""+ number[0]);
                }
                pieceUpdate(finalViewHolder ,number[0]);
            }


        });
        viewHolder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number[0]++;
                finalViewHolder.text.setText(String.valueOf(number[0]));
                pieceUpdate(finalViewHolder ,number[0]);
            }
        });

        return convertView;
    }
    private void pieceUpdate(ViewHolder finalViewHolder,int piece) {
        new getData(context){
            @Override
            protected void onPostExecute(String s) {
                if(!s.equals("") && s!=null){
                }else{
                    Toast.makeText(c, "Ürün Güncellenemedi!!!", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(MainActivity.server_url+"cartlist.php",finalViewHolder.id.getText().toString(), String.valueOf(piece));
        Float toplamfiyat=(Float.parseFloat(finalViewHolder.price.getText().toString().replace(" ₺",""))*Float.parseFloat(finalViewHolder.text.getText().toString()));
        finalViewHolder.totalprice.setText(toplamfiyat+" ₺");
    }
    private class ViewHolder{
        ImageView deletebutton;
        ImageView image;
        ImageView min;
        ImageView plus;
        TextView title;
        TextView price;
        TextView text;
        TextView stockcode;
        TextView size;
        TextView id;
        TextView totalprice;
    }
}




