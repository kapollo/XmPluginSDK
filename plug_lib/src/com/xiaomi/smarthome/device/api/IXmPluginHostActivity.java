
package com.xiaomi.smarthome.device.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import java.util.ArrayList;

public interface IXmPluginHostActivity {
    public FragmentActivity activity();

    // 动画类型
    public final String ANIM_SLIDE_IN_LEFT = "slide_in_left";
    public final String ANIM_SLIDE_IN_RIGHT = "slide_in_right";
    public final String ANIM_SLIDE_IN_TOP = "slide_in_top";
    public final String ANIM_SLIDE_IN_BOTTOM = "slide_in_bottom";
    public final String ANIM_SLIDE_OUT_LEFT = "slide_out_left";
    public final String ANIM_SLIDE_OUT_RIGHT = "slide_out_right";
    public final String ANIM_SLIDE_OUT_TOP = "slide_out_top";
    public final String ANIM_SLIDE_OUT_BOTTOM = "slide_out_bottom";

    /**
     * /** ApiLevel:1 打开菜单，onActivityResult()返回用户点击结果 String selectMenu =
     * data.getStringExtra("menu");
     * 
     * @param menus 自定义菜单列表，在默认菜单之上,点击后推出菜单项
     * @param intents 自定义菜单列表，在默认菜单之上，点击后打开Intent
     * @param useDefault true使用默认菜单，false不使用默认菜单
     * @param requestCode requestCode If >= 0, this code will be returned in
     *            onActivityResult() when the activity exits.
     */
    public abstract void openMoreMenu(ArrayList<String> menus, ArrayList<Intent> intents,
            boolean useDefault, int requestCode);

    /**
     * ApiLevel:1 打开分享页面
     */
    public abstract void openShareActivity();

    /**
     * ApiLevel:1 实现沉浸式标题栏，需要传入当前Activity中的titlebar view
     * 
     * @param titleBarView
     */
    public abstract void setTitleBarPadding(View titleBarView);

    /**
     * ApiLevel:1 启动插件中的Activity
     * 
     * @param intent
     * @param packageName 插件包名
     * @param className 启动的Activity类名
     * @param requestCode
     */
    public abstract void startActivityForResult(Intent intent, String packageName,
            String className, int requestCode);

    /**
     * ApiLevel:1 获取启动插件内activity的Intent,用于设备更多页面进入设置页面
     * 
     * @param packageName
     * @param className
     * @return
     */
    public Intent getActivityIntent(String packageName, String className);

    /**
     * ApiLevel:1 进入默认的固件升级页面
     */
    public abstract void goUpdateActivity();

    /**
     * ApiLevel:1 开始加载场景
     */
    public abstract void startLoadScene();

    /**
     * ApiLevel:1 开始设置智能设备的场景(只能设置智能场景条件)
     * 
     * @param deviceId
     * @param deviceEvent
     */
    public abstract void startCreateSceneByCondition(String deviceId, String deviceEvent);

    /**
     * ApiLevel:1 编辑当前已有智能场景
     * 
     * @param sceneId
     */
    public abstract void startEditScene(int sceneId);

    /**
     * ApiLevel:2 增加通用时间设置接口
     * 
     * @param deviceId device id
     * @param onMethod 当on timer时间到的时候执行的action
     * @param onParams on action的参数
     * @param offMethod 当off timer时间到的时候执行的action
     * @param offParams off action参数
     * @param timerName 定时器名称
     * @param timerTitle 定时器标题
     */
    public abstract void startSetTimerList(String deviceId, String onMethod, String onParams,
            String offMethod, String offParams, String timerName, String timerTitle);

    /**
     * ApiLevel:2 设置白色的状态栏，默认是黑色的
     */
    public abstract void enableWhiteTranslucentStatus();

    /**
     * ApiLevel:2 打开反馈页面
     */
    public abstract void openFeedbackActivity();

    /**
     * ApiLevel:2 把设备添加到桌面快捷方式
     */
    public abstract void addToLauncher();

    /**
     * ApiLevel:2 打开webview
     * 
     * @param url
     * @param title
     */
    public abstract void loadWebView(String url, String title);

    /**
     * ApiLevel:3 打开商城页面
     * 
     * @param gid
     */
    public abstract void openShopActivity(String gid);

    /**
     * ApiLevel:3 设置插件Activity动画 public final String ANIM_SLIDE_IN_LEFT =
     * "slide_in_left"; public final String ANIM_SLIDE_IN_RIGHT =
     * "slide_in_right"; public final String ANIM_SLIDE_IN_TOP = "slide_in_top";
     * public final String ANIM_SLIDE_IN_BOTTOM = "slide_in_bottom"; public
     * final String ANIM_SLIDE_OUT_LEFT = "slide_out_left"; public final String
     * ANIM_SLIDE_OUT_RIGHT = "slide_out_right"; public final String
     * ANIM_SLIDE_OUT_TOP = "slide_out_top"; public final String
     * ANIM_SLIDE_OUT_BOTTOM = "slide_out_bottom";
     * 
     * @param enterAnim
     * @param exitAnim
     */
    public void overridePendingTransition(String enterAnim, String exitAnim);

    /**
     * ApiLevel:3 分享米聊，微信，朋友圈，sina微博，
     * 
     * @param mShareTitle
     * @param mShareContent
     * @param mShareUrl
     * @param mShareImageUrl
     * @param mShareThumbUrl
     * @param mThumb
     */
    public void share(String shareTitle,
            String shareContent,
            String shareUrl,
            String shareImageUrl,
            String shareThumbUrl,
            Bitmap thumb);
}