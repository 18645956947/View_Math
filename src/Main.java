import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        int secceWeight = 800;
        int secceHright = 800;

        int N = 10;
        Circle[] circles = new Circle[N];
        int R = 50;
        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * (secceWeight-2*R)) + R;
            int y = (int) (Math.random() * (secceHright-2*R)) + R;
            int vx = (int) (Math.random() * 11);
            int vy = (int) (Math.random() * 11);
            circles[i] = new Circle(x, y, R, vx, vy);

        }

        //新开的一个线程
        EventQueue.invokeLater(() -> {
           AlgoFrame algoFrame = new AlgoFrame("Welcome", secceWeight, secceHright);

           //Java事件派发队列
           new Thread(() -> {
               while(true){
                   //绘制数据
                   algoFrame.render(circles);
                   AlgoVisHelper.pause(20);

                   //更新数据
                   for (Circle circle: circles) {
                       circle.move(0, 0, secceWeight, secceHright);
                   }
               }
           }).start();


        });
    }
}
