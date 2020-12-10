package com.telephone.coursetable.proxy;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.telephone.coursetable.Http.HttpConnectionAndCode;
import com.telephone.coursetable.Http.Post;
import com.telephone.coursetable.MyApp;

public class ProxyUtil {
    private static final String TAG = "com.telephone.coursetable.proxy.ProxyUtil";
    public static final int TYPE_OF_BKJW = 0;
    public static final int TYPE_OF_BKJW1 = 1;

    public static HttpConnectionAndCode simplePostRequest(String url) {
        return Post.post(url, null, "", "", null, null, null, null, null, null, false, null);
    }

    /**
     * 封装，调用此方法判断学分制管理系统的线路状态
     */
    public static boolean checkBkjwProxyAvailable() {
        return checkProxyAvailable(TYPE_OF_BKJW);
    }

    public static boolean checkBkjw1ProxyAvailable() {
        return checkProxyAvailable(TYPE_OF_BKJW1);
    }

    /**
     * 用于获取线路
     *
     * @param type 0 bkjw;1 bkjw1;以后随需求在类静态常量中添加
     */
    public static boolean checkProxyAvailable(int type) {
        HttpConnectionAndCode res = simplePostRequest("http://guetproxy.f3322.net:23700/api/route/available/" + type);
        Response result = null;
        if (res.resp_code == 200) {
            String json = res.comment;
            result = new Gson().fromJson(json, new TypeToken<Response>() {
            }.getType());
            if (result != null) {
                if (result.code == 0) {
                    MyProxy proxy = new MyProxy();
                    proxy.setHOST_PORT(result.route);
                    MyApp.getProxyMap().put(type, proxy);
//                    Log.d(TAG, "checkProxyAvailable: 可用线路:类型:" + type + ",route:" + result.route);
                    return true;
                } else {
                    MyApp.getProxyMap().remove(type);
                    return false;
                }
            } else {
                MyApp.getProxyMap().remove(type);
                return false;
            }
        } else {
            MyApp.getProxyMap().remove(type);
            return false;
        }
    }

    public static void setProxyStatus() {
        //不可对这个if进行优化，checkBkjwProxyAvailable()必须先执行
        if (checkBkjwProxyAvailable()) {
            MyApp.getProxyMap().get(TYPE_OF_BKJW).setEnable(true);
        }

//        Log.d(TAG, "setProxyStatus: 启动bkjw代理");
        if (checkBkjw1ProxyAvailable()) {
            MyApp.getProxyMap().get(TYPE_OF_BKJW1).setEnable(true);
        }
//        Log.d(TAG, "setProxyStatus: 启动bkjw1代理");
    }

    public static String urlProxify(String url) {
        if (!MyApp.isProxy()) {
//            Log.d(TAG, "urlProxify: 代理被禁用");
            return url;
        }
        for (MyProxy p : MyApp.getProxyMap().values()) {
            switch (p.getType()) {
                case TYPE_OF_BKJW:
                    if (p.enable) {
//                        Log.d(TAG, "urlProxify: 进行url替换: http://172.16.13.22=>" + p.getHOST_PORT());
                        return url.replace("http://172.16.13.22", p.getHOST_PORT());
                    }
                    break;
                case TYPE_OF_BKJW1:
                    if (p.enable) {
//                        Log.d(TAG, "urlProxify: 进行url替换: http://172.16.1.99=>" + p.getHOST_PORT());
                        return url.replace("http://172.16.1.99", p.getHOST_PORT());
                    }
                    break;
                default:
                    break;
            }
        }
        return url;

    }

}
