import java.util.Random;

public class apple {
    public int posX;
    public int posY;

    public apple(int x, int y){
        posX = x;
        posY = y;
    }

    public void SetRandom(){
        int Random = new Random().nextInt(0,1000);
        posX = Random * Main.width - 1;
        posY = Random * Main.height - 1;


    }
}
