package midsummer.translation;

import android.app.ProgressDialog;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.autoupdatesdk.BDAutoUpdateSDK;
import com.baidu.autoupdatesdk.UICheckUpdateCallback;

import net.youmi.android.AdManager;
import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;
import net.youmi.android.banner.AdViewListener;

public class About extends AppCompatActivity implements View.OnClickListener
{

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        AdManager.getInstance(this).setEnableDebugLog(false);
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        BDAutoUpdateSDK.silenceUpdateAction(this);

        dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);

        TextView versionName = (TextView) findViewById(R.id.version);
        versionName.setText(getVersion());

        findViewById(R.id.version).setOnClickListener(this);
        findViewById(R.id.support).setOnClickListener(this);

        TextView developer = (TextView) findViewById(R.id.developer);
        //创建一个 SpannableString对象
        SpannableString qq = new SpannableString("作者QQ：951203598");
        //设置超链接
        qq.setSpan(new URLSpan("http://qm.qq.com/cgi-bin/qm/qr?k=-0A4UCeLbqT2fqA2uVTcXoHtFXW36tE7"), 5, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //SpannableString对象设置给TextView
        developer.setText(qq);
        //设置TextView可点击
        developer.setMovementMethod(LinkMovementMethod.getInstance());

        TextView group = (TextView) findViewById(R.id.group);
        //创建一个 SpannableString对象
        SpannableString q = new SpannableString("QQ反馈群：247708078");
        //设置超链接
        q.setSpan(new URLSpan("http://qm.qq.com/cgi-bin/qm/qr?k=Oi8I9tFyxfvyOugCzIAfLotzC0GZBTIf"), 6, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //SpannableString对象设置给TextView
        group.setText(q);
        //设置TextView可点击
        group.setMovementMethod(LinkMovementMethod.getInstance());

        //广告
        // 实例化广告条
        AdView adView = new AdView(this, AdSize.FIT_SCREEN);
        // 获取要嵌入广告条的布局
        LinearLayout adLayout = (LinearLayout) findViewById(R.id.adLayout);
        // 将广告条加入到布局中
        adLayout.addView(adView);
        adView.setAdListener(new AdViewListener()
        {
            @Override
            public void onSwitchedAd(AdView adView)
            {
                // 切换广告并展示
            }

            @Override
            public void onReceivedAd(AdView adView)
            {
                // 请求广告成功
            }

            @Override
            public void onFailedToReceivedAd(AdView adView)
            {
                // 请求广告失败
            }
        });
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.version:
                dialog.show();
                BDAutoUpdateSDK.uiUpdateAction(this, new Update());
                break;
            case R.id.support:
                break;
            default:
                break;
        }
    }

    private String getVersion()
    {
        try
        {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            return this.getString(R.string.version) + version;
        } catch (Exception e)
        {
            e.printStackTrace();
            return this.getString(R.string.version);
        }
    }

    private class Update implements UICheckUpdateCallback
    {
        @Override
        public void onCheckComplete()
        {
            dialog.dismiss();
        }
    }
}
