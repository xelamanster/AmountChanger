package com.example.newamountchanger;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText amountEdit;
	Double sum;
	String amnt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		amountEdit=(EditText)findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
		
	public void dialog(View view){
		Intent intent = new Intent(this, DialogActivity.class);
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		amnt=amountEdit.getText().toString();
		if(data!=null){
			String newAmount = data.getStringExtra("amount");
			if(amnt.trim().length()!=0&&newAmount.trim().length()!=0){
				sum=Double.parseDouble(amnt)+Double.parseDouble(newAmount);
				amountEdit.setText(sum.toString());
			}else if(newAmount.trim().length()!=0){
				amountEdit.setText(newAmount);
			}	
		}	
	}
}