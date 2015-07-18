package com.example.quiz;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends Activity {
	dbcontrol db=new dbcontrol(this);
	int score=0,qid=1;
    question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    String ans;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radioButton1);
        rdb=(RadioButton)findViewById(R.id.radioButton2);
        rdc=(RadioButton)findViewById(R.id.radioButton3);
        setview();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question, menu);
		return true;
	}
	
	void setview()
	{
		currentQ=db.getquestion(qid);
		if(currentQ!=null)
		{
			txtQuestion.setText(currentQ.qname);
			rda.setText(currentQ.opta);
			rdb.setText(currentQ.optb);
			rdc.setText(currentQ.optc);
			ans=currentQ.answer;
		}
	}
	
	public void ok(View v)
	{
		RadioGroup grp=(RadioGroup)findViewById(R.id.radiogroup0);
        RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
        if(ans.equals(answer.getText()))
        {
        	score++;
        	int count=db.rowcount();
        	if(qid>=count)
        	{
        		Intent i=new Intent(QuestionActivity.this,EndActivity.class);
            	i.putExtra("score", score);
        		startActivity(i);
        	}
        	else
        	{
        		qid++;
        		Toast.makeText(QuestionActivity.this,"your score is:"+score,Toast.LENGTH_LONG).show();
        		setview();
        	}
        }
        else
        {
        	Intent i=new Intent(QuestionActivity.this,EndActivity.class);
        	i.putExtra("score", score);
    		startActivity(i);
        }
	}
}
