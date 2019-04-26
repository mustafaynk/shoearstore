package com.shoeARstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by User on 4.7.2017.
 */

public class localdatabase {
    private static  final String DATABASE_ISIM="cartlist";
    private static final String DATABASE_TABLO="cart";
    private static final String DATABASE_TABLO2="fav";
    private static final int DATABASE_VERSION=1;

    private final Context contextim;
    private VeritabaniHelper veritabaniHelper;
    private SQLiteDatabase veritabanim;

    //sutünlar
    public static final String KEY_ROW_ID="_id";
    public static final String KEY_ROW_STOCKCODE="stockcode";
    public static final String KEY_ROW_PIECE="piece";
    public static final String KEY_ROW_SHOESIZE="size";
    //create table
    private static final String CREATE_TABLO_CART="CREATE TABLE " + DATABASE_TABLO + " ("+
            KEY_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            KEY_ROW_STOCKCODE + " TEXT NOT NULL , "+
            KEY_ROW_PIECE+" TEXT NOT NULL , " +
            KEY_ROW_SHOESIZE+" TEXT NOT NULL);";

    private static final String CREATE_TABLO_FAV="CREATE TABLE " + DATABASE_TABLO2 + " ("+
            KEY_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            KEY_ROW_STOCKCODE + " TEXT NOT NULL , "+
            KEY_ROW_SHOESIZE+" TEXT NOT NULL);";

    public localdatabase(Context c) {
        this.contextim=c;
    }

    public localdatabase baglantiAc(){
        veritabaniHelper=new VeritabaniHelper(contextim);
        veritabanim=veritabaniHelper.getWritableDatabase();
        return this;
    }
    public void baglantiKapa(){
        veritabaniHelper.close();
    }


    public void favKaydet(String stockcode,String size){
        ContentValues cv=new ContentValues();
        cv.put(KEY_ROW_STOCKCODE,stockcode);
        cv.put(KEY_ROW_SHOESIZE,size);
        veritabanim.insert(DATABASE_TABLO2,null,cv);
    }
    public ArrayList<String> favoritesKayitListele(){
        ArrayList<String> veriler=new ArrayList<>();
        String[] sutunlar=new String[]{KEY_ROW_ID,KEY_ROW_STOCKCODE,KEY_ROW_SHOESIZE};
        Cursor c=veritabanim.query(DATABASE_TABLO2,sutunlar,null,null,null,null,null);
        int id=c.getColumnIndex(KEY_ROW_ID);
        int stockcodeid=c.getColumnIndex(KEY_ROW_STOCKCODE);
        int sizeid=c.getColumnIndex(KEY_ROW_SHOESIZE);
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            veriler.add(c.getString(id)+"/"+c.getString(stockcodeid)+"/"+c.getString(sizeid));
        }
        return veriler;
    }

    public boolean favSil(String stockcode){
        if(!stockcode.equals("")) {
            veritabanim.delete(DATABASE_TABLO2, KEY_ROW_STOCKCODE + "=" + stockcode, null);
            return true;
        }
        return false;
    }

    public int itemKontrol(String stockcode){
        Cursor cursor=veritabanim.rawQuery("SELECT * FROM "+DATABASE_TABLO2
                +" WHERE "+KEY_ROW_STOCKCODE+" = "+stockcode,null);

        return cursor.getCount();
    }

    public int favItemCount(){
        long count= DatabaseUtils.queryNumEntries(veritabanim,DATABASE_TABLO2);
        return (int) count;
    }

    public int cartItemCount(){
        long count= DatabaseUtils.queryNumEntries(veritabanim,DATABASE_TABLO);
        return (int) count;
    }

    public void cartKaydet(String stockcode,String piece,String size) {
        ContentValues cv=new ContentValues();
        cv.put(KEY_ROW_STOCKCODE,stockcode);
        cv.put(KEY_ROW_PIECE,piece);
        cv.put(KEY_ROW_SHOESIZE,size);
        veritabanim.insert(DATABASE_TABLO,null,cv);
    }

    public ArrayList<String> cartKayitlariListele() {
        ArrayList<String> veriler=new ArrayList<>();
        String[] sutunlar=new String[]{KEY_ROW_ID,KEY_ROW_STOCKCODE,KEY_ROW_PIECE,KEY_ROW_SHOESIZE};
        Cursor c=veritabanim.query(DATABASE_TABLO,sutunlar,null,null,null,null,null);
        int id=c.getColumnIndex(KEY_ROW_ID);
        int stockcodeid=c.getColumnIndex(KEY_ROW_STOCKCODE);
        int pieceid=c.getColumnIndex(KEY_ROW_PIECE);
        int sizeid=c.getColumnIndex(KEY_ROW_SHOESIZE);
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
           veriler.add(c.getString(id)+"/"+c.getString(stockcodeid)+"/"+c.getString(pieceid)+"/"+c.getString(sizeid));
        }
        return veriler;
    }

    public boolean sil(int itemId) {
        if(itemId!=-1) {
            veritabanim.delete(DATABASE_TABLO, KEY_ROW_ID + "=" + itemId, null);
            return true;
        }
        return false;
    }

    public void veriGuncelle(String stockcode, String piece, int index) {
        ContentValues cv=new ContentValues();
        cv.put(KEY_ROW_STOCKCODE,stockcode);
        cv.put(KEY_ROW_PIECE,piece);
        veritabanim.update(DATABASE_TABLO,cv,KEY_ROW_ID+"="+index,null);
    }


    public void tabloSil() {
        veritabanim.delete(DATABASE_TABLO,null,null);
    }

    private static class VeritabaniHelper extends SQLiteOpenHelper {

        public VeritabaniHelper(Context context)
        {
            super(context,DATABASE_ISIM,null,DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLO_CART);
            sqLiteDatabase.execSQL(CREATE_TABLO_FAV);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLO);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLO2);
            onCreate(sqLiteDatabase);
        }
    }


}
