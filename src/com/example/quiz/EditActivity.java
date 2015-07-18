package com.example.quiz;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends Activity {

	dbcontrol d=new dbcontrol(this);
	EditText e1,e2,e3,e4,e5,e6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		e4=(EditText)findViewById(R.id.editText4);
		e5=(EditText)findViewById(R.id.editText5);
		e6=(EditText)findViewById(R.id.editText6);
		clear();
	}
	
	void clear(){
		e1.setText("");
		e2.setText("");
		e3.setText("");
		e4.setText("");
		e5.setText("");
		e6.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit, menu);
		return true;
	}
	
	public void add(View clickedbutton)
	{
		String qname,opta,optb,optc,answer;
		int qid;
		question r;
		if(e1.getText().toString().length()!=0 && e2.getText().length()!=0 && e3.getText().length()!=0 && e4.getText().length()!=0 && e5.getText().length()!=0 && e6.getText().length()!=0)
		{
			qid=Integer.parseInt(e1.getText().toString());
			qname=e2.getText().toString();
			opta=e3.getText().toString();
			optb=e4.getText().toString();
			optc=e5.getText().toString();
			answer=e6.getText().toString();
			r=new question(qid,qname,opta,optb,optc,answer);
			int i=d.insert(r);
			if(i!=-1)
				Toast.makeText(EditActivity.this,"Question added",Toast.LENGTH_LONG).show();
			else
				Toast.makeText(EditActivity.this,"Question id exists",Toast.LENGTH_LONG).show();
			clear();
		}
		else
			Toast.makeText(EditActivity.this,"Enter field values first!",Toast.LENGTH_LONG).show();
	}
	
	public void save(View v)
	{
		String qname,opta,optb,optc,answer;
		int qid;
		question r;
		if(e1.getText().toString().length()!=0 && e2.getText().length()!=0 && e3.getText().length()!=0 && e4.getText().length()!=0 &&e5.getText().length()!=0 && e6.getText().length()!=0)
		{
			qid=Integer.parseInt(e1.getText().toString());
			qname=e2.getText().toString();
			opta=e3.getText().toString();
			optb=e4.getText().toString();
			optc=e5.getText().toString();
			answer=e6.getText().toString();
			r=new question(qid,qname,opta,optb,optc,answer);
			int i=d.update(r);
			if(i!=0 && i!=-1)
				Toast.makeText(EditActivity.this,"Success",Toast.LENGTH_LONG).show();
			else
				Toast.makeText(EditActivity.this,"Updation failed",Toast.LENGTH_LONG).show();
			clear();
		}
		else
			Toast.makeText(EditActivity.this,"Enter field values first!",Toast.LENGTH_LONG).show();
	}
}
