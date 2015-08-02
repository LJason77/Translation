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
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

import java.util.List;

@EActivity(R.layout.bases)
public class Bases extends AppCompatActivity
{
	// 初始化toolbar
	@ViewById(R.id.toolbar)
	Toolbar toolbar;
	// 初始化字母
	@ViewById
	TextView letter;
	// 初始化碱基
	@ViewById
	TextView bases;
	// 初始化版本号
	@ViewById
	TextView version;
	// 初始化按钮
	@ViewsById({R.id.q , R.id.w , R.id.e , R.id.r , R.id.t , R.id.y , R.id.u , R.id.i , R.id.o , R.id.p , R.id.a , R.id.s , R.id.d , R.id.f ,
			R.id.g , R.id.h , R.id.j , R.id.k , R.id.l , R.id.z , R.id.x , R.id.c , R.id.v , R.id.b , R.id.n , R.id.m , R.id.clear , R.id.copy ,})
	List<Button> mButtons;
	// 初始化侧边栏
	@ViewById
	DrawerLayout drawer;
	// 初始化开发者
	@ViewById
	TextView developer;
	// 初始化群
	@ViewById
	TextView group;
	// 初始化源码
	@ViewById
	TextView github;
	private ProgressDialog dialog;

	private static void copy(String content, Context context)
	{
		// 得到剪贴板管理器
		@SuppressWarnings("deprecation") ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
		cmb.setText(content.trim());
	}

	/**
	 * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
	 *
	 * @return 返回状态栏高度的像素值。
	 */
	public static int getStatusBarHeight(Context context)
	{
		int result = 0;
		int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
		if(resourceId > 0)
		{
			result = context.getResources().getDimensionPixelSize(resourceId);
		}
		return result;
	}

