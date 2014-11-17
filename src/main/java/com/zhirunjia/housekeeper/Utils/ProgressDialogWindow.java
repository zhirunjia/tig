package com.zhirunjia.housekeeper.Utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.zhirunjia.housekeeper.Activity.R;

/**
 * Created by Xu wenQiang on 14-5-28.
 */
public class ProgressDialogWindow {

    /**
     * 显示
     *
     * @param context
     * @param title 标题
     * @param message 消息
     * @return ProgressDialog
     */
    public static ProgressDialog open(Context context, String title, String message){
        return ProgressDialog.show(context, title, message, true, false);
    }

    /**
     * 显示
     *
     * @param context
     * @return ProgressDialog
     */
    public static ProgressDialog open(Context context){
        return ProgressDialog.show(context, context.getResources().getString(R.string.progress_dialog_title), context.getResources().getString(R.string.progress_dialog_message), true, true);
    }

    /**
     * 关闭
     *
     * @param progressDialog
     */
    public static void close(ProgressDialog progressDialog){
        progressDialog.dismiss();
    }
}
