package com.shoeARstore;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FindStoreActivity extends FragmentActivity implements GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener, LocationListener, OnMapReadyCallback {

    private GoogleMap mMap;
    Spinner iller;
    LatLng Turkey;
    ListView magazalardetay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_store);

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        TextView title=(TextView) toolbar.findViewById(R.id.eshop);
        title.setText("MAĞAZALAR");
        ImageView backButton=(ImageView) toolbar.findViewById(R.id.backImage);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        iller=(Spinner) findViewById(R.id.iller);
        magazalardetay=(ListView) findViewById(R.id.magazadetay);

        ArrayAdapter<CharSequence> siralaAdapter=ArrayAdapter.createFromResource(this,R.array.iller,android.R.layout.simple_spinner_item);
        siralaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        iller.setAdapter(siralaAdapter);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }
        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabled = service
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        Turkey=new LatLng(38.7448829,35.8052027);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Turkey, (float) 5));

// check if enabled and if not send user to the GSP settings
// Better solution would be to display a dialog and suggesting to
// go to the settings
        if (!enabled) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
        iller.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String city=(String) parent.getItemAtPosition(position);

                new getData(FindStoreActivity.this){
                    @Override
                    protected void onPostExecute(String s) {
                        if(!s.equals("") || s!=null){
                            try {
                                JSONArray jsonArray=new JSONArray(s);
                                String[] detaylar=new String[jsonArray.length()];
                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                                    LatLng sydney = new LatLng(jsonObject.getDouble("StoreLatitude"), jsonObject.getDouble("StoreLongtitude"));
                                    mMap.addMarker(new MarkerOptions().position(sydney).title(jsonObject.getString("StoreName"))
                                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.logo))
                                            .flat(true).//haritanın döndürülmesi sonucu iconların ona göre ayarlanması
                                            alpha(0.7f)//marker saydamlığı
                                    );
                                    detaylar[i]="Mağaza Adı:"+jsonObject.getString("StoreName")+"\n\n"+
                                            "Mağaza Adres:"+jsonObject.getString("StoreAdress")+"\n\n"+
                                            "Mağaza Telefon:"+jsonObject.getString("StoreTelephone")+"\n\n"+
                                            "Mağaza Mail:"+jsonObject.getString("StoreMail")+"\n";
                                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12));
                                }
                                ArrayAdapter<String> details=new ArrayAdapter<String>(FindStoreActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,(String[]) detaylar);
                                magazalardetay.setAdapter(details);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }else {
                            Toast.makeText(getApplicationContext(), "Belirlediğiniz Şehirde Mağazamız Bulunmamaktadır!!!", Toast.LENGTH_SHORT).show();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Turkey,(float) 6.42));
                        }
                        dialog.dismiss();
                        super.onPostExecute(s);
                    }
                }.execute(MainActivity.server_url+"stores.php",city,"yok");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    LocationManager locationManager;
    String provider;

    @Override
    public boolean onMyLocationButtonClick() {
        //if(mMap.isMyLocationEnabled()) Toast.makeText(this, "Var", Toast.LENGTH_SHORT).show();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Define the criteria how to select the locatioin provider -> use
        // default
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return false;
        }
        Location location = locationManager.getLastKnownLocation(provider);

        // Initialize the location fields
        if (location != null) {
            Toast.makeText(this, "Provider "+provider+" seçildi", Toast.LENGTH_SHORT).show();
            System.out.println("Provider " + provider + " has been selected.");
            onLocationChanged(location);
        } else {
            Toast.makeText(this, "Location not available", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLocationChanged(Location location) {
        int lat = (int) (location.getLatitude());
        int lng = (int) (location.getLongitude());
        Toast.makeText(this, String.valueOf(lat)+"-"+String.valueOf(lng), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled new provider " + provider,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Disabled provider " + provider,
                Toast.LENGTH_SHORT).show();
    }
}