	@Click({R.id.q , R.id.w , R.id.e , R.id.r , R.id.t , R.id.y , R.id.u , R.id.i , R.id.o , R.id.p , R.id.a , R.id.s , R.id.d , R.id.f ,
			R.id.g , R.id.h , R.id.j , R.id.k , R.id.l , R.id.z , R.id.x , R.id.c , R.id.v , R.id.b , R.id.n , R.id.m , R.id.clear , R.id.copy ,})
	public void button(View view)
	{
		switch(view.getId())
		{
			case R.id.copy:
				String jian = bases.getText().toString();
				Bases.copy(jian, getBaseContext());
				Toast.makeText(getBaseContext(), R.string.copy, Toast.LENGTH_SHORT).show();
				break;
			case R.id.clear:
				String lett = "";
				jian = "";
				letter.setText(lett);
				bases.setText(jian);
				break;
			case R.id.q:
				lett = letter.getText().toString();
				lett = lett.concat("Q");
				letter.setText(lett);

				jian = bases.getText().toString();
				jian = jian.concat("Q");
				bases.setText(jian);
				break;
			case R.id.w:
				lett = letter.getText().toString();
				lett = lett.concat("W");
				letter.setText(lett);

				jian = bases.getText().toString();
				jian = jian.concat("W");
				bases.setText(jian);
				break;
			case R.id.e:
				lett = letter.getText().toString();
				lett = lett.concat("E");
				letter.setText(lett);

				String[] se = {"UUA" , "UUG" , "CUU" , "CUC" , "CUA" , "CUG"};
				int e = (int) (Math.random() * 6);
				String s_e = se[e];

				jian = bases.getText().toString();
				jian = jian.concat(s_e);
				bases.setText(jian);
				break;
			case R.id.r:
				lett = letter.getText().toString();
				lett = lett.concat("R");
				letter.setText(lett);

				String[] sr = {"CCU" , "CCC" , "CCA" , "CCG"};
				int r = (int) (Math.random() * 4);
				String s_r = sr[r];

				jian = bases.getText().toString();
				jian = jian.concat(s_r);
				bases.setText(jian);
				break;
			case R.id.t:
				lett = letter.getText().toString();
				lett = lett.concat("T");
				letter.setText(lett);

				jian = bases.getText().toString();
				jian = jian.concat("UGG");
				bases.setText(jian);
				break;
			case R.id.y:
				lett = letter.getText().toString();
				lett = lett.concat("Y");
				letter.setText(lett);

				String[] sy = {"AAA" , "AAG"};
				int y = (int) (Math.random() * 2);
				String s_y = sy[y];

				jian = bases.getText().toString();
				jian = jian.concat(s_y);
				bases.setText(jian);
				break;
			case R.id.u:
				lett = letter.getText().toString();
				lett = lett.concat("U");
				letter.setText(lett);

				String[] su = {"CAA" , "CAG"};
				int u = (int) (Math.random() * 2);
				String s_u = su[u];

				jian = bases.getText().toString();
				jian = jian.concat(s_u);
				bases.setText(jian);
				break;
			case R.id.i:
				lett = letter.getText().toString();
				lett = lett.concat("I");
				letter.setText(lett);

				String[] si = {"AUU" , "AUC" , "AUA"};
				int i = (int) (Math.random() * 3);
				String s_i = si[i];

				jian = bases.getText().toString();
				jian = jian.concat(s_i);
				bases.setText(jian);
				break;
			case R.id.o:
				lett = letter.getText().toString();
				lett = lett.concat("O");
				letter.setText(lett);

				String[] so = {"UAU" , "UAC"};
				int o = (int) (Math.random() * 2);
				String s_o = so[o];

				jian = bases.getText().toString();
				jian = jian.concat(s_o);
				bases.setText(jian);
				break;
			case R.id.p:
				lett = letter.getText().toString();
				lett = lett.concat("P");
				letter.setText(lett);

				String[] sp = {"UUC" , "UUU"};
				int p = (int) (Math.random() * 2);
				String s_p = sp[p];

				jian = bases.getText().toString();
				jian = jian.concat(s_p);
				bases.setText(jian);
				break;
			case R.id.a:
				lett = letter.getText().toString();
				lett = lett.concat("A");
				letter.setText(lett);

				String[] sa = {"GAU" , "GAC"};
				int a = (int) (Math.random() * 2);
				String s_a = sa[a];

				jian = bases.getText().toString();
				jian = jian.concat(s_a);
				bases.setText(jian);
				break;
			case R.id.s:
				lett = letter.getText().toString();
				lett = lett.concat("S");
				letter.setText(lett);

				String[] ss = {"AAU" , "AAC"};
				int s = (int) (Math.random() * 2);
				String s_s = ss[s];

				jian = bases.getText().toString();
				jian = jian.concat(s_s);
				bases.setText(jian);
				break;
			case R.id.d:
				lett = letter.getText().toString();
				lett = lett.concat("D");
				letter.setText(lett);

				jian = bases.getText().toString();
				jian = jian.concat("AUG");
				bases.setText(jian);
				break;
			case R.id.f:
				lett = letter.getText().toString();
				lett = lett.concat("F");
				letter.setText(lett);

				jian = bases.getText().toString();
				jian = jian.concat("F");
				bases.setText(jian);
				break;
			case R.id.g:
				lett = letter.getText().toString();
				lett = lett.concat("G");
				letter.setText(lett);

				String[] sg = {"GAA" , "GAG"};
				int g = (int) (Math.random() * 2);
				String s_g = sg[g];

				jian = bases.getText().toString();
				jian = jian.concat(s_g);
				bases.setText(jian);
				break;
			case R.id.h:
				lett = letter.getText().toString();
				lett = lett.concat("H");
				letter.setText(lett);

				String[] sh = {"CAU" , "CAC"};
				int h = (int) (Math.random() * 2);
				String s_h = sh[h];

				jian = bases.getText().toString();
				jian = jian.concat(s_h);
				bases.setText(jian);
				break;
			case R.id.j:
				lett = letter.getText().toString();
				lett = lett.concat("J");
				letter.setText(lett);

				jian = bases.getText().toString();
				jian = jian.concat("J");
				bases.setText(jian);
				break;
			case R.id.k:
				lett = letter.getText().toString();
				lett = lett.concat("K");
				letter.setText(lett);

				jian = bases.getText().toString();
				jian = jian.concat("K");
				bases.setText(jian);
				break;
			case R.id.l:
				lett = letter.getText().toString();
				lett = lett.concat("L");
				letter.setText(lett);

				String[] sl = {"ACU" , "ACC" , "ACA" , "ACG"};
				int l = (int) (Math.random() * 4);
				String s_l = sl[l];

				jian = bases.getText().toString();
				jian = jian.concat(s_l);
				bases.setText(jian);
				break;
			case R.id.z:
				lett = letter.getText().toString();
				lett = lett.concat("Z");
				letter.setText(lett);

				jian = bases.getText().toString();
				jian = jian.concat("Z");
				bases.setText(jian);
				break;
			case R.id.x:
				lett = letter.getText().toString();
				lett = lett.concat("X");
				letter.setText(lett);

				String[] sx = {"UCU" , "UCC" , "UCA" , "UCG"};
				int x = (int) (Math.random() * 4);
				String s_x = sx[x];

				jian = bases.getText().toString();
				jian = jian.concat(s_x);
				bases.setText(jian);
				break;
			case R.id.c:
				lett = letter.getText().toString();
				lett = lett.concat("C");
				letter.setText(lett);

				String[] sc = {"GGU" , "GGC" , "GGA" , "GGG"};
				int c = (int) (Math.random() * 4);
				String s_c = sc[c];

				jian = bases.getText().toString();
				jian = jian.concat(s_c);
				bases.setText(jian);
				break;
			case R.id.v:
				lett = letter.getText().toString();
				lett = lett.concat("V");
				letter.setText(lett);

				String[] sv = {"GUU" , "GUC" , "GUA" , "GUG"};
				int v = (int) (Math.random() * 4);
				String s_v = sv[v];

				jian = bases.getText().toString();
				jian = jian.concat(s_v);
				bases.setText(jian);
				break;
			case R.id.b:
				lett = letter.getText().toString();
				lett = lett.concat("B");
				letter.setText(lett);

				String[] sb = {"UGU" , "UGC"};
				int b = (int) (Math.random() * 2);
				String s_b = sb[b];

				jian = bases.getText().toString();
				jian = jian.concat(s_b);
				bases.setText(jian);
				break;
			case R.id.n:
				lett = letter.getText().toString();
				lett = lett.concat("N");
				letter.setText(lett);

				String[] sn = {"CGU" , "CGC" , "CGA" , "CGG"};
				int n = (int) (Math.random() * 4);
				String s_n = sn[n];

				jian = bases.getText().toString();
				jian = jian.concat(s_n);
				bases.setText(jian);
				break;
			case R.id.m:
				lett = letter.getText().toString();
				lett = lett.concat("M");
				letter.setText(lett);

				String[] sm = {"GCU" , "GCC" , "GCA" , "GCG"};
				int m = (int) (Math.random() * 4);
				String s_m = sm[m];

				jian = bases.getText().toString();
				jian = jian.concat(s_m);
				bases.setText(jian);
				break;
		}
	}

