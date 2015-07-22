package midsummer.translation.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import midsummer.translation.R;

/**
 * This class contains some util methods and keeps theme constants.
 * 这个类包含了一些实效的方法,使主题常量。
 */
public class FlatUI
{
    public static final String androidStyleNameSpace = "http://schemas.android.com/apk/res/android";

    public static final int SAND = R.array.sand;
    public static final int ORANGE = R.array.orange;
    public static final int CANDY = R.array.candy;
    public static final int BLOSSOM = R.array.blossom;
    public static final int GRAPE = R.array.grape;
    public static final int DEEP = R.array.deep;
    public static final int SKY = R.array.sky;
    public static final int GRASS = R.array.grass;
    public static final int DARK = R.array.dark;
    public static final int SNOW = R.array.snow;
    public static final int SEA = R.array.sea;
    public static final int BLOOD = R.array.blood;

    public static void initDefaultValues(Context context)
    {

        Attributes.DEFAULT_BORDER_WIDTH_PX = (int) dipToPx(context, Attributes.DEFAULT_BORDER_WIDTH_DP);
        Attributes.DEFAULT_RADIUS_PX = (int) dipToPx(context, Attributes.DEFAULT_RADIUS_DP);
        Attributes.DEFAULT_SIZE_PX = (int) dipToPx(context, Attributes.DEFAULT_SIZE_DP);
    }

    public static Typeface getFont(Context context, Attributes attributes)
    {

        String fontPath = "fonts/" + attributes.getFontFamily()
                + "_" + attributes.getFontWeight()
                + "." + attributes.getFontExtension();
        return Typeface.createFromAsset(context.getAssets(), fontPath);

/*        try
        {
            return Typeface.createFromAsset(context.getAssets(), fontPath);
        } catch (Exception e)
        {
            return null;
        }
*/
    }

    public static Drawable getActionBarDrawable(Activity activity, int theme, boolean dark)
    {
        return getActionBarDrawable(activity, theme, dark, 0);
    }


    public static Drawable getActionBarDrawable(Activity activity, int theme, boolean dark, float borderBottom)
    {
        int[] colors = activity.getResources().getIntArray(theme);

        int color1 = colors[2];
        int color2 = colors[1];

        if (dark)
        {
            color1 = colors[1];
            color2 = colors[0];
        }

        borderBottom = dipToPx(activity, borderBottom);

        PaintDrawable front = new PaintDrawable(color1);
        PaintDrawable bottom = new PaintDrawable(color2);
        Drawable[] d = {bottom, front};
        LayerDrawable drawable = new LayerDrawable(d);
        drawable.setLayerInset(1, 0, 0, 0, (int) borderBottom);
        return drawable;
    }

    public static void setDefaultTheme(int theme)
    {
        Attributes.DEFAULT_THEME = theme;
    }

    private static float dipToPx(Context context, float dp)
    {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics);
    }
}