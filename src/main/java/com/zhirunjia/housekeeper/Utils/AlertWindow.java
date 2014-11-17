package com.zhirunjia.housekeeper.Utils;

import android.app.AlertDialog;
import android.content.Context;

import com.zhirunjia.housekeeper.Activity.R;

/**
 * Created by Xu wenQiang on 14-5-20.
 */
public class AlertWindow {

    /**
     * 弹窗提示
     *
     * @param context
     * @param title 弹窗标题
     * @param message 弹窗消息
     */
    public static void dialog(Context context, String title, String message){
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("确定", null)
                .show();
    }

    /**
     * 格式验证错误弹窗提示
     *
     * @param context
     * @param message 提示信息
     */
    public static void formatCheckErrorDialog(Context context, String message){
        dialog(context, context.getResources().getString(R.string.format_check_result_error_title), message);
    }

    /**
     * 未填写弹窗提示
     *
     * @param context
     * @param message 提示信息
     */
    public static void isNullDialog(Context context, String message){
        dialog(context, context.getResources().getString(R.string.is_null_check_result_title), message);
    }

    /**
     * HTTP请求出现异常提示
     *
     * @param context
     * @pram message 提示信息
     */
    public static void httpRequestError(Context context, String message){
        dialog(context,context.getResources().getString(R.string.http_request_error_title), message);
    }

    /**
     * HTTP请求结果为NULL
     *
     * @param context
     * @pram message 提示信息
     */
    public static void httpRequestNullError(Context context, String message){
        dialog(context,context.getResources().getString(R.string.http_request_error_title), message);
    }

    /**
     * HTTP请求出现异常提示
     *
     * @pram message 提示信息
     * @param context
     */
    public static void httpRequestNullError(Context context){
        dialog(context,context.getResources().getString(R.string.http_request_error_title), context.getResources().getString(R.string.http_request_fail_error));
    }

    /**
     * 登录出错提示
     *
     * @param context
     * @param message 提示信息
     */
    public static void loginError(Context context, String message){
        dialog(context, context.getResources().getString(R.string.login_fail_title), message);
    }

    /**
     * 未选择错误提示
     *
     * @param context
     * @param message 提示信息
     */
    public static void uncheckedError(Context context, String message){
        dialog(context, context.getResources().getString(R.string.unchecked_error_title), message);
    }

}
