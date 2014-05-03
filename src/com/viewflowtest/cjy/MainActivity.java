package com.viewflowtest.cjy;

import java.util.Timer;
import java.util.TimerTask;

import org.taptwo.android.widget.CircleFlowIndicator;
import org.taptwo.android.widget.OnScrollChangedListener;
import org.taptwo.android.widget.ViewFlow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements OnGlobalLayoutListener,
		OnScrollChangedListener {
	private ViewFlow viewFlow;
	private ImageButton jingquBtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//设置界面没有titlebar
		setContentView(R.layout.main);

		viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		viewFlow.setAdapter(new ImageAdapter(this));
		viewFlow.setmSideBuffer(3); // 实际图片张数， 我的ImageAdapter实际图片张数为3

		CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
		viewFlow.setFlowIndicator(indic);
		viewFlow.setTimeSpan(4500);
		viewFlow.setSelection(3 * 1000); // 设置初始位置
		viewFlow.startAutoFlowTimer(); // 启动自动播放
		initView();
		setListener();

	}
	//获取imageviewID
	private void initView() {
		jingquBtn = (ImageButton) findViewById(R.id.jingqu_btn);

	}

	/** 设置监听 */
	private void setListener() {
		jingquBtn.setOnClickListener(scenicListener);
	}

	private OnClickListener scenicListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this,
					SceneryGuideList.class);
			startActivity(intent);
		}
	};

	@Override
	public void onScrollChanged(int top, int oldTop) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onGlobalLayout() {
		// TODO Auto-generated method stub
		
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {  
	    // TODO Auto-generated method stub  
	    if(keyCode == KeyEvent.KEYCODE_BACK)  
	       {    
	           exitBy2Click();      //调用双击退出函数  
	       }  
	    return false;  
	}  
	/** 
	 * 双击退出函数 
	 */  
	private static Boolean isExit = false;  
	  
	private void exitBy2Click() {  
	    Timer tExit = null;  
	    if (isExit == false) {  
	        isExit = true; // 准备退出  
	        Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();  
	        tExit = new Timer();  
	        tExit.schedule(new TimerTask() {  
	            @Override  
	            public void run() {  
	                isExit = false; // 取消退出  
	            }  
	        }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务  
	  
	    } else {  
	        finish();  
	        System.exit(0);  
	    }  
	}  

}