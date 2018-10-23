package net.mode;

/**
 * 表示数据流动的结点
 */
public class DataNode {
    private int x;
    private int y;

    private int r;
    //private int vx,vy;
    private NetNode form;
    private NetNode to;

    public DataNode(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void setMove(NetNode form, NetNode to){
        this.form = form;
        this.to = to;
    }
    public void move(){
        double vx =(this.to.getX() - this.form.getX()) / 100.0;
        double vy =(this.to.getY() - this.form.getY()) / 100.0;

        if((this.to.getX() - this.x) < r){
            x = this.form.getX();
            y = this.form.getY();
        }
        x += vx;
        y += vy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
