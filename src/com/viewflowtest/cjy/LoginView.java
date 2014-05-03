package com.viewflowtest.cjy;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginView extends Activity {

	// String[] user = { "baojun", "anhua", "shichu", "jianfei", "junlin",
	// "yongsheng", "xuerui","bingbing" };
	// String pass = "123456";
	String username = null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.login);
		final Button button1 = (Button) findViewById(R.id.buttonE);
		Button button2 = (Button) findViewById(R.id.buttonF);
		final EditText editText1 = (EditText) findViewById(R.id.editText1);
		final EditText editText2 = (EditText) findViewById(R.id.editText2);

		button1.setOnClickListener(new OnClickListener() {
			int i;

			@Override
			public void onClick(View v) {

				boolean flag = false;
				// 通过遍历数据的形式判断输入的帐号和密码是否正确
				username = (String) editText1.getText().toString();
				String userpass = (String) editText2.getText().toString();
				TextView textView1 = (TextView) findViewById(R.id.textView3);
				TextView textView2 = (TextView) findViewById(R.id.textView4);
				for (int i = 0; i < Data.USER.length; i++) {
					if (username.equals(Data.USER[i][0])) {// 判断帐号是否正确
						if (userpass.equals(Data.USER[i][1])) { // 判断密码是否正确
							username = Data.USER[i][2]; // 获取昵称
							flag = true; // 将标志变量设置为true
							break; // 跳出for循环
						}
					}
				}

				if (flag) {
					Toast.makeText(LoginView.this, "登陆成功！", Toast.LENGTH_SHORT)
							.show();
					Intent intent = new Intent(LoginView.this, MainActivity.class); // 创建要显示Activity对应的Intent对象
					Bundle bundle = new Bundle(); // 创建一个Bundle的对象bundle
					bundle.putString("username", username); // 保存昵称
					intent.putExtras(bundle); // 将数据包添加到intent对象中
					startActivity(intent); // 开启一个新的Activity
					// loginView.this.finish();
				} else {
					if (username.equals("") || userpass.equals("")) {
						if ("".equals(username)) {
							Toast.makeText(LoginView.this, "您还没有输入用户名！",
									Toast.LENGTH_SHORT).show();
						}
						if ("".equals(userpass)) {
							Toast.makeText(LoginView.this, "您还没有输入密码！",
									Toast.LENGTH_SHORT).show();
						}

					} else {
						Toast.makeText(LoginView.this, "您输入的帐号或密码错误！",
								Toast.LENGTH_SHORT).show();
						Toast.makeText(LoginView.this,
								"用户名或密码错误，例如你们名字的后两个字的拼音为用户名密码为123456，可以成功登录",
								Toast.LENGTH_LONG).show();
						textView1.setText(username);
						textView2.setText(userpass);
					}

				}

				// username = (String) editText1.getText().toString();
				// String userpass = (String) editText2.getText().toString();
				// TextView textView1 = (TextView) findViewById(R.id.textView3);
				// TextView textView2 = (TextView) findViewById(R.id.textView4);
				// for (int j = 0; j < user.length; j++) {
				//
				// if (user[j].equalsIgnoreCase(username)
				// && pass.equalsIgnoreCase(userpass)) {
				//
				// Toast.makeText(loginView.this, "登录成功",
				// Toast.LENGTH_SHORT).show();
				// i = 1;
				// Intent intent7 = new Intent(loginView.this, arrge.class);
				// textView1.setText("用户：" + username + "登录成功！");
				// Bundle bundle=new Bundle();
				// bundle.putCharSequence("username", username);
				// intent7.putExtras(bundle);
				// startActivity(intent7);
				// loginView.this.finish();
				//
				// break;
				//
				// //
				// username==(String)user[0]||username==(String)user[1]||username==(String)user[2]&&userpass==(String)pass
				//
				// } else {
				// i = 0;
				// textView1.setText(username);
				// textView2.setText(userpass);
				//
				// }
				// }
				// if (i == 0) {
				// Toast.makeText(loginView.this,
				// "用户名或密码错误，例如你们名字的后两个字的拼音为用户名密码为123456，可以成功登录",
				// Toast.LENGTH_SHORT).show();
				// }

			}
		});

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				editText1.setText(null);
				editText2.setText(null);
				Toast.makeText(LoginView.this, "注册功能暂未实现", Toast.LENGTH_LONG)
						.show();
			}
		});

	}

	public void menuAction2() {
		Dialog alertDialog = new AlertDialog.Builder(LoginView.this)
				.setTitle("关于")
				.setMessage(
						"原来打算名字叫:SignMan、\n现在应该正式改名为:collection store.\n英文翻译不准确吧。大概意思这就是一个网络留言薄，留住我们这几个人之间的美好，都珍藏着。。。\n"
								+ "希望这东西还能让我继续有动力做下去。\n先说明：这软件只有我们几个人的用户名才能登录。\n愿我们的友谊天长地久！\n20140401（愚人节）——宝军\n其实做这个只是无聊" +
								"，同时也想做一个留言板，以后大家有什么心事啊，无聊啊之类的话都可以放到这上面，说给我们这些朋友听，这里没人会笑你，有的只会是懂你，理解你！\n" +
								"不过这只是我的想法，现在还没学到安卓网络编程，现在啥也实现不了，后续会慢慢更新上来的。	QQ邮箱：1018795480@qq.com")
				.setIcon(R.drawable.ic_launcher)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				}).create();
		alertDialog.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.exitmenu:
			finish();
			break;
		case R.id.aboutmenu:
			menuAction2();
			break;

		}
		return super.onMenuItemSelected(featureId, item);
	}
}
