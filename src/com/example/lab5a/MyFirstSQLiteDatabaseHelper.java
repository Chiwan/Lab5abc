package com.example.lab5a;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyFirstSQLiteDatabaseHelper extends SQLiteOpenHelper{

	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "TestDB.db";
	private static final String TABLE_NAME = "myFirstTable";
	private static final String COLUMN_NAME = "userName";
	private static final String COLUMN_ID = "_id";

	public MyFirstSQLiteDatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
				+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ COLUMN_NAME + " TEXT);");
		insertDemoRows(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(MyFirstSQLiteDatabaseHelper.class.getName(),
				 "Upgrading database from version " + oldVersion + " to "
				            + newVersion + ", which will destroy all old data");	
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	    onCreate(db);
	}
	
	private void insertDemoRows(SQLiteDatabase db){
		//db =this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLUMN_NAME, "John Q. Public");
		db.insert(TABLE_NAME, null, values);
		//db.close();
	}

	public void insertData(){
		
	}

}
