package TemplateDesignPatter.HeadFirstTemplateDesignPattern;

import javax.swing.*;
import java.awt.*;

/* Ekranı güncellemek için algoritmayı kontrol eden bir update() methodu içeren JFrame'i extends ediyoruz.
paint() hook methodunu override ederek bu algoritmaya bağlanabiliyoruz.*/
public class MyFrame extends JFrame {

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("Head First Desing Patterns");
    }

    /* Burada sadece bazı başlangıçlar var */
    public MyFrame(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300,300);
        this.setVisible(true);
    }

    /* JFrame'in update algoritması paint() işlevini çağırır. Varsayılan olarak, paint() hiçbir şey yapmaz...
    bu bir hook'dur. paint() işlevini override ediyoruz ve JFrame'e pencereye bir mesaj çizmesini söylüyoruz.*/
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String message = "I Rule";
        g.drawString(message,150,150);
    }
}
