package net.view.frame;

import net.mode.DataNode;
import net.mode.Line;
import net.mode.NetNode;
import net.utils.GraphicsHelpUtil;

import javax.swing.*;
import java.awt.*;


/**
 * 展示窗口
 */
public class NetFrame extends JFrame {
    public static int canvasWidth;
    public static int canvasHeight;
    private NetNode[] netNodes;
    private Line[] lines;
    private DataNode[] dataNodes;
    /**
     * 自定义构造函数
     * @param title jFrame 标题
     * @param canvasWidth 面板长度
     * @param canvasHeight 面板高度
     */
    public NetFrame(String title, int canvasWidth, int canvasHeight){
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        NetJPanl netJPanl = new NetJPanl();
        this.setContentPane(netJPanl);
        this.pack();
    }
    public void rePaint(NetNode [] netNodes, Line[] lines, DataNode[] dataNodes){
        this.netNodes = netNodes;
        this.lines = lines;
        this.dataNodes = dataNodes;
        repaint();
    }

    /**
     * 画板 绘制结点和连线
     */
    private class NetJPanl extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);



            g2d.setColor(Color.green);
            g2d.setStroke(new BasicStroke(5.0f));
            // 画线
            for(Line l: lines){
                g2d.drawLine(l.getForm().getX(),
                        l.getForm().getY(),
                        l.getTo().getX(),
                        l.getTo().getY());
            }

            // 画节点
            g2d.setColor(Color.red);
            for(NetNode i : netNodes){
                if(i.isFIll())
                    GraphicsHelpUtil.fillCircle(g2d, i.getX(), i.getY() ,i.getR());
                else
                    GraphicsHelpUtil.strokeCircle(g2d, i.getX(), i.getY() ,i.getR());
            }

            // 数据点
            g2d.setColor(Color.blue);
            for(DataNode dn: dataNodes) {
                GraphicsHelpUtil.fillCircle(g2d, dn.getX(), dn.getY(), dn.getR());
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }

}
