package orderspage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shoeARstore.MainActivity;
import com.shoeARstore.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class GridListViewItemAdapter extends BaseAdapter {

    Context context;

    ArrayList<BeanclassOrderPage> orders;
    Typeface fonts1,fonts2;



    public GridListViewItemAdapter(Context context, ArrayList<BeanclassOrderPage> orders) {

        this.context = context;
        this.orders = orders;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int position) {
        return orders.get(position);
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
            convertView = layoutInflater.inflate(R.layout.order_page_grid_item,null);
            viewHolder = new ViewHolder();

            viewHolder.orderstatus = (TextView) convertView.findViewById(R.id.orderStatus);
            viewHolder.orderprice=(TextView) convertView.findViewById(R.id.orderPrice);
            viewHolder.ordernumber = (TextView) convertView.findViewById(R.id.orderNumber);
            viewHolder.orderdate=(TextView) convertView.findViewById(R.id.orderDate);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.orderImage);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        BeanclassOrderPage beanclassOrderPage=(BeanclassOrderPage) getItem(position);
        Picasso.with(context).load(MainActivity.server_url+"assets/images/orderspageicon.png").into(viewHolder.image);

        viewHolder.orderdate.setText(beanclassOrderPage.getOrderdate());
        if(beanclassOrderPage.getStatus()==2){
            viewHolder.orderstatus.setText("Hazırlanıyor");
        }else if(beanclassOrderPage.getStatus()==3){
            viewHolder.orderstatus.setText("Kargoda");
        }else if(beanclassOrderPage.getStatus()==4){
            viewHolder.orderstatus.setText("Teslim Edildi");
        }
        viewHolder.ordernumber.setText("Sipariş No:"+beanclassOrderPage.getOrderno());
        viewHolder.orderprice.setText(beanclassOrderPage.getPrice()+"₺");

        return convertView;
    }

    private class ViewHolder {
        TextView orderstatus;
        TextView orderprice;
        TextView ordernumber;
        TextView orderdate;
        ImageView image;

    }
}



