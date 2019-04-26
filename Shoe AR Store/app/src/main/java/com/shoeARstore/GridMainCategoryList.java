package com.shoeARstore;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class GridMainCategoryList extends BaseAdapter {

    Context context;

    ArrayList<String> categoryname;
    ArrayList<String> categoryid;
    ArrayList<String> categoryimagepath;
    Typeface fonts1,fonts2;



    public GridMainCategoryList(Context context, ArrayList<String> categoryname, ArrayList<String> categoryid, ArrayList<String> categoryimagepath) {

        this.context = context;
        this.categoryname = categoryname;
        this.categoryid=categoryid;
        this.categoryimagepath=categoryimagepath;
    }

    @Override
    public int getCount() {
        return categoryname.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
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

        final ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.maincategory_listitem,null);
            viewHolder = new ViewHolder();

            viewHolder.categoryname = (TextView) convertView.findViewById(R.id.categoryname);
            viewHolder.categoryid=(TextView) convertView.findViewById(R.id.categoryid);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);

            convertView.setTag(viewHolder);

        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.categoryname.setText(categoryname.get(position));
        viewHolder.categoryid.setText(categoryid.get(position));
        Picasso.with(context).load(MainActivity.server_url+categoryimagepath.get(position)).into(viewHolder.image);
        /*if(categoryname.get(position).equals("Erkek") || categoryname.get(position).equals("Kadın") || categoryname.get(position).equals("Çocuk")){
            Picasso.with(context).load(MainActivity.server_url+"assets/images/icon-"+categoryname.get(position)+".png").into(viewHolder.image);
        }else {
            Picasso.with(context).load(MainActivity.server_url+"assets/images/icon-default.png").into(viewHolder.image);
        }*/

        return convertView;
    }

    private class ViewHolder {
        TextView categoryname;
        TextView categoryid;
        ImageView image;

    }
}



