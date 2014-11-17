package com.zhirunjia.housekeeper.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson JSON 工具
 * User: Xu wenQiang
 * Date: 13-7-11
 * Time: 上午10:00
 */
public class JacksonMapperHelper {

    private static Object lock = new Object();

    private static ObjectMapper instance;

    private JacksonMapperHelper() {
    }

    public static ObjectMapper getInstance() {

        if (null != instance) {
            return instance;
        }

        //用同步代码块替代方法同步，提高效率，因为绝大部分调用不必进入同步块
        synchronized (lock) {
            //二次空校验，在有两个及以及并发调用时，避免实例被重复创建
            if (null == instance) {
                //声明一个局部变更，避免因构造函数执行期内，并发调用会返回一个未构造完成的实例引用
                ObjectMapper tempObject = new ObjectMapper();
                instance = tempObject;
            }
        }

        return instance;
    }

}
