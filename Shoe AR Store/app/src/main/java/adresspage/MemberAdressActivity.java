package adresspage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.shoeARstore.MainActivity;
import com.shoeARstore.R;
import com.shoeARstore.getData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Shoe Ar Store
 */

public class MemberAdressActivity extends AppCompatActivity {
    TextView deliveryadress,invoiceadress;
    Button addDeliveryadress,addInvoiceadress;
    private String kullaniciid;
    ListView teslimatAdressList,faturaAdressList;
    private int teslimatAdresCount,faturaAdresCount;

    ArrayList<AdressBeanlist> BeanTeslimat,BeanFatura;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adress);

        //Component İnitialize
        deliveryadress=(TextView) findViewById(R.id.deliveryadresstext);
        invoiceadress=(TextView) findViewById(R.id.invoiceadresstext);
        addDeliveryadress=(Button) findViewById(R.id.adddeliveryadress);
        addInvoiceadress=(Button) findViewById(R.id.addinvoiceadress);
        teslimatAdressList=(ListView) findViewById(R.id.deliveryadresslist);
        faturaAdressList=(ListView) findViewById(R.id.invoiceadresslist);

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        TextView title=(TextView) toolbar.findViewById(R.id.eshop);
        title.setText("ADRESLERİM");
        ImageView backButton=(ImageView) toolbar.findViewById(R.id.backImage);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences prefs =getApplicationContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid = prefs.getString("id", "0");


        TabHost tabHost=(TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec mSpec=tabHost.newTabSpec("Teslimat");
        mSpec.setContent(R.id.deliveryadress);
        mSpec.setIndicator("Teslimat Adreslerim");
        tabHost.addTab(mSpec);

        mSpec=tabHost.newTabSpec("Fatura");
        mSpec.setContent(R.id.invoiceadress);
        mSpec.setIndicator("Fatura Adreslerim");
        tabHost.addTab(mSpec);

        adresCek("Teslimat");
        adresCek("Fatura");




        addDeliveryadress.setText(getResources().getString(R.string.adressaddtext,"Teslimat"));
        addInvoiceadress.setText(getResources().getString(R.string.adressaddtext,"Fatura"));

        addDeliveryadress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityGec("Teslimat");
            }
        });
        addInvoiceadress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityGec("Fatura");
            }
        });

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("Teslimat")){
                    deliveryadress.setText(getResources().getString(R.string.adresstext,String.valueOf(teslimatAdresCount),"Teslimat"));
                }else {
                    invoiceadress.setText(getResources().getString(R.string.adresstext,String.valueOf(faturaAdresCount),"Fatura"));
                }
            }
        });
    }

    protected void adresCek(final String adresTip) {
        BeanTeslimat=new ArrayList<>();
        BeanFatura=new ArrayList<>();
        new getData(MemberAdressActivity.this){
            @Override
            protected void onPostExecute(String s) {
                if(s!=null){
                    try {
                        JSONArray jsonArray=new JSONArray(s);
                        if(adresTip.equals("Teslimat")) teslimatAdresCount=jsonArray.length();
                        else faturaAdresCount=jsonArray.length();
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            if(adresTip.equals("Teslimat"))
                            {
                                AdressBeanlist adressBeanlist=new AdressBeanlist(jsonObject.getString("Id"),jsonObject.getString("UserName"),jsonObject.getString("UserSurname"),jsonObject.getString("UserTelephone"),jsonObject.getString("AdressCountry"),
                                                    jsonObject.getString("AdressCity"),jsonObject.getString("AdressDistrict"),jsonObject.getString("OpenAdress"),jsonObject.getString("AdressName"),"","","",adresTip);
                                BeanTeslimat.add(adressBeanlist);

                            }else{
                                AdressBeanlist adressBeanlist=new AdressBeanlist(jsonObject.getString("Id"),jsonObject.getString("UserName"),jsonObject.getString("UserSurname"),jsonObject.getString("UserTelephone"),jsonObject.getString("AdressCountry"),
                                        jsonObject.getString("AdressCity"),jsonObject.getString("AdressDistrict"),jsonObject.getString("OpenAdress"),jsonObject.getString("AdressName"),jsonObject.getString("CompanyName"),jsonObject.getString("CompanyTaxName"),jsonObject.getString("CompanyTaxNumber"),adresTip);
                                BeanFatura.add(adressBeanlist);

                            }

                        }
                        AdressBaseAdapter adapter;
                        //ArrayAdapter<String> details=new ArrayAdapter<String>(MemberAdressActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,detaylar);
                        if((adresTip.equals("Teslimat"))){
                            adapter=new AdressBaseAdapter(BeanTeslimat,MemberAdressActivity.this);
                            teslimatAdressList.setAdapter(adapter);
                        }
                        else{
                            adapter=new AdressBaseAdapter(BeanFatura,MemberAdressActivity.this);
                            faturaAdressList.setAdapter(adapter);
                        }
                        deliveryadress.setText(getResources().getString(R.string.adresstext,String.valueOf(teslimatAdresCount),"Teslimat"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(MainActivity.server_url+"getir.php","Adres",adresTip+"-"+kullaniciid);
    }


    private void activityGec(String adressName) {
        Intent gec=new Intent(MemberAdressActivity.this,addAdressActivity.class);
        gec.putExtra("addressName",adressName);
        startActivity(gec);
    }
}
