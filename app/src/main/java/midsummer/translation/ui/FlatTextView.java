package midsummer.translation.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import midsummer.translation.R;

public class FlatTextView extends TextView implements Attributes.AttributeChangeListener
{

    private Attributes attributes;

    private int textColor = 2;
    private int backgroundColor = Attributes.INVALID;
    private int customBackgroundColor = Attributes.INVALID;

    private boolean hasOwnTextColor;

    public FlatTextView(Context context)
    {
        super(context);
        init(null);
    }

    public FlatTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(attrs);
    }

    public FlatTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void init(AttributeSet attrs)
    {

        if (attributes == null)
            attributes = new Attributes(this, getResources());

        if (attrs != null)
        {
            // getting android default tags for textColor and textColorHint
            // 获得Android的textColor和textColorHint标签
            String textColorAttribute = attrs.getAttributeValue(FlatUI.androidStyleNameSpace, "textColor");
            int styleId = attrs.getStyleAttribute();
            int[] attributesArray = new int[]{android.R.attr.textColor};
            TypedArray styleTextColorTypedArray = getContext().obtainStyledAttributes(styleId, attributesArray);
            // color might have values from the entire integer range, so to find out if there is any color set,
            // checking if default value is returned is not enough. Thus we get color with two different 
            // default values - if returned value is the same, it means color is set
            /*
             * 颜色可能值从整个整数范围内,所以找出是否有任何颜色,检查返回的默认值是不够的。因此我们得到颜色有两个不同的默认值,如果返回值是相同的,这意味着设置颜色
             */
            int styleTextColor1 = styleTextColorTypedArray.getColor(0, -1);
            int styleTextColor2 = styleTextColorTypedArray.getColor(0, 1);
            hasOwnTextColor = textColorAttribute != null || styleTextColor1 == styleTextColor2;
            styleTextColorTypedArray.recycle();

            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.fl_FlatTextView);

            // getting common attributes
            // 获得公共属性
            int customTheme = a.getResourceId(R.styleable.fl_FlatTextView_fl_theme, Attributes.DEFAULT_THEME);
            attributes.setThemeSilent(customTheme, getResources());

            attributes.setFontFamily(a.getString(R.styleable.fl_FlatTextView_fl_fontFamily));
            attributes.setFontWeight(a.getString(R.styleable.fl_FlatTextView_fl_fontWeight));
            attributes.setFontExtension(a.getString(R.styleable.fl_FlatTextView_fl_fontExtension));

            attributes.setRadius(a.getDimensionPixelSize(R.styleable.fl_FlatTextView_fl_cornerRadius, Attributes.DEFAULT_RADIUS_PX));
            attributes.setBorderWidth(a.getDimensionPixelSize(R.styleable.fl_FlatTextView_fl_borderWidth, 0));

            // getting view specific attributes
            // 获得view特定属性
            textColor = a.getInt(R.styleable.fl_FlatTextView_fl_textColor, textColor);
            backgroundColor = a.getInt(R.styleable.fl_FlatTextView_fl_backgroundColor, backgroundColor);
            customBackgroundColor = a.getInt(R.styleable.fl_FlatTextView_fl_customBackgroundColor, customBackgroundColor);

            a.recycle();
        }

        GradientDrawable gradientDrawable = new GradientDrawable();
        if (backgroundColor != Attributes.INVALID)
        {
            gradientDrawable.setColor(attributes.getColor(backgroundColor));
        } else if (customBackgroundColor != Attributes.INVALID)
        {
            gradientDrawable.setColor(customBackgroundColor);
        } else
        {
            gradientDrawable.setColor(Color.TRANSPARENT);
        }
        gradientDrawable.setCornerRadius(attributes.getRadius());
        gradientDrawable.setStroke(attributes.getBorderWidth(), attributes.getColor(textColor));
        setBackground(gradientDrawable);

        // setting the text color only if there is no android:textColor attribute used
        // 如果没有使用android:textColor属性则设置文本颜色
        if (!hasOwnTextColor) setTextColor(attributes.getColor(textColor));

        // check for IDE preview render
        // 检查IDE的预览渲染
        if (!this.isInEditMode())
        {
            Typeface typeface = FlatUI.getFont(getContext(), attributes);
            if (typeface != null) setTypeface(typeface);
        }
    }

    public Attributes getAttributes()
    {
        return attributes;
    }

    @Override
    public void onThemeChange()
    {
        init(null);
    }
}
