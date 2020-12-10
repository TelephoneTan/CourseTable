package com.telephone.coursetable.proxy;

public class MyProxy {
    int type;
    String HOST_PORT;
    boolean enable;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public String getHOST_PORT() {
        return HOST_PORT;
    }

    public void setHOST_PORT(String HOST_PORT) {
        this.HOST_PORT = HOST_PORT;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
