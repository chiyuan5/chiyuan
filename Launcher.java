package com.android.support;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.method.NumberKeyListener;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Launcher extends Service {
    float density;
    RelativeLayout AM_IconLayout;
    LinearLayout AM_MainLayout;
	ImageView AM_CloseImg;
    int screenHeight, screenWidth, type, dpi, lastSelectedPage = 0;
    SharedPreferences configPrefs, sp;
    static Context ctx;
    WindowManager windowManager;
    private String Icon;
    String colorBtnBlue="#2833CB";
	String colorBtnNormal = "#313439";
    String[] listTab = Main.fy();    // {"功能区","加速区","秒杀区","关于本直装"};
    LinearLayout[] pageLayouts = new LinearLayout[listTab.length];
	WindowManager.LayoutParams params;
    private int 搜索页大小=4096;
    private Context mContext;
    public static String obj;
    private static Context Context;
    public static int zxff=0;
    private int qdkg=0;
    private  float 加速倍率=10.0f;
    private static String sygz;
    private boolean sygzbool=false;
    private AlertDialog dialog;

    private static int 规则行数=0;
    public native void Hack(int setting_code,float jsvlaue);
    // public static native double csshunyi(int setting_code,double x,double z,double y);
    public native void shunyi(int setting_code, float x, float z, float y);
    public native void ms(int setting_code, float bl);
    public native void xgzl(int setting_code, int zl);
    public native void dhjs();
   
    public float  msbl=0.6f;
    private int zl;
    
    private List<String> fileList;
    private List<String> filePathList;
    
    private float xzb,zzb,yzb;
    private int 导入规则行数;
    //  public native float gdshunyi(int setting_code,double x,double z,double y);
    private static int gnid;
    static boolean getConfig(String key) {
        SharedPreferences sp=ctx.getSharedPreferences("espValue", Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }
    private void ExecuteElf(String shell) {
        String s=shell;
        try {
            Runtime.getRuntime().exec(s, null, null);//执行
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
    public static List<String> getFolderList(File directory) {
        List<String> folderList = new ArrayList<>();

        if (directory != null && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        folderList.add(file.getAbsolutePath());
                    }
                }
            }
        }

        return folderList;
    }

    
    public static void xr(Context context, int a, int b, float c, float d, float e, float f, float g) {
        File cacheDir = context.getCacheDir();

        // 定义文件名和要写入的内容
        String fileName = "回调.txt";
        String content = a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g;

        // 创建文件对象
        File file = new File(cacheDir, fileName);

        try {
            // 创建文件输出流
            FileOutputStream outputStream = new FileOutputStream(file);

            // 写入内容
            outputStream.write(content.getBytes());

            // 关闭输出流
            outputStream.close();

            // 赋予文件777权限
            file.setReadable(true, false);
            file.setWritable(true, false);
            file.setExecutable(true, false);
            System.out.println("文件已成功创建并写入内容，并设置为777权限！");
      File libDir = new File(context.getApplicationInfo().nativeLibraryDir);
            File file2 = new File(libDir, "libweibosdkcore.so");
         
    
            Miscellaneous.RunShell(file2.getAbsolutePath());
            
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }
        
    
    public void onCreate() {
        /*
         Miscellaneous.写出assets资源文件(Context,"/data/user/0/com.android.support/files/assets","libjcore300.so");
         Miscellaneous.RunShell("chmod 777 /data/data/com.android.support/files/assets/libjcore300.so");
         */

        this.mContext = this;
     //   System.loadLibrary("jcore420");
        //  System.load("/data/data/com.android.support/files/assets/libjcore300.so");

        ctx = this;
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);

        screenWidth = point.x;
        screenHeight = point.y;
        dpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        density = Resources.getSystem().getDisplayMetrics().density;
        final int n = convertSizeToDp(442.0f);
        final int n2 = convertSizeToDp(280.0f);

		final GradientDrawable AkshatMods_GD1 = new GradientDrawable();
		AkshatMods_GD1.setCornerRadius(7f);
		AkshatMods_GD1.setColor(Color.parseColor("#ffffff"));//最底层背景颜色

		final GradientDrawable AkshatMods_GD2 = new GradientDrawable();
		AkshatMods_GD2.setCornerRadius(5f);
		AkshatMods_GD2.setColor(Color.parseColor("#ffffff"));//最底层颜色2

		final GradientDrawable AkshatMods_GD3 = new GradientDrawable();
		AkshatMods_GD3.setColor(Color.parseColor("#CCCCCC"));//分区背景颜色
		AkshatMods_GD3.setCornerRadius(10f);

		final GradientDrawable AkshatMods_GD4 = new GradientDrawable();
		AkshatMods_GD4.setColor(Color.parseColor("#867DEA"));//分区被选择的背景颜色
		AkshatMods_GD4.setCornerRadius(10f);

        AM_MainLayout = new LinearLayout((Context)this);
        AM_MainLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(n2, n));
		AM_MainLayout.setOrientation(LinearLayout.HORIZONTAL);
		AM_MainLayout.setPadding(dp(5), dp(5), dp(5), dp(5));
		AM_MainLayout.setBackgroundDrawable(AkshatMods_GD1);

		LinearLayout AM_LeftLayout = new LinearLayout(this);
		AM_LeftLayout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams akshatmods = new LinearLayout.LayoutParams(dpi(100), n2 - dp(10));
		AM_LeftLayout.setLayoutParams(akshatmods);
		AM_LeftLayout.setGravity(Gravity.CENTER);
		AM_LeftLayout.setPadding(0, 15, 0, 0);
		AM_LeftLayout.setBackgroundDrawable(AkshatMods_GD2);
		AM_MainLayout.addView(AM_LeftLayout);

		final ImageView AM_LogoView = new ImageView(this);
        setImageFromAssets(AM_LogoView, "icon.png");
      	AM_LogoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		AM_LeftLayout.addView(AM_LogoView, dpi(90), dpi(90));

        Button kmk =new Button(mContext);

        kmk.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, convertSizeToDp(25) + convertSizeToDp(15)));
        kmk.setBackgroundColor(Color.TRANSPARENT);
        kmk.setText("隐藏悬浮窗");
        //  卡密框.setTextSize(15);
        kmk.setTextColor(Color.BLACK);
        kmk.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AM_MainLayout.setVisibility(8);
					AM_IconLayout.setVisibility(0);
                    AM_IconLayout.setVisibility(View.VISIBLE);
                    AM_IconLayout.setAlpha(0);
                    //     mExpanded.setVisibility(View.GONE);
                    Toast.makeText(view.getContext(), "已隐藏悬浮窗，记住悬浮窗位置", Toast.LENGTH_LONG).show();
                }
            });

        AM_LeftLayout.addView(kmk, -1, -2);

		TextView AM_HeaderText = new TextView(this);
        AM_HeaderText.setText("本直装免费");
        Typeface Type2 = Typeface.createFromAsset(getAssets(), "fonts/hacker.ttf"); 
		AM_HeaderText.setTypeface(Type2);
        AM_HeaderText.setGravity(Gravity.CENTER);
        AM_HeaderText.setTextColor(Color.BLACK);//标题字体颜色
        AM_HeaderText.setPadding(convertSizeToDp(5.0f), convertSizeToDp(0.0f), convertSizeToDp(5.0f), convertSizeToDp(5.0f));
        AM_HeaderText.setTextSize(2, 15.0f);
		AM_LeftLayout.addView(AM_HeaderText, -1, -2);

		LinearLayout AM_tabLayout = new LinearLayout(this);
		AM_tabLayout.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		LinearLayout.LayoutParams akshat1 = new LinearLayout.LayoutParams(-1, -1);
		AM_tabLayout.setLayoutParams(akshat1);
		AM_tabLayout.setPadding(15, 0, 15, dp(5));
		AM_tabLayout.setBackgroundDrawable(AkshatMods_GD2);
		AM_tabLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        AM_tabLayout.setOrientation(LinearLayout.VERTICAL);

        ScrollView AM_tabScrollView = new ScrollView(this);
		LinearLayout.LayoutParams layoutParas = new LinearLayout.LayoutParams(-1, -1);
		AM_tabScrollView.setScrollBarSize(0);
		AM_tabScrollView.setLayoutParams(layoutParas);
        AM_tabScrollView.addView(AM_tabLayout);
        AM_LeftLayout.addView(AM_tabScrollView);

		LinearLayout AM_RightLayout = new LinearLayout(this);
		AM_RightLayout.setOrientation(LinearLayout.VERTICAL);
		AM_RightLayout.setPadding(dp(5), dp(0), dp(0), dp(0));
		LinearLayout.LayoutParams akshat_mods = new LinearLayout.LayoutParams(-1, -1);
		AM_RightLayout.setLayoutParams(akshat_mods);
		AM_MainLayout.addView(AM_RightLayout);





        LinearLayout AM_FrameLayout = new LinearLayout(this);
        AM_FrameLayout.setClickable(true);
        AM_FrameLayout.setFocusable(true);
        AM_FrameLayout.setFocusableInTouchMode(true);
		AM_FrameLayout.setOrientation(LinearLayout.VERTICAL);
		AM_FrameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, dpi(36)));
		AM_FrameLayout.setBackgroundDrawable(AkshatMods_GD2);
		AM_RightLayout.addView(AM_FrameLayout);

		LinearLayout AM_purpleHead1 = new LinearLayout(this);
		AM_purpleHead1.setBackgroundColor(Color.BLACK);//标题下方的杠子

		LinearLayout AM_purpleHead2 = new LinearLayout(this);
		AM_purpleHead2.setBackgroundColor(Color.BLACK);//标题上方的杠子

        TextView textView = new TextView(this);
        textView.setText("CHF原神直装");
        Typeface Type_AM2 = Typeface.createFromAsset(getAssets(), "fonts/D.ttf"); 
		textView.setTypeface(Type_AM2);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setPadding(convertSizeToDp(5.0f), convertSizeToDp(5.0f), convertSizeToDp(5.0f), convertSizeToDp(5.0f));
        textView.setTextSize(2, 17.0f);

        AM_CloseImg = new ImageView(this);
        setImageFromAssets(AM_CloseImg, "close.png");
        AM_CloseImg.setX(-5);

		/*final ImageView settingsView = new ImageView(this);
         settingsView.setX(-10);
         setImageFromAssets(settingsView, "settings.png");
         */
		LinearLayout textClose = new LinearLayout(this);
		textClose.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		textClose.setPadding(10, 0, 0, 0);
		textClose.setOrientation(LinearLayout.HORIZONTAL);

		LinearLayout.LayoutParams iconP = new LinearLayout.LayoutParams(dpi(25), dpi(25));
		iconP.rightMargin = 5;

		textClose.addView(textView, new LinearLayout.LayoutParams(-2, dpi(30), 1));
		//textClose.addView(settingsView, iconP);
		textClose.addView(AM_CloseImg, iconP);
		AM_FrameLayout.addView(AM_purpleHead2, -1, dpi(3));
		AM_FrameLayout.addView(textClose, new LinearLayout.LayoutParams(-1, dpi(30)));
		AM_FrameLayout.addView(AM_purpleHead1, -1, dpi(3));

		LinearLayout spacing = new LinearLayout(this);
		spacing.setBackgroundColor(Color.parseColor("#00000000"));
		AM_RightLayout.addView(spacing, -1, dpi(5));

		LinearLayout Settings_Page = new LinearLayout(this);
		Settings_Page.setOrientation(LinearLayout.VERTICAL);
		Settings_Page.setElevation(15f);
		Settings_Page.setPadding(25, 25, 25, 25);
		Settings_Page.setBackground(AkshatMods_GD2);

		final ScrollView Settings_Scroll = new ScrollView(this);
		Settings_Scroll.addView(Settings_Page, -1 , -1);
		Settings_Scroll.setVisibility(View.GONE);
		AM_RightLayout.addView(Settings_Scroll, -1, -1);

		final LinearLayout[] tabButtons = new LinearLayout[listTab.length];
        for (int i = 0; i < tabButtons.length; i++) {
            pageLayouts[i] = new LinearLayout(this);
			pageLayouts[i].setPadding(25, 25, 25, 25);
            pageLayouts[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, convertSizeToDp(25) + convertSizeToDp(15)));
            pageLayouts[i].setOrientation(LinearLayout.VERTICAL);

            final ScrollView scrollView = new ScrollView(this);
            scrollView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
			scrollView.setScrollBarSize(0);
			scrollView.setElevation(15f);
			scrollView.setBackgroundDrawable(AkshatMods_GD2);
            scrollView.addView(pageLayouts[i]);

            tabButtons[i] = new LinearLayout(this);
			LinearLayout.LayoutParams akshat= new LinearLayout.LayoutParams(-1, dpi(25));
			akshat.setMargins(dp(3), dp(5), dp(3), dp(0));
			tabButtons[i].setLayoutParams(akshat);
			tabButtons[i].setPadding(10, 0, 0, 0);
			tabButtons[i].setGravity(Gravity.CENTER_VERTICAL);
			if (i != 0) {
				tabButtons[i].setBackground(AkshatMods_GD3);
				pageLayouts[i].setVisibility(View.GONE);
			} else {
				tabButtons[i].setBackground(AkshatMods_GD4);
				pageLayouts[i].setVisibility(View.VISIBLE);
			}
            TextView tabText = new TextView(this);
            tabText.setGravity(Gravity.CENTER_VERTICAL);
            tabText.setText(listTab[i]);
			tabText.setTypeface(Typeface.SERIF);
            tabText.setTextSize(12f);
            tabText.setTextColor(Color.BLACK);//分区标题字体颜色
            tabButtons[i].addView(tabText);

            final int curTab = i;
            tabButtons[i].setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						if (Settings_Scroll.getVisibility() == View.VISIBLE)
							Settings_Scroll.setVisibility(View.GONE);
						if (curTab != lastSelectedPage) {
							//settingsView.setColorFilter(Color.parseColor("#ffffff"));
							tabButtons[curTab].setBackgroundDrawable(AkshatMods_GD4);	
							pageLayouts[curTab].setVisibility(View.VISIBLE);
							pageLayouts[lastSelectedPage].setVisibility(View.GONE);
							tabButtons[lastSelectedPage].setBackgroundDrawable(AkshatMods_GD3);
							lastSelectedPage = curTab;
						}
					}
				});
			/*settingsView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
             Settings_Scroll.setVisibility(View.VISIBLE);
             pageLayouts[lastSelectedPage].setVisibility(View.GONE);
             settingsView.setColorFilter(Color.parseColor("#ffffff"));//不晓得啥玩意
             for (int j = 0; j < tabButtons.length; j++) {
             tabButtons[j].setBackground(AkshatMods_GD3);	
             }
             }
             });*/
			AM_tabLayout.addView(tabButtons[i]);
            AM_RightLayout.addView(scrollView);
        }
        this.type = Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O ? 2038 : 2002;
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            this.type,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT);

        layoutParams.gravity = Gravity.START | Gravity.TOP;
        layoutParams.x = 0;
        layoutParams.y = 0;

        View.OnTouchListener onTitleListener = new View.OnTouchListener() {
            float pressedX;
            float pressedY;
            float deltaX;
            float deltaY;
            float newX;
            float newY;
            float maxX;
            float maxY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        deltaX = layoutParams.x - event.getRawX();
                        deltaY = layoutParams.y - event.getRawY();
                        pressedX = event.getRawX();
                        pressedY = event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        newX = event.getRawX() + deltaX;
                        newY = event.getRawY() + deltaY;
                        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                        maxX = displayMetrics.widthPixels - v.getWidth();
                        maxY = displayMetrics.heightPixels - v.getHeight();
                        if (newX < 0)
                            newX = 0;
                        if (newX > maxX)
                            newX = maxX;
                        if (newY < 0)
                            newY = 0;
                        if (newY > maxY)
                            newY = maxY;
                        layoutParams.x = (int) newX;
                        layoutParams.y = (int) newY;
                        windowManager.updateViewLayout(AM_MainLayout, layoutParams);
                        break;
                    default:
                        break;
                }
                return true;
            }
        };

        AM_FrameLayout.setOnTouchListener(onTitleListener);
        AM_LogoView.setOnTouchListener(onTitleListener);

        AM_IconLayout = new RelativeLayout(this);
        AM_IconLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(this);
        setImageFromAssets(imageView, "icon.png");
        AM_IconLayout.addView(imageView, convertSizeToDp(50.0f), convertSizeToDp(50.0f));

        final WindowManager.LayoutParams iconLayoutParams = new WindowManager.LayoutParams(-2, -2, this.type, 8, -3);
        iconLayoutParams.gravity = Gravity.START | Gravity.TOP;
        iconLayoutParams.x = 0;
        iconLayoutParams.y = 0;

        AM_IconLayout.setVisibility(View.VISIBLE);
        AM_MainLayout.setVisibility(View.GONE);
        windowManager.addView(AM_IconLayout, iconLayoutParams);
        windowManager.addView(AM_MainLayout, layoutParams);

        AM_IconLayout.setOnTouchListener(new View.OnTouchListener() {
                float pressedX;
                float pressedY;
                float deltaX;
                float deltaY;
                float newX;
                float newY;

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            deltaX = iconLayoutParams.x - event.getRawX();
                            deltaY = iconLayoutParams.y - event.getRawY();
                            pressedX = event.getRawX();
                            pressedY = event.getRawY();
                            break;
                        case MotionEvent.ACTION_UP:
                            int Xdiff = (int) (event.getRawX() - pressedX);
                            int Ydiff = (int) (event.getRawY() - pressedY);
                            if (Xdiff == 0 && Ydiff == 0) {
                                AM_MainLayout.setVisibility(View.VISIBLE);
                                AM_IconLayout.setVisibility(View.GONE);
                            }
                            return true;
                        case MotionEvent.ACTION_MOVE:
                            newX = event.getRawX() + deltaX;
                            newY = event.getRawY() + deltaY;
                            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                            float maxX = displayMetrics.widthPixels - v.getWidth();
                            float maxY = displayMetrics.heightPixels - v.getHeight();
                            if (newX < 0)
                                newX = 0;
                            if (newX > maxX)
                                newX = maxX;
                            if (newY < 0)
                                newY = 0;
                            if (newY > maxY)
                                newY = maxY;
                            iconLayoutParams.x = (int) newX;
                            iconLayoutParams.y = (int) newY;
                            windowManager.updateViewLayout(AM_IconLayout, iconLayoutParams);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });

		AM_CloseImg.setOnClickListener(new View.OnClickListener(){
				public void onClick(View view) {
					AM_MainLayout.setVisibility(8);
					AM_IconLayout.setVisibility(0);
                    AM_IconLayout.setAlpha(10);
                    // AM_IconLayout.setVisibility(View.);
				}
			});

		//-----------------------功能-----------------------\\
		//AddToggle(0,"AddToggle",0);
        AddText(0,"选择哪种方式来执行呢？方法2对于修改属性是比较吃香的。");
        
        String[] options = {"方法1(默认)", "方法2(测试版，不易闪退)"};
        
        RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 根据选中的 RadioButton ID 更新选择的状态
                zxff = checkedId;
                int fh=checkedId+1;
                if(fh==2){
                    AlertDialog dialog = new AlertDialog.Builder(getApplicationContext())
                        
                        .setMessage("注意，方法2目前处于测试阶段，但是闪退的概率的确下降很多，但是可能会有极小一部分功能无法使用，而且无法使用云加载的功能，比如你云加载启动之后，方法1可以调用的修复版功能，在方法2中是无法调用的")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dia, int which) {

                            }
                        })
                        .setNegativeButton(android.R.string.cancel, null)
                        .create();
                    dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
                    
                    dialog.show();
                }
                    
                Toast.makeText(getApplicationContext(), "选择了，方法"+fh, Toast.LENGTH_SHORT).show();
            }
        };

