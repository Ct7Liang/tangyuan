package com.ct7liang.tangyuan.utils;

import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2018-02-24.
 *
 */
public class FileUtils {

    public static void write(String filePath, String content, boolean append) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath, append);
            fos.write(content.getBytes());
            fos.close();
        } catch (Exception e) {
            LogUtils.write("数据写入失败 异常:" + e.toString());
        }
    }

    @NonNull
    public static String read(File file){
        int len=0;
        StringBuffer str = new StringBuffer("");
        try {
            FileInputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader in = new BufferedReader(isr);
            String line;
            while( (line=in.readLine()) != null ){
                // 处理换行符的问题
                if(len != 0){
                    str.append("\r\n"+line);
                }else{
                    str.append(line);
                }
                len++;
            }
            in.close();
            is.close();
        } catch (IOException e) {
            LogUtils.write("数据读取失败 异常:" + e.toString());
        }
        return str.toString();
    }

}