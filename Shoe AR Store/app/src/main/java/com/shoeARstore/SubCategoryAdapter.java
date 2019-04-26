package com.shoeARstore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class SubCategoryAdapter extends ArrayAdapter<String>
{
    String[] categoryname,categoryid;
    Context c;
    LayoutInflater inflater;
    public SubCategoryAdapter(Context context, String[] categoryname, String[] categoryid) {
        super(context, R.layout.subcategories_listview_item,categoryname);
        this.categoryname=categoryname;
        this.categoryid=categoryid;
        this.c=context;
    }
    public class  ViewHolder
    {
        TextView categoryname,categoryid;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.subcategories_listview_item, null,true);
        }
        final ViewHolder holder=new ViewHolder();
        holder.categoryname=(TextView) convertView.findViewById(R.id.categoryname);
        holder.categoryid=(TextView) convertView.findViewById(R.id.categoryid);
        holder.categoryname.setText(categoryname[position]);
        holder.categoryid.setText(categoryid[position]);
        return convertView;
    }
}
