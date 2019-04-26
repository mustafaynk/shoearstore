package orderspage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shoeARstore.ExpandableHeightGridView;
import com.shoeARstore.MainActivity;
import com.shoeARstore.R;
import com.shoeARstore.getData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    SharedPreferences prefs;
    String kullaniciid;

    private ExpandableHeightGridView orders;
    private ArrayList<BeanclassOrderPage> Bean;
    private GridListViewItemAdapter baseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_page);

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        TextView title=(TextView) toolbar.findViewById(R.id.eshop);
        title.setText("SİPARİŞLERİM");
        ImageView backButton=(ImageView) toolbar.findViewById(R.id.backImage);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        prefs =getApplicationContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid=prefs.getString("id","-1");

        orders=(ExpandableHeightGridView) findViewById(R.id.orderList);
        Bean=new ArrayList<>();

        new getData(OrderActivity.this){
            @Override
            protected void onPostExecute(String s) {
                if(!s.equals("") && s!=null){
                    try {
                        JSONArray jsonArray=new JSONArray(s);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            BeanclassOrderPage beanclassOrderPage=new BeanclassOrderPage(jsonObject.getInt("Status"),jsonObject.getString("Price"),jsonObject.getString("OrderNo"), jsonObject.getString("OrderComplatedDate"));
                            Bean.add(beanclassOrderPage);
                        }
                        baseAdapter=new GridListViewItemAdapter(OrderActivity.this,Bean);
                        orders.setAdapter(baseAdapter);
                        orders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                TextView textView=(TextView) view.findViewById(R.id.orderNumber);
                                Intent gec=new Intent(OrderActivity.this,OrderDetailActivity.class);
                                gec.putExtra("orderno",textView.getText().toString().replace("Sipariş No:",""));
                                startActivity(gec);
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(OrderActivity.this, "Sipariş Listeniz Boş...", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(MainActivity.server_url+"orders.php",kullaniciid,"yok");
       /* Bean = new ArrayList<BeanclassOrderPage>();

        for (int i= 0; i< IMAGE.length; i++){

            BeanclassOrderPage bean = new BeanclassOrderDetail(IMAGE[i],ORDERDAY[i], ORDERNAME[i], QT[i], DATE[i], IDNUMBER[i],PROGRESS[i]);
            Bean.add(bean);

        }

        baseAdapter = new ListBaseAdapterOrder(OrderActivity.this, Bean) {
        };

        listview.setAdapter(baseAdapter);*/

    }
}
