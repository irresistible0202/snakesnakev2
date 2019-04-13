import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Snack {

    public static void main(String[] args) {
        Window wnd = new Window();
    }
}

//класс окна
class Window extends JFrame {

    //панель
    Field field;

    public Window() {

        //выделить память для панели
        field = new Field();

        //вложить панель в окно
        Container cont = this.getContentPane();
        cont.add(field);

        //заголовок

        //размеры окна
        setBounds(0, 0, 300, 300);

        //после закрытия окна - программа освобождает ресурсы
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //окно видмое
        setVisible(true);
    }

}

//класс поля
class Field extends JPanel {

    //таймер для обычной перерисовки панели
    Timer tmDraw;

    //Конструктор вызывается в момент создания объекта поле
    public Field() {

        //установить размещение элементов заданное пользователем
        setLayout(null);

        //выделить память для таймера, каждые 50 млс панель будет перерисовываться
        tmDraw = new Timer(50, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        //запустить таймер
        tmDraw.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        //заливаем фон (белый квадрат 600x600)
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 600, 600);

        //установить цвет
        g.setColor(Color.CYAN);
        //нарисовать одну линию
        g.drawLine(0, 0, 600, 0);
        //нарисовать вторую линию
        g.drawLine(0, 20, 600, 20);
        //попробуйте нарисовать линию 3 ....

        //далее нарисовать линии через цикл for (сначала по вертикали, а затем по горизонтали)

    }
}
