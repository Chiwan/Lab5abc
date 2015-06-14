package com.example.lab5a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
	private static final String MyPreferences = "MyPrefs";
	private SharedPreferences mySP;
	//private SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}
	
	public void doLogin(View v){
		EditText passwordEditText = (EditText)findViewById(R.id.editText1);
		String password = passwordEditText.getText().toString();
		mySP = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = mySP.edit();

		if(!password.equals("mypassword")){
			
	        Toast toast = Toast.makeText(getApplicationContext(),"Login failed. Try Again",Toast.LENGTH_LONG);
			toast.show();
		}else{
			editor.putBoolean("isAuthorized", true);
		}
		editor.commit();
		
		Intent i = new Intent(this,MainActivity.class);
		startActivity(i);
		finish();
	}	
}
