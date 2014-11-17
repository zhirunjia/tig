package com.zhirunjia.housekeeper.Utils;

import org.json.JSONObject;

import android.content.Context;

import com.zhirunjia.housekeeper.Activity.R;


/**
 * Created by Xu wenQiang on 14-6-10.
 */
public class ResultDataUtil {

    /**
     * 检查返回结果是否有错误, 如果有错则弹窗提示
     *
     * @param jsonObject ResultData 转换成的Json对象
     * @return boolean
     */
    public static Boolean ifSuccess(Context context, JSONObject jsonObject) throws Exception {

        if(jsonObject == null){
            AlertWindow.httpRequestNullError(context);
            return false;
        }

        if(!jsonObject.getString("resultCode").equals(context.getResources().getString(R.string.http_result_code_success))){
            AlertWindow.httpRequestError(context, jsonObject.getString("resultMessage"));
            return false;
        }

        return true;
    }
}
