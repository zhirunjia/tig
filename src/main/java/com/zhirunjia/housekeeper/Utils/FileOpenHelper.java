package com.zhirunjia.housekeeper.Utils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Xu wenQiang on 2014/5/7.
 */
public class FileOpenHelper {

    public static final String DB_PATH = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/database";

    public static final String DB_NAME = DB_PATH + File.separator + "housekeeper.db";

    static {
        if (android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState())) {
            File dbp = new File(DB_PATH);
            if (!dbp.exists()) {
                System.out.println(DB_NAME);
                System.out.println("开始在SD卡上建立数据库目录.....");
                dbp.mkdirs();
            }
        }
    }

    public static boolean isExists() {
        return new File(DB_NAME).exists() ? true : false;
    }

    public static File downLoadFile(String httpUrl, String updatePath, String fileName) throws Exception {
        File tmpFile = new File(updatePath);
        if (!tmpFile.exists()) {
            tmpFile.mkdir();
        }
        final File file = new File(updatePath + File.separator + fileName);
        URL url = new URL(httpUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream is = conn.getInputStream();
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buf = new byte[256];
        conn.connect();
        double count = 0;
        if (conn.getResponseCode() >= 400) {
            System.out.println("连接超时");
        } else {
            while (count <= 100) {
                if (is != null) {
                    int numRead = is.read(buf);
                    if (numRead <= 0) {
                        break;
                    } else {
                        fos.write(buf, 0, numRead);
                    }
                } else {
                    break;
                }
            }
        }
        conn.disconnect();
        fos.close();
        is.close();
        return file;
    }
}
