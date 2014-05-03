package com.viewflowtest.cjy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;


public class StartActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//设置界面没有titlebar
		setContentView(R.layout.start);
		findViewById();
		setListener();
		init();
		
	}
	protected void findViewById() {
		// 暂时不做任何操作
	}

	protected void setListener() {
		// 暂时不做任何操作
	}

	protected void init() {
		// 延迟1500毫秒发送消息到消息队列
		handler1.sendEmptyMessageDelayed(0, 3000);
	}
	Handler handler1 = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			// 跳转到登录界面,并默认方式关闭当前界面
			startActivity(LoginView.class);
			defaultFinish();
		}
	};
	protected void startActivity(Class<?> cls) {
		startActivity(cls, null);
	}
	/** 含有Bundle通过Class跳转界面 **/
	protected void startActivity(Class<?> cls, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(this, cls);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}

	
	
	/** 带有右进右出动画的退出 **/
	public void finish() {
		super.finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}

	/** 默认退出 **/
	protected void defaultFinish() {
		super.finish();
	}

}