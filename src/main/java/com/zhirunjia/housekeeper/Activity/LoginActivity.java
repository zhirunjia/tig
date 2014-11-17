package com.zhirunjia.housekeeper.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zhirunjia.housekeeper.Utils.WindowUtil;

public class LoginActivity extends CommonActivity{
	private final static String TAG = "LoginActivity";

	@Override
	public void onCreate(Bundle saveInstanceState){
		super.onCreate(saveInstanceState);
		setContentView(R.layout.login_layout);
		// 设置头部标题
		super.setCommonHeaderTitleTextById(R.string.login_header_title_text);
	}

	//登录表单提交
	public void submitLoginForm(View view){
		Log.i(TAG , "点击登录按钮");
		WindowUtil.openWindow(super.context, HomeActivity.class);
	}
}
