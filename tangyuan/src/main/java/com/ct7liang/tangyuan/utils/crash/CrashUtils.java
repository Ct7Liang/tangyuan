package com.ct7liang.tangyuan.utils.crash;

import android.content.Context;
import com.ct7liang.tangyuan.AppFolder;
import java.io.File;

/**
 * Created by Administrator on 2018-05-07.
 *
 */
public class CrashUtils {

    public static void init(Context applicationContext){
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(applicationContext, new File(AppFolder.get()+"/crash_log"));
    }
}