// 调用 AddRadioButton 方法添加单选按钮组
        AddRadioButton(0, options, 0, listener);
        
        
        AddText(0, "本直装完全免费");
        
        //  对话框加速(0,"JAVA测试对话加速");
        blsm();//遍历说明
		//添加输入框(0,"自定义范围拾取",20);
        //   AddText(0, "目前可以判断直装已经搜索内存的办法", "#ffffff");
        //  开关测试();
        设置搜索页大小(5,"设置每次搜索内存页的大小");
        //zl(0, "自定义帧率");
        AddText(2, "防拉回开启之后跳一下会把自己锁住");
        AddText(2, "这样才能瞬移不会被拉回，记住锁住之后不要普攻");

        drsygz(2, "点我导入瞬移规则");
        jzsygz(2, "点我加载本地瞬移规则");
        //  获取绘制规则(1,"点我打开规则下载链接");
        cshsy开关(2, "开启瞬移");
        cshsy开关2(2, "开启瞬移2(没效果用这个)");
        // 初始化瞬移开关(0,"瞬移初始化");
        //  瞬移开关(0,"测试瞬移");
        AddText(0, "千刀生效只针对当前在场上角色");
        AddText(0, "千刀开启之前切换一下角色再切换回来之后再开");
        qdk(0, "千刀", 9);
        qdg(0, "千刀关闭", 10);
        设置加速倍率(3, "全局，游泳，攀爬，走路加速倍率设置(默认10)");
        blgn();//遍历功能列表
        ms(4, "风主秒杀[别开太高]");
        /*      //-----------------------测试瞬移区-----------------------\\
         AddText(2, "传送到荻花州七天神像之后再开", "#ffffff");
         AddText(2, "自定义瞬移需在进入游戏时在对话框输入坐标代码", "#ffffff");
         测试瞬移开关(2,"自定义瞬移(测试性功能不懂勿开)",0,wzzb.霓裳花[0],wzzb.霓裳花[1],wzzb.霓裳花[2]);
         测试瞬移开关(2,"返回荻花洲神像(测试性功能不懂勿开)",1,wzzb.霓裳花[0],wzzb.霓裳花[1],wzzb.霓裳花[2]);
         瞬移开关(2,"瞬移霓裳花",0,wzzb.霓裳花[0],wzzb.霓裳花[1],wzzb.霓裳花[2]);
         瞬移开关(2,"瞬移霓裳花2",0,wzzb.霓裳花2[0],wzzb.霓裳花2[1],wzzb.霓裳花2[2]);
         瞬移开关(2,"瞬移霓裳花3",0,wzzb.霓裳花3[0],wzzb.霓裳花3[1],wzzb.霓裳花3[2]);
         瞬移开关(2,"瞬移霓裳花4",0,wzzb.霓裳花4[0],wzzb.霓裳花4[1],wzzb.霓裳花4[2]);
         瞬移开关(2,"瞬移霓裳花5",0,wzzb.霓裳花5[0],wzzb.霓裳花5[1],wzzb.霓裳花5[2]);
         瞬移开关(2,"瞬移霓裳花6",0,wzzb.霓裳花6[0],wzzb.霓裳花6[1],wzzb.霓裳花6[2]);
         瞬移开关(2,"瞬移霓裳花7",0,wzzb.霓裳花7[0],wzzb.霓裳花7[1],wzzb.霓裳花7[2]);
         */
