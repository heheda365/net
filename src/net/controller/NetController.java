package net.controller;

import net.mode.DataNode;
import net.mode.Line;
import net.mode.NetNode;
import net.view.frame.NetFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * 圆形数据控制
 * @Author: wugui
 * @Date 2018-6-2 20:02
 */
public class NetController {
    private NetFrame netFrame;
    private int count;
    private int width;
    private int height;
    private NetNode[] netNodes;
    private Line[] lines;
    private DataNode[] dataNodes;
    private boolean isRun = true;

    /**
     * @param count 圆形个数
     * @param width 窗口宽度
     * @param height 窗口高度
     */
    public NetController(int count, int width, int height) {
        this.count = count;
        this.width = width;
        this.height = height;
    }

    /**
     * 启动
     */
    public void start(){
        EventQueue.invokeLater(()->{
            initData();
            netFrame = new NetFrame("网络" ,width,height);
            netFrame.addKeyListener(new AlgoKey());
            netFrame.addMouseListener(new AlgoMouse());
            new Thread(()->{
                run();
            }).start();
            netFrame.setVisible(true);
        });
    }

    /**
     * 初始化数据  包括 开始坐标 速度 半径
     */
    private void initData(){
        netNodes = new NetNode[9];
        lines = new Line[8];
        dataNodes = new DataNode[1];
        netNodes[0] = new NetNode("A", 300, 100, 30);
        netNodes[1] = new NetNode("B", 200, 300, 30);
        netNodes[2] = new NetNode("C", 300, 300, 30);
        netNodes[3] = new NetNode("D", 400, 300, 30);
        netNodes[4] = new NetNode("E", 100, 500, 30);
        netNodes[5] = new NetNode("F", 200, 500, 30);
        netNodes[6] = new NetNode("G", 300, 500, 30);
        netNodes[7] = new NetNode("H", 400, 500, 30);
        netNodes[8] = new NetNode("I", 500, 500, 30);

        lines[0] = new Line(netNodes[0], netNodes[1]);
        lines[1] = new Line(netNodes[0], netNodes[2]);
        lines[2] = new Line(netNodes[0], netNodes[3]);
        lines[3] = new Line(netNodes[1], netNodes[4]);
        lines[4] = new Line(netNodes[1], netNodes[5]);
        lines[5] = new Line(netNodes[2], netNodes[6]);
        lines[6] = new Line(netNodes[3], netNodes[7]);
        lines[7] = new Line(netNodes[3], netNodes[8]);

        dataNodes[0] = new DataNode(netNodes[1].getX(), netNodes[1].getY(), 10);
        dataNodes[0].setMove(netNodes[1], netNodes[0]);
    }

    /**
     * 控制小球运动
     */
    private void run(){
        try {
            while (true) {
                if(isRun){
                    dataMove();
                }
                this.netFrame.rePaint(netNodes, lines, dataNodes);
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void dataMove() {
//        for(dn : dataNodes){
//            dn.move();
//        }
        dataNodes[0].move();
    }

    /**
     * 键盘监听事件
     */
    class AlgoKey extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            if(e.getKeyChar() == ' '){
                isRun = ! isRun;
            }
        }
    }

    /**
     * 鼠标监听事件
     */
    class AlgoMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println();
            super.mousePressed(e);
            for (NetNode i : netNodes){
                if (position(i, (int)e.getPoint().getX(), (e.getY() - netFrame.getBounds().height + height))) {
                    i.setFIll(!i.isFIll());
                }
            }
        }

        /**
         * 计算点击点是否在圈内
         * @param circle
         * @param x 点击坐标
         * @param y 点击坐标
         * @return 是 为true
         */
        private boolean position(NetNode circle, int x, int y){
            return (circle.getX()-x) * (circle.getX()-x) + (circle.getY()-y) * (circle.getY()-y) < circle.getR() * circle.getR();
        }
    }
}


