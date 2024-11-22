public class apple {
    public int posX;
    public int posY;

    public apple(int x, int y){
        posX = x;
        posY = y;
    }

    public void SetRandom(){
        //int Random = new Random().nextInt(0,1000); - так не работает
        posX = Math.abs((int)(Math.random()* SnakeGame.width-1));
        posY = Math.abs((int)(Math.random()* SnakeGame.height-1));


    }
}
