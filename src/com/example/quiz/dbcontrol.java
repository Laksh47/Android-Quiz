package com.example.quiz;

import android.util.Log;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class dbcontrol extends SQLiteOpenHelper{
	private static final String LOGCAT = null;
	dbcontrol(Context app){
		super(app,"questions.db",null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String query="CREATE TABLE IF NOT EXISTS question (qid INTEGER PRIMARY KEY,qname TEXT,opta TEXT,optb TEXT,optc TEXT,answer TEXT)";
		db.execSQL(query);	
		 Log.d(LOGCAT,"questions Created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldv, int newv) {
		String query;
	    query = "DROP TABLE IF EXISTS question";
	    db.execSQL(query);
	    onCreate(db);
	}
	
	public int insert(question r)
	{
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("qid", r.qid);
		values.put("qname",r.qname);
		values.put("opta",r.opta);
		values.put("optb",r.optb);
		values.put("optc",r.optc);
		values.put("answer",r.answer);
		int i=(int) database.insert("question", null, values);
		database.close();
		return i;
	}
	
	/*public int delete(int id)
	{
		SQLiteDatabase database = this.getWritableDatabase();
		String rid=""+id;
		//String query="DELETE FROM reps where id="+id;
		int i=database.delete("reps", "id = ?", new String[]{rid});
		database.close();
		return i;
	}*/
	
	public int update(question r)
	{
		SQLiteDatabase database = this.getWritableDatabase();
		 ContentValues values = new ContentValues();
		 String rid=""+r.qid;
		// values.put("qid", r.qid);
		 values.put("qname",r.qname);
		 values.put("opta",r.opta);
		 values.put("optb",r.optb);
		 values.put("optc",r.optc);
		 values.put("answer",r.answer);
		 int i=database.update("question", values, "qid = ?", new String[] {rid});
		 database.close();
		 return i;
	}
	
	public question getquestion(int rid)
	{
		String qname,opta,optb,optc,answer;
		int qid=rid;
		question r = null;
		SQLiteDatabase database = this.getReadableDatabase();
	    //String selectQuery = "SELECT * FROM reps where id="+rid;
	    //Cursor c=database.rawQuery(selectQuery,null);
		Cursor c=database.query("question",new String[]{"qname","opta","optb","optc","answer"}, "qid=?",new String[] {String.valueOf(rid)},null, null, null);
	    if (c.moveToFirst()) {
	    	qname=c.getString(0);
	    	opta=c.getString(1);
	    	optb=c.getString(2);
	    	optc=c.getString(3);
	    	answer=c.getString(4);
	    	r=new question(qid,qname,opta,optb,optc,answer);
	    }
		return r;
	}
	
	public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM question";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
