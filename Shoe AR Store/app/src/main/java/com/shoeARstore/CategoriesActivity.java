package com.shoeARstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by User
 */

public class CategoriesActivity extends android.support.v4.app.Fragment {
    ListView subcategory,subsubcategory;
    Button onceki;
    ExpandableHeightGridView maincategories;
    ViewFlipper flipper;
    TextView kategoriadtext;
    String maincategoryid="yok",subcatid="yok",subsubcatid="yok",oncekikategoriad;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_categories,container,false);
        maincategories=(ExpandableHeightGridView) view.findViewById(R.id.maincategories);
        flipper=(ViewFlipper) view.findViewById(R.id.flipper);
        subcategory=(ListView) view.findViewById(R.id.subcategories);
        subsubcategory=(ListView) view.findViewById(R.id.subsubcategories);
        kategoriadtext=(TextView) view.findViewById(R.id.kategoriadi);
        onceki=(Button) view.findViewById(R.id.buttononceki);




        maincategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onceki.setVisibility(View.VISIBLE);
                TextView categoryid=(TextView) view.findViewById(R.id.categoryid);
                TextView categoryname=(TextView) view.findViewById(R.id.categoryname);
                maincategoryid=categoryid.getText().toString();
                oncekikategoriad=kategoriadtext.getText().toString();
                kategoriadtext.setText("Tüm "+categoryname.getText().toString()+" Ürünleri");
                subKategoriCek(subcategory,categoryid.getText().toString());
                flipper.showNext();
            }
        });
        subcategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView subcategoryid=(TextView) view.findViewById(R.id.categoryid);
                TextView categoryname=(TextView) view.findViewById(R.id.categoryname);
                subcatid=subcategoryid.getText().toString();
                oncekikategoriad=kategoriadtext.getText().toString();
                kategoriadtext.setText("Tüm "+categoryname.getText().toString()+" Ürünleri");
                subsubKategoriCek(subsubcategory,subcatid);
                flipper.showNext();
            }
        });
        subsubcategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView subsubcategoryid=(TextView) view.findViewById(R.id.categoryid);
                subsubcatid=subsubcategoryid.getText().toString();
                Intent gec=new Intent(getActivity(),ProductListActivity.class);
                gec.putExtra("categoryid",maincategoryid+"-"+subcatid+"-"+subsubcatid);
                startActivity(gec);
            }
        });

        onceki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flipper.getDisplayedChild()>0) {
                    if(!subsubcatid.equals("yok")){
                        subsubcatid="yok";
                        if(flipper.getDisplayedChild()==2){
                            subcatid="yok";
                        }
                    }else if(!subcatid.equals("yok")){
                        subcatid="yok";
                    }else if(!maincategoryid.equals("yok")){
                        maincategoryid="yok";
                    }
                    flipper.showPrevious();
                    kategoriadtext.setText(oncekikategoriad);
                }
                if(flipper.getDisplayedChild()==0){
                    kategoriadtext.setText("Tüm Ürünler");
                    onceki.setVisibility(View.INVISIBLE);
                    maincategoryid="yok";
                }
            }
        });

        kategoriadtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gec=new Intent(getActivity(),ProductListActivity.class);
                gec.putExtra("categoryid",maincategoryid+"-"+subcatid+"-"+subsubcatid);
                startActivity(gec);
            }
        });

        mainCategoryCek(maincategories);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void subsubKategoriCek(final ListView subsubcategory, String subcategoryid) {
        new getData(getActivity()){
            @Override
            protected void onPostExecute(String s) {
                dialog.dismiss();
                if(s!=null){
                    try {
                        JSONArray jsonArray=new JSONArray(s);
                        String[] categoryname=new String[jsonArray.length()];
                        String[] categoryid=new String[jsonArray.length()];
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            categoryname[i]=jsonObject.getString("SubSubCategoryName");
                            categoryid[i]=jsonObject.getString("Id");
                        }
                        SubCategoryAdapter adapter=new SubCategoryAdapter(getActivity(),categoryname,categoryid);
                        subsubcategory.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                super.onPostExecute(s);
            }
        }.execute(MainActivity.server_url+"getir.php","subsubcategory",subcategoryid);
    }

    private void subKategoriCek(final ListView subcategory, String maincategoryid) {
        new getData(getActivity()){
            @Override
            protected void onPostExecute(String s) {
                dialog.dismiss();
                if(s!=null){
                    try {

                        JSONArray jsonArray=new JSONArray(s);
                        String[] categoryname=new String[jsonArray.length()];
                        String[] categoryid=new String[jsonArray.length()];
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            categoryname[i]=jsonObject.getString("SubCategoryName");
                            categoryid[i]=jsonObject.getString("Id");
                        }
                        SubCategoryAdapter adapter=new SubCategoryAdapter(getActivity(),categoryname,categoryid);
                        subcategory.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                super.onPostExecute(s);
            }
        }.execute(MainActivity.server_url+"getir.php","subcategory",maincategoryid);
    }


    private void mainCategoryCek(final ExpandableHeightGridView maincategories) {
        new getData(getActivity()){
            @Override
            protected void onPostExecute(String s) {
                if(s!=null){
                    try {
                        ArrayList<String> categoryname=new ArrayList<>();
                        ArrayList<String> categoryid=new ArrayList<>();
                        ArrayList<String> categoryimagepath=new ArrayList<>();
                        JSONArray jsonArray=new JSONArray(s);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            categoryname.add(jsonObject.getString("CategoryName"));
                            categoryid.add(jsonObject.getString("Id"));
                            categoryimagepath.add(jsonObject.getString("ImagePath").replace("\\", "/"));
                        }
                        GridMainCategoryList baseAdapter=new GridMainCategoryList(getActivity(),categoryname,categoryid,categoryimagepath);
                        maincategories.setAdapter(baseAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(MainActivity.server_url+"getir.php","maincategory","yok");

    }

    public static CategoriesActivity newInstance(){
        CategoriesActivity fragment=new CategoriesActivity();
        return fragment;
    }
}
