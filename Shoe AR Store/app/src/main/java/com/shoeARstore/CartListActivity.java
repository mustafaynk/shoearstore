package com.shoeARstore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class CartListActivity extends android.support.v4.app.Fragment {

    public static CartListActivity newInstance(){
        CartListActivity fragment=new CartListActivity();
        return fragment;
    }
    private ListView listview;
    private TextView odemeyap,sepettext,totalpricewithkdv,cargoprice,totalprice;
    private LinearLayout totalPriceLayout;

    SharedPreferences prefs;
    String kullaniciid;

    private ArrayList<CartListBeanlist> Bean;
    private CartListBaseAdapter baseAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_cartlist,container,false);


        prefs =getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid=prefs.getString("id","-1");

        listview = (ListView)view.findViewById(R.id.listview);
        odemeyap=(TextView) view.findViewById(R.id.pay);
        sepettext=(TextView) view.findViewById(R.id.sepetbos);
        totalpricewithkdv=(TextView) view.findViewById(R.id.totalpricewithkdv);
        cargoprice=(TextView) view.findViewById(R.id.cargoprice);
        totalprice=(TextView) view.findViewById(R.id.totalPrice);

        totalPriceLayout=(LinearLayout) view.findViewById(R.id.totalPriceStatus);

        if (!kullaniciid.equals("-1")){
            sepettext.setVisibility(View.GONE);
            odemeyap.setVisibility(View.VISIBLE);
            totalPriceLayout.setVisibility(View.VISIBLE);
            new getData(getActivity()){
                @Override
                protected void onPostExecute(String s) {
                    if(s!=null && !s.equals("")){
                        try {
                            ArrayList<String> image=new ArrayList<>();
                            ArrayList<String> price=new ArrayList<>();
                            ArrayList<String> title=new ArrayList<>();
                            ArrayList<String> stockcode=new ArrayList<>();
                            ArrayList<String> piece=new ArrayList<>();
                            ArrayList<String> number=new ArrayList<>();
                            ArrayList<String> id=new ArrayList<>();
                            JSONArray jsonArray=new JSONArray(s);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                image.add(MainActivity.server_url+jsonObject.getString("ProductImagePath").replace("\\","/"));
                                price.add(jsonObject.getString("CurrnetPrice"));
                                title.add(jsonObject.getString("ProductName"));
                                stockcode.add(jsonObject.getString("ProductStockCode"));
                                piece.add(jsonObject.getString("Piece"));
                                number.add(jsonObject.getString("Number"));
                                id.add(jsonObject.getString("OrdersId"));
                            }
                            adapterGonder(image,title,price,stockcode,piece,number,id);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }else{
                        sepettext.setVisibility(View.VISIBLE);
                        odemeyap.setVisibility(View.INVISIBLE);
                        totalPriceLayout.setVisibility(View.INVISIBLE);
                    }
                    dialog.dismiss();
                    super.onPostExecute(s);
                }
            }.execute(MainActivity.server_url+"cartlist.php",kullaniciid,"listele");
        }else{
            sepettext.setVisibility(View.VISIBLE);
            odemeyap.setVisibility(View.INVISIBLE);
            totalPriceLayout.setVisibility(View.INVISIBLE);
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=(TextView) view.findViewById(R.id.productstockcode);
                Intent gec = new Intent(getActivity(), ProductDetailActivity.class);
                gec.putExtra("StockCode",textView.getText().toString());
                startActivity(gec);
            }
        });

        return view;
    }
    private void adapterGonder(ArrayList<String> image, ArrayList<String> title, ArrayList<String> price, ArrayList<String> stockcode, ArrayList<String> piece, ArrayList<String> number,ArrayList<String> id) {
        Bean=new ArrayList<>();
        Float toplamfiyat= Float.valueOf(0);
        for(int i=0;i<image.size();i++){
            CartListBeanlist beanlist=new CartListBeanlist(image.get(i),title.get(i),price.get(i),stockcode.get(i),piece.get(i),number.get(i),id.get(i));
            Bean.add(beanlist);
            toplamfiyat+=Float.valueOf(price.get(i))*Float.valueOf(piece.get(i));
        }
        baseAdapter = new CartListBaseAdapter(getActivity(), Bean) {
        };
        totalpricewithkdv.setText(toplamfiyat+" ₺");
        Float cargoPrice=(image.size()*Float.valueOf("1.5"));
        cargoprice.setText(cargoPrice+" ₺");
        totalprice.setText((toplamfiyat+cargoPrice)+" ₺");
        listview.setAdapter(baseAdapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
