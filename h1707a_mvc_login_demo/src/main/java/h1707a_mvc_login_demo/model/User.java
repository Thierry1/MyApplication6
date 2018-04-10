package h1707a_mvc_login_demo.model;

/**
 * 爱生活，爱代码
 * 创建于：2018/3/12 14:44
 * 作 者：T
 * 微信：704003376
 */

public class User {
    private String userName;
    private String userPwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User() {
    }
}
