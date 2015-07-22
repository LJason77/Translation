package midsummer.translation.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class RippleLinearLayout extends LinearLayout
{
    private TouchEffectAnimator touchEffectAnimator;

    public RippleLinearLayout(Context context)
    {
        super(context);
        init();
    }

    public RippleLinearLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    private void init()
    {
        // you should set a background to view for effect to be visible. in this sample, this
        // linear layout contains a transparent background which is set inside the XML
        /*
         * 你应该设置一个背景可见视图效果。在本例中,这个线性布局包含一个透明背景设置在XML
         */

        // giving the view to animate on
        // 产生动画视图
        touchEffectAnimator = new TouchEffectAnimator(this);

        // enabling ripple effect. it only performs ease effect without enabling ripple effect
        // 使连锁反应。它只执行缓解效果没有启用涟漪效应
        touchEffectAnimator.setHasRippleEffect(true);

        // setting the effect color
        // 设置颜色效果
        touchEffectAnimator.setEffectColor(Color.LTGRAY);

        // setting the duration
        // 设置持续时间
        touchEffectAnimator.setAnimDuration(1000);

        // setting radius to clip the effect. use it if you have a rounded background
        // 设置半径剪辑的效果。如果你有一个圆形的背景则使用它
        touchEffectAnimator.setClipRadius(20);

        // the view must contain an onClickListener to receive UP touch events. touchEffectAnimator
        // doesn't return any value in onTouchEvent for flexibility. so it is developers
        // responsibility to add a listener
        /*
         * 视图必须包含onClickListener接收触摸事件，在onTouchEvent，touchEffectAnimator不会返回任何值的灵活性，所以添加一个listener是开发人员的责任
         */
        setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
            }
        });
    }

    @Override
    public boolean onTouchEvent(@NonNull final MotionEvent event)
    {
        // send the touch event to animator
        touchEffectAnimator.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        // let animator show the animation by applying changes to view's canvas
        // 让动画师给动画通过应用更改视图的画布
        touchEffectAnimator.onDraw(canvas);
        super.onDraw(canvas);
    }
}
