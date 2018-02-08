package com.ct7liang.tangyuan;

import android.os.Environment;
import java.io.File;

/**
 * Created by Administrator on 2018-02-08.
 *
 */
public class AppFolder {

    private static File mFile;

    /**
     * 创建app文件夹
     */
    public static void createAppFolder(String folderName){
        if (folderName != null){
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                mFile = new File(sdPath, folderName);
                if (!mFile.exists()){
                    try{
                        mFile.mkdirs();
                    }catch(Exception e){
                        //防止读写sd卡造成的权限问题,而崩溃
                    }
                }
            }
        }
    }

    /**
     * @return 返回App文件夹(File)
     */
    public static File get(){
        if (mFile != null){
            return mFile;
        }else{
            return null;
        }
    }
}
