package com.example.quiz;
public class question{
	String qname,opta,optb,optc,answer;
	int qid;
	public question(int qid,String qname,String opta,String optb,String optc,String answer){
		this.qid=qid;
		this.qname=qname;
		this.opta=opta;
		this.optb=optb;
		this.optc=optc;
		this.answer=answer;	
	}
}