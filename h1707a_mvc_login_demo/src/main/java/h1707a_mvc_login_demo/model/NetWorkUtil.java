package h1707a_mvc_login_demo.model;

import android.os.SystemClock;

/**
 * 爱生活，爱代码
 * 创建于：2018/3/12 14:53
 * 作 者：T
 * 微信：704003376
 */

public class NetWorkUtil {
    /**
     * 请求服务器获取网络数据并解析
     */
    public static boolean getNetWorkData(final User user) {
        //模拟网络请求数据并解析
        SystemClock.sleep(1500);
        if ("beijing".equals(user.getUserName())
                && "jiyun".equals(user.getUserPwd()))
            return true;
        else
            return false;
    }


}
