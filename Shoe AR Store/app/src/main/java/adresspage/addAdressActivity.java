package adresspage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.shoeARstore.MainActivity;
import com.shoeARstore.R;
import com.shoeARstore.getData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Shoe Ar Store
 */

public class addAdressActivity extends AppCompatActivity {

    TextView textTitle;
    LinearLayout layoutFatura,layoutFaturaKurumsal,adresKaydet;
    RadioGroup faturaTip;

    ArrayAdapter<CharSequence> spinnerAdapter;

    EditText ad,soyad,telefon,acikadres,adresad,firmaad,firmavergidairesi,firmavergino;
    Spinner ulke,il,ilce;

    String adressAd,kullaniciid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_adress);

        //İnitialize
        adresKaydet=(LinearLayout) findViewById(R.id.save);
        layoutFatura=(LinearLayout) findViewById(R.id.layoutFatura);
        layoutFaturaKurumsal=(LinearLayout) findViewById(R.id.layoutFaturaKurumsal);
        faturaTip=(RadioGroup) findViewById(R.id.radioFaturaTip);

        //form
        ad=(EditText) findViewById(R.id.firstname);
        soyad=(EditText) findViewById(R.id.lastname);
        telefon=(EditText) findViewById(R.id.phone);
        acikadres=(EditText) findViewById(R.id.openAdressLine);
        adresad=(EditText) findViewById(R.id.adressName);
        firmaad=(EditText) findViewById(R.id.companyname);
        firmavergidairesi=(EditText)findViewById(R.id.companytaxname);
        firmavergino=(EditText) findViewById(R.id.companytaxnumber);

        ulke=(Spinner) findViewById(R.id.spinnerCountry);
        il=(Spinner) findViewById(R.id.spinnerCity);
        ilce=(Spinner) findViewById(R.id.spinnerDistrict);

        //Spinner Ayarla
        spinnerAdapter=ArrayAdapter.createFromResource(this,R.array.ulkeler,android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ulke.setAdapter(spinnerAdapter);
        spinnerAdapter=ArrayAdapter.createFromResource(this,R.array.iller,android.R.layout.simple_spinner_item);
        il.setAdapter(spinnerAdapter);
        ilce.setAdapter(spinnerAdapter);

        ///TOOLBAR
        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        TextView title=(TextView) toolbar.findViewById(R.id.eshop);
        title.setText("Adres Ekle");
        ImageView backButton=(ImageView) toolbar.findViewById(R.id.backImage);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        SharedPreferences prefs =getApplicationContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid = prefs.getString("id", "0");


        textTitle=(TextView) findViewById(R.id.textTitle);
        if(getIntent().getExtras()!=null){
            adressAd=getIntent().getExtras().getString("addressName");
            if(adressAd.equals("Fatura")){
                layoutFatura.setVisibility(View.VISIBLE);
            }
            textTitle.setText(getResources().getString(R.string.adressAdd,adressAd));
        }

        faturaTip.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.radioFaturaBireysel:
                        layoutFaturaKurumsal.setVisibility(View.GONE);
                        break;
                    case R.id.radioFaturaKurumsal:
                        layoutFaturaKurumsal.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        adresKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            new getData(addAdressActivity.this){
                @Override
                protected String doInBackground(String... params) {
                    InputStream is=null;
                    String line;
                    String login_url=params[0];
                    String ad=params[1];
                    String soyad=params[2];
                    String telefon=params[3];
                    String acikadres=params[4];
                    String ulke=params[5];
                    String il=params[6];
                    String ilce=params[7];
                    String adresad=params[8];
                    String firmaad=params[9];
                    String firmavergi=params[10];
                    String firmavergino=params[11];
                    String adrestip=params[12];
                    String kullaniciid=params[13];
                    try {
                        URL url=new URL(login_url);
                        HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();

                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream=httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                        String post_data= URLEncoder.encode("ad","UTF-8")+"="+URLEncoder.encode(ad,"UTF-8")+"&"+
                                URLEncoder.encode("soyad","UTF-8")+"="+URLEncoder.encode(soyad,"UTF-8")+"&"+
                                URLEncoder.encode("telefon","UTF-8")+"="+URLEncoder.encode(telefon,"UTF-8")+"&"+
                                URLEncoder.encode("acikadres","UTF-8")+"="+URLEncoder.encode(acikadres,"UTF-8")+"&"+
                                URLEncoder.encode("ulke","UTF-8")+"="+URLEncoder.encode(ulke,"UTF-8")+"&"+
                                URLEncoder.encode("il","UTF-8")+"="+URLEncoder.encode(il,"UTF-8")+"&"+
                                URLEncoder.encode("ilce","UTF-8")+"="+URLEncoder.encode(ilce,"UTF-8")+"&"+
                                URLEncoder.encode("adresad","UTF-8")+"="+URLEncoder.encode(adresad,"UTF-8")+"&"+
                                URLEncoder.encode("firmaad","UTF-8")+"="+URLEncoder.encode(firmaad,"UTF-8")+"&"+
                                URLEncoder.encode("firmavergi","UTF-8")+"="+URLEncoder.encode(firmavergi,"UTF-8")+"&"+
                                URLEncoder.encode("firmavergino","UTF-8")+"="+URLEncoder.encode(firmavergino,"UTF-8")+"&"+
                                URLEncoder.encode("adrestip","UTF-8")+"="+URLEncoder.encode(adrestip,"UTF-8")+"&"+
                                URLEncoder.encode("kullaniciid","UTF-8")+"="+URLEncoder.encode(kullaniciid,"UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();

                        is=new BufferedInputStream(httpURLConnection.getInputStream());

                        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
                        StringBuffer sb=new StringBuffer();

                        if(bufferedReader!=null)
                        {
                            while ((line=bufferedReader.readLine())!=null)
                            {
                                sb.append(line+"\n");
                            }
                        }else{
                            return  null;
                        }
                        return sb.toString();

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            if(is!=null){
                                is.close();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(String s) {
                    try {
                        JSONArray jsonArray=new JSONArray(s);
                        if(((JSONObject)jsonArray.get(0)).getString("status").equals("1"))
                        {
                            Toast.makeText(addAdressActivity.this, "Adres Başarıyla Kaydedildi...", Toast.LENGTH_SHORT).show();
                            activityGec();
                        }
                        else {
                            Toast.makeText(addAdressActivity.this, "Adres Kaydedilemedi...Lütfen Girdiğiniz Bilgileri Kontrol Ediniz!!!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    dialog.dismiss();
                    super.onPostExecute(s);
                }
            }.execute(MainActivity.server_url+"addAdress.php",ad.getText().toString(),soyad.getText().toString(),telefon.getText().toString(),acikadres.getText().toString(),ulke.getSelectedItem().toString(),il.getSelectedItem().toString(),ilce.getSelectedItem().toString(),adresad.getText().toString(),firmaad.getText().toString(),firmavergidairesi.getText().toString(),firmavergino.getText().toString(),adressAd,kullaniciid);
            }
        });

    }

    private void activityGec() {
        Intent gec=new Intent(addAdressActivity.this,MemberAdressActivity.class);
        startActivity(gec);
    }
}
