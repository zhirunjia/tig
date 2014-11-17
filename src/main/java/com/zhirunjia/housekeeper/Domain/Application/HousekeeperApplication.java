package com.zhirunjia.housekeeper.Domain.Application;

import com.zhirunjia.housekeeper.Domain.Exception.CatchAppGlobalException;

import android.app.Application;

public class HousekeeperApplication extends Application{

	 @Override
	    public void onCreate() {
	        super.onCreate();
	        // 捕获应用全局异常
	        /*CatchAppGlobalException catchAppGlobalException = CatchAppGlobalException.getInstance();
	        catchAppGlobalException.init(getApplicationContext());*/
	    }

}
