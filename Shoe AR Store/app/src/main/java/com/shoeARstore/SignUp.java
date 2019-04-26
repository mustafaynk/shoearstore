package com.shoeARstore;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import static com.shoeARstore.HomeFragment.MyPREFERENCES;
import static com.shoeARstore.HomeFragment.id;
import static com.shoeARstore.HomeFragment.name;


public class SignUp extends AppCompatActivity {
    TextView tSignin,tSignUp;
    EditText eFname,eLname,eMail,ePass;
    CheckBox cSozlesme;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        tSignin = (TextView) findViewById(R.id.signin);
        tSignUp=(TextView) findViewById(R.id.signin1);
        eFname=(EditText) findViewById(R.id.fname);
        eLname=(EditText) findViewById(R.id.lname);
        eMail=(EditText) findViewById(R.id.email1);
        ePass=(EditText) findViewById(R.id.password);
        cSozlesme=(CheckBox) findViewById(R.id.sozlesme);

        tSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(SignUp.this, SignIn.class);
                startActivity(it);
            }
        });

        tSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cSozlesme.isChecked()) {
                    final String fname = eFname.getText().toString();
                    final String lname = eLname.getText().toString();
                    String mail = eMail.getText().toString();
                    String pass = ePass.getText().toString();
                    if (isValidEmail(mail) != true) {
                        uyari("Mail Adresinizi Kontrol Ediniz!!!");
                    } else {
                        if (!(fname.equals("")) && !(lname.equals("")) && !(pass.equals(""))) {
                            new getData(SignUp.this) {
                                @Override
                                protected String doInBackground(String... params) {
                                    URL url;
                                    try {
                                        String post_data = null;
                                        String login_url = params[0];
                                        String name = params[1];
                                        String lname = params[2];
                                        String mail = params[3];
                                        String sifre = params[4];
                                        post_data = URLEncoder.encode("First_Name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                                                URLEncoder.encode("Last_Name", "UTF-8") + "=" + URLEncoder.encode(lname, "UTF-8") + "&" +
                                                URLEncoder.encode("E_Mail", "UTF-8") + "=" + URLEncoder.encode(mail, "UTF-8") + "&" +
                                                URLEncoder.encode("Password", "UTF-8") + "=" + URLEncoder.encode(sifre, "UTF-8");
                                        url = new URL(login_url);
                                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                        httpURLConnection.setRequestMethod("POST");
                                        httpURLConnection.setDoOutput(true);
                                        httpURLConnection.setDoInput(true);
                                        OutputStream outputStream = httpURLConnection.getOutputStream();
                                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                                        bufferedWriter.write(post_data);
                                        bufferedWriter.flush();
                                        bufferedWriter.close();
                                        outputStream.close();
                                        InputStream inStream = httpURLConnection.getInputStream();
                                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream, "iso-8859-9"));
                                        String result = "";
                                        String line;
                                        while ((line = bufferedReader.readLine()) != null) {
                                            result += line;
                                        }
                                        bufferedReader.close();
                                        inStream.close();
                                        httpURLConnection.disconnect();
                                        return result;
                                    } catch (MalformedURLException e) {
                                        e.printStackTrace();
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    } catch (ProtocolException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    return null;
                                }

                                @Override
                                protected void onPostExecute(String s) {
                                    if (s != null) {
                                        try {
                                            JSONArray jsonArray = new JSONArray(s);
                                            for (int i = 0; i < jsonArray.length(); i++) {
                                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                                if (jsonObject.getString("status").equals("1")) {
                                                    girisYap(fname + lname, jsonObject.getString("Id"));
                                                }
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                    dialog.dismiss();
                                    super.onPostExecute(s);
                                }
                            }.execute(MainActivity.server_url + "kullanicikaydi.php", fname, lname, mail, pass);
                        } else {
                            uyari("Lütfen Boş Alan Bırakmayınız!!!");
                        }
                    }
                }
                else{
                    Toast.makeText(SignUp.this, "Kullanım Sözleşmesini Kabul Ediniz!!!", Toast.LENGTH_SHORT).show();
                }
        }});

    }

    public void uyari(String alert){
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
        builder.setTitle("Hatalı İşlem");
        builder.setMessage(alert);
        builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
    SharedPreferences sharedPreferences;

    private void girisYap(String firstName, String gelenid) {
        sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(name,firstName);
        editor.putString(id,gelenid);
        editor.commit();
        Toast.makeText(this, "Kayıt Başarılı!!!", Toast.LENGTH_SHORT).show();
        Intent gec=new Intent(SignUp.this,HomeFragment.class);
        startActivity(gec);
    }
}
