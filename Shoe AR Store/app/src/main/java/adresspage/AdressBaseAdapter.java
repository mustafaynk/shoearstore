package adresspage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.shoeARstore.MainActivity;
import com.shoeARstore.R;
import com.shoeARstore.getData;

import java.util.ArrayList;

/**
 * Slide And Drag
 */

public class AdressBaseAdapter extends BaseAdapter {

    ArrayList<AdressBeanlist> Bean;
    Context context;

    String kullaniciid;

    public AdressBaseAdapter(ArrayList<AdressBeanlist> bean, Context context) {
        Bean = bean;
        this.context = context;
    }


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
        final CustomViewHolder cvh;
        if (convertView == null) {
            cvh = new CustomViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_adress_page, null);
            cvh.txtId=(TextView) convertView.findViewById(R.id.icerikId);
            cvh.txtTitle=(TextView) convertView.findViewById(R.id.title);
            cvh.txtIcerik=(TextView) convertView.findViewById(R.id.icerik);
            cvh.txtDelete=(TextView) convertView.findViewById(R.id.delete);
            convertView.setTag(cvh);
        } else {
            cvh = (CustomViewHolder) convertView.getTag();
        }

        SharedPreferences prefs =context.getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid = prefs.getString("id", "0");
        AdressBeanlist beanlist=(AdressBeanlist) getItem(position);
        cvh.txtId.setText(beanlist.getId());
        cvh.txtTitle.setText(beanlist.getAdressname());
        cvh.txtDelete.setTag(beanlist.getAdressType());
        if(beanlist.getAdressType().equals("Teslimat")){
            cvh.txtIcerik.setText("Ad-Soyad:"+beanlist.getName()+" "+beanlist.getSurname()+"\n"+
                    "Telefon:"+beanlist.getTelephone()+"\n"+
                    "Ülke-İl-İlçe:"+beanlist.getCountry()+"/"+beanlist.getCity()+"/"+beanlist.getDistrict()+"\n"+
                    "Açık Adres:"+beanlist.getOpenadress());
        }else{
            cvh.txtIcerik.setText("Ad-Soyad:"+beanlist.getName()+" "+beanlist.getSurname()+"\n"+
                    "Telefon:"+beanlist.getTelephone()+"\n"+
                    "Ülke-İl-İlçe:"+beanlist.getCountry()+"/"+beanlist.getCity()+"/"+beanlist.getDistrict()+"\n"+
                    "Açık Adres:"+beanlist.getOpenadress()+"\n"+
                    "Firma Bilgileri\nFirma Adı:"+beanlist.getCompanyname()+"\n"+
                    "Vergi Dairesi:"+beanlist.getCompanytaxname()+"\n"+
                    "Vergi Numarası:"+beanlist.getCompanytaxnumber());
        }




        cvh.txtDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getData(context){
                    @Override
                    protected void onPostExecute(String s) {
                        if(s!=null || !(s.equals(""))){
                            Toast.makeText(context, "Adres Başarıyla Silindi...", Toast.LENGTH_SHORT).show();
                        }
                        Intent gec=new Intent(context,MemberAdressActivity.class);
                        context.startActivity(gec);
                        dialog.dismiss();
                        super.onPostExecute(s);
                    }
                }.execute(MainActivity.server_url+"adress.php","sil",kullaniciid+"-"+cvh.txtId.getText().toString()+","+cvh.txtDelete.getTag());
            }
        });
        return convertView;
    }



    class CustomViewHolder {
        public TextView txtIcerik;
        public TextView txtTitle;
        public TextView txtId;
        public TextView txtDelete;

    }
}
