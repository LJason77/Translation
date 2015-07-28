package midsummer.translation;
/*
 * 主页
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.autoupdatesdk.BDAutoUpdateSDK;
import com.baidu.autoupdatesdk.UICheckUpdateCallback;

public class Bases extends AppCompatActivity implements View.OnClickListener
{
	private ProgressDialog dialog;
	//声明两个变量
    private String lett = "";
    private String jian = "";

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

	private static void copy(String content, Context context)
	{
		// 得到剪贴板管理器
		@SuppressWarnings("deprecation") ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
		cmb.setText(content.trim());
	}

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bases);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //百度
        PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, "blaIiCECLxYpAkvN3ymDd1EM");
		//百度升级
		BDAutoUpdateSDK.silenceUpdateAction(this);
		dialog = new ProgressDialog(this);
		dialog.setIndeterminate(true);

        // 打開 up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        // 實作 drawer toggle 並放入 toolbar
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.open,R.string.close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

		//获得版本号
		TextView versionName = (TextView) findViewById(R.id.version);
		//设置关于页的版本号
		versionName.setText(getVersion());
		findViewById(R.id.version).setOnClickListener(this);

		//显示文字并设置链接
		TextView developer = (TextView) findViewById(R.id.developer);
		//创建一个 SpannableString对象
		SpannableString qq = new SpannableString("作者QQ：951203598");
		//设置超链接
		qq.setSpan(new URLSpan("http://qm.qq.com/cgi-bin/qm/qr?k=-0A4UCeLbqT2fqA2uVTcXoHtFXW36tE7"), 5, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//SpannableString对象设置给TextView
		developer.setText(qq);
		//设置TextView可点击
		developer.setMovementMethod(LinkMovementMethod.getInstance());

		//显示文字并设置链接
		TextView group = (TextView) findViewById(R.id.group);
		//创建一个 SpannableString对象
		SpannableString q = new SpannableString("QQ反馈群：247708078");
		//设置超链接
		q.setSpan(new URLSpan("http://qm.qq.com/cgi-bin/qm/qr?k=Oi8I9tFyxfvyOugCzIAfLotzC0GZBTIf"), 6, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//SpannableString对象设置给TextView
		group.setText(q);
		//设置TextView可点击
		group.setMovementMethod(LinkMovementMethod.getInstance());

		//显示文字并设置链接
		TextView github = (TextView) findViewById(R.id.github);
		//创建一个 SpannableString对象
		SpannableString git = new SpannableString("获得源码：Translation");
		//设置超链接
		git.setSpan(new URLSpan("https://github.com/18312847646/Translation.git"), 5, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//SpannableString对象设置给TextView
		github.setText(git);
		//设置TextView可点击
		github.setMovementMethod(LinkMovementMethod.getInstance());
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // 为ActionBar扩展菜单项
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bases, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // 处理动作按钮的点击事件
        switch (item.getItemId())
        {
			case R.id.score:
				Uri uri = Uri.parse("market://details?id="+getPackageName());
				Intent intent = new Intent(Intent.ACTION_VIEW,uri);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
                return true;
			case R.id.theme:
                return true;
/*            case R.id.about:
                Intent intenta = new Intent(this, About.class);
                startActivity(intenta);
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

	//获得版本号
	private String getVersion()
	{
		try
		{
			PackageManager manager = this.getPackageManager();
			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
			String version = info.versionName;
			return this.getString(R.string.version) + version;
		} catch(Exception e)
		{
			e.printStackTrace();
			return this.getString(R.string.version);
		}
	}

	//点击版本号升级
	public void onClick(View v)
	{
		switch(v.getId())
		{
			case R.id.version:
				dialog.show();
				BDAutoUpdateSDK.uiUpdateAction(this, new Update());
				break;
			default:
				break;
		}
	}

    //以下都是button
    public void Qing(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        TextView jj = (TextView) findViewById(R.id.jj);
        lett = "";
        jian = "";
        letter.setText(lett);
        jj.setText(jian);
    }

    public void Fu(View v)
    {
        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        Bases.copy(jian, getBaseContext());
        Toast.makeText(getBaseContext(), "文本已复制到粘贴板", Toast.LENGTH_SHORT).show();

    }

    public void Q(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("Q");
        letter.setText(lett);

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat("Q");
        jj.setText(jian);
    }

    public void W(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("W");
        letter.setText(lett);

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat("W");
        jj.setText(jian);
    }

    public void E(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("E");
        letter.setText(lett);

        String[] sjsz = {"UUA", "UUG", "CUU", "CUC", "CUA", "CUG"};
        int sjs = (int) (Math.random() * 6);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void R(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("R");
        letter.setText(lett);

        String[] sjsz = {"CCU", "CCC", "CCA", "CCG"};
        int sjs = (int) (Math.random() * 4);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void T(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("T");
        letter.setText(lett);

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat("UGG");
        jj.setText(jian);
    }

    public void Y(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("Y");
        letter.setText(lett);

        String[] sjsz = {"AAA", "AAG"};
        int sjs = (int) (Math.random() * 2);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void U(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("U");
        letter.setText(lett);

        String[] sjsz = {"CAA", "CAG"};
        int sjs = (int) (Math.random() * 2);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void I(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("I");
        letter.setText(lett);

        String[] sjsz = {"AUU", "AUC", "AUA"};
        int sjs = (int) (Math.random() * 3);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void O(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("O");
        letter.setText(lett);

        String[] sjsz = {"UAU", "UAC"};
        int sjs = (int) (Math.random() * 2);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void P(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("P");
        letter.setText(lett);

        String[] sjsz = {"UUC", "UUU"};
        int sjs = (int) (Math.random() * 2);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void A(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("A");
        letter.setText(lett);

        String[] sjsz = {"GAU", "GAC"};
        int sjs = (int) (Math.random() * 2);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void S(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("S");
        letter.setText(lett);

        String[] sjsz = {"AAU", "AAC"};
        int sjs = (int) (Math.random() * 2);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void D(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("D");
        letter.setText(lett);

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat("AUG");
        jj.setText(jian);
    }

    public void F(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("F");
        letter.setText(lett);

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat("F");
        jj.setText(jian);
    }

    public void G(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("G");
        letter.setText(lett);

        String[] sjsz = {"GAA", "GAG"};
        int sjs = (int) (Math.random() * 2);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void H(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("H");
        letter.setText(lett);

        String[] sjsz = {"CAU", "CAC"};
        int sjs = (int) (Math.random() * 2);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void J(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("J");
        letter.setText(lett);

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat("J");
        jj.setText(jian);
    }

    public void K(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("K");
        letter.setText(lett);

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat("K");
        jj.setText(jian);
    }

    public void L(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("L");
        letter.setText(lett);

        String[] sjsz = {"ACU", "ACC", "ACA", "ACG"};
        int sjs = (int) (Math.random() * 4);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void Z(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("Z");
        letter.setText(lett);

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat("Z");
        jj.setText(jian);
    }

    public void X(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("X");
        letter.setText(lett);

        String[] sjsz = {"UCU", "UCC", "UCA", "UCG"};
        int sjs = (int) (Math.random() * 4);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void C(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("C");
        letter.setText(lett);

        String[] sjsz = {"GGU", "GGC", "GGA", "GGG"};
        int sjs = (int) (Math.random() * 4);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void V(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("V");
        letter.setText(lett);

        String[] sjsz = {"GUU", "GUC", "GUA", "GUG"};
        int sjs = (int) (Math.random() * 4);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void B(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("B");
        letter.setText(lett);

        String[] sjsz = {"UGU", "UGC"};
        int sjs = (int) (Math.random() * 2);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void N(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("N");
        letter.setText(lett);

        String[] sjsz = {"CGU", "CGC", "CGA", "CGG"};
        int sjs = (int) (Math.random() * 4);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

    public void M(View v)
    {
        TextView letter = (TextView) findViewById(R.id.letter);
        lett = letter.getText().toString();
        lett = lett.concat("M");
        letter.setText(lett);

        String[] sjsz = {"GCU", "GCC", "GCA", "GCG"};
        int sjs = (int) (Math.random() * 4);
        String p = sjsz[sjs];

        TextView jj = (TextView) findViewById(R.id.jj);
        jian = jj.getText().toString();
        jian = jian.concat(p);
        jj.setText(jian);
    }

	//升级
	private class Update implements UICheckUpdateCallback
	{
		@Override
		public void onCheckComplete()
		{
			dialog.dismiss();
		}
	}
}
