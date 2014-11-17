package com.zhirunjia.housekeeper.Activity;

import android.R.integer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class HouseholdAppliancesCleaningActivity extends CommonActivity{

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.household_appliances_cleaning_layout);
		// 设置头部标题
		super.setCommonHeaderTitleTextById(R.string.household_appliances_cleaning_header_title_text);
		// 设置公共顶部提示信息
		super.setCommonTopHintTextById(R.string.household_appliances_cleaning_top_hint_text);
		// 填充服务内容Demo
		for(int i = 0 ; i < 10 ; i++){
			insertOptionList(i);
		}
	}

	/**
	 * 插入选列表
	 *
	 */
	private void insertOptionList(int number){
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.household_appliances_cleaning_option_list);
		View view = View.inflate(this,R.layout.household_appliances_cleaning_list_layout, null);
		TextView serverNameTextView = (TextView)view.findViewById(R.id.household_appliances_cleaning_server_name);
		serverNameTextView.setText("服务名称" + number);
		TextView serverDescription1TextView = (TextView)view.findViewById(R.id.household_appliances_cleaning_server_description_1);
		serverDescription1TextView.setText("服务简介" + number + " 行 1");
		TextView serverDescription2TextView = (TextView)view.findViewById(R.id.household_appliances_cleaning_server_description_2);
		serverDescription2TextView.setText("服务名称" + number + "行 2");
		linearLayout.addView(view);
	}
}
