package com.shoeARstore;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class BaseAdapterNotification extends BaseAdapter {

    Context context;

    ArrayList<BeanclassNotification>bean;
    Typeface fonts1,fonts2;





    public BaseAdapterNotification(Context context, ArrayList<BeanclassNotification> bean) {


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

//        fonts1 =  Typeface.createFromAsset(context.getAssets(),
//                "fonts/Lato-Light.ttf");
//
//        fonts2 = Typeface.createFromAsset(context.getAssets(),
//                "fonts/Lato-Regular.ttf");

        ViewHolder viewHolder = null;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_notification,null);

            viewHolder = new ViewHolder();


            viewHolder.title = (TextView)convertView.findViewById(R.id.title);
            viewHolder.time = (TextView)convertView.findViewById(R.id.time);




//            viewHolder.title.setTypeface(fonts2);
//            viewHolder.time.setTypeface(fonts2);

            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }

        BeanclassNotification bean = (BeanclassNotification)getItem(position);


        viewHolder.title.setText(bean.getTitle());

        viewHolder.time.setText(bean.getTime());

        return convertView;
    }

    private class ViewHolder{

        TextView title;
        TextView time;





    }
}




