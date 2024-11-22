import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JPanel implements ActionListener {
    public static final int scale = 32;
    public static final int width = 16;
    public static final int height = 16;

    Timer timer = new Timer(400,this);

    apple App = new apple(Math.abs((int)(Math.random()*width-1)),Math.abs((int)(Math.random()*height-1)));
    Snake_1 s = new Snake_1(5,5,6,5);

    public SnakeGame(){
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }


    @Override
    //конструктор библиотеки пэйнт
    public void paint(Graphics g) {
        //super.paint(g);

        g.setColor(Color.BLACK);
        //зальем черный фон
        g.fillRect(0,0,width*scale,height*scale);
        //создаем цикл для удобства отслеживания змейки
        for (int i = 0; i < width*scale; i+=scale) {
            g.setColor(Color.white);
            g.drawLine(i,0,i,height*scale);
        }

        for (int j = 0; j < height*scale; j+=scale) {
            g.setColor(Color.white);
            g.drawLine(0,j,width*scale,j);
        }

        g.setColor(Color.red);
        g.fillOval(App.posX*scale+1,App.posY*scale+1,scale-1,scale-1);

        for (int i =0; i < s.lenght; i++) {

            g.setColor(Color.blue);
                g.fillRect(s.arrX[i]*scale,s.arrY[i]*scale,scale,scale);

        }

        if(s.gameOver){
            //s.stop();
            g.setColor(Color.red);
            g.setFont(new Font("arial",Font.BOLD,24));
            g.drawString("GAME OVER",5*scale,8*scale);


        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Жданова");
        //+16 и + 8 чтоб поле было ровное
        frame.setSize(width*scale+16,height*scale+8);
        //СОздание окна приложения джифрейм

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //запретить менять размер окна
        frame.add(new SnakeGame()) ;
        //добавляет компонент в конец контейнера
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //закрытие по крестику
        frame.setLocationRelativeTo(null);
        //по середине
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(!s.gameOver){
            s.move();
        }

        if((s.arrX[0]==App.posX) && (s.arrY[0]==App.posY)){
            s.lenght++;
            App.SetRandom();
        }


        repaint();
    }

    public class KeyBoard extends KeyAdapter{
        public void keyPressed(KeyEvent event){
            int key = event.getKeyCode();

            if(key == KeyEvent.VK_UP){
                s.direction = 0;
            }

            if(key == KeyEvent.VK_DOWN){
                s.direction = 1;
            }

            if(key == KeyEvent.VK_LEFT){
                s.direction = 2;
            }

            if(key == KeyEvent.VK_RIGHT){
                s.direction = 3;
            }

            if(key == KeyEvent.VK_ENTER){
                s = new Snake_1(5,5,6,5);
            }
        }
    }
}