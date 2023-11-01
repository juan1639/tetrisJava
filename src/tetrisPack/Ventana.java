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

import java.util.ArrayList;

// ===============================================================
public class Ventana extends JPanel implements ActionListener {

    private Timer timer;

    private Settings settings;
    private Plantilla plantilla;

    private Pieza pieza;

    // --------------------------------------------------
    public Ventana() {
        
        inicializa();
    }
    
    private void inicializa() {

        loadSettings();

        addKeyListener(new TAdapter());
        setBackground(Color.gray);
        setFocusable(true);

        setPreferredSize(new Dimension(settings.resX, settings.resY));

        comenzar();
    }

    private void loadSettings() {

        settings = new Settings();
        plantilla = new Plantilla();

        System.out.println(plantilla.z[2][0] + "..." + plantilla.pieza.get(2)[2][1]);
    }

    private void loadImages() {

        // //BufferedImage manzana = ImageIO.read(new File(path, "bloque_azul.png"));

        // ImageIcon iia = new ImageIcon("appleSnake.png");
        // manzana = iia.getImage();
    }

    private void comenzar() {

        if (settings.isOtraPieza()) {

            settings.setOtraPieza(false);
            int x = settings.xInicial;
            int y = settings.yInicial;

            int nro_rnd = settings.getNext_pieza();
            int elegida = nro_rnd;

            // ---------------------------------------------------
            nro_rnd = (int) (Math.random() * 7);
            settings.setNext_pieza(nro_rnd);
            //verNext = new NextPieza(settings.xNext, settings.yNext, plantilla.pieza.get(nro_rnd));

            // ---------------------------------------------------
            pieza = new Pieza(x, y, plantilla.pieza.get(elegida));
        }

        timer = new Timer((int) (1000 / settings.FPS), this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        renderiza(g);
    }
    
    private void renderiza(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, settings.columnas * settings.tileX, settings.filas * settings.tileY);
        
        if (settings.estado.isEnJuego()) {

            pieza.dibuja(g, settings.tileX, settings.tileY);
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

    private void update_snake() {

        // if (settings.estado.isEnJuego()) {

        //     int getX = settings.getX();
        //     int getY = settings.getY();

        //     if (settings.controles.isIzquierda()) {
        //         getX -= 5;
        //         settings.setX(getX);
        //         settings.controles.setIzquierda(false);

        //     } else if (settings.controles.isDerecha()) {
        //         getX += 5;
        //         settings.setX(getX);
        //         settings.controles.setDerecha(false);

        //     } else if (settings.controles.isRotar()) {
        //         getY -= 5;
        //         settings.setY(getY);
        //         settings.controles.setRotar(false);

        //     } else if (settings.controles.isAbajo()) {
        //         getY += 5;
        //         settings.setY(getY);
        //         settings.controles.setAbajo(false);
        //     }
        // }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (settings.estado.isEnJuego()) {
            
            //update_snake();
            pieza.actualiza(settings);
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (settings.estado.isEnJuego()) {

                if (key == KeyEvent.VK_LEFT) {
                    System.out.println("iz");
                    settings.controles.setIzquierda(true);
                }

                if (key == KeyEvent.VK_RIGHT) {
                    System.out.println("de");
                    settings.controles.setDerecha(true);
                }

                if (key == KeyEvent.VK_UP || key == KeyEvent.VK_SPACE) {
                    System.out.println("up");
                    settings.controles.setRotar(true);
                }

                if (key == KeyEvent.VK_DOWN) {
                    System.out.println("do");
                    settings.controles.setAbajo(true);
                }
            }

            if (!settings.estado.isEnJuego()) {

                if (key == KeyEvent.VK_SPACE) {
                    System.out.println("Rejugar");
                    settings.estado.setEnJuego(true);
                    comenzar();
                }
            }
        }
    }
}
