package com.example.lab5a;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class NewListUserActivity extends ListActivity {
	private static final String TABLE_NAME = "myFirstTable";
	private static final String COLUMN_NAME = "userName";
	private static final String COLUMN_ID = "_id";
	static String[] COLUMN_BINDING;
	static int[] VIEW_BINDING;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_listuser);
		//ListView listView = (ListView) findViewById(R.id.);
		COLUMN_BINDING = new String[] {COLUMN_NAME}  ;
		MyFirstSQLiteDatabaseHelper myDB = new MyFirstSQLiteDatabaseHelper(this);
		SQLiteDatabase db = myDB.getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_NAME, new String[] {COLUMN_ID, COLUMN_NAME},
			 null, null, null, null, null, null);
		//startManagingCursor(cursor);
		if(cursor.moveToFirst()){
			System.out.println(cursor.getCount());
			Log.e("Exemple : ", ""+cursor.getString(1));
			Log.e("Count :",""+cursor.getCount());
		};
		
		VIEW_BINDING = new int[]{R.id.name_entry};
		ListAdapter adapter = new SimpleCursorAdapter(this,R.layout.activity_listuser_entry,cursor,COLUMN_BINDING,VIEW_BINDING);
		setListAdapter(adapter);
	}
	
	
}
