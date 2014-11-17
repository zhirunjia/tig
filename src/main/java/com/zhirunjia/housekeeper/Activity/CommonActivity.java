package com.zhirunjia.housekeeper.Activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class CommonActivity extends Activity{
	protected Context context = CommonActivity.this;
	// 头部标题文本控件
	protected TextView commonHeaderTitleTextView;
	// 头部标题左侧按钮
	protected TextView commonHeaderTitleLeftButton;
	// 头部标题右侧按钮
	protected TextView commonHeaderTitleRightButton;

	// 顶部提示文字控件
	protected TextView commonTopHintTextView;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		// 设置默认值
		this.commonHeaderTitleLeftButton = (TextView)findViewById(R.id.common_header_title_left_button);
		this.commonHeaderTitleRightButton = (TextView)findViewById(R.id.common_header_title_right_button);
		// 设置全屏
		//设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	//公共头部后退按钮点击事件
	public void commonBackButtonOnClick(View view){
		finish();
	}

	/**
	 * 设置公共头部标题
	 *
	 * @param title 标题
	 * @return void
	 */
	protected void setCommonHeaderTitleTextById(int text) {
		this.commonHeaderTitleTextView = (TextView)findViewById(R.id.common_header_title);
		this.commonHeaderTitleTextView.setText(text);
	}

	/**
	 * 设置公共顶部提示信息
	 *
	 * @param hintText 提示信息
	 * @return void
	 */
	protected void setCommonTopHintTextById(int Id) {
		this.commonTopHintTextView = (TextView)findViewById(R.id.common_top_hint_text);
		this.commonTopHintTextView.setText(Id);
	}

	/**
	 * 公共页脚前往首页按钮
	 *
	 *
	 */
	public void goHomeButtonOnClick(){

	}

	/**
	 * 公共页脚前往订单按钮
	 *
	 *
	 */
	public void goOrderButtonOnClick(){

	}

	/**
	 * 公共页脚前往我的按钮
	 *
	 *
	 */
	public void goMyButtonOnClick(){

	}

	/**
	 * 公共页脚前往更多按钮
	 *
	 *
	 */
	public void goMoreButtonOnClick(){

	}

	/**
	 * 获取图片 Drawable
	 *
	 * @param int 资源ID
	 * @return Drawable
	 */
	protected Drawable getDrawableById(int id){
		return this.getResources().getDrawable(R.drawable.index_cellphone);
	}

}
