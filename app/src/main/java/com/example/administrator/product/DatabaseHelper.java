package com.example.administrator.product;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String Dbname="Mydb.db";
    public  static String TableName="product";
    public  static String col1="id";
    public  static String col2="productmodel";
    public  static String col3="productcode";
    public  static String col4="productname";
    public  static String col5="productsellername";
    public  static String col6="price";
    public  static String col7="ownername";
    public  static String col8="ownermono";

    public DatabaseHelper( Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="create table "+TableName+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text,"+col4+" text,"+col5+" text,"+col6+" text,"+col7+" text,"+col8+" text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query="drop table if exists " +TableName;
        db.execSQL(query);
        onCreate(db);

        }

        public boolean insertData(String productmodel,String productcode,String productname,String productsellername,String price,String ownrename,String ownermono)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put(col2,productmodel);
            contentValues.put(col3,productcode);
            contentValues.put(col4,productname);
            contentValues.put(col5,productsellername);
            contentValues.put(col6,price);
            contentValues.put(col7,ownrename);
            contentValues.put(col8,ownermono);

            long status=db.insert(TableName,null,contentValues);
            if(status==-1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
}
