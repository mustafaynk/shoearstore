package com.shoeARstore;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

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

public class getData extends AsyncTask<String,Void,String> {
    Context c;
    public Dialog dialog;

    public getData(Context c) {
        this.c = c;
    }


    @Override
    protected String doInBackground(String... params) {
        InputStream is=null;
        String line;
        String login_url=params[0];
        String tablo=params[1];
        String kosul=params[2];
        try {
            URL url=new URL(login_url);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String post_data= URLEncoder.encode("tabload","UTF-8")+"="+URLEncoder.encode(tablo,"UTF-8")+"&"+
                    URLEncoder.encode("kosul","UTF-8")+"="+URLEncoder.encode(kosul,"UTF-8");;
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
    protected void onPreExecute() {
        dialog=new Dialog(c);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.progress);
        ((TextView) dialog.findViewById(R.id.textview)).startAnimation(AnimationUtils.loadAnimation(c,android.R.anim.slide_in_left));
        dialog.show();
        super.onPreExecute();
    }



}
