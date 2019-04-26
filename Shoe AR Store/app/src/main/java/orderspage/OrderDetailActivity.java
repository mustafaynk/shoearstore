package orderspage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shoeARstore.ExpandableHeightListView;
import com.shoeARstore.MainActivity;
import com.shoeARstore.R;
import com.shoeARstore.getData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class OrderDetailActivity extends AppCompatActivity {

    private ExpandableHeightListView listview;
    private ArrayList<BeanclassOrderDetail> Bean;
    private ListBaseAdapterOrder baseAdapter;
    SharedPreferences prefs;
    String kullaniciid;
    private String orderno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        TextView title=(TextView) toolbar.findViewById(R.id.eshop);
        ImageView backButton=(ImageView) toolbar.findViewById(R.id.backImage);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bean = new ArrayList<BeanclassOrderDetail>();
        listview=(ExpandableHeightListView) findViewById(R.id.listview);

        prefs =getApplicationContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid=prefs.getString("id","-1");


        if(getIntent().getExtras()!=null){
            orderno=getIntent().getExtras().getString("orderno");
            title.setText("SİPARİŞ DETAYI:"+orderno);
        }else {
            orderno=null;
        }
        if(orderno!=null && !kullaniciid.equals("-1")){
            new getData(OrderDetailActivity.this){
                @Override
                protected void onPostExecute(String s) {
                    if(!s.equals("") && s!=null){
                        try {
                            JSONArray jsonArray=new JSONArray(s);
                            JSONObject jsonObject;
                            Random rnd=new Random(100);
                            for(int i=0;i<jsonArray.length();i++){
                                jsonObject=jsonArray.getJSONObject(i);
                                BeanclassOrderDetail beanclassOrderDetail=new BeanclassOrderDetail(jsonObject.getString("ProductImagePath"),jsonObject.getString("OrderComplatedDate"),jsonObject.getString("ProductName"),jsonObject.getString("Piece"),jsonObject.getString("OrderComplatedDate"),jsonObject.getString("OrdersId"), 5*rnd.nextInt(10));
                                Bean.add(beanclassOrderDetail);
                            }
                            baseAdapter=new ListBaseAdapterOrder(OrderDetailActivity.this,Bean);
                            listview.setAdapter(baseAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }else {
                        Toast.makeText(OrderDetailActivity.this, "Hata!!!", Toast.LENGTH_SHORT).show();
                    }
                    dialog.dismiss();
                    super.onPostExecute(s);
                }
            }.execute(MainActivity.server_url+"orderdetail.php",kullaniciid,orderno);
        }

    }
}
