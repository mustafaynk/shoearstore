package com.shoeARstore;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SignIn extends AppCompatActivity {


TextView tSignup,tSignin,tForgotPass;
    EditText eMail,ePass;
    CheckBox cRemember;

    public static final String MyPREFERENCES="login";
    public static final String name="name";
    public static final String id="id";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        //tanımlamalar
        tSignup = (TextView)findViewById(R.id.signup);
        tSignin=(TextView) findViewById(R.id.signin1);
        tForgotPass=(TextView) findViewById(R.id.forgotpass);
        eMail=(EditText)findViewById(R.id.email);
        ePass=(EditText) findViewById(R.id.password);
        cRemember=(CheckBox) findViewById(R.id.checkboxremember);

        tSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(SignIn.this, SignUp.class);
                startActivity(it);

            }
        });

        tSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=eMail.getText().toString();
                String pass=ePass.getText().toString();
                new getData(SignIn.this){
                    @Override
                    protected void onPostExecute(String s) {
                        if(s!=null || !(s.equals("null"))){
                            try {
                                JSONArray jsonArray=new JSONArray(s);
                                for (int i=0;i<jsonArray.length();i++){
                                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                                    if(!(jsonObject.getString("Id").equals("-1"))) {
                                        girisYap(jsonObject.getString("FirstName") + " " + jsonObject.getString("LastName"), jsonObject.getString("Id"));
                                    }else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(SignIn.this);
                                        builder.setTitle("Hatalı Giriş");
                                        builder.setMessage("Lütfen Bilgilerinizi Kontrol Ediniz!!!");
                                        builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.dismiss();
                                            }
                                        });
                                        builder.show();
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        dialog.dismiss();
                        super.onPostExecute(s);
                    }
                }.execute(MainActivity.server_url+"giris.php",mail,pass);
                eMail.setText("");
                ePass.setText("");
            }
        });

        tForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(SignIn.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setContentView(R.layout.sifremiunuttum);
                dialog.show();
                final EditText mail=(EditText) dialog.findViewById(R.id.forgotpassmail);
                TextView onay=(TextView) dialog.findViewById(R.id.forgotpasssend);
                onay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SignUp emailKontrol=new SignUp();
                    if(emailKontrol.isValidEmail(mail.getText().toString())){

                    }else{
                        Toast.makeText(SignIn.this, "Lütfen Geçerli Bir E-Mail Adresi Giriniz!!!", Toast.LENGTH_SHORT).show();
                    }
                    }
                });
            }
        });
    }

    private void girisYap(String firstName, String gelenid) {
        sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(name,firstName);
        editor.putString(id,gelenid);
        editor.commit();
        Toast.makeText(this, "Giriş Başarılı Bir Şekilde Gerçekleştirildi!!!", Toast.LENGTH_SHORT).show();
        Intent gec=new Intent(SignIn.this,HomeFragment.class);
        startActivity(gec);
    }
}
