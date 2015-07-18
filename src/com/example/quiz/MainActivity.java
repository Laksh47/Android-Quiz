package com.example.quiz;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void goToActivity(Class<? extends Activity> activityClass)
	{
		Intent newActivity=new Intent(MainActivity.this,activityClass);
		startActivity(newActivity);
	}
	
	public void yes(View c) 
	{
		goToActivity(QuestionActivity.class);
	}
	
	public void edit(View c) 
	{
		goToActivity(EditActivity.class);
	}
}
