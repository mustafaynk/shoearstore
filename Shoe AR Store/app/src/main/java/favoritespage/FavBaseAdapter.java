package favoritespage;

import android.content.Context;
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

/**
 * Slide And Drag
 */

public class FavBaseAdapter extends BaseAdapter {

    ArrayList<FavBeanlist> Bean;
    Context context;

    public FavBaseAdapter(ArrayList<FavBeanlist> bean, Context context) {
        Bean = bean;
        this.context = context;
    }

    public void setItem(int position,FavBeanlist element){
        Bean.set(position,element);
        notifyDataSetChanged();
    }

    public void addItem(int position,FavBeanlist element){
        Bean.add(position,element);
        notifyDataSetChanged();
    }

    public FavBeanlist deleteItem (int position) {
        FavBeanlist silinen=Bean.remove(position);
        notifyDataSetChanged();
        return silinen;
    }


    @Override
    public int getCount() {
        return Bean.size();
    }

    @Override
    public Object getItem(int position) {
        return Bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Bean.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomViewHolder cvh;
        if (convertView == null) {
            cvh = new CustomViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_custom_btn, null);
            cvh.imgLogo = (ImageView) convertView.findViewById(R.id.image);
            cvh.txtName = (TextView) convertView.findViewById(R.id.title);
            cvh.txtPrice=(TextView) convertView.findViewById(R.id.price);
            cvh.txtId=(TextView) convertView.findViewById(R.id.id);
            cvh.txtStock=(TextView) convertView.findViewById(R.id.stockcode);
            convertView.setTag(cvh);
        } else {
            cvh = (CustomViewHolder) convertView.getTag();
        }
        FavBeanlist beanlist=(FavBeanlist) getItem(position);
        Picasso.with(context).load(MainActivity.server_url+beanlist.getImage()).into(cvh.imgLogo);
        cvh.txtName.setText(beanlist.getTitle());
        cvh.txtPrice.setText(beanlist.getPrice()+"₺");
        cvh.txtStock.setText(beanlist.getStockcode());
        return convertView;
    }



    class CustomViewHolder {
        public ImageView imgLogo;
        public TextView txtName;
        public TextView txtPrice;
        public TextView txtId;
        public TextView txtStock;
    }
}
