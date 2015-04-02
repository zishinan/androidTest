package com.jclt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.jclt.server.ActValue;
import com.jclt.server.Client;
import com.jclt.server.Data;

public class FirstActivity extends CommonActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Client client = new Client();
		client.setData(new Data(ActValue.LOGIN, "����"));
		client.start();
		while(!ActValue.access){
			if(ActValue.access){
				break;
			}
		}
		// requestWindowFeature();��ȡֵ
		// 1.DEFAULT_FEATURES��ϵͳĬ��״̬��һ�㲻��Ҫָ��
		// 2.FEATURE_CONTEXT_MENU������ContextMenu��Ĭ�ϸ��������ã�һ������ָ��
		// 3.FEATURE_CUSTOM_TITLE���Զ�����⡣����Ҫ�Զ������ʱ����ָ�����磺������һ����ťʱ
		// 4.FEATURE_INDETERMINATE_PROGRESS����ȷ���Ľ���
		// 5.FEATURE_LEFT_ICON������������ͼ��
		// 6.FEATURE_NO_TITLE���ޱ���
		// 7.FEATURE_OPTIONS_PANEL�����á�ѡ����塱���ܣ�Ĭ�������á�
		// 8.FEATURE_PROGRESS������ָʾ������
		// 9.FEATURE_RIGHT_ICON:�������Ҳ��ͼ��
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// getWindow().setFlags(); ȡֵ
		// 1.���ô���ȫ��
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// 2.���ô���ʼ�յ���
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		// 3.���ô��屳��ģ��
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.first_tiem);
		// this.setContentView(R.layout.letao_myletao_code_shoes);

		// �ڴ������ػ������賤ʱ��ִ�е�����ʱ��ֱ�ӰѴ�������Activity��OnCreate��OnStart�У��ᵼ��ִ�й���������Activity����Ӧ�����ʱ����������򻹻�ҵ���
		// Handler�ǰ���Щ���ܷŵ�һ���������߳���ִ�У���Activity����Ӱ�졣
		// ����:http://blog.csdn.net/caesardadi/article/details/8473777
		Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 2:

					Intent intent = new Intent(FirstActivity.this,
							SecondActivity.class);
					// overridePendingTransition(R.anim.zoomin,R.anim.zoomout);//����ת����������������
					FirstActivity.this.startActivityForResult(intent, 0);
					FirstActivity.this.finish();
					int version = Integer.valueOf(android.os.Build.VERSION.SDK);
					if (version > 5) {
						// ʵ��Activity�л�ʱ�Ķ���Ч��
						overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
					}
					FirstActivity.this.finish();
				default:
					break;
				}
				super.handleMessage(msg);
			}
		};
		handler.sendEmptyMessageDelayed(2, 900L);

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}