package com.jclt.server;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import android.util.Log;

import com.alibaba.fastjson.JSON;


public class Client extends Thread {
	public Data data = new Data();
	public static final String RESULT = "RESULT";
	public static final String SUCCESS = "SUCCESS";
	private static final String IP = "192.168.1.107";
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		IoConnector ioConnector = new NioSocketConnector();
		ioConnector.getFilterChain().addLast("logger", new LoggingFilter());
		ioConnector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		ioConnector.setHandler(new ClientHandler());
		ConnectFuture future = ioConnector.connect(new InetSocketAddress(IP, 8888));
		future.awaitUninterruptibly();
		IoSession ioSession = future.getSession();
		String sendData = JSON.toJSONString(data);
		ioSession.write(sendData);
		ioSession.getCloseFuture().awaitUninterruptibly();
		ioConnector.dispose();
		Log.e("mylog", "end send to server");
		super.run();
	}
}
