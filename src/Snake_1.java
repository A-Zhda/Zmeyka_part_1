
public class Snake_1 {
    public int lenght = 10;
    public int direction = 0;

    public int arrX[] = new int[50];
    public int arrY[] = new int[50];

    public boolean gameOver = false;

    public Snake_1(int x1, int y1, int x2, int y2){
        arrX[0] = x1;
        arrX[1] = x2;
        arrY[0] = y1;
        arrY[1] = y2;
    }

    public void move(){
        for (int i = lenght; i > 0 ; i--) {
            arrX[i]=arrX[i-1];
            arrY[i]=arrY[i-1];

        }


        //змея сама себя ест поэтому с 3 элемента
        for (int i = 3; i < lenght; i++) {
            for (int j = 3; j < lenght; j++) {
                if(arrX[i]==arrY[j]){
                    if (arrX[i]== 0) {
                        continue;
                    }
                    if(arrX[0] == arrX[i] && arrY[0] == arrY[j]){
                        gameOver = true;

                    }
                }
            }

        }
        
        //вверх
        if(direction==0){
            arrY[0]--;
        }
        //ыниз
        if(direction==1){
            arrY[0]++;
        }
        //право
        if(direction==3){
            arrX[0]++;
        }
        //лево
        if(direction==2){
            arrX[0]--;
        }

        //за границу рамки
        if(arrX[0]>Main.width-1){
            arrX[0]=0;
        }
        if(arrX[0]<0){
            arrX[0]=Main.width-1;
        }

        if(arrY[0]>Main.height-1){
            arrY[0]=0;
        }
        if(arrY[0]<0){
            arrY[0]=Main.height-1;
        }
    }



}
