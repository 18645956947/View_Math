public class Circle {
    //位置 坐标
    public int x, y;
    //半径
    private int r;
    //速度
    public int vx, vy;

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR(){
        return r;
    }

    public void move(int minx, int miny, int maxx, int maxy){
        x += vx;
        y += vy;
        checkCollection(minx, miny, maxx, maxy);
    }

    private void checkCollection(int minx, int miny, int maxx, int maxy){
        if(x - r < minx){
            x = r;
            vx = -vx;
        }
        if(x + r >= maxx){
            x = maxx - r;
            vx = -vx;
        }
        if(y - r < miny){
            y = r;
            vy = -vy;
        }
        if(y + r >= maxy){
            y = maxy - r;
            vy = -vy;
        }
    }

}
