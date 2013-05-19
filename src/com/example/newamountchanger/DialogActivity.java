package com.example.newamountchanger;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class DialogActivity extends Activity {
	EditText amount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);
		amount=(EditText)findViewById(R.id.editTextDialog);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.dialog, menu);
		return true;
	}
	
	public void add(View view){
		Intent intent=new Intent();
		String amnt=amount.getText().toString();
		Log.d("my log","am"+amnt);
		intent.putExtra("amount",amnt);
		setResult(1,intent);
		finish();
	}
}
