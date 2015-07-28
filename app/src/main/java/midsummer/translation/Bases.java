package midsummer.translation;
/*
 * 主页
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.ClipboardManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;

public class Bases extends AppCompatActivity
{
    //声明两个变量
    private String lett = "";
    private String jian = "";

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

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

        // 打開 up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        // 實作 drawer toggle 並放入 toolbar
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.open,R.string.close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

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

    private static void copy(String content, Context context)
    {
        // 得到剪贴板管理器
        @SuppressWarnings("deprecation") ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(content.trim());
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
}