	@AfterViews
	public void UI()
	{
		setImmerseLayout(toolbar);
		setSupportActionBar(toolbar);

		SystemBarTintManager tintManager = new SystemBarTintManager(this);
		tintManager.setStatusBarTintEnabled(true);

		// 打开 up button
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		// 当做 drawer toggle 放入 toolbar
		ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
		drawerToggle.syncState();
		drawer.setDrawerListener(drawerToggle);

		initialization();
	}

	protected void setImmerseLayout(View view)
	{
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
		{
			Window window = getWindow();
			window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			//window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

			int statusBarHeight = getStatusBarHeight(this.getBaseContext());
			view.setPadding(0, statusBarHeight, 0, 0);
		}
	}

	/**
	 * 关于界面
	 */
	@Background
	public void initialization()
	{
		// 设置关于页的版本号
		version.setText(getVersion());

		// 显示文字并设置链接
		// 创建一个 SpannableString对象
		SpannableString qq = new SpannableString("\u4F5C\u8005\u0051\u0051\uFF1A\u0039\u0035\u0031\u0032\u0030\u0033\u0035\u0039\u0038");
		// 设置超链接
		qq.setSpan(new URLSpan("http://qm.qq.com/cgi-bin/qm/qr?k=jzWp1dTM-vhFloHOeO6-6kyLAovJsfSA"), 5, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		// SpannableString对象设置给TextView
		developer.setText(qq);
		// 设置TextView可点击
		developer.setMovementMethod(LinkMovementMethod.getInstance());

		// 显示文字并设置链接
		// 创建一个 SpannableString对象
		SpannableString q = new SpannableString("\u0051\u0051\u53CD\u9988\u7FA4\uFF1A\u0032\u0034\u0037\u0037\u0030\u0038\u0030\u0037\u0038");
		// 设置超链接
		q.setSpan(new URLSpan("http://qm.qq.com/cgi-bin/qm/qr?k=Oi8I9tFyxfvyOugCzIAfLotzC0GZBTIf"), 6, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		// SpannableString对象设置给TextView
		group.setText(q);
		// 设置TextView可点击
		group.setMovementMethod(LinkMovementMethod.getInstance());

		// 显示文字并设置链接
		// 创建一个 SpannableString对象
		SpannableString git = new SpannableString("\u83B7\u5F97\u6E90\u7801\uFF1A\u0054\u0072\u0061\u006E\u0073\u006C\u0061\u0074\u0069\u006F\u006E");
		// 设置超链接
		git.setSpan(new URLSpan("https://github.com/18312847646/Translation.git"), 5, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		// SpannableString对象设置给TextView
		github.setText(git);
		// 设置TextView可点击
		github.setMovementMethod(LinkMovementMethod.getInstance());
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// 处理动作按钮的点击事件
		switch(item.getItemId())
		{
			case R.id.score:
				try
				{
					Uri uri = Uri.parse("market://details?id=" + getPackageName());
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(intent);
				} catch(Exception e)
				{
					Toast.makeText(this, "没有安装任何市场哦", Toast.LENGTH_LONG).show();
				}
				return true;
/*			case R.id.theme:
				Toast.makeText(this, "开发中", Toast.LENGTH_SHORT).show();
				return true;*/
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	// 获得版本号
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// 为ActionBar扩展菜单项
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.bases, menu);
		return super.onCreateOptionsMenu(menu);
	}
}
