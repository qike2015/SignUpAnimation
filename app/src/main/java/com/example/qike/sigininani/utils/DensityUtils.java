package com.example.qike.sigininani.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * 单位转换的辅助类
 */
public class DensityUtils
{

    private DensityUtils()
    {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * dp转px
     */
    public static int dp2px(Context context, float dp)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources()
                .getDisplayMetrics());
    }

    /**
     * sp转px
     */
    public static int sp2px(Context context, float spVal)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, context.getResources()
                .getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @return
     */
    public static float px2dp(Context context, float pxVal)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * 获取屏幕像素密度
     */
    public static float getDesity(Context context)
    {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * px转sp
     *
     * @return
     */
    public static float px2sp(Context context, float pxVal)
    {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }

}
