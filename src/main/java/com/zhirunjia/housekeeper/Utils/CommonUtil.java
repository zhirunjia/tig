package com.zhirunjia.housekeeper.Utils;

import java.util.Map;

import android.content.Context;

import com.zhirunjia.housekeeper.Domain.Constants.GlobalVarable;

/**
 * Created by Xu wenQiang on 14-6-16.
 */
public class CommonUtil {

    private static String TAG = "CommonUtil";

    /**
     * 未登录重置
     *
     * @param context 当前窗口
     */
    public static void ifLogIn(Context context, Class<?> cls) {
        /*Login login = (Login) getGlobalAppVal(GlobalVarable.GLOBAL_APP_DATA_KEY_LOGIN);
        if (login == null
                || (TextUtils.isEmpty(login.getAccount()) && !login.getIsLogin())) {
            Intent intent = new Intent(context, cls);
            context.startActivity(intent);
        }*/
    }

    /**
     * 获取GlobalAppData对象
     * <p/>
     * return GlobalAppData
     */
    private static Map<String, Object> getGlobalAppObject() {
        //Log.i(TAG, "getGlobalAppObject: " + GlobalVarable.staticMap.toString());
        return GlobalVarable.staticMap;
    }

    /**
     * 获取全局变量内的对象
     *
     * @param key 全局变量的KEY
     * @return Object
     */
    public static Object getGlobalAppVal(String key) {
        return getGlobalAppObject().get(key);
    }

    /**
     * 设置全局变量内的对象
     *
     * @param key 全局变量的KEY
     * @return void
     */
    public static void setGlobalAppVal(String key, Object val) {
        getGlobalAppObject().put(key, val);
    }

}
