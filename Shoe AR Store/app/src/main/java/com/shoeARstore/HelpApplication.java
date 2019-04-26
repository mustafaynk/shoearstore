package com.shoeARstore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by User
 */

public class HelpApplication extends AppCompatActivity{
    private String[] TITLE;
    NotificationExpandableHeightListView listView;
    ArrayList<BeanclassNotification> Bean;
    private BaseAdapterNotification baseAdapter;
    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_page);
        TITLE = new String[]{"HAKKIMIZDA",
                "KULLANICI SÖZLEŞMESİ", "KULLANIM ŞARTLARI","İLETİŞİM"};
        Bean=new ArrayList<>();
        listView=(NotificationExpandableHeightListView) findViewById(R.id.listview);
        webView=(WebView) findViewById(R.id.webview);

        for (int i= 0; i< TITLE.length; i++){
            BeanclassNotification bean = new BeanclassNotification(TITLE[i], "");
            Bean.add(bean);
        }
        baseAdapter = new BaseAdapterNotification(getApplicationContext(), Bean) {
        };

        listView.setAdapter(baseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final TextView textView=(TextView) view.findViewById(R.id.title);
                String kosul;
                if(textView.getText().equals("HAKKIMIZDA")) kosul="aboutus";
                else if (textView.getText().equals("KULLANICI SÖZLEŞMESİ")) kosul="termsofuse";
                else if(textView.getText().equals("KULLANIM ŞARTLARI")) kosul="useragreement";
                else kosul="contact";
                new getData(HelpApplication.this){
                    @Override
                    protected void onPostExecute(String s) {
                        dialog.dismiss();
                        if(s!=null){
                            JSONArray jsonArray= null;
                            String veri = null;
                            try {
                                jsonArray = new JSONArray(s);
                                JSONObject jsonObject;
                                for (int i=0;i<jsonArray.length();i++) {
                                    TextSliderView textSliderView = new TextSliderView(c);
                                    jsonObject = jsonArray.getJSONObject(i);
                                    if(textView.getText().equals("HAKKIMIZDA")) veri=jsonObject.getString("Content");
                                    else if (textView.getText().equals("KULLANICI SÖZLEŞMESİ")) veri=jsonObject.getString("Conditions");
                                    else if(textView.getText().equals("KULLANIM ŞARTLARI")) veri=jsonObject.getString("Agreement");
                                    else veri="Adres:"+jsonObject.getString("Adress")+"<br>Telefon:"+jsonObject.getString("Telephone")+"<br>E-Mail:"+jsonObject.getString("EMail");
                                }
                                gonder(veri);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        dialog.dismiss();
                        super.onPostExecute(s);
                    }
                }.execute(MainActivity.server_url+"slidermaincategory.php",kosul,"yok");
            }
        });


    }

    private void gonder(String veri) {
        webView.loadData("","text/html; charset=UTF-8", "UTF-8");
        webView.loadData(veri, "text/html; charset=UTF-8", "UTF-8");
    }


}