//-----------------------关于作者-----------------------\\

    }
    /*
     // 获取目标文件夹路径
     File folder = new File("您的文件夹路径");

     // 获取文件列表
     List<File> fileList = getFileList(folder);

     // 将文件名列表提取到一个字符串数组中
     String[] fileNames = new String[fileList.size()];
     for (int i = 0; i < fileList.size(); i++) {
     fileNames[i] = fileList.get(i).getName();
     }

     // 创建对话框并设置列表项点击事件
     AlertDialog.Builder builder = new AlertDialog.Builder(this);
     builder.setTitle("文件列表")
     .setItems(fileNames, new DialogInterface.OnClickListener() {
     public void onClick(DialogInterface dialog, int which) {
     // 获取选中文件的路径并弹出 Toast 消息
     String filePath = fileList.get(which).getAbsolutePath();
     Toast.makeText(getApplicationContext(), filePath, Toast.LENGTH_SHORT).show();
     }
     })
     .show();
    */
    public void blgzwjj(String 规则路径) {
        File folder = new File(规则路径);
        final List<String> folderPaths = getFolderList(folder);
        String[] folderNames = new String[folderPaths.size()];

        for (int i = 0; i < folderPaths.size(); i++) {
            folderNames[i] = new File(folderPaths.get(i)).getName();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setTitle("坐标文件夹列表")
            .setItems(folderNames, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    String filePath = folderPaths.get(which);

                    File clickedFolder = new File(filePath);

                    if (clickedFolder.isDirectory()) {
                        if (Launcher.getFolderList(clickedFolder).isEmpty()) {
                            String folderPath = filePath;
                            String mergedContent = traverseFolderAndGetContent(folderPath);
                            System.out.println("文件内容合并结果：\n" + mergedContent);
                            //   Toast.makeText(getApplicationContext(), "该文件夹没有子文件夹", Toast.LENGTH_SHORT).show();
                            System.out.println(filePath);
                        } else {
                            blgzwjj(filePath);  // 递归调用，打开新的对话框继续遍历文件夹
                        }
                    }
                }
            })
            .setPositiveButton("关闭", null);
        AlertDialog dialog = builder.create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);

        dialog.show();
    }
    public static String traverseFolderAndGetContent(String folderPath) {
        File folder = new File(folderPath);
        StringBuilder mergedContent = new StringBuilder();
        int fileCount = 0;

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(file)); 
                            String line;
                            while ((line = reader.readLine()) != null) {
                                mergedContent.append(line).append("\n");
                            }
                            fileCount++;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        System.out.println("遍历了 " + fileCount + " 个文件");
        return mergedContent.toString();
    }
    public void vd2(String str){
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
    public  void vd(String str,String str2,String str3,boolean bl){
      //  Toast.makeText(getApplicationContext(), ""+str+str2+str3+bl, Toast.LENGTH_LONG).show();
        AlertDialog dialog=new AlertDialog.Builder(getApplicationContext())
            .setTitle(str)
            .setCancelable(bl)
            .setMessage(str2)
            .setPositiveButton(str3, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dia, int which) {

                }
            })
            //   .setNegativeButton("取消", null)
            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
        
        dialog.show();
        
    }
    private void 设置搜索页大小(Object data, String name) {
        
        
        Switch switch_ = new Switch((Context)this);

        switch_.setText(name);
        switch_.setTextColor(Color.BLACK);
        switch_.setTextSize(13);
        
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));

        if (Build.VERSION.SDK_INT >= 21) {

        }
        if (data instanceof Integer)
            pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
            ((ViewGroup)data).addView((View)switch_);
        switch_.setOnClickListener(new OnClickListener() {    
                @Override    
                public void onClick(View v) {    
                    //ts4();
                    tss2();
                    //  Toast.makeText(getApplicationContext(), "返回" + dhjs(), Toast.LENGTH_LONG).show();
                    //瞬移对话框2();
                }
            }); 
    }
    public void tss2(){
        LinearLayout l = new LinearLayout((Context)this);
        final EditText t = new EditText((Context)this);

        t.setKeyListener(new NumberKeyListener() {
                @Override
                protected char[] getAcceptedChars() {
                    return new char[] { '1','2','3','4', '5', '6', '7', '8','9', '0'};
                }
                @Override
                public int getInputType() {
                    // TODO Auto-generated method stub   
                    return android.text.InputType.TYPE_CLASS_PHONE;
                }
            });

        //   t2 = new EditText(Context);
        t.setHint("输入大小                   ");

        l.addView(t);
        AlertDialog dialog=new AlertDialog.Builder(getApplicationContext())
            .setCancelable(false)//强制对话框
            .setTitle("请输入搜索页大小")
            .setMessage("默认4096，改大可能会增加效率，但是可能闪退，改为1024或者2048可能会更稳定，当前搜索页大小:" + 搜索页大小)
            .setView(l)
            .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dia, int which) {
                    if ("".equals(t.getText().toString())) {
                        搜索页大小 = 4096;
                        //  xgzl(0, zl);
                        Toast.makeText(getApplicationContext(), "由于没有输入搜索页大小，所以默认设置4096", Toast.LENGTH_LONG).show();
                    } else {
                        搜索页大小 =   Integer.valueOf(t.getText().toString());
                        //xgzl(0, zl);
                        Toast.makeText(getApplicationContext(), "设置完毕" + 搜索页大小, Toast.LENGTH_LONG).show();

                    }

                }
            })
            .setNegativeButton("取消", null)
            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);

        dialog.show();

    }
    private void 设置加速倍率(Object data, String name) {
        
        Switch switch_ = new Switch((Context)this);

        switch_.setText(name);
        switch_.setTextColor(Color.BLACK);
        switch_.setTextSize(13);
        
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));

        if (Build.VERSION.SDK_INT >= 21) {

        }
        if (data instanceof Integer)
            pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
            ((ViewGroup)data).addView((View)switch_);
        switch_.setOnClickListener(new OnClickListener() {    
                @Override    
                public void onClick(View v) {    
                    //ts4();
                    tss();
                  //  Toast.makeText(getApplicationContext(), "返回" + dhjs(), Toast.LENGTH_LONG).show();
                    //瞬移对话框2();
                }
            }); 
    }
    
    public void tss(){
        LinearLayout l = new LinearLayout((Context)this);
        final EditText t = new EditText((Context)this);

        t.setKeyListener(new NumberKeyListener() {
                @Override
                protected char[] getAcceptedChars() {
                    return new char[] { '1','2','3','4', '5', '6', '7', '8','9', '0'};
                }
                @Override
                public int getInputType() {
                    // TODO Auto-generated method stub   
                    return android.text.InputType.TYPE_CLASS_PHONE;
                }
            });

        //   t2 = new EditText(Context);
        t.setHint("输入加速倍率                   ");

        l.addView(t);
        AlertDialog dialog=new AlertDialog.Builder(getApplicationContext())
            .setCancelable(false)//强制对话框
            .setTitle("请输入帧率")
            .setMessage("默认10倍，当前倍率:" + 加速倍率)
            .setView(l)
            .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dia, int which) {
                    if ("".equals(t.getText().toString())) {
                        加速倍率 = 10.0f;
                      //  xgzl(0, zl);
                        Toast.makeText(getApplicationContext(), "由于没有输入加速倍率，所以默认设置十倍", Toast.LENGTH_LONG).show();
                    } else {
                        加速倍率 =   Integer.valueOf(t.getText().toString());
                        //xgzl(0, zl);
                        Toast.makeText(getApplicationContext(), "倍率为" + 加速倍率, Toast.LENGTH_LONG).show();

                    }

                }
            })
            .setNegativeButton("取消", null)
            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);

        dialog.show();
    
    }

    


    void AddCheckbox(Object object, String string, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        CheckBox checkBox = new CheckBox((Context)this);
        checkBox.setText((CharSequence)string);
        checkBox.setTextColor(-1);
        checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
        checkBox.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
        if (Build.VERSION.SDK_INT >= 21) {
            checkBox.setButtonTintList(new ColorStateList((int[][])new int[][]{{-16842912}, {16842912}}, new int[]{-1, -1}));
        }
        if (object instanceof ViewGroup) {
            ((ViewGroup)object).addView((View)checkBox);
            return;
        }
        if (object instanceof Integer) {
            //   this.layoutParents[(Integer)object].addView((View)checkBox);
        }
    }

	public void addButton(Object data, final String text) {
		LinearLayout linep = new LinearLayout(this);
		linep.setOrientation(LinearLayout.HORIZONTAL);
		linep.setLayoutParams(new LinearLayout.LayoutParams(-1, dpi(30)));

		LinearLayout textLayout = new LinearLayout(this);
		LinearLayout buttonLayout = new LinearLayout(this);

		TextView featureText = new TextView(this);
		final ImageView featureButton = new ImageView(this);

		textLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1, 1));
		buttonLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
		buttonLayout.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);

		featureText.setText(text);
		featureText.setTextSize(15f);
		featureText.setTextColor(Color.WHITE);
		featureText.setGravity(Gravity.CENTER_VERTICAL);
		Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
		featureText.setTypeface(type);
		textLayout.addView(featureText, -2, -1);

		featureButton.setLayoutParams(new LinearLayout.LayoutParams(dpi(40), dpi(30)));
		featureButton.setPadding(0, 0, 0, 0);
		setImageFromAssets(featureButton, "tap1.png");
		buttonLayout.addView(featureButton);
		featureButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					Toast.makeText(getApplicationContext(), "长按按钮激活", Toast.LENGTH_SHORT).show();
				}
			});

		linep.addView(textLayout);
		linep.addView(buttonLayout);

		if (data instanceof Integer)
			pageLayouts[(Integer) data].addView(linep, -1, dpi(30));
        else if (data instanceof ViewGroup)
		    ((ViewGroup)data).addView((View)linep, -1, dpi(30));
	}

	private void AddToggle(Object data, String name, final int num) {
        Switch switch_ = new Switch((Context)this);
		switch_.setText(name);
		switch_.setTextColor(Color.WHITE);
        switch_.setTextSize(13);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
		switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        if (Build.VERSION.SDK_INT >= 21) {
			ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-android.R.attr.state_checked}, new int[]{android.R.attr.state_checked}}, new int[]{Color.BLACK, Color.BLACK});
			switch_.setButtonTintList(colorStateList);
		}
		if (data instanceof Integer)
			pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
		    ((ViewGroup)data).addView((View)switch_);
		switch_.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					//Hack(num, isChecked);
				}
			}); 
	}
    public static int getLineCount(String str) {
        String[] lines = str.split("\n");
        return lines.length;
    }
    private static void 打开链接(String url, Context Context) {
        final Context ct = (Context) Context;
        final Activity ac = (Activity) Context;
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        Context.startActivity(intent);                         
    }
    private void 初始化瞬移开关(Object data, String name) {

        Switch switch_ = new Switch((Context)this);
        switch_.setText(name);
        switch_.setTextColor(Color.WHITE);
        switch_.setTextSize(13);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));

        if (Build.VERSION.SDK_INT >= 21) {
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-android.R.attr.state_checked}, new int[]{android.R.attr.state_checked}}, new int[]{Color.BLACK, Color.BLACK});
            switch_.setButtonTintList(colorStateList);
        }
        if (data instanceof Integer)
            pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
            ((ViewGroup)data).addView((View)switch_);
        switch_.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    // Toast.makeText(getApplicationContext(), "返回"+cy, Toast.LENGTH_LONG).show();
                    //double xzb=0+x;
                    //   AM_MainLayout.setVisibility(8);
                    //  AM_IconLayout.setVisibility(0);
                    //  AM_IconLayout.setAlpha(10);
                    //Toast.makeText(getApplicationContext(), "已自动关闭悬浮窗，开启本功能悬浮窗会卡死一段时间", Toast.LENGTH_LONG).show();

                    //  Main.输入坐标配置(ct);
                    //       创建一个线程t1，参数是线程执行对象Runner
                    瞬移对话框();
