package yorumlarsayfasi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.shoeARstore.MainActivity;
import com.shoeARstore.R;
import com.shoeARstore.getData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class YorumlarActivity extends AppCompatActivity {

    private ExpandableHeightListView listview;
    private ArrayList<BeanclassReview> Bean;
    private BaseAdapterReview baseAdapter;

    private Spinner sirala;

    private String kullaniciid,stockcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        SharedPreferences prefs =getApplicationContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid=prefs.getString("id","0");

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ImageView backButton=(ImageView) toolbar.findViewById(R.id.backImage);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listview = (ExpandableHeightListView)findViewById(R.id.listview);
        sirala=(Spinner) findViewById(R.id.sirala);

        FloatingActionButton addComment=(FloatingActionButton) findViewById(R.id.fab);
        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!kullaniciid.equals("0")){
                    if(stockcode!=null){
                        Intent gec=new Intent(YorumlarActivity.this,AddCommentActivity.class);
                        gec.putExtra("stockcode",stockcode);
                        startActivity(gec);
                    }
                }else{
                    Toast.makeText(YorumlarActivity.this, "Yorum Yapmak İçin Giriş Yapınız!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });



        final ArrayAdapter<String> siralaAdapter=new ArrayAdapter<String>(YorumlarActivity.this,R.layout.siralaitemlayout,Arrays.asList(getResources().getStringArray(R.array.siraliitemcomment))){
            @Override
            public boolean isEnabled(int position) {
                if(position==0){
                return false;
                }else{
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view=super.getDropDownView(position, convertView, parent);
                TextView tv=(TextView) view;
                if(position==0){
                    tv.setTextColor(Color.GRAY);
                }else{
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        siralaAdapter.setDropDownViewResource(R.layout.siralaitemlayout);
        sirala.setAdapter(siralaAdapter);

        sirala.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected=(String) parent.getItemAtPosition(position);
                if(selected.equals("Değerlendirmeye Göre")){
                     adapterSirala("rate");
                }else if ((selected.equals("Tarihe Göre"))){
                    adapterSirala("tarih");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Bean = new ArrayList<BeanclassReview>();

        //        ********LISTVIEW***********
    if(getIntent().getExtras()!=null){
        stockcode=getIntent().getExtras().getString("stockcode");
        new getData(YorumlarActivity.this){
            @Override
            protected void onPostExecute(String s) {
                if(s!=null){
                    try {
                       ArrayList<String> Rate=new ArrayList<>();
                        ArrayList<String> Date=new ArrayList<>();
                        ArrayList<String> UserName=new ArrayList<>();
                        ArrayList<String> Description=new ArrayList<>();
                        JSONArray jsonArray=new JSONArray(s);
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            if(i<jsonArray.length()-1) {//Yorumlar
                                Rate.add(jsonObject.getString("Points"));
                                Date.add(jsonObject.getString("CommentDate"));
                                Description.add(jsonObject.getString("Review"));
                            }if (i==jsonArray.length()-1){
                                for (String name:jsonObject.getString("Name").split(",")){
                                    UserName.add(name);
                                }
                            }
                        }
                        gonder(Rate,Date,Description,UserName);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(MainActivity.server_url+"comments.php","comments",stockcode);
    }




    }
    Comparator<BeanclassReview> sortByRate = new Comparator<BeanclassReview>() {
        @Override
        public int compare(BeanclassReview lhs, BeanclassReview rhs) {
            Float rate1=Float.parseFloat(lhs.getRateno().substring(0,lhs.getRateno().indexOf("/")));
            Float rate2=Float.parseFloat(rhs.getRateno().substring(0,rhs.getRateno().indexOf("/")));
            if(rate1>=rate2){
                return degistir(lhs,rhs);
            }
            return -1;
        }
    };
    Comparator<BeanclassReview> sortByDate = new Comparator<BeanclassReview>() {
        @Override
        public int compare(BeanclassReview lhs, BeanclassReview rhs) {
            String tarih1=lhs.getDate();
            String tarih2=rhs.getDate();
            Calendar date1=new GregorianCalendar();
            date1.set(Integer.parseInt(tarih1.split("-")[0]),Integer.parseInt(tarih1.split("-")[1]),Integer.parseInt(tarih1.split("-")[2]));
            Calendar date2=new GregorianCalendar();
            date2.set(Integer.parseInt(tarih2.split("-")[0]),Integer.parseInt(tarih2.split("-")[1]),Integer.parseInt(tarih2.split("-")[2]));

            if(date1.getTimeInMillis()<date2.getTimeInMillis()){
                return degistir(lhs,rhs);
            }
            return -1;
        }
    };
    private int degistir(BeanclassReview lhs, BeanclassReview rhs) {
        //Güncelleme 1
        lhs.getTitle().compareTo (rhs.getTitle());
        lhs.getRateno().compareTo (rhs.getRateno());
        lhs.getDate().compareTo (rhs.getDate());
        lhs.getUsername().compareTo (rhs.getUsername());
        lhs.getLike().compareTo (rhs.getLike());
        return 1;
    }


    private void adapterSirala(String kosul) {
        if(kosul.equals("rate")){
            Collections.sort(Bean,sortByRate);

        }else if (kosul.equals("tarih")){
            Collections.sort(Bean,sortByDate);
        }
        baseAdapter = new BaseAdapterReview(YorumlarActivity.this, Bean) {
        };
        baseAdapter.notifyDataSetChanged();
        listview.setAdapter(baseAdapter);
    }

    private void gonder(ArrayList<String> rate, ArrayList<String> date, ArrayList<String> description, ArrayList<String> userName) {
        Bean=new ArrayList<BeanclassReview>();
        for(int i=0;i<rate.size();i++){
            BeanclassReview bean=new BeanclassReview("Güzel",rate.get(i)+"/5",date.get(i),userName.get(i),description.get(i),"12");
            Bean.add(bean);

        }
        baseAdapter = new BaseAdapterReview(YorumlarActivity.this, Bean) {
        };
        listview.setAdapter(baseAdapter);
    }
}