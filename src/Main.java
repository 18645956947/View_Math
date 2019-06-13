import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        //新开的一个线程
        EventQueue.invokeLater(() -> {
           AlgoFrame algoFrame = new AlgoFrame("Welcome", 500, 500);
//           AlgoFrame algoFrame = new AlgoFrame("Welcome");

        });
    }
}