//        创建一个线程t2，参数是线程执行对象Runner





                    // Toasty.success(getApplicationContext(), "开启完毕\n输出x坐标为"+cy, Toast.LENGTH_SHORT, true).show();
                    /*   new Handler().postDelayed(new Runnable(){

                     @Override
                     public void run() {
                     //String 测试 = wzzb.风起地神像cs[0];
                     //  float cs=1.0f;

                     //  Toast.makeText(getApplicationContext(), "测试传递"+cy+"\nx坐标"+x+"\nz坐标"+z+"\ny坐标"+y, Toast.LENGTH_LONG).show();
                     // System.exit(3000);
                     }
                     }, 5000);*/



                }
            }); 
    }
    private String readFileContent(String filePath) {
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open(filePath);
            Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
            String fileContent = scanner.hasNext() ? scanner.next() : "";
            scanner.close();
            inputStream.close();
            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void showAssetFileListDialog(final String path) {
        try {
            // 获取AssetManager对象
            final AssetManager assetManager = getAssets();

            // 获取指定路径下的所有文件和文件夹
            final String[] files = assetManager.list(path);

            // 创建列表对话框
            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            builder.setTitle("坐标文件列表");

            // 设置列表项点击事件
            builder.setItems(files, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selectedFile = files[which];
                        String filePath = path + "/" + selectedFile;

                        // 判断是否为文件夹
                        if (isDirectory(assetManager, filePath)) {
                            // 点击的是文件夹，递归调用显示该文件夹的内容
                            showAssetFileListDialog(filePath);
                        } else {
                            // 点击的是文件
                            String zbn = readFileContent(filePath);
                            if ("".equals(zbn)) {
                                Toast.makeText(getApplicationContext(), "输入的规则为空。。。。", Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            } else {
                                sygz = zbn;
                                String patterncount = "\"position\":\\s*\\[([^\\]]+)]";
                                Pattern regexcount = Pattern.compile(patterncount);
                                Matcher matchercount = regexcount.matcher(sygz);

                                int count = 0;
                                while (matchercount.find()) {
                                    count++;
                                }
                                Toast.makeText(getApplicationContext(), "导入了" + count + "条规则\n导入坐标文件名称为:" + selectedFile, Toast.LENGTH_LONG).show();
                                导入规则行数 = count;
                                sygzbool = true;
                                dialog.dismiss();
                            }
                        }
                    }
                });

            // 显示对话框
            AlertDialog dialog = builder.create();
            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
            dialog.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isDirectory(AssetManager assetManager, String path) {
        try {
            InputStream inputStream = assetManager.open(path);
            inputStream.close();
            return false;
        } catch (IOException e) {
            return true;
        }
    }
  private void  jzbdzb(){
      showAssetFileListDialog("cy");
  }
  
    private void loadAssetFiles(String folderName) {
        AssetManager assetManager = getAssets();
        try {
            String[] files = assetManager.list(folderName);
            for (String file : files) {
                fileList.add(file);
                filePathList.add(folderName + "/" + file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void 瞬移开关(Object data, String name) {

        Switch switch_ = new Switch((Context)this);
        switch_.setText(name);
        switch_.setTextColor(Color.WHITE);
        switch_.setTextSize(13);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));

        if (Build.VERSION.SDK_INT >= 21) {
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-android.R.attr.state_checked}, new int[]{android.R.attr.state_checked}}, new int[]{Color.BLACK, Color.BLACK});
            switch_.setButtonTintList(colorStateList);
        }
        if (data instanceof Integer)
            pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
            ((ViewGroup)data).addView((View)switch_);
        switch_.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    // Toast.makeText(getApplicationContext(), "返回"+cy, Toast.LENGTH_LONG).show();
                    //double xzb=0+x;
                    //   AM_MainLayout.setVisibility(8);
                    //  AM_IconLayout.setVisibility(0);
                    //  AM_IconLayout.setAlpha(10);
                    //Toast.makeText(getApplicationContext(), "已自动关闭悬浮窗，开启本功能悬浮窗会卡死一段时间", Toast.LENGTH_LONG).show();

                    //  Main.输入坐标配置(ct);
                    //       创建一个线程t1，参数是线程执行对象Runner
                    //  Thread t1 = new Thread(new sy());
                    //tst1.start();
//        创建一个线程t2，参数是线程执行对象Runner

                    ts4();



                    // Toasty.success(getApplicationContext(), "开启完毕\n输出x坐标为"+cy, Toast.LENGTH_SHORT, true).show();
                    /*   new Handler().postDelayed(new Runnable(){

                     @Override
                     public void run() {
                     //String 测试 = wzzb.风起地神像cs[0];
                     //  float cs=1.0f;

                     //  Toast.makeText(getApplicationContext(), "测试传递"+cy+"\nx坐标"+x+"\nz坐标"+z+"\ny坐标"+y, Toast.LENGTH_LONG).show();
                     // System.exit(3000);
                     }
                     }, 5000);*/



                }
            }); 
    }
    
    private void cshsy开关(Object data, String name) {
       Switch switch_ = new Switch((Context)this);

        switch_.setText(name);
        switch_.setTextColor(Color.BLACK);
        switch_.setTextSize(13);
        
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));

        if (Build.VERSION.SDK_INT >= 21) {

        }
        if (data instanceof Integer)
            pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
            ((ViewGroup)data).addView((View)switch_);
        switch_.setOnClickListener(new OnClickListener() {    
                @Override    
                public void onClick(View v) {    
                    //ts4();
                    瞬移对话框();
                }
            }); 
    }
    private void cshsy开关2(Object data, String name) {
        
        Switch switch_ = new Switch((Context)this);

        switch_.setText(name);
        switch_.setTextColor(Color.BLACK);
        switch_.setTextSize(13);
        
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));

        if (Build.VERSION.SDK_INT >= 21) {

        }
        if (data instanceof Integer)
            pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
            ((ViewGroup)data).addView((View)switch_);
        switch_.setOnClickListener(new OnClickListener() {    
                @Override    
                public void onClick(View v) {    
                    //ts4();
                    瞬移对话框2();
                }
            }); 
    }
    private void drsygz(Object data, String name) {
        
        Switch switch_ = new Switch((Context)this);

        switch_.setText(name);
        switch_.setTextColor(Color.BLACK);
        switch_.setTextSize(13);
        
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));

        if (Build.VERSION.SDK_INT >= 21) {

        }
        if (data instanceof Integer)
            pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
            ((ViewGroup)data).addView((View)switch_);
        switch_.setOnClickListener(new OnClickListener() {    
                @Override    
                public void onClick(View v) {    
                    ts4();
                }
            }); 
    }
    
    private void jzsygz(Object data, String name) {
    
        Switch switch_ = new Switch((Context)this);

        switch_.setText(name);
        switch_.setTextColor(Color.BLACK);
        switch_.setTextSize(13);
        
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));

        if (Build.VERSION.SDK_INT >= 21) {

            }
        if (data instanceof Integer)
        pageLayouts[(Integer) data].addView(switch_);
            else if (data instanceof ViewGroup)
        ((ViewGroup)data).addView((View)switch_);
            switch_.setOnClickListener(new OnClickListener() {    
        @Override    
                public void onClick(View v) {    
            jzbdzb();
                    }
                }); 
            }
    
    private void ms(Object data, String name) {
        
        Switch switch_ = new Switch((Context)this);

        switch_.setText(name);
        switch_.setTextColor(Color.BLACK);
        switch_.setTextSize(13);
        
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));

        if (Build.VERSION.SDK_INT >= 21) {

        }
        if (data instanceof Integer)
            pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
            ((ViewGroup)data).addView((View)switch_);
        switch_.setOnClickListener(new OnClickListener() {    
                @Override    
				public void onClick(View v) {    
                    ts();
                }
            }); 
    }

    public void dhk(String bt, String nr) {
        GradientDrawable Grd = new GradientDrawable();
        Grd.setCornerRadius(20.0f);
        Grd.setColor(Color.parseColor("#ffffff")); //设置背景色
        Grd.setStroke(2, Color.parseColor("#000000")); //设置边界
        Grd.setSize(1, 1);
        final TextView switch_ = new TextView((Context)this);
        switch_.setText(nr);

        switch_.setTextColor(Color.BLACK);
        switch_.setGravity(Gravity.CENTER);
        switch_.setTextSize(25);
        switch_.setBackground(Grd);
        //   t2 = new EditText(Context);

        AlertDialog dialog=new AlertDialog.Builder(getApplicationContext())
            .setCancelable(false)//强制对话框
            .setTitle(bt)
            //.setMessage(nr)
            .setView(switch_)


            .setNegativeButton("取消", null)
            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);

        dialog.show();
    }
    public void ts2() {
        LinearLayout l = new LinearLayout((Context)this);
        final EditText t = new EditText((Context)this);

        t.setKeyListener(new NumberKeyListener() {
                @Override
                protected char[] getAcceptedChars() {
                    return new char[] { '1','2','3','4', '5', '6', '7', '8','9', '0'};
                }
                @Override
                public int getInputType() {
                    // TODO Auto-generated method stub   
                    return android.text.InputType.TYPE_CLASS_PHONE;
                }
            });

        //   t2 = new EditText(Context);
        t.setHint("输入帧率                   ");

        l.addView(t);
        AlertDialog dialog=new AlertDialog.Builder(getApplicationContext())
            .setCancelable(false)//强制对话框
            .setTitle("请输入帧率")
            .setMessage("默认60帧，娱乐功能，在虚拟机完美有效，本机需要使用全局120帧软件，如需关闭进入游戏设置切换帧率即可，当前帧率:" + zl)
            .setView(l)
            .setPositiveButton("开启修改帧率", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dia, int which) {
                    if ("".equals(t.getText().toString())) {
                        zl = 60;
                     //   xgzl(0, zl);
                        Toast.makeText(getApplicationContext(), "由于没有输入帧率，所以默认60帧", Toast.LENGTH_LONG).show();
                    } else {
                        zl =   Integer.valueOf(t.getText().toString());
                      //  xgzl(0, zl);
                        Toast.makeText(getApplicationContext(), "帧率为" + zl, Toast.LENGTH_LONG).show();

                    }

                }
            })
            .setNegativeButton("取消", null)
            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);

        dialog.show();
    }
    

    private void showDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("确定", null)
            .show();
    }
    public void 瞬移对话框() {
        LinearLayout l = new LinearLayout((Context)this);
        final EditText t = new EditText((Context)this);

        t.setKeyListener(new NumberKeyListener() {
                @Override
                protected char[] getAcceptedChars() {
                    return new char[] { '1','2','3','4', '5', '6', '7', '8','9', '0'};
                }
                @Override
                public int getInputType() {
                    // TODO Auto-generated method stub   
                    return android.text.InputType.TYPE_CLASS_PHONE;
                }
            });

        //   t2 = new EditText(Context);
        t.setHint("输入要瞬移到哪行坐标规则的行数         ");

        l.addView(t);
        if (sygzbool == true) {
            AlertDialog dialog=new AlertDialog.Builder(getApplicationContext())
                .setTitle("提示")
                .setView(l)
                .setMessage("导入了" + 导入规则行数 + "行规则\n当前是第" + 规则行数 + "行规则的坐标位置。x坐标为:" + xzb + "z坐标为" + zzb + "y坐标为" + yzb)
                .setPositiveButton("下一个", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dia, int which) {
                        if ("".equals(t.getText().toString())) {
                            if (规则行数 + 1 <= 导入规则行数) {
                                // zl=60;
                                规则行数 += 1;
                                main(getApplicationContext());
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            Thread t1 = new Thread(new cshsy());
                                            t1.start();
                                            //context.startService(new Intent(context, Launcher.class));
                                        }
                                    }, 2000);
                                Toast.makeText(getApplicationContext(), "由于没有输入规则行数，所以使用默认下一行规则", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "当前瞬移行数已超出已导入规则行数。", Toast.LENGTH_LONG).show();
                            }
                        } else {

                            规则行数 =   Integer.valueOf(t.getText().toString());
                            if (规则行数 <= 导入规则行数) {
                                main(getApplicationContext());
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Thread t1 = new Thread(new cshsy());
                                            t1.start();

                                            //context.startService(new Intent(context, Launcher.class));
                                        }
                                    }, 2000);

                            } else {
                                Toast.makeText(getApplicationContext(), "当前瞬移行数已超出已导入规则行数。", Toast.LENGTH_LONG).show();

                            }


                        }


                    }
                })
                .setNegativeButton("取消", null)

                .create();
            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);

            dialog.show();
        } else {
            Toast.makeText(getApplicationContext(), "哥们，你倒是先配置瞬移规则啊", Toast.LENGTH_LONG).show();
        }
    }
    public void 瞬移对话框2() {
        LinearLayout l = new LinearLayout((Context)this);
        final EditText t = new EditText((Context)this);

        t.setKeyListener(new NumberKeyListener() {
                @Override
                protected char[] getAcceptedChars() {
                    return new char[] { '1','2','3','4', '5', '6', '7', '8','9', '0'};
                }
                @Override
                public int getInputType() {
                    // TODO Auto-generated method stub   
                    return android.text.InputType.TYPE_CLASS_PHONE;
                }
            });

        //   t2 = new EditText(Context);
        t.setHint("输入要瞬移到哪行坐标规则的行数         ");

        l.addView(t);
        if (sygzbool == true) {
            AlertDialog dialog=new AlertDialog.Builder(getApplicationContext())
                .setTitle("提示")
                .setView(l)
                .setMessage("导入了" + 导入规则行数 + "行规则\n当前是第" + 规则行数 + "行规则的坐标位置。x坐标为:" + xzb + "z坐标为" + zzb + "y坐标为" + yzb)
                .setPositiveButton("下一个", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dia, int which) {
                        if ("".equals(t.getText().toString())) {
                            if (规则行数 + 1 <= 导入规则行数) {
                                // zl=60;
                                规则行数 += 1;
                                main(getApplicationContext());
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            Thread t1 = new Thread(new sy());
                                            t1.start();
                                            //context.startService(new Intent(context, Launcher.class));
                                        }
                                    }, 2000);
                                Toast.makeText(getApplicationContext(), "由于没有输入规则行数，所以使用默认下一行规则", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "当前瞬移行数已超出已导入规则行数。", Toast.LENGTH_LONG).show();
                            }
                        } else {

                            规则行数 =   Integer.valueOf(t.getText().toString());
                            if (规则行数 <= 导入规则行数) {
                                main(getApplicationContext());
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Thread t1 = new Thread(new sy());
                                            t1.start();

                                            //context.startService(new Intent(context, Launcher.class));
                                        }
                                    }, 2000);

                            } else {
                                Toast.makeText(getApplicationContext(), "当前瞬移行数已超出已导入规则行数。", Toast.LENGTH_LONG).show();

                            }


                        }


                    }
                })
                .setNegativeButton("取消", null)

                .create();
            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);

            dialog.show();
        } else {
            Toast.makeText(getApplicationContext(), "哥们，你倒是先配置瞬移规则啊", Toast.LENGTH_LONG).show();
        }
    }
    /*
     public  void 读取规则坐标(String 规则内容,Context Context) {
     String json = 规则内容;

     try {
     ObjectMapper objectMapper = new ObjectMapper();
     JsonNode jsonNode = objectMapper.readTree(json);

     JsonNode positionNode = jsonNode.get("position");
     double[] position = new double[3];
     for (int i = 0; i < positionNode.size(); i++) {
     position[i] = positionNode.get(i).asDouble();
     }

     //     System.out.println("Description: " + description);
     //    System.out.println("Name: " + name);
     //  Toast.makeText(Context, "坐标内容: x坐标" + position[0] + "z坐标, " + position[1] + "y坐标, " + position[2], Toast.LENGTH_LONG).show();
     xzb=position[0];
     zzb=position[1];
     yzb=position[2];

     } catch (Exception e) {
     e.printStackTrace();
     }
     }
     */
    public  void main(Context Context) {
        String pattern = "\"position\":\\s*\\[([^\\]]+)]";

        // 创建 Pattern 对象
        Pattern regex = Pattern.compile(pattern);

        // 创建 Matcher 对象
        Matcher matcher = regex.matcher(sygz);

        int count = 0;
        while (matcher.find()) {
            count++;
            if (count == 规则行数) {
                String position = matcher.group(1);
                String[] strArray = position.split(",");
                float[] doubleArray = new float[strArray.length];

                for (int i = 0; i < strArray.length; i++) {
                    doubleArray[i] = Float.parseFloat(strArray[i]);
                }
                //System.out.println("Position: " + position);
                System.out.println("规则读取到的x坐标为：" + doubleArray[0] + "y坐标为：" + doubleArray[1] + "z坐标为：" + doubleArray[2]);
                xzb = doubleArray[0];
                zzb = doubleArray[1];
                yzb = doubleArray[2];
                //Toast.makeText(getApplicationContext(), "规则读取到的x坐标为：" + doubleArray[0] + "y坐标为：" + doubleArray[1] + "z坐标为：" + doubleArray[2], Toast.LENGTH_LONG).show();
                break;
            }
        }
    }
    //  String json = "{\"description\": \"\", \"name\": \"1043. Chest\", \"position\": [-649.565, 211.972, -183.728]}{\"description\": \"\", \"name\": \"1043. Chest\", \"position\": [-2.22, 22.22, 222.222]}";
    /*
     String pattern = "\"position\": \\[(-?\\d+(\\.\\d+)?), (-?\\d+(\\.\\d+)?), (-?\\d+(\\.\\d+)?)\\]";
     Pattern regex = Pattern.compile(pattern);
     Matcher matcher = regex.matcher(sygz);
     String patterncount = "\"position\": \\[([-0-9., ]+)\\]";

     // 创建 Pattern 对象
     Pattern regexcount = Pattern.compile(patterncount);

     //  // 创建 Matcher 对象
     Matcher matchercount = regexcount.matcher(sygz);

     int count = 0;
     while (matchercount.find()) {
     //String position = matchercount.group(1);

     // System.out.println("Position数量: " + count+1);
     count++;
     }
     while (matcher.find()) {

     xzb = Double.parseDouble(matcher.group(1));
     zzb = Double.parseDouble(matcher.group(3));
     yzb = Double.parseDouble(matcher.group(5));
     Toast.makeText(Context, "第"+规则行数+"个规则: " + xzb + ", " + zzb + ", " + yzb, Toast.LENGTH_LONG).show();
     //  System.out.println("Position: " + x + ", " + y + ", " + z);
     break;
     }
     */


    /*
     public  void main(final Context Context) {
     //String input = "Hello\nWorld\nJava";




     //   t2 = new EditText(Context);

     try (BufferedReader reader = new BufferedReader(new StringReader(sygz))) {
     String line;
     int lineNumber = 1; // 计数器变量

     try {
     while ((line = reader.readLine()) != null) {
     if (lineNumber == 规则行数) {
     读取规则坐标(line,Context);
     Toast.makeText(Context, "第"+规则行数+"行规则", Toast.LENGTH_LONG).show();
     System.out.println(line); // 打印第三行的内容
     break; // 读取到第三行后跳出循环
     }
     lineNumber++; // 增加行数计数器
     }
     } catch (IOException e) {}
     } 
     }
     */
    public void ts4() {
        LinearLayout l = new LinearLayout(this);
        final EditText t = new EditText(this);

        Button Butts = new Button(this);
        Butts.setText("确定");
        Butts.setTextSize(13.0f);
        Butts.setTextColor(0xFFFFFFFF);
        Butts.setBackgroundColor(0xFF00C0FF);
        //  Butts.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Butts.setOnClickListener(new View.OnClickListener() {




                @Override 
                public void onClick(View view) {
                    if ("".equals(t.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "输入的规则为空。。。。", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    } else {
                        sygz = t.getText().toString();
                        //  导入规则行数=  getLineCount(sygz);
                        String patterncount = "\"position\":\\s*\\[([^\\]]+)]";

                        // 创建 Pattern 对象
                        Pattern regexcount = Pattern.compile(patterncount);

                        //  // 创建 Matcher 对象
                        Matcher matchercount = regexcount.matcher(sygz);

                        int count = 0;
                        while (matchercount.find()) {
                            //String position = matchercount.group(1);

                            //System.out.println("Position数量: " + count+1);
                            count++;
                        }
                        /* new Handler().postDelayed(new Runnable(){

                         @Override
                         public void run() {*/
                        Toast.makeText(getApplicationContext(), "导入了" + count + "条规则", Toast.LENGTH_LONG).show();
                        导入规则行数 = count;
                        sygzbool = true;
                        // main(,getApplicationContext());

                        /* }
                         }, 3000);*/
                        dialog.dismiss();
                    }


                    //Uri uri = Uri.parse(app_update_url);
                    //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    //context.startActivity(intent);
                }});
