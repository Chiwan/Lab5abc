package com.example.lab5a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private static final String MyPreferences = "MyPrefs";
	private SharedPreferences mySP;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mySP = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void doLogin(View v){
		boolean isLogged = mySP.getBoolean("isAuthorized", false);
		if(isLogged){
			Intent secureDataIntent = new Intent(this,SecureDataActivity.class);
			startActivity(secureDataIntent);
			finish();
		}else{
			Intent loginIntent = new Intent(this,LoginActivity.class);
			startActivity(loginIntent);
			finish();
		}
	}
	
	
}
