package tetrisPack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

// ===============================================================
public class Ventana extends JPanel implements ActionListener {

    private final int resX = 600;
    private final int resY = 600;

    private final int FPS = 60;

    private int x = 200;
    private int y = 200;

    private Boolean enJuego = true;

    private Timer timer;
    private Settings settings;

    // --------------------------------------------------
    public Ventana() {
        
        inicializa();
    }
    
    private void inicializa() {

        addKeyListener(new TAdapter());
        setBackground(Color.gray);
        setFocusable(true);

        setPreferredSize(new Dimension(resX, resY));

        loadSettings();
        //loadImages();
        comenzar();
    }

    private void loadSettings() {

        settings = new Settings();
    }

    private void loadImages() {

        // ImageIcon iid = new ImageIcon("seg_snkVerde.png");
        // segmento = iid.getImage();

        // //BufferedImage manzana = ImageIO.read(new File(path, "bloque_azul.png"));

        // ImageIcon iia = new ImageIcon("appleSnake.png");
        // manzana = iia.getImage();

        // ImageIcon iih = new ImageIcon("seg_snkVerde.png");
        // cabeza = iih.getImage();
    }

    private void comenzar() {

        // int xInicial = (int) (columnas / 2);
        // int yInicial = (int) (filas / 2);

        // marcador = 0;
        // longitudSnake = 2;

        // for (int i = 0; i < longitudSnake; i++) {
        //     x[i] = xInicial - i;
        //     y[i] = yInicial;
        // }
        
        // nueva_manzana();

        timer = new Timer((int) (1000 / FPS), this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        renderiza(g);
    }
    
    private void renderiza(Graphics g) {
        
        if (enJuego) {

            g.setColor(Color.white);
            g.drawRect(x, y, 100, 100);
        }        
    }

    // private void gameOver(Graphics g) {

    //     textos((int) (resX / 10), "Game Over", 1, g);
    //     textos((int) (resX / 30), "Pulse SPACE para jugar otra partida...", 2, g);
    // }

    // private void textos(int size, String texto, int idTxt, Graphics g) {

    //     int fontSize = size;
    //     String msg = texto;

    //     Font fuente = new Font("Helvetica", Font.BOLD, fontSize);
    //     FontMetrics metr = getFontMetrics(fuente);

    //     g.setFont(fuente);

    //     if (idTxt == 1) {
    //         g.setColor(Color.orange);
    //         g.drawString(msg, (resX - metr.stringWidth(msg)) / 2, resY / 2);

    //     } else if (idTxt == 2) {
    //         g.setColor(Color.white);
    //         g.drawString(msg, (resX - metr.stringWidth(msg)) / 2, (int) (resY / 1.2));

    //     } else if (idTxt == 3) {
    //         g.setColor(Color.yellow);
    //         g.drawString(msg, (resX - metr.stringWidth(msg)) / 2, 30);
    //     }
    // }

    private void check_colisionManzana() {

        // if ((x[0] == manzanaX) && (y[0] == manzanaY)) {

        //     longitudSnake++;
        //     marcador ++;
        //     nueva_manzana();
        // }
    }

    private void update_snake() {

        if (enJuego) {

            if (settings.controles.isIzquierda()) {
                x -= 5;
                settings.controles.setIzquierda(false);

            } else if (settings.controles.isDerecha()) {
                x += 5;
                settings.controles.setDerecha(false);

            } else if (settings.controles.isRotar()) {
                y -= 5;
                settings.controles.setRotar(false);

            } else if (settings.controles.isAbajo()) {
                y += 5;
                settings.controles.setAbajo(false);
            }
        }
    }

    private void check_colisiones() {

        
        
        // if (!enJuego) {
        //     timer.stop();
        // }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (enJuego) {

            check_colisionManzana();
            check_colisiones();
            update_snake();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (enJuego) {

                if (key == KeyEvent.VK_LEFT) {
                    System.out.println("iz");
                    settings.controles.setIzquierda(true);
                }

                if (key == KeyEvent.VK_RIGHT) {
                    System.out.println("de");
                    settings.controles.setDerecha(true);
                }

                if (key == KeyEvent.VK_UP) {
                    System.out.println("up");
                    settings.controles.setRotar(true);
                }

                if (key == KeyEvent.VK_DOWN) {
                    System.out.println("do");
                    settings.controles.setAbajo(true);
                }
            }

            if (!enJuego) {

                if (key == KeyEvent.VK_SPACE) {
                    System.out.println("Rejugar");
                    enJuego = true;
                    comenzar();
                }
            }
        }
    }
}