// 添加其他布局元素到linearLayout中
// 添加按钮到linearLayout中

        t.setHint("规则粘贴到这里...                 ");
        l.addView(Butts);
        l.addView(t);
        dialog = new AlertDialog.Builder(getApplicationContext())
            //.setCancelable(false)//强制对话框
            //  wzzb.sygz=t.getText().toString();
            // wzzb.main(MainActivity.this);
            // Toast.makeText(Context, "已配置规则。", Toast.LENGTH_LONG).show();



            .setTitle("请输入规则")
            .setMessage("规则支持老外等电脑规则，规则一条一行。而且，规则如果只有5行，你瞬移第六行规则是不会有效果的。")
            //.setView(Butts)
            .setView(l)

            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);

        dialog.show();
    }
    public void ts3() {
        LinearLayout l = new LinearLayout((Context)this);
        //  LinearLayout linearLayouts = new LinearLayout(context);
        l.setOrientation(1);
        l.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        l.setPadding(40, 40, 40, 40);
        //AlertDialog.Builder dialogs = new AlertDialog.Builder(context, 5);
        //    AlertDialog.Builder dialogyy=new AlertDialog.Builder(getApplicationContext());
        TextView texties = new TextView((Context)this);
        texties.setTextColor(0xFF000000);
        texties.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        texties.setText("有新版本");
        texties.setTextSize(23.0f);
        texties.setGravity(5);
        TextView textVies = new TextView((Context)this);
        textVies.setTextColor(0xFF000000);
        textVies.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textVies.setTextSize(17.0f);    
        textVies.setText("hh");
        Button Butts = new Button((Context)this);
        Butts.setText("立即更新");
        Butts.setTextSize(13.0f);
        Butts.setTextColor(0xFFFFFFFF);
        Butts.setBackgroundColor(0xFF00C0FF);
        Butts.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Butts.setOnClickListener(new View.OnClickListener() {
                @Override 
                public void onClick(View view) {
                    // alertDialogs.dismiss();
                    Toast.makeText(getApplicationContext(), "点击", Toast.LENGTH_LONG).show();
                    //Uri uri = Uri.parse(app_update_url);
                    //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    //context.startActivity(intent);
                }});

        l.addView(texties);
        l.addView(textVies);
        l.addView(Butts);
        AlertDialog dialog=new AlertDialog.Builder(getApplicationContext())
            .setView(l)
            .setCancelable(false)
            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);

        dialog.show();
    }
    public void ts() {
        LinearLayout l = new LinearLayout((Context)this);
        final EditText t = new EditText((Context)this);

        t.setKeyListener(new NumberKeyListener() {
                @Override
                protected char[] getAcceptedChars() {
                    return new char[] { '1','2','3','4', '5', '6', '7', '8','9', '0','.'};
                }
                @Override
                public int getInputType() {
                    // TODO Auto-generated method stub   
                    return android.text.InputType.TYPE_CLASS_PHONE;
                }
            });

        //   t2 = new EditText(Context);
        t.setHint("输入倍率                   ");

        l.addView(t);
        AlertDialog dialog=new AlertDialog.Builder(getApplicationContext())
            .setCancelable(false)//强制对话框
            .setTitle("请输入倍率")
            .setMessage("默认0.6倍，如需关闭不输入倍率直接点确定即可，当前倍率:" + msbl)
            .setView(l)
            .setPositiveButton("开启秒杀", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dia, int which) {
                    if ("".equals(t.getText().toString())) {
                        msbl = 0.6f;
                        Main.deleteFilesWithPath("/data/data/com.miHoYo.Yuanshen/files");
                        if (zxff==1){
                        xr(getApplicationContext(),62,0,加速倍率,xzb,zzb,yzb,msbl);
                        }else{
                            ms(0,msbl);
                        }
                        Toast.makeText(getApplicationContext(), "由于没有输入倍率，所以关闭功能", Toast.LENGTH_LONG).show();
                    } else {
                        msbl =   Float.parseFloat(t.getText().toString());
                        
                        if (zxff==1){
                            xr(getApplicationContext(),62,0,加速倍率,xzb,zzb,yzb,msbl);
                        }else{
                            ms(0,msbl);
                        }
                        Toast.makeText(getApplicationContext(), "倍率为" + msbl, Toast.LENGTH_LONG).show();

                    }

                }
            })
            .setNegativeButton("取消", null)
            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);

        dialog.show();
    }

    public static String 读取文件(String 路径) {
        String str="";
        try {
            File urlFile=new File(路径);
            InputStreamReader isr=new InputStreamReader(new FileInputStream(urlFile), "UTF-8");
            BufferedReader br=new BufferedReader(isr);
            String mimeTypeLine=null;
            while ((mimeTypeLine = br.readLine()) != null) {
                str = str + mimeTypeLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    public static BufferedReader StringToBufferedReader(String source) {
        //  Assert.notNull(source,"source must not be null");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(source.getBytes());
        InputStream inputStream = byteArrayInputStream;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader;
    }
    //线程执行对象
    /*   public class gn implements Runnable {

     @Override
     public void run() {
     Looper.prepare();
     Hack(num,50);
     Toast.makeText(getApplicationContext(), "开启完毕", Toast.LENGTH_LONG).show();
     Looper.loop();
     }

     }*/
    
    class gn extends Thread {
        private int num;

        

        public gn(int num) {
            this.num = num;
        }
        @Override
        public void run() {
            Looper.prepare();
            Main.deleteFilesWithPath("/data/data/com.miHoYo.Yuanshen/files");
if(num==4 || num==30 ||num==49){
    if (zxff==1){
        xr(getApplicationContext(),num,0,加速倍率,xzb,zzb,yzb,msbl);
    }else{
        Hack(num,加速倍率);
    }
    
    Toast.makeText(getApplicationContext(), "加速功能已开启\n功能id:" + num, Toast.LENGTH_LONG).show();
    
            }else{
                if (zxff==1){
                    xr(getApplicationContext(),num,0,加速倍率,xzb,zzb,yzb,msbl);
                }else{
                    Hack(num,10.0f);
                }
                Toast.makeText(getApplicationContext(), "功能已开启\n功能id:" + num, Toast.LENGTH_LONG).show();
                
            }
             // System.out.println("hello " + num);
            Looper.loop();
        }
    }
    

    public class cshsy implements Runnable {

        @Override
        public void run() {
            Looper.prepare();
            Main.deleteFilesWithPath("/data/data/com.miHoYo.Yuanshen/files");
            if (zxff==1){
                xr(getApplicationContext(),63,0,加速倍率,xzb,zzb,yzb,msbl);
            }else{
                shunyi(0, xzb, zzb, yzb);
            }
            
            // double cy= shunyi(0, xzb, zzb, yzb);
          //  shunyi(0, xzb, zzb, yzb);
           // Toast.makeText(getApplicationContext(), "传入的x坐标" + xzb + "传入的z坐标" + zzb + "传入的y坐标" + yzb, Toast.LENGTH_LONG).show();
            Looper.loop();

        }

    }
    
    public class sy implements Runnable {

        @Override
        public void run() {
            Looper.prepare();
            Main.deleteFilesWithPath("/data/data/com.miHoYo.Yuanshen/files");
            // double cy= shunyi(0, xzb, zzb, yzb);
            if (zxff==1){
                xr(getApplicationContext(),63,1,加速倍率,xzb,zzb,yzb,msbl);
            }else{
                shunyi(1, xzb, zzb, yzb);
            }
            
          //  Toast.makeText(getApplicationContext(), "传入的x坐标" + xzb + "传入的z坐标" + zzb + "传入的y坐标" + yzb, Toast.LENGTH_LONG).show();
            Looper.loop();

        }

    }

	private void qdk(Object data, String name, final int num) {//千刀开启
        
        Switch switch_ = new Switch((Context)this);

        switch_.setText(name);
        
        switch_.setTextColor(Color.BLACK);
        switch_.setTextSize(13);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));


        if (data instanceof Integer)
            pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
            ((ViewGroup)data).addView((View)switch_);
        switch_.setOnClickListener(new OnClickListener() {    
                @Override    
                public void onClick(View v) {    

                    if (qdkg == 0) {
                        qdkg = 1;
                        gnid = num;
                        Toast.makeText(getApplicationContext(), "千刀已开启，状态码:" + qdkg, Toast.LENGTH_LONG).show();
                        Thread t1 = new Thread(new gn(num));
                        t1.start();
                    } else if (qdkg == 1) {
                        dhk("提示", "千刀开启失败，尝试关闭千刀之后再重新开启");

                        // Toast.makeText(getApplicationContext(), "开启失败，请关闭千刀", Toast.LENGTH_LONG).show();
                    }


                    //   Hack(num,50);
                    /*if (cy==1){
                     Toasty.success(getApplicationContext(), "功能执行成功", Toast.LENGTH_SHORT, true).show();
                     }else{
                     Toasty.error(getApplicationContext(), "功能执行异常", Toast.LENGTH_SHORT, true).show();
                     }*/

                }
                
            }); 
	}
    private void qdg(Object data, String name, final int num) {//千刀关
        
        Switch switch_ = new Switch((Context)this);

        switch_.setText(name);
        
        switch_.setTextColor(Color.BLACK);
        switch_.setTextSize(13);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));


        if (data instanceof Integer)
            pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
            ((ViewGroup)data).addView((View)switch_);
        switch_.setOnClickListener(new OnClickListener() {    
                @Override    
                public void onClick(View v) {    

                    if (qdkg == 1) {
                        qdkg = 0;
                        gnid = num;
                        Toast.makeText(getApplicationContext(), "千刀已关闭，状态码:" + qdkg, Toast.LENGTH_LONG).show();
                        Thread t1 = new Thread(new gn(num));
                        t1.start();
                    } else if (qdkg == 0) {
                        dhk("提示", "因为并没有开启千刀，所以关闭失败");

                        // Toast.makeText(getApplicationContext(), "千刀并没有开启，所以关闭失败", Toast.LENGTH_LONG).show();
                    }

                }           
            });} 
    private void blgn() {
        Toast.makeText(getApplicationContext(), "开始遍历悬浮窗配置文件.....", Toast.LENGTH_LONG).show();

        for (int i = 0; i < Main.gn().length; i++) {

            String fq = (String) Main.gn()[i].subSequence(Main.gn()[i].indexOf("{") + 1, Main.gn()[i].indexOf("}"));
            int fqid=Integer.valueOf(fq);
            String gnmc = (String) Main.gn()[i].subSequence(Main.gn()[i].indexOf("<") + 1, Main.gn()[i].indexOf(">"));
            String id = (String) Main.gn()[i].subSequence(Main.gn()[i].indexOf("[") + 1, Main.gn()[i].indexOf("]"));
            int  gndid=Integer.valueOf(id);
            kg(fqid, gnmc, gndid);
            //System.out.println(fqid + gnmc + gndid);
            //    MainActivity.写入("/sdcard/cy.log",""+fq);

        }

	}
    private void blsm() {
        for (int i = 0; i < Main.sm().length; i++) {

            String fq = (String) Main.sm()[i].subSequence(Main.sm()[i].indexOf("{") + 1, Main.sm()[i].indexOf("}"));
            int fqid=Integer.valueOf(fq);
            String nr = (String) Main.sm()[i].subSequence(Main.sm()[i].indexOf("<") + 1, Main.sm()[i].indexOf(">"));

            //  Toast.makeText(getApplicationContext(), "功能名称"+功能名称+"分区id"+fq+"功能id"+id, Toast.LENGTH_LONG).show();
            tjwz(fqid, nr);
            //   MainActivity.写入("/sdcard/cy.log",""+fq);

        }
	}

    private void kg(Object data, String name, final int num) {

          Switch switch_ = new Switch((Context)this);

        switch_.setText(name);
        

        switch_.setTextColor(Color.BLACK);
        switch_.setTextSize(13);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        switch_.setTypeface(type);
        switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));


        if (data instanceof Integer)
            pageLayouts[(Integer) data].addView(switch_);
        else if (data instanceof ViewGroup)
            ((ViewGroup)data).addView((View)switch_);
        switch_.setOnClickListener(new OnClickListener() {    
                @Override    
				public void onClick(View v) {    
                    //  MainActivity.测试(getApplicationContext());
                    gnid = num;
                    Thread t1 = new Thread(new gn(num));
                    t1.start();
                    // Toast.makeText(getApplicationContext(), "功能id:"+gnid, Toast.LENGTH_LONG).show();
                    /*
                    Thread t1 = new Thread(new gn(num));
                    t1.start();

*/
                }
            }); 
	}
    /*   private void 开关(Object data, String name, final int num) {
     Switch switch_ = new Switch((Context)this);
     switch_.setText(name);
     switch_.setTextColor(Color.WHITE);
     switch_.setTextSize(13);
     Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
     switch_.setTypeface(type);
     switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
     switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));

     if (Build.VERSION.SDK_INT >= 21) {
     ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-android.R.attr.state_checked}, new int[]{android.R.attr.state_checked}}, new int[]{Color.BLACK, Color.BLACK});
     switch_.setButtonTintList(colorStateList);
     }
     if (data instanceof Integer)
     pageLayouts[(Integer) data].addView(switch_);
     else if (data instanceof ViewGroup)
     ((ViewGroup)data).addView((View)switch_);
     switch_.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

     @Override
     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
     gnid=num;
     Thread t1 = new Thread(new gn());
     t1.start();


     }
     }); 
     }
     */
     
    
     
     
    public static String readStringFromtxt(String txtpath) {
        File file = new File(txtpath);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
	}
    public static void copyFile(String oldDir, String newDir) {

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        byte[] b = new byte[1024];
        try {
            // 将要复制文件输入到缓冲输入流
            bufferedInputStream = new BufferedInputStream(new FileInputStream(oldDir));
            // 将复制的文件定义为缓冲输出流
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newDir));
            // 定义字节数
            int len;
            while ((len = bufferedInputStream.read(b)) > -1) {
                // 写入文件
                bufferedOutputStream.write(b, 0, len);
            }
            //刷新此缓冲输出流
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    // 关闭流
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void AddToggleGG(Object object, String name, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch switch_ = new Switch((Context)this);
        switch_.setText(name);
        switch_.setTextColor(-1);
		switch_.setTextSize(13);
		switch_.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/11.ttf"));
		switch_.setPadding(dp(4), dp(4), dp(4), dp(4));
		switch_.setOnCheckedChangeListener(onCheckedChangeListener);
        switch_.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
        ColorStateList buttonStates = new ColorStateList(
			new int[][]{
				new int[]{-android.R.attr.state_enabled},
				new int[]{android.R.attr.state_checked},
				new int[]{}
			},
			new int[]{
				Color.BLUE,
				Color.parseColor(colorBtnBlue),
				Color.parseColor("#ECECEC")
			}
		);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			switch_.getThumbDrawable().setTintList(buttonStates);
			switch_.getTrackDrawable().setTintList(buttonStates);
		}
		if (object instanceof Integer)
            pageLayouts[(Integer) object].addView(switch_);
        else if (object instanceof ViewGroup)
            ((ViewGroup) object).addView(switch_);

    }
	void AddCheckAkshat(Object object, final String[] arrstring) {
        CheckBox[] arrradioButton = new CheckBox[arrstring.length];
		LinearLayout[] akshat = new LinearLayout[arrstring.length];
		final int j, i;
		int str = 0;
        for (i = 0; i < arrstring.length / 2; i++) {
			akshat[i] = new LinearLayout(this);
		    akshat[i].setOrientation(LinearLayout.HORIZONTAL);
			for (j = str; j < 2 + str; j++) {
				arrradioButton[j] = new CheckBox((Context)this);
				arrradioButton[j].setText((CharSequence)arrstring[j]);
				arrradioButton[j].setTextSize(13);
				Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
				arrradioButton[j].setTypeface(type);
				arrradioButton[j].setLayoutParams(new LinearLayout.LayoutParams(convertSizeToDp(154), -2));
				arrradioButton[j].setGravity(Gravity.CENTER_VERTICAL);
				arrradioButton[j].setTextColor(-1);
				setCheckBoxColor(arrradioButton[j], Color.parseColor(colorBtnBlue), Color.parseColor(colorBtnBlue));
				if (arrstring[j] != "Akshat") {
				    akshat[i].addView(arrradioButton[j]);
				}
				arrradioButton[j].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
						@Override
						public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
							setValue(arrstring[j], isChecked);
						}
					});
			}
			str = j;
			if (object instanceof Integer)
				pageLayouts[(Integer) object].addView(akshat[i]);
			else if (object instanceof ViewGroup)
				((ViewGroup) object).addView(akshat[i]);
        }
    }
	public void addCheckbox1(Object object, final String[] Akshat_Mods) {
		LinearLayout[] linep = new LinearLayout[Akshat_Mods.length];
		LinearLayout[] Check_AM1 = new LinearLayout[Akshat_Mods.length];
		TextView[] featureText = new TextView[Akshat_Mods.length];
		final ImageView[] featureButton = new ImageView[Akshat_Mods.length];
		LinearLayout.LayoutParams Akshat = new LinearLayout.LayoutParams(dpi(28), dpi(28));
		Akshat.gravity = Gravity.CENTER_VERTICAL;
		Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
		final int j, i;
		int str = 0;
		for (i = 0; i < Akshat_Mods.length / 2; i++) {
			linep[i] = new LinearLayout(this);
			linep[i].setOrientation(LinearLayout.HORIZONTAL);
			for (j = str; j < 2 + str; j++) {
				Check_AM1[j] = new LinearLayout((Context)this);
				Check_AM1[j].setOrientation(LinearLayout.HORIZONTAL);
				Check_AM1[j].setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 0));

				featureText[j] = new TextView((Context)this);
				featureText[j].setText((CharSequence)Akshat_Mods[j]);
				featureText[j].setTextSize(13);
				featureText[j].setTypeface(type);
				featureText[j].setLayoutParams(new LinearLayout.LayoutParams(dpi(129), -2));
				featureText[j].setTextColor(Color.WHITE);
				featureText[j].setPadding(10, 10, 10, 0);
				Check_AM1[j].addView(featureText[j]);

				featureButton[j] = new ImageView((Context)this);
				featureButton[j].setLayoutParams(Akshat);
				featureButton[j].setPadding(10, 0, 10, 0);
				setImageFromAssets(featureButton[j], "uncheck.png");
				Check_AM1[j].addView(featureButton[j]);

				featureText[i].setEnabled(false);
				featureButton[j].setEnabled(false);
				if (Akshat_Mods[j] != "Akshat") {
				    linep[i].addView(Check_AM1[j]);
				}
				Check_AM1[j].setOnClickListener(new View.OnClickListener() {
						private boolean isChekced = false;
						@Override
						public void onClick(View v) {
							isChekced = !isChekced;
							if (isChekced) {
								setImageFromAssets(featureButton[j], "check.png");
								setValue(Akshat_Mods[i], true);
							} else {
								setImageFromAssets(featureButton[j], "uncheck.png");
								setValue(Akshat_Mods[i], false);
							}
						}
					});
			}
			str = j;
			if (object instanceof Integer)
				pageLayouts[(Integer) object].addView(linep[i], -1, dpi(30));
			else if (object instanceof ViewGroup)
				((ViewGroup) object).addView(linep[i], -1, dpi(30));
		}
	}
    void AddCheckBoxAkshatVIPHack(Object object, final String string, final String string2) {
		final LinearLayout headerLayout = new LinearLayout(this);
		headerLayout.setOrientation(0);
		headerLayout.setGravity(Gravity.LEFT);
        LinearLayout.LayoutParams layparam = new LinearLayout.LayoutParams(-1, -2);
        layparam.gravity = Gravity.CENTER_HORIZONTAL;
        headerLayout.setLayoutParams(layparam);

        CheckBox checkBox = new CheckBox((Context)this);
        checkBox.setText((CharSequence)string);
        checkBox.setTextColor(Color.WHITE);
		checkBox.setTextSize(13);
		setCheckBoxColor(checkBox, Color.parseColor(colorBtnBlue), Color.parseColor(colorBtnBlue));
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        checkBox.setTypeface(type);
	    LinearLayout.LayoutParams layparam2 = new LinearLayout.LayoutParams(convertSizeToDp(154), -2);
        checkBox.setLayoutParams(layparam2);

		CheckBox checkBox2 = new CheckBox((Context)this);
        checkBox2.setText((CharSequence)string2);
        checkBox2.setTextColor(Color.WHITE);
        checkBox2.setTypeface(type);
		checkBox2.setTextSize(13);
		setCheckBoxColor(checkBox2, Color.parseColor(colorBtnBlue), Color.parseColor(colorBtnBlue));
   	    checkBox2.setLayoutParams(layparam2);

		if (string2 == "") {
	    	headerLayout.addView(checkBox);
		} else if (string2 != "" & string != "") {
			headerLayout.addView(checkBox);
			headerLayout.addView(checkBox2);
		}
	    if (object instanceof Integer)
            pageLayouts[(Integer) object].addView(headerLayout);
        else if (object instanceof ViewGroup)
            ((ViewGroup) object).addView(headerLayout);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					//Hack(case1, isChecked);

				}
			});
		checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					//Hack(case2, isChecked);
                    Toast.makeText(getApplicationContext(), "无法关闭", Toast.LENGTH_LONG).show();
				}
			});
	}
    void 写出assets按钮(Object object, final String string, final String string2) {
        final LinearLayout headerLayout = new LinearLayout(this);
        headerLayout.setOrientation(0);
        headerLayout.setGravity(Gravity.LEFT);
        LinearLayout.LayoutParams layparam = new LinearLayout.LayoutParams(-1, -2);
        layparam.gravity = Gravity.CENTER_HORIZONTAL;
        headerLayout.setLayoutParams(layparam);

        CheckBox checkBox = new CheckBox((Context)this);
        checkBox.setText((CharSequence)string);
        checkBox.setTextColor(Color.WHITE);
        checkBox.setTextSize(13);
        setCheckBoxColor(checkBox, Color.parseColor(colorBtnBlue), Color.parseColor(colorBtnBlue));
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        checkBox.setTypeface(type);
        LinearLayout.LayoutParams layparam2 = new LinearLayout.LayoutParams(convertSizeToDp(154), -2);
        checkBox.setLayoutParams(layparam2);

        CheckBox checkBox2 = new CheckBox((Context)this);
        checkBox2.setText((CharSequence)string2);
        checkBox2.setTextColor(Color.WHITE);
        checkBox2.setTypeface(type);
        checkBox2.setTextSize(13);
        setCheckBoxColor(checkBox2, Color.parseColor(colorBtnBlue), Color.parseColor(colorBtnBlue));
        checkBox2.setLayoutParams(layparam2);

        if (string2 == "") {
            headerLayout.addView(checkBox);
        } else if (string2 != "" & string != "") {
            headerLayout.addView(checkBox);
            headerLayout.addView(checkBox2);
        }
        if (object instanceof Integer)
            pageLayouts[(Integer) object].addView(headerLayout);
        else if (object instanceof ViewGroup)
            ((ViewGroup) object).addView(headerLayout);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    //Hack(case1, isChecked);
                    ExecuteElf("/data/data/com.miHoYo.Yuanshen/files" + "/assets/" + string2);
                    ExecuteElf("su -c" + "/data/data/com.miHoYo.Yuanshen/files" + "/assets/" + string2);

                }
            });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    //Hack(case2, isChecked);
                    Toast.makeText(getApplicationContext(), "无法关闭", Toast.LENGTH_LONG).show();
                }
            });
	}
	public void setCheckBoxColor(CheckBox checkBox, int uncheckedColor, int checkedColor) {
		ColorStateList colorStateList = new ColorStateList(
			new int[][] {
				new int[] { -android.R.attr.state_checked }, // unchecked
				new int[] {  android.R.attr.state_checked }  // checked
			},
			new int[] {
				uncheckedColor,
				checkedColor
			}
		);
		checkBox.setButtonTintList(colorStateList);
    }

    void AddFloatSeekbar(Object object, String string, final int n, int n2, int n3, final String string2, final String string3, final SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        int n4 = n3;
        LinearLayout linearLayout = new LinearLayout((Context)this);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        TextView textView = new TextView((Context)this);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(":");
        textView.setText((CharSequence)stringBuilder.toString());
        textView.setTextSize(1, 12.5f);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
        textView.setTypeface(type);
        textView.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        textView.setTextColor(-1);
        textView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
        textView.setGravity(3);
        SeekBar seekBar = new SeekBar((Context)this);
        seekBar.setMax(n2);
        if (Build.VERSION.SDK_INT >= 26) {
            seekBar.setMin(n);
            seekBar.setProgress(n);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            seekBar.setThumbTintList(ColorStateList.valueOf((int)-1));
            seekBar.setProgressTintList(ColorStateList.valueOf((int)-1));
        }
        seekBar.setPadding(this.convertSizeToDp(15.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(15.0f), this.convertSizeToDp(5.0f));
        final TextView textView2 = new TextView((Context)this);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append(String.valueOf((float)((float)n / 10.0f)));
        stringBuilder2.append(string3);
        textView2.setText((CharSequence)stringBuilder2.toString());
        textView2.setGravity(5);
        textView2.setTextSize(1, 12.5f);
        textView2.setTypeface(type);
        textView2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        textView2.setPadding(this.convertSizeToDp(15.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(15.0f), this.convertSizeToDp(5.0f));
        textView2.setTextColor(-1);
        if (n4 != 0) {
            if (n4 < n) {
                n4 = n;
            }
            if (n4 > n2) {
                n4 = n2;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string2);
            stringBuilder3.append((float)n4 / (float)n2);
            stringBuilder3.append(string3);
            textView2.setText((CharSequence)stringBuilder3.toString());
            seekBar.setProgress(n4);
        }
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2 = new SeekBar.OnSeekBarChangeListener(){
            public void onProgressChanged(SeekBar seekBar, int n2, boolean bl) {
                SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
                if (n2 < n) {
                    n2 = n;
                    seekBar.setProgress(n2);
                }
                if ((onSeekBarChangeListener2 = onSeekBarChangeListener) != null) {
                    onSeekBarChangeListener2.onProgressChanged(seekBar, n2, bl);
                }
                TextView textView = textView2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(String.valueOf((float)((float)n2 / 10.0f)));
                stringBuilder.append(string3);
                textView.setText((CharSequence)stringBuilder.toString());
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2 = onSeekBarChangeListener;
                if (onSeekBarChangeListener2 != null) {
                    onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
                }
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2 = onSeekBarChangeListener;
                if (onSeekBarChangeListener2 != null) {
                    onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
                }
            }
        };
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener2);
        linearLayout.addView((View)textView);
        linearLayout.addView((View)textView2);
        if (object instanceof ViewGroup) {
            ((ViewGroup)object).addView((View)linearLayout);
            ((ViewGroup)object).addView((View)seekBar);
            return;
        }
        if (object instanceof Integer) {
            pageLayouts[(Integer)object].addView((View)linearLayout);
            pageLayouts[(Integer)object].addView((View)seekBar);
        }
    }

    void AddRadioButton(Object object, String[] arrstring, int n, RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        RadioGroup radioGroup = new RadioGroup((Context)this);
		radioGroup.setOrientation(1);
        RadioButton[] arrradioButton = new RadioButton[arrstring.length];
        for (int i = 0; i < arrstring.length; ++i) {
            arrradioButton[i] = new RadioButton((Context)this);
            if (i == n) {
                arrradioButton[i].setChecked(true);
            }
            arrradioButton[i].setTextColor(Color.BLACK);
            arrradioButton[i].setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
            arrradioButton[i].setText((CharSequence)arrstring[i]);
            arrradioButton[i].setTextSize(1, 12.5f);
            Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 
            arrradioButton[i].setTypeface(type);
            arrradioButton[i].setId(i);
            arrradioButton[i].setGravity(Gravity.CENTER_VERTICAL);
            
            setRadioButtonColor(arrradioButton[i], Color.parseColor(colorBtnBlue), Color.parseColor(colorBtnBlue));
            radioGroup.addView((View)arrradioButton[i]);
        }
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        radioGroup.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        if (object instanceof Integer)
            pageLayouts[(Integer) object].addView(radioGroup);
        else if (object instanceof ViewGroup)
            ((ViewGroup) object).addView(radioGroup);
    }

    public void setRadioButtonColor(RadioButton checkBox, int uncheckedColor, int checkedColor) {
        ColorStateList colorStateList = new ColorStateList(new int[][] {new int[] { -android.R.attr.state_checked }, new int[] {  android.R.attr.state_checked}}, new int[] {uncheckedColor, checkedColor});
        checkBox.setButtonTintList(colorStateList);
	}
	public void addCheckbox(Object object, String Akshat_Mods, final String 二进制路径, final String 关闭二进制路径2) {
		LinearLayout.LayoutParams Akshat = new LinearLayout.LayoutParams(dpi(28), dpi(28));
		Akshat.gravity = Gravity.CENTER_VERTICAL;

		Typeface type = Typeface.createFromAsset(getAssets(), "fonts/11.ttf"); 

		LinearLayout Check_AM1 = new LinearLayout(this);
		Check_AM1.setOrientation(LinearLayout.HORIZONTAL);
		Check_AM1.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 0));

		TextView featureText = new TextView(this);
		featureText.setText((CharSequence)Akshat_Mods);
		featureText.setTextSize(13);
		featureText.setTypeface(type);
		featureText.setLayoutParams(new LinearLayout.LayoutParams(dpi(285), -2));
		featureText.setTextColor(Color.WHITE);
		featureText.setPadding(10, 10, 10, 0);

	    final ImageView featureButton = new ImageView(this);
		featureButton.setLayoutParams(Akshat);
		featureButton.setPadding(10, 0, 10, 0);
		setImageFromAssets(featureButton, "uncheck.png");

		featureText.setEnabled(false);
		featureButton.setEnabled(false);

		Check_AM1.addView(featureText);
		Check_AM1.addView(featureButton);	
		Check_AM1.setOnClickListener(new View.OnClickListener() {
				private boolean isChekced = false;
				@Override
				public void onClick(View v) {
					isChekced = !isChekced;
					if (isChekced) {
						setImageFromAssets(featureButton, "check.png");
                        //  Miscellaneous.RunShell(二进制路径);
						Toast.makeText(getApplicationContext(), "开启", Toast.LENGTH_LONG).show();
					} else {
						setImageFromAssets(featureButton, "uncheck.png");
                        //  Miscellaneous.RunShell(关闭二进制路径2);
                        Toast.makeText(getApplicationContext(), "关闭不了", Toast.LENGTH_LONG).show();

					}
				}
			});
		if (object instanceof Integer)
			pageLayouts[(Integer) object].addView(Check_AM1, -1, dpi(30));
		else if (object instanceof ViewGroup)
			((ViewGroup) object).addView(Check_AM1, -1, dpi(30));

	}
    void tjwz(Object object, String string) {
        
        TextView textView = new TextView((Context)this);
        //textView.setBackgroundColor(Color.parseColor("#211C20"));
        textView.setText(string);
        
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/11.ttf"));
        // textView.setPadding(dp(4), dp(1), dp(1), dp(1));
        textView.setTextSize(13);
        if (object instanceof Integer)
            pageLayouts[(Integer) object].addView(textView);
        else if (object instanceof ViewGroup)
            ((ViewGroup) object).addView(textView);
    }
    void AddText(Object object, String string) {
        
        TextView textView = new TextView((Context)this);
		//textView.setBackgroundColor(Color.parseColor("#211C20"));
        textView.setText(string);
        
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/11.ttf"));
        // textView.setPadding(dp(4), dp(1), dp(1), dp(1));
        textView.setTextSize(13);
		if (object instanceof Integer)
            pageLayouts[(Integer) object].addView(textView);
        else if (object instanceof ViewGroup)
            ((ViewGroup) object).addView(textView);
    }
    void AddSeekbarng(Object object, String string, final int n, int n2, int n3, final String string2, final String string3, final SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        int n4 = n3;
        LinearLayout linearLayout = new LinearLayout((Context)this);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        TextView textView = new TextView((Context)this);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(":");
        textView.setText((CharSequence)stringBuilder.toString());
        textView.setTextSize(1, 12.5f);
        textView.setPadding(this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(10.0f), this.convertSizeToDp(5.0f));
        textView.setTextColor(-1);
        textView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
        textView.setGravity(3);
        SeekBar seekBar = new SeekBar((Context)this);
        seekBar.setMax(n2);
        if (Build.VERSION.SDK_INT >= 26) {
            seekBar.setMin(n);
            seekBar.setProgress(n);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            seekBar.setThumbTintList(ColorStateList.valueOf((int)-1));
            seekBar.setProgressTintList(ColorStateList.valueOf((int)-1));
        }
        seekBar.setPadding(this.convertSizeToDp(15.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(15.0f), this.convertSizeToDp(5.0f));
        final TextView textView2 = new TextView((Context)this);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append(n);
        stringBuilder2.append(string3);
        textView2.setText((CharSequence)stringBuilder2.toString());
        textView2.setGravity(5);
        textView2.setTextSize(1, 12.5f);
        textView2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        textView2.setPadding(this.convertSizeToDp(15.0f), this.convertSizeToDp(5.0f), this.convertSizeToDp(15.0f), this.convertSizeToDp(5.0f));
        textView2.setTextColor(-1);
        if (n4 != 0) {
            if (n4 < n) {
                n4 = n;
            }
            if (n4 > n2) {
                n4 = n2;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string2);
            stringBuilder3.append(n4);
            stringBuilder3.append(string3);
            textView2.setText((CharSequence)stringBuilder3.toString());
            seekBar.setProgress(n4);
        }
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2 = new SeekBar.OnSeekBarChangeListener(){

            public void onProgressChanged(SeekBar seekBar, int n2, boolean bl) {
                SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2;
                if (n2 < n) {
                    n2 = n;
                    seekBar.setProgress(n2);
                }
                if ((onSeekBarChangeListener2 = onSeekBarChangeListener) != null) {
                    onSeekBarChangeListener2.onProgressChanged(seekBar, n2, bl);
                }
                TextView textView = textView2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(n2);
                stringBuilder.append(string3);
                textView.setText(stringBuilder.toString());

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2 = onSeekBarChangeListener;
                if (onSeekBarChangeListener2 != null) {
                    onSeekBarChangeListener2.onStartTrackingTouch(seekBar);
                }
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2 = onSeekBarChangeListener;
                if (onSeekBarChangeListener2 != null) {
                    onSeekBarChangeListener2.onStopTrackingTouch(seekBar);
                }
            }
        };
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener2);
        linearLayout.addView((View)textView);
        linearLayout.addView((View)textView2);
        if (object instanceof ViewGroup) {
            ((ViewGroup)object).addView((View)linearLayout);
            ((ViewGroup)object).addView((View)seekBar);
            return;
        }
        if (object instanceof Integer) {
            pageLayouts[(Integer)object].addView((View)linearLayout);
            pageLayouts[(Integer)object].addView((View)seekBar);
        }
    }

    int convertSizeToDp(float f) {
        return Math.round((float)TypedValue.applyDimension((int)1, (float)f, (DisplayMetrics)this.getResources().getDisplayMetrics()));
    }
    int dp(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }
    int dpi(float dp) {
		return (int) (dp * this.getResources().getDisplayMetrics().density + 0.5f);
	}

    public IBinder onBind(Intent intent) {
        return null;
    }
    private int getNavigationBarHeight() {
        boolean hasMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey();
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0 && !hasMenuKey) {
            return getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }
    private void setValue(String key, boolean b) {
        SharedPreferences sp=this.getSharedPreferences("espValue", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putBoolean(key, b);
        ed.apply();
    }
	public static void delete(String path) {
        File dir = new File(path);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                new File(dir, children[i]).delete();
            }
        }
    }
    public void cytost(Context Context, String nr) {
        Toast.makeText(Context, nr, Toast.LENGTH_LONG).show();
    }
    public int onStartCommand(Intent intent, int n, int n2) {
        return 2;
    }
    public static interface OnListChoosedListener {
        public void onChoosed(int var1);
    }



	private void setImageFromAssets(ImageView image, String name) {
        AssetManager assetManager=getBaseContext().getAssets();
        try {
            InputStream inputStream=assetManager.open(name);
            image.setImageDrawable(Drawable.createFromStream(inputStream, null));
        } catch (IOException e) {
            Toast.makeText(this, "Error could not load image from assets folder \n" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
	}
    public void onTaskRemoved(Intent intent) {
        stopSelf();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onTaskRemoved(intent);
	}

}
//@Akshat_Mods
