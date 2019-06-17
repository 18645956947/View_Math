import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoVisHelper {
    private AlgoVisHelper(){

    }
    //设置线段的粗细
    public  static void setStrokeWidth(Graphics2D g2d, int w){
        int strokeWidth = 5;
        g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }
    //画一个空心圆并画一个半径为r的空心圆
    public static void strokeCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(circle);
    }
    //画一个实心圆并画一个半径为r的实心圆
    public static void fillCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.fill(circle);
    }
    //填进颜色
    public static void setColor(Graphics2D g2d, Color color){
        g2d.setColor(color);
    }

    //t为毫秒
    public static void pause(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            System.out.println("Error in Sleep");;
        }
    }
}
