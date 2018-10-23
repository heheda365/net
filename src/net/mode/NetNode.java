package net.mode;

public class NetNode {
    private String name;
    private int x,y;    //坐标
    private int r;      // 半径
    private boolean isFIll; //是否为实心

    public boolean isFIll() {
        return isFIll;
    }

    public void setFIll(boolean FIll) {
        isFIll = FIll;
    }

    public NetNode(String name, int x, int y, int r) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setR(int r) {
        this.r = r;
    }
}
