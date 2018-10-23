package net;

import net.controller.NetController;

/**
 * 测试函数
 */
public class Test {
    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        NetController netController = new NetController(9, 1200, 600);
        netController.start();
    }
}
