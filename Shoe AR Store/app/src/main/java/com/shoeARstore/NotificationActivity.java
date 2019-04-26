package com.shoeARstore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class NotificationActivity extends Fragment {

    private NotificationExpandableHeightListView listview;
    private ArrayList<BeanclassNotification>Bean;
    private BaseAdapterNotification baseAdapter;


    private String[] TITLE = {"Size Özel Erkek Ayakkabılarında %50 İndirim Fırsatını Kaçırmayın!!!",
            "Alışverişlerinizde Bizi Tercih Ettiğiniz İçin Teşekkür Ederiz...", "Türkiye'nin İlk AR Teknolojili Uygulaması olan Shoe AR Store'a Hoşgeldiniz!.!"};
    private String[] TIME = {"25 dakika önce", "1 saat önce", "2 gün önce"};


    public static NotificationActivity newInstance(){
        NotificationActivity fragment=new NotificationActivity();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_notification,container,false);

        listview = (NotificationExpandableHeightListView) view.findViewById(R.id.listview);


        Bean = new ArrayList<BeanclassNotification>();

        for (int i= 0; i< TITLE.length; i++){

            BeanclassNotification bean = new BeanclassNotification(TITLE[i], TIME[i]);
            Bean.add(bean);

        }

        baseAdapter = new BaseAdapterNotification(getActivity(), Bean) {
        };

        listview.setAdapter(baseAdapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        ********LISTVIEW***********



    }
}
