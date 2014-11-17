package com.zhirunjia.housekeeper.Activity;

import com.zhirunjia.housekeeper.Utils.WindowUtil;

import android.os.Bundle;
import android.view.View;

public class HomeActivity extends CommonActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);
		// 设置头部标题
		super.setCommonHeaderTitleTextById(R.string.home_header_title_text);
		// 设置头部左侧按钮文字
		super.commonHeaderTitleLeftButton.setText("背景");
		// 设置头部右侧按钮背景图片
		super.commonHeaderTitleRightButton.setBackgroundResource(R.drawable.index_cellphone);
	}

	// 家电清理按钮
	public void goHouseholdAppliancesCleaningButtonOnClick(View view){
		WindowUtil.openWindow(this.context, HouseholdAppliancesCleaningActivity.class);
	}

}
