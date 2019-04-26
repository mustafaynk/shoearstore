package com.shoeARstore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import adresspage.MemberAdressActivity;
import favoritespage.FavoritesActivity;
import orderspage.OrderActivity;

/**
 * Created by User
 */

public class HomeFragment extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView home,offer,fav,bag,noti;
    LinearLayout home0,offer0,fav0,bag0,noti0;
    NavigationView navigationView;
    TextView categories,helppage,cartcount,kullaniciadi;
    LinearLayout findstore,logout,orders,adress;
    DrawerLayout drawer;
    Fragment selectedFragment;


    public static final String MyPREFERENCES="login";
    public static final String name="name";
    public static final String id="id";
    String kullaniciid;
    SharedPreferences sharedPreferences;

    @Override
    protected void onResume() {
        sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences prefs =getApplicationContext().getSharedPreferences("login",Context.MODE_PRIVATE);
        kullaniciid=prefs.getString(id,"-1");
        if(!(kullaniciid.equals("-1"))){
                logout.setVisibility(View.VISIBLE);
                String welcomeText=getResources().getString(R.string.welcometext,prefs.getString(name,"NoName"));
                kullaniciadi.setText(welcomeText);
        }else {
            logout.setVisibility(View.GONE);
        }
        super.onResume();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationdrawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        SharedPreferences prefs =getApplicationContext().getSharedPreferences("login",Context.MODE_PRIVATE);
        kullaniciid=prefs.getString(id,"-1");


        //                 ********Sol Açılır Menü********
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final View navigation=navigationView.getHeaderView(0);
        categories=(TextView) navigation.findViewById(R.id.categories);
        kullaniciadi=(TextView) navigation.findViewById(R.id.name);

        kullaniciadi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs =getApplicationContext().getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);
                if(prefs.getString(id,"-1").equals("-1")){
                    Intent gec=new Intent(HomeFragment.this,SignIn.class);
                    startActivity(gec);
                }
            }
        });
        helppage=(TextView) navigation.findViewById(R.id.helpmenu);
        helppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gec=new Intent(HomeFragment.this,HelpApplication.class);
                startActivity(gec);
            }
        });
        findstore=(LinearLayout) navigation.findViewById(R.id.findstore);
        findstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                Intent gec=new Intent(HomeFragment.this,FindStoreActivity.class);
                startActivity(gec);
            }
        });

        logout=(LinearLayout) navigation.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                cartcount.setText("0");
                logout.setVisibility(View.GONE);
                kullaniciadi.setText(R.string.giristext);
                clickb("1");
            }
        });
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                clickb("2");
            }
        });
        orders=(LinearLayout) navigation.findViewById(R.id.siparisler);
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                if(kullaniciid.equals("-1")){
                    Toast.makeText(HomeFragment.this, "Lütfen Giriş Yapınız!!!", Toast.LENGTH_SHORT).show();
                }else {
                    Intent gec=new Intent(HomeFragment.this, OrderActivity.class);
                    startActivity(gec);
                }
            }
        });
        adress=(LinearLayout) navigation.findViewById(R.id.adress);
        adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                if(kullaniciid.equals("-1")){
                    Toast.makeText(HomeFragment.this, "Lütfen Giriş Yapınız!!!", Toast.LENGTH_SHORT).show();
                }else {
                    Intent gec = new Intent(HomeFragment.this, MemberAdressActivity.class);
                    startActivity(gec);
                }
            }
        });

        home = (ImageView) findViewById(R.id.home);
        home0 = (LinearLayout) findViewById(R.id.home0);
        offer = (ImageView) findViewById(R.id.offer);
        offer0 = (LinearLayout) findViewById(R.id.offer0);
        fav = (ImageView) findViewById(R.id.fav);
        fav0 = (LinearLayout) findViewById(R.id.fav0);
        bag = (ImageView) findViewById(R.id.bag);
        bag0 = (LinearLayout) findViewById(R.id.bag0);
        noti = (ImageView) findViewById(R.id.noti);
        noti0 = (LinearLayout) findViewById(R.id.noti0);
        cartcount=(TextView) findViewById(R.id.cartcount);

        cartlistCount();

        home0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    clickb("1");


            }
        });
        offer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    clickb("2");


            }
        });
        fav0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    clickb("3");
            }
        });
        bag0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    clickb("4");
            }
        });
        noti0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    clickb("5");
            }
        });
        if(getIntent().getExtras()!=null){
            clickb(getIntent().getExtras().getString("fragment","1"));
            return;
        }
        clickb("1");
    }

    private void cartlistCount() {
        if(!kullaniciid.equals("-1")){
        new getData(HomeFragment.this){
            @Override
            protected void onPostExecute(String s) {
                if(s!=null){
                    cartcount.setText(s);
                }
                dialog.dismiss();
                super.onPostExecute(s);
            }
        }.execute(MainActivity.server_url+"cartlist.php",kullaniciid,"count");
        }else {
            cartcount.setText("0");
        }
    }

    private void clickb(String s) {
        home.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        offer.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        fav.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        bag.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        noti.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);


        if(s.equalsIgnoreCase("1")) {
            selectedFragment=MainActivity.newInstance();
            home.setColorFilter(getResources().getColor(R.color.boticoncolor), android.graphics.PorterDuff.Mode.MULTIPLY);
        }


        else if(s.equalsIgnoreCase("2")) {
            selectedFragment=CategoriesActivity.newInstance();
            offer.setColorFilter(getResources().getColor(R.color.boticoncolor), android.graphics.PorterDuff.Mode.MULTIPLY);
        }
        else if(s.equalsIgnoreCase("3")) {
            fav.setColorFilter(getResources().getColor(R.color.boticoncolor), android.graphics.PorterDuff.Mode.MULTIPLY);
            selectedFragment=FavoritesActivity.newInstance();
        }
        else if(s.equalsIgnoreCase("4")) {
            selectedFragment=CartListActivity.newInstance();
            bag.setColorFilter(getResources().getColor(R.color.boticoncolor), android.graphics.PorterDuff.Mode.MULTIPLY);

        }
        else if(s.equalsIgnoreCase("5")) {
            selectedFragment=NotificationActivity.newInstance();
            noti.setColorFilter(getResources().getColor(R.color.boticoncolor), android.graphics.PorterDuff.Mode.MULTIPLY);

        }
        if (selectedFragment!=null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content, selectedFragment);
            transaction.commit();
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        return false;
    }
}
