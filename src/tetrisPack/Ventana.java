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
    private Colores colores;

    private Pieza pieza;

    // --------------------------------------------------
    public Ventana() {
        
        inicializa();
    }
    
    private void inicializa() {

        loadSettings();

        addKeyListener(new TAdapter());
        setBackground(new Color(colores.fondo[0], colores.fondo[1], colores.fondo[2]));
        setFocusable(true);

        setPreferredSize(new Dimension(settings.resX, settings.resY));

        comenzar();
    }

    private void loadSettings() {

        settings = new Settings();
        plantilla = new Plantilla();
        colores = new Colores();

        System.out.println(plantilla.z[2][0] + "..." + plantilla.pieza.get(2)[2][1]);
    }

    private void loadImages() {

        // //BufferedImage manzana = ImageIO.read(new File(path, "bloque_azul.png"));

        // ImageIcon iia = new ImageIcon("appleSnake.png");
        // manzana = iia.getImage();
    }

    private void comenzar() {

        instanciar_matrizFondo();
        instanciar_pieza();

        timer = new Timer((int) (1000 / settings.FPS), this);
        timer.start();
    }

    private void instanciar_matrizFondo() {

        int filas = settings.filas;
        int col = settings.columnas;
        int ancho = settings.tileX;
        int alto = settings.tileY;

        for (int i = 0; i < filas; i ++) {
            for (int ii = 0; ii < col; ii ++) {

                settings.tileFondo[i][ii] = new Fondo(ii, i, ancho, alto);
            }
        }
    }

    private void instanciar_pieza() {

        if (settings.isOtraPieza()) {

            settings.setOtraPieza(false);
            int x = settings.xInicial;
            int y = settings.yInicial;
            int col = settings.columnas;
            int filas = settings.filas;

            int nro_rnd = settings.getNext_pieza();
            int elegida = nro_rnd;

            // ---------------------------------------------------
            nro_rnd = (int) (Math.random() * 7);
            settings.setNext_pieza(nro_rnd);
            //verNext = new NextPieza(settings.xNext, settings.yNext, plantilla.pieza.get(nro_rnd));

            // ---------------------------------------------------
            pieza = new Pieza(x, y, plantilla.pieza.get(elegida), col, filas, colores.piezas[elegida]);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        renderiza(g);
    }
    
    private void renderiza(Graphics g) {

        //g.setColor(Color.black);
        //g.fillRect(0, 0, settings.columnas * settings.tileX, settings.filas * settings.tileY);

        for (int i = 0; i < settings.filas; i ++) {
            for (int ii = 0; ii < settings.columnas; ii ++) {

                settings.tileFondo[i][ii].dibuja(g);
            }
        }

        if (settings.estado.isEnJuego()) {

            pieza.dibuja(g, settings.tileX, settings.tileY);
        }

        Toolkit.getDefaultToolkit().sync();        
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

    private void gravedad_piezas() {

        int[] gravedad = settings.getGravedad();
        int nivel = settings.getNivel();
        int contador = settings.getIncremento_dificultad();
        contador ++;

        if (contador >= gravedad[nivel]) {
            contador = 0;
            settings.controles.setAbajo(true);
        }

        settings.setIncremento_dificultad(contador);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (settings.estado.isEnJuego()) {

            Fondo.check_lineDone(settings);
            gravedad_piezas();
            
            instanciar_pieza();
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

            if (key == KeyEvent.VK_ESCAPE) {
                Toolkit.getDefaultToolkit().beep();
                System.exit(0);
            }
        }
    }
}
