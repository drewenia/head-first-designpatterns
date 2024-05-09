package ProxyDesingPattern.HeadFirstProxyDesignPattern;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxy implements Icon {

    /* imageIcon, yüklendiğinde nihayetinde görüntülemek istediğimiz REAL icon'dur */
    volatile ImageIcon imageIcon;
    Thread retrievalThread;
    boolean retrieving = false;
    final URL imageURL;

    /* Resmin URL'sini constructor'a aktarıyoruz. Bu, yüklendikten sonra görüntülememiz gereken image'dir! */
    public ImageProxy(URL imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public int getIconWidth() {
        /* imageIcon yüklenene kadar varsayılan bir genişlik ve yükseklik döndürüyoruz; sonra bunu imageIcon'a
        döndürüyoruz.*/
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        /* imageIcon yüklenene kadar varsayılan bir genişlik ve yükseklik döndürüyoruz; sonra bunu imageIcon'a
        döndürüyoruz.*/
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 600;
        }
    }

    synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            /* Zaten bir Icon'umuz varsa, devam edip ona kendisini paint etmesini söyleriz.*/
            imageIcon.paintIcon(c, g, x, y);
        } else {
            /* Aksi takdirde "Loading..." mesajını görüntüleriz.*/
            g.drawString("Loading CD cover, please wait...", x + 300, y + 190);
            if (!retrieving){
                retrieving = true;
                /* Tüm User Interface'i kapatmak istemiyoruz, bu yüzden image'i almak için başka bir thread
                kullanacağız*/
                retrievalThread = new Thread(() -> {
                    try {
                        /* İşte burada işler ilginçleşiyor. Bu kod ekrandaki Icon'u paint eder (imageIcon'a delege
                        atayarak). Ancak, tam olarak oluşturulmuş bir ImageIcon'umuz yoksa, bir tane oluştururuz.
                        İşte burada REAL Icon görüntüsünü yüklüyoruz. IconImage ile görüntü yüklemenin synchronous
                        olduğuna dikkat edin: ImageIcon constructor'ı görüntü yüklenene kadar geri dönmez. Bu bize
                        ekran güncellemeleri yapmak ve mesajımızı görüntülemek için fazla bir şans vermiyor,
                        bu yüzden bunu asenkron olarak yapacağız */
                        /* Thread'imizde Icon nesnesini instantiate ediyoruz. Görüntü yüklenene kadar constructor geri
                        dönmeyecektir.*/
                        setImageIcon(new ImageIcon(imageURL,"CD Cover"));
                        c.repaint();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                });

                retrievalThread.start();
            }
        }
    }
}
