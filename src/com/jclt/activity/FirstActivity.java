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
		client.setData(new Data(ActValue.LOGIN, "中文"));
		client.start();
		while(!ActValue.access){
			if(ActValue.access){
				break;
			}
		}
		// requestWindowFeature();的取值
		// 1.DEFAULT_FEATURES：系统默认状态，一般不需要指定
		// 2.FEATURE_CONTEXT_MENU：启用ContextMenu，默认该项已启用，一般无需指定
		// 3.FEATURE_CUSTOM_TITLE：自定义标题。当需要自定义标题时必须指定。如：标题是一个按钮时
		// 4.FEATURE_INDETERMINATE_PROGRESS：不确定的进度
		// 5.FEATURE_LEFT_ICON：标题栏左侧的图标
		// 6.FEATURE_NO_TITLE：无标题
		// 7.FEATURE_OPTIONS_PANEL：启用“选项面板”功能，默认已启用。
		// 8.FEATURE_PROGRESS：进度指示器功能
		// 9.FEATURE_RIGHT_ICON:标题栏右侧的图标
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// getWindow().setFlags(); 取值
		// 1.设置窗体全屏
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// 2.设置窗体始终点亮
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		// 3.设置窗体背景模糊
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.first_tiem);
		// this.setContentView(R.layout.letao_myletao_code_shoes);

		// 在处理下载或其他需长时间执行的任务时，直接把处理函数放Activity的OnCreate或OnStart中，会导致执行过程中整个Activity无响应，如果时间过长，程序还会挂掉。
		// Handler是把这些功能放到一个单独的线程里执行，与Activity互不影响。
		// 解释:http://blog.csdn.net/caesardadi/article/details/8473777
		Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 2:

					Intent intent = new Intent(FirstActivity.this,
							SecondActivity.class);
					// overridePendingTransition(R.anim.zoomin,R.anim.zoomout);//在跳转的语句后加上这条语句
					FirstActivity.this.startActivityForResult(intent, 0);
					FirstActivity.this.finish();
					int version = Integer.valueOf(android.os.Build.VERSION.SDK);
					if (version > 5) {
						// 实现Activity切换时的动画效果
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