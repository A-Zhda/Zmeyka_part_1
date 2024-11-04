public class Snake_1 {
    public int lenght = 6;
    public int direction = 0;

    public int arrX[] = new int[300];
    public int arrY[] = new int[300];

    public Snake_1(int x1, int y1, int x2, int y2){
        arrX[0] = x1;
        arrX[1] = x2;
        arrY[0] = y1;
        arrY[1] = y2;
        for (int i = 2; i < arrX.length; i++) {
            if (i%2==0) {
                arrX[i] = x1+1;
                x1++;
            }else{
                arrX[i] = x2+1;
                x2++;
            }
        }

    }

    public void move(){
        for (int i = lenght; i >0 ; i--) {
            arrX[i]=arrX[i-1];
            arrY[i]=arrY[i-1];

        }
        //вверх
        if(direction==0){
            arrY[0]--;
        }
        //ыниз
        if(direction==2){
            arrY[0]++;
        }
        //право
        if(direction==1){
            arrX[0]++;
        }
        //лево
        if(direction==3){
            arrX[0]--;
        }

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
