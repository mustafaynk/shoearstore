package yorumlarsayfasi;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.shoeARstore.R;

import java.util.ArrayList;



public class BaseAdapterReview extends BaseAdapter {

    Context context;

    ArrayList<BeanclassReview>bean;
    RatingBar ratingbar;





    public BaseAdapterReview(Context context, ArrayList<BeanclassReview> bean) {
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

        ViewHolder viewHolder = null;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_review,null);

            viewHolder = new ViewHolder();


            viewHolder.title = (TextView)convertView.findViewById(R.id.title);
            viewHolder.rateno = (TextView)convertView.findViewById(R.id.rateno);
            viewHolder.date = (TextView)convertView.findViewById(R.id.date);
            viewHolder.username = (TextView)convertView.findViewById(R.id.username);
            viewHolder.description = (TextView)convertView.findViewById(R.id.description);
            viewHolder.like = (TextView)convertView.findViewById(R.id.like);



//        ***********ratingBar**********
            ratingbar = (RatingBar) convertView.findViewById(R.id.ratingbar);
            LayerDrawable stars = (LayerDrawable) ratingbar.getProgressDrawable();
            stars.getDrawable(2).setColorFilter(convertView.getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_ATOP);


            convertView.setTag(viewHolder);
        }else {

            viewHolder = (ViewHolder)convertView.getTag();

        }
        BeanclassReview bean = (BeanclassReview)getItem(position);
        viewHolder.title.setText(bean.getTitle());
        viewHolder.rateno.setText(bean.getRateno());
        viewHolder.date.setText(bean.getDate());
        viewHolder.username.setText(bean.getUsername());
        viewHolder.description.setText(bean.getDescription());
        viewHolder.like.setText(bean.getLike());
        String rate=bean.getRateno().substring(0,bean.getRateno().indexOf("/"));
        ratingbar.setRating(Float.parseFloat(rate));
        return convertView;
    }




    private class ViewHolder{
        TextView title;
        TextView rateno;
        TextView date;
        TextView username;
        TextView description;
        TextView like;

    }
}




