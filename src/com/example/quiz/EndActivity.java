package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends Activity {

	TextView t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end);
		t=(TextView)findViewById(R.id.textView1);
		Intent intent = getIntent();
		int score=intent.getIntExtra("score",0);
		t.setText("Your score is:"+score+"\n;-)");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.end, menu);
		return true;
		
	}
	
	public void gotomain(View v)
	{
		Intent newActivity=new Intent(EndActivity.this,MainActivity.class);
		startActivity(newActivity);	
	}

}
