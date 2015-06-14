package com.example.lab5a;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecureDataActivity extends Activity{

	private static final String MyPreferences = "MyPrefs";
	private SharedPreferences mySP; 
	private static final String TABLE_NAME = "myFirstTable";
	private static final String COLUMN_NAME = "userName";
	
	private MyFirstSQLiteDatabaseHelper myDB;
	private SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_securedata);
		mySP = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);
		
		String name = "Jean-Philippe Kha";
	}
	
	public void doLogout(View v){
		SharedPreferences.Editor editor =mySP.edit();
		editor.putBoolean("isAuthorized", false);
		editor.commit();
		Intent i = new Intent(this,MainActivity.class);
		startActivity(i);
		finish();
	}
	
	public void openOrCreateDatabase(View v){
		myDB = new MyFirstSQLiteDatabaseHelper(this);
		
	}
	public void insertData(View v){
		db = myDB.getWritableDatabase();
		ContentValues values = new ContentValues();
		String name = "John Q. Public";
		values.put(COLUMN_NAME, name);
		db.insert(TABLE_NAME, null, values);
		Log.d("addName", name.toString());
		//db.close();
	}
	public void closeData(View v){
		db.close();	
	}
	
	public void showUserList(View v){
		Intent i = new Intent(this,NewListUserActivity.class);
		startActivity(i);
		finish();
	}
	
	
}
