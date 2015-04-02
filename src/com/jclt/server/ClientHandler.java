package com.jclt.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.jclt.server.entry.Dir;
import com.jclt.server.entry.Product;
import com.jclt.server.entry.Smalldir;

public class ClientHandler extends IoHandlerAdapter {
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		Log.e("mylog", "send:"+message.toString());
		super.messageSent(session, message);
	}
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		
		String dataResult = message.toString().trim();
		Log.e("mylog", dataResult);
		Data data = JSON.parseObject(dataResult,Data.class);
		String msg = data.getMsg();
		Log.e("mylog", data.getMsg());
		Log.e("mylog", data.getAct());
		try {
			if(ActValue.LOGIN.equals(data.getAct())){	Map<String, Object> maps = (Map<String,Object>) JSON.parse(msg);
//			String productsString = maps.get("products");
//			String dirsString = maps.get("dirs");
//			String smalldirsString = maps.get("smalldirs");
			List<Product> products = new ArrayList<Product>();
			List<Dir> dirs = new ArrayList<Dir>();
			List<Smalldir> smalldirs = new ArrayList<Smalldir>();
			
			List productsObj = (List) maps.get("products");
			List dirsObj = (List) maps.get("dirs");
			List smalldirsObj = (List) maps.get("smalldirs");
//			List productsObj = JSON.parseObject(productsString, List.class);
//			List dirsObj = JSON.parseObject(dirsString, List.class);
//			List smalldirsObj = JSON.parseObject(smalldirsString, List.class);
			for (Object object : smalldirsObj) {
				smalldirs.add(JSON.parseObject(object.toString(), Smalldir.class));
			}
			for (Object object : dirsObj) {
				dirs.add(JSON.parseObject(object.toString(), Dir.class));
			}
			for (Object object : productsObj) {
				products.add(JSON.parseObject(object.toString(), Product.class));
			}
			ResultData.setDirs(dirs);
			List<Dir> mainDirs = new ArrayList<Dir>();
			int i = 0;
			for (Dir dir : dirs) {
				mainDirs.add(dir);
				i ++;
				if(i > 3){
					break;
				}
			}
			Dir more = new Dir();
			more.setId(-1L);
			more.setName("更多分类");
			more.setSort(100);
			mainDirs.add(more);
			ResultData.setMainDirs(mainDirs);
			ResultData.setSmalldirs(smalldirs);
			ResultData.setProducts(products);
			System.err.println(dirs.size());
		
}
		} catch (Exception e) {
			Log.e("mylog", msg);
		}
		if(ActValue.SIGIN.equals(data.getAct())){
			
		}
		if(ActValue.BUY.equals(data.getAct())){
			
		}
		if(ActValue.SHOW_BUY.equals(data.getAct())){
			
		}
		if(ActValue.CHANGE_PWD.equals(data.getAct())){
			
			
		}
		session.setAttribute(Client.RESULT, Client.SUCCESS);
		ActValue.access = true;
		super.messageReceived(session, message);
	}
}
