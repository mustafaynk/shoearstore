package favoritespage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.shoeARstore.HomeFragment;
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
import java.util.ArrayList;

import favoritespage.items.Menu;
import favoritespage.items.MenuItem;
import favoritespage.items.SlideAndDragListView;


/**
 * Slide And Drag
 */
public class FavoritesActivity extends android.support.v4.app.Fragment implements AdapterView.OnItemLongClickListener,
        AdapterView.OnItemClickListener, AbsListView.OnScrollListener,
        SlideAndDragListView.OnDragDropListener, SlideAndDragListView.OnSlideListener,
        SlideAndDragListView.OnMenuItemClickListener, SlideAndDragListView.OnItemDeleteListener,
        SlideAndDragListView.OnItemScrollBackListener {
    private static final String TAG = FavoritesActivity.class.getSimpleName();
    SharedPreferences prefs;
    String kullaniciid;
    private String ekleStockCode;

    private TextView favtext;
    private Menu mMenu;
    private ArrayList<FavBeanlist> Bean=new ArrayList<>();
    private SlideAndDragListView mListView;
    private Toast mToast;
    private FavBeanlist mDraggedEntity;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_sdlv,container,false);
        favtext=(TextView) view.findViewById(R.id.textfav);
        mListView = (SlideAndDragListView) view.findViewById(R.id.lv_edit);
        initData();
        initMenu();
        initUiAndListener();
        mToast = Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT);
        return view;
    }

    public static FavoritesActivity newInstance(){
        FavoritesActivity fragment=new FavoritesActivity();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void initData() {

        prefs =getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid=prefs.getString("id","0");
        if(!kullaniciid.equals("0"))
        {
            new getData(getActivity()){
                @Override
                protected void onPostExecute(String s) {
                    if(!s.equals("")){
                        try {
                            ArrayList<String> image=new ArrayList<>();
                            ArrayList<String> title=new ArrayList<>();
                            ArrayList<String> stockcode=new ArrayList<>();
                            ArrayList<String> price=new ArrayList<>();

                            JSONArray jsonArray=new JSONArray(s);
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                image.add(jsonObject.getString("Resim"));
                                title.add(jsonObject.getString("ProductName"));
                                stockcode.add(jsonObject.getString("StockCode"));
                                if(jsonObject.getString("LastPrice").equals("0")) price.add(jsonObject.getString("FirstPrice"));
                                else price.add(jsonObject.getString("LastPrice"));
                            }
                            adapterGonder(image,title,price,stockcode);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        favtext.setText(R.string.favNotItemText);
                        favtext.setVisibility(View.VISIBLE);
                        mListView.setVisibility(View.INVISIBLE);
                    }
                    dialog.dismiss();
                    super.onPostExecute(s);
                }
            }.execute(MainActivity.server_url+"wishlist.php",kullaniciid,"yok");
        }
        else{
            Toast.makeText(getActivity(), "Lütfen Giriş Yapınız!!!", Toast.LENGTH_SHORT).show();
            favtext.setVisibility(View.VISIBLE);
            mListView.setVisibility(View.INVISIBLE);
            favtext.setText(R.string.favNotMemberText);
        }


    }

    private void adapterGonder(ArrayList<String> image, ArrayList<String> title, ArrayList<String> price, ArrayList<String> stockcode) {
        for(int i=0;i<image.size();i++){
            FavBeanlist beanlist=new FavBeanlist(image.get(i),title.get(i),stockcode.get(i),price.get(i));
            Bean.add(beanlist);
        }
        mAdapter=new FavBaseAdapter(Bean,getActivity());

        mListView.setAdapter(mAdapter);
        wishlistControl(image.size());

    }

    private void wishlistControl(int size) {
        if (size>0){
            favtext.setVisibility(View.GONE);
            mListView.setVisibility(View.VISIBLE);
        }else{
            favtext.setText(R.string.favNotItemText);
            favtext.setVisibility(View.VISIBLE);
            mListView.setVisibility(View.INVISIBLE);
        }
    }

    public void initMenu() {
        mMenu = new Menu(true);
        mMenu.addItem(new MenuItem.Builder().setWidth(100)
                .setBackground(Utils.getDrawable(getActivity(), R.color.strok))
                .setIcon(getResources().getDrawable(R.drawable.bag1))
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .build());
        mMenu.addItem(new MenuItem.Builder().setWidth(100)
                .setBackground(Utils.getDrawable(getActivity(), R.color.strok2))
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setIcon(getResources().getDrawable(R.drawable.ic_delete))
                .build());
    }

    public void initUiAndListener() {

        mListView.setMenu(mMenu);
        mListView.setOnScrollListener(this);
        mListView.setOnDragDropListener(this);
        mListView.setOnItemClickListener(this);
        mListView.setOnSlideListener(this);
        mListView.setOnMenuItemClickListener(this);
        mListView.setOnItemDeleteListener(this);
        //mListView.setOnItemLongClickListener(this);
        mListView.setOnItemScrollBackListener(this);
    }

    private FavBaseAdapter mAdapter;
    /*private BaseAdapter mAdapter = new BaseAdapter() {

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
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.item_custom_btn, null);
                cvh.imgLogo = (ImageView) convertView.findViewById(R.id.image);
                cvh.txtName = (TextView) convertView.findViewById(R.id.title);
                cvh.txtPrice=(TextView) convertView.findViewById(R.id.price);
                cvh.txtId=(TextView) convertView.findViewById(R.id.id);
                convertView.setTag(cvh);
            } else {
                cvh = (CustomViewHolder) convertView.getTag();
            }
            FavBeanlist beanlist=(FavBeanlist) getItem(position);
            Picasso.with(getActivity()).load(MainActivity.server_url+beanlist.getImage());
            cvh.txtName.setText(beanlist.getTitle());
            cvh.txtPrice.setText(beanlist.getPrice());
            cvh.txtId.setText(beanlist.getId());
            return convertView;
        }
        class CustomViewHolder {
            public ImageView imgLogo;
            public TextView txtName;
            public TextView txtPrice;
            public TextView txtId;
        }
    };*/
    @Override
    public void onDragViewStart(int beginPosition) {
        mDraggedEntity=(FavBeanlist) mAdapter.getItem(beginPosition);
    }

    @Override
    public void onDragDropViewMoved(int fromPosition, int toPosition) {
        FavBeanlist silinen=mAdapter.deleteItem(fromPosition);
        mAdapter.addItem(toPosition,silinen);
    }

    @Override
    public void onDragViewDown(int finalPosition) {
        mAdapter.setItem(finalPosition,mDraggedEntity);
    }

    @Override
    public void onSlideOpen(View view, View parentView, int position, int direction) {
        ekleStockCode=((TextView) view.findViewById(R.id.stockcode)).getText().toString();
    }

    @Override
    public void onSlideClose(View view, View parentView, int position, int direction) {
    }

    @Override
    public int onMenuItemClick(View v, int itemPosition, int buttonPosition, int direction) {
        switch (direction) {
            case MenuItem.DIRECTION_RIGHT:
                switch (buttonPosition) {
                    case 0:
                        Dialog dialog=new Dialog(getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_OPTIONS_PANEL);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.setContentView(R.layout.add_cart_favlist);
                        final Spinner numaralarSpinner=(Spinner) dialog.findViewById(R.id.numaralar);
                        Button ekle=(Button) dialog.findViewById(R.id.sepetekle);
                        new getData(getActivity()){
                            @Override
                            protected void onPostExecute(String s) {
                                if(s!=null){
                                    try {
                                        JSONArray jsonArray=new JSONArray(s);
                                        ArrayList<String> numara=new ArrayList<>();
                                        for(int i=0;i<jsonArray.length();i++){
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                                            String numbers = jsonObject.getString("ProductOptions");
                                            for (String number : numbers.split("/")) {
                                                String[] numaralar=number.split("=");
                                                if(!(numaralar[1].equals("0"))){
                                                    String n=numaralar[0].replace("Numara","").replace("_",",");
                                                    numara.add(n);
                                                }
                                            }
                                        }

                                        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,numara);
                                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        numaralarSpinner.setAdapter(adapter);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                dialog.dismiss();
                                super.onPostExecute(s);
                            }
                        }.execute(MainActivity.server_url+"getir.php","NumaraGetir",ekleStockCode);
                        dialog.show();
                        ekle.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(!numaralarSpinner.getSelectedItem().toString().equals("") && !kullaniciid.equals("0")) {
                                    new getData(getActivity()) {
                                        @Override
                                        protected String doInBackground(String... params) {
                                            String login_url = params[0];
                                            String kullaniciid = params[1];
                                            String stockcode = params[2];
                                            String piece = params[3];
                                            String size = params[4];
                                            String islem = params[5];
                                            InputStream is = null;
                                            String line;
                                            try {
                                                URL url = new URL(login_url);
                                                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                                                httpURLConnection.setRequestMethod("POST");
                                                httpURLConnection.setDoOutput(true);
                                                httpURLConnection.setDoInput(true);
                                                OutputStream outputStream = httpURLConnection.getOutputStream();
                                                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                                                String post_data = URLEncoder.encode("tabload", "UTF-8") + "=" + URLEncoder.encode(kullaniciid, "UTF-8") + "&" +
                                                        URLEncoder.encode("stockcode", "UTF-8") + "=" + URLEncoder.encode(stockcode, "UTF-8") + "&" +
                                                        URLEncoder.encode("piece", "UTF-8") + "=" + URLEncoder.encode(piece, "UTF-8") + "&" +
                                                        URLEncoder.encode("size", "UTF-8") + "=" + URLEncoder.encode(size, "UTF-8") + "&" +
                                                        URLEncoder.encode("kosul", "UTF-8") + "=" + URLEncoder.encode(islem, "UTF-8");
                                                bufferedWriter.write(post_data);
                                                bufferedWriter.flush();
                                                bufferedWriter.close();
                                                outputStream.close();

                                                is = new BufferedInputStream(httpURLConnection.getInputStream());

                                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                                                StringBuffer sb = new StringBuffer();

                                                if (bufferedReader != null) {
                                                    while ((line = bufferedReader.readLine()) != null) {
                                                        sb.append(line + "\n");
                                                    }
                                                } else {
                                                    return null;
                                                }
                                                return sb.toString();

                                            } catch (MalformedURLException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            } finally {
                                                try {
                                                    if (is != null) {
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
                                            if (!s.equals("") && s != null) {
                                                Toast.makeText(getActivity(), "Ürün Başarıyla Sepete Eklendi...", Toast.LENGTH_SHORT).show();
                                                Intent gec = new Intent(getActivity(), HomeFragment.class);
                                                gec.putExtra("fragment", "4");
                                                startActivity(gec);
                                            } else {
                                                Toast.makeText(getActivity(), "Ürün Sepete Eklenemedi!!!", Toast.LENGTH_SHORT).show();
                                            }
                                            dialog.dismiss();
                                            super.onPostExecute(s);
                                        }
                                    }.execute(MainActivity.server_url + "cartlist.php", kullaniciid, ekleStockCode, "1", numaralarSpinner.getSelectedItem().toString(), "add");
                                }
                            }
                        });
                        return Menu.ITEM_SCROLL_BACK;
                    case 1:

                        return Menu.ITEM_DELETE_FROM_BOTTOM_TO_TOP;
                }
        }
        return Menu.ITEM_NOTHING;
    }

    @Override
    public void onItemDeleteAnimationFinished(View view, int position) {
        final int pos=position;
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Favori Listemden Çıkar...");
        builder.setMessage("Ürün Favori Listesinden Çıkarılsın Mı?");
        builder.setCancelable(false);
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String stockcode=((FavBeanlist)mAdapter.getItem(pos)).getStockcode();
                mAdapter.deleteItem(pos);
                //silme kısmı
                new getData(getActivity()){
                    @Override
                    protected void onPostExecute(String s) {
                        if (!s.equals("")) {
                            Toast.makeText(getActivity(), "Ürün Başarıyla Favorilerden Çıkarıldı...", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "Ürün Favorilerden Çıkarılamadı...", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                        super.onPostExecute(s);
                    }
                }.execute(MainActivity.server_url+"favorites.php",kullaniciid,stockcode+"-delete");
                wishlistControl(mAdapter.getCount());
            }
        });
        builder.setNegativeButton("Vazgeç", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog olustur=builder.create();
        olustur.show();

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                break;
            case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                break;
            case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        toast("onItemLongClick   position--->" + position);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onScrollBackAnimationFinished(View view, int position) {
    }

    private void toast(String toast) {
        mToast.setText(toast);
        mToast.show();
    }
}
