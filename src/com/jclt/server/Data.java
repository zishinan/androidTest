package com.jclt.server;


public class Data {
	private String act;
	private String msg;
	public Data() {
	}
	public Data(String act,String msg)
	{
		this.act = act;
		this.msg = msg;
	}
	public String getAct()
	{
		return act;
	}
	public void setAct(String act)
	{
		this.act = act;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	
}
