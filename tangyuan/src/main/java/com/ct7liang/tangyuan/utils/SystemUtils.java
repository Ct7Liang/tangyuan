package com.ct7liang.tangyuan.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Administrator on 2018-04-11.
 *
 */
public class SystemUtils {

    /** 
     * 获取手机IMEI(需要权限<uses-permission android:name="android.permission.READ_PHONE_STATE"/>) 
     * @return 手机IMEI
     */
    public static String getIMEI(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Activity.TELEPHONY_SERVICE);
        if (tm != null) {
            return tm.getDeviceId();
        }
        return null;
    }

    public static final String PHONE_BRAND = Build.BRAND;
    public static final String PHONE_MODEL = Build.MODEL;
    public static final String PHONE_PRODUCT = Build.PRODUCT;
    public static final int PHONE_RELEASE = Build.VERSION.SDK_INT;

    /**
     * 隐藏输入键盘
     */
    public static void hideSoftInput(EditText view, Context context) {
        InputMethodManager inputMeMana = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMeMana.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 显示软键盘
     */
    public static void showSoftInput(Context context) {
        InputMethodManager inputMeMana = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMeMana.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
    }



//    /**
//     * 获取 ANDROID_ID
//     */
//    public static String getAndroidId(Context context) {
//        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
//        return androidId;
//    }


//    @NonNull
//    public static String printSystemInfo() {
//        Date date = new Date(System.currentTimeMillis());
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = dateFormat.format(date);
//        StringBuilder sb = new StringBuilder();
//        sb.append("_______  系统信息  ").append(time).append(" ______________");
//        sb.append("\nID                 :").append(Build.ID);
//        sb.append("\nBRAND              :").append(Build.BRAND);
//        sb.append("\nMODEL              :").append(Build.MODEL);
//        sb.append("\nRELEASE            :").append(Build.VERSION.RELEASE);
//        sb.append("\nSDK                :").append(Build.VERSION.SDK);
//        sb.append("\n_______ OTHER _______");
//        sb.append("\nBOARD              :").append(Build.BOARD);
//        sb.append("\nPRODUCT            :").append(Build.PRODUCT);
//        sb.append("\nDEVICE             :").append(Build.DEVICE);
//        sb.append("\nFINGERPRINT        :").append(Build.FINGERPRINT);
//        sb.append("\nHOST               :").append(Build.HOST);
//        sb.append("\nTAGS               :").append(Build.TAGS);
//        sb.append("\nTYPE               :").append(Build.TYPE);
//        sb.append("\nTIME               :").append(Build.TIME);
//        sb.append("\nINCREMENTAL        :").append(Build.VERSION.INCREMENTAL);
//        sb.append("\n_______ CUPCAKE-3 _______");
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
//            sb.append("\nDISPLAY            :").append(Build.DISPLAY);
//        }
//        sb.append("\n_______ DONUT-4 _______");
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
//            sb.append("\nSDK_INT            :").append(Build.VERSION.SDK_INT);
//            sb.append("\nMANUFACTURER       :").append(Build.MANUFACTURER);
//            sb.append("\nBOOTLOADER         :").append(Build.BOOTLOADER);
//            sb.append("\nCPU_ABI            :").append(Build.CPU_ABI);
//            sb.append("\nCPU_ABI2           :").append(Build.CPU_ABI2);
//            sb.append("\nHARDWARE           :").append(Build.HARDWARE);
//            sb.append("\nUNKNOWN            :").append(Build.UNKNOWN);
//            sb.append("\nCODENAME           :").append(Build.VERSION.CODENAME);
//        }
//        sb.append("\n_______ GINGERBREAD-9 _______");
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
//            sb.append("\nSERIAL             :").append(Build.SERIAL);
//        }
//        return sb.toString();
//    }
}
