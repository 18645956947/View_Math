
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){
        super(title);
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;
        //创建画布 放进JFrame 并设置大小
        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();//自动调整大小

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String title){
        this(title, 1024, 768);
    }

    public int getCanvasWidth(){
        return canvasWidth;
    }
    public int getCanvasHeight(){
        return canvasHeight;
    }

    private class AlgoCanvas extends JPanel{

        //动画基础--双缓存
        public AlgoCanvas(){
            super(true);
        }
        //绘制画布  绘制都在g上
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //使用Graphics2D模板画  一个上下文环境
            Graphics2D g2d = (Graphics2D) g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(
                                        RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);
            //绘制图片边的粗细
           AlgoVisHelper.setStrokeWidth(g2d, 5);

            AlgoVisHelper.setColor(g2d, Color.RED);
            //画一个实心圆
            AlgoVisHelper.fillCircle(g2d, canvasWidth/2, canvasHeight/2, 200);
            AlgoVisHelper.setColor(g2d, Color.BLUE);
            //画一个空心圆
            AlgoVisHelper.strokeCircle(g2d, canvasWidth/2, canvasHeight/2, 200);


        }

        //设置画布大小
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
