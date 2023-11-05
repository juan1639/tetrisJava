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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.ArrayList;

// ===============================================================
public class Ventana extends JPanel implements ActionListener {

    private Timer timer;

    private Settings settings;
    private Plantilla plantilla;

    private Marcadores lineas;
    private Marcadores nivel;
    private Marcadores hi;

    private Gameover gameover;
    private Gameover titulo;

    private Pieza pieza;
    private Nextpieza verNextPieza;

    private Fireworks chispa;

    public int newGame;
    public int salir_rejugar;
    public int nextLevel;

    // --------------------------------------------------
    public Ventana() {
        
        inicializa();
    }
    
    private void inicializa() {

        loadSettings();

        addKeyListener(new TAdapter());
        setBackground(new Color(Colores.fondo[0], Colores.fondo[1], Colores.fondo[2]));
        setFocusable(true);

        setPreferredSize(new Dimension(settings.resX, settings.resY));

        comenzar();
    }

    private void loadSettings() {

        settings = new Settings();
        plantilla = new Plantilla();
    }

    private void comenzar() {

        instanciar_matrizFondo();
        instanciar_marcadores();
        instanciar_pieza();
        instanciar_tituloPresentacion();
        instanciar_gameOver();

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
            verNextPieza = new Nextpieza(settings.xNext, settings.yNext, plantilla.getPieza().get(nro_rnd), Colores.piezas[nro_rnd]);

            // ---------------------------------------------------
            pieza = new Pieza(x, y, plantilla.getPieza().get(elegida), col, filas, Colores.piezas[elegida]);
        }
    }

    private void instanciar_marcadores() {

        int[] argsInt = Marcadores.argsInt_instanciaMarcadores(settings);
        String[] argsTxt = Marcadores.argsString_instanciaMarcadores();

        int[] rgb = Colores.marcadores;

        lineas = new Marcadores(0, argsInt, argsTxt, new Color(rgb[0], rgb[1], rgb[2]));
        nivel = new Marcadores(1, argsInt, argsTxt, new Color(rgb[3], rgb[4], rgb[5]));
        hi = new Marcadores(2, argsInt, argsTxt, new Color(rgb[6], rgb[7], rgb[8]));
    }

    private void instanciar_gameOver() {

        int[] argsInt = Gameover.argsInt_instanciaGameOver(settings);
        String[] argsTxt = Gameover.argsString_instanciaGameOver();

        gameover = new Gameover(argsInt, argsTxt);
    }

    private void instanciar_tituloPresentacion() {

        int[] argsInt = Gameover.argsInt_instanciaTitulo(settings);
        String[] argsTxt = Gameover.argsString_instanciaTitulo();

        titulo = new Gameover(argsInt, argsTxt);
    }

    private void instanciar_fireWorks() {

        if (!settings.isFireWorks()) {
            return;
        }

        double[] arg = Pausaniveles.argsDouble_instanciarFireWorks(settings);
        chispa = new Fireworks(arg[0], arg[1], arg[2] / 15, arg[3] / 10);

        settings.setFireWorks(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        renderiza(g);
    }
    
    private void renderiza(Graphics g) {

        g.setColor(Color.black);
        g.drawRect(0, 0, settings.columnas * settings.tileX, settings.filas * settings.tileY);

        for (int i = 0; i < settings.filas; i ++) {
            for (int ii = 0; ii < settings.columnas; ii ++) {

                settings.tileFondo[i][ii].dibuja(g);
            }
        }

        Marcadores.area_marcadores(g, Marcadores.calculaAreaMarcadoresCoord(settings));

        if (settings.estado.isEnJuego()) {

            pieza.dibuja(g, settings.tileX, settings.tileY);
            lineas.dibuja(g, settings.getLineas(), this);
            nivel.dibuja(g, settings.getNivel(), this);
            hi.dibuja(g, settings.getHiScore(), this);
            verNextPieza.dibuja(g, settings.tileX, settings.tileY);

        } else if (settings.estado.isGameOver()) {

            //System.out.println("Game Over");
            lineas.dibuja(g, settings.getLineas(), this);
            nivel.dibuja(g, settings.getNivel(), this);
            hi.dibuja(g, settings.getHiScore(), this);
            gameover.dibuja(g, this);

        } else if (settings.estado.isMenuPrincipal()) {

            lineas.dibuja(g, settings.getLineas(), this);
            nivel.dibuja(g, settings.getNivel(), this);
            hi.dibuja(g, settings.getHiScore(), this);
            titulo.dibuja(g, this);

        } else if (settings.estado.isEntreNiveles()) {

            pieza.dibuja(g, settings.tileX, settings.tileY);
            lineas.dibuja(g, settings.getLineas(), this);
            nivel.dibuja(g, settings.getNivel(), this);
            hi.dibuja(g, settings.getHiScore(), this);
            verNextPieza.dibuja(g, settings.tileX, settings.tileY);
            chispa.dibuja(g);
        }

        Toolkit.getDefaultToolkit().sync();        
    }

    private void pausa_optionPane() {

        if (settings.getPausa_rejugar() <= 0) {
            return;
        }

        int contador = settings.getPausa_rejugar();
        contador --;
        settings.setPausa_rejugar(contador);

        if (settings.estado.isGameOver()) {

            if (settings.getPausa_rejugar() == 0) {

                salir_rejugar = JOptionPane.showConfirmDialog(this, "Jugar otra partida?");

                if (salir_rejugar == JOptionPane.NO_OPTION) {
                    System.out.println("Salir...");
                    Toolkit.getDefaultToolkit().beep();
                    System.exit(0);

                } else if (salir_rejugar == JOptionPane.YES_OPTION) {
                    System.out.println("Jugar otra partida...");

                } else if (salir_rejugar == JOptionPane.CANCEL_OPTION) {
                    System.out.println("Cancelar...");
                }
            }

        } else if (settings.estado.isEntreNiveles()) {

            if (settings.getPausa_rejugar() == 0) {

                nextLevel = JOptionPane.showConfirmDialog(this, "continuar siguiente nivel...", "NIVEL SUPERADO", JOptionPane.CLOSED_OPTION);

                if (nextLevel == JOptionPane.OK_OPTION) {

                    settings.estado.setEnJuego(true);
                    settings.estado.setEntreNiveles(false);
                    settings.setPausa_rejugar(99);
                }
            }

        } else if (settings.estado.isMenuPrincipal()) {

            if (settings.getPausa_rejugar() == 0) {

                newGame = JOptionPane.showConfirmDialog(this, "Comenzar nueva partida...", "COMENZAR", JOptionPane.CLOSED_OPTION);

                if (newGame == JOptionPane.OK_OPTION) {

                    settings.estado.setEnJuego(true);
                    settings.estado.setMenuPrincipal(false);
                    settings.setPausa_rejugar(99);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (settings.estado.isEnJuego()) {

            Pausaniveles.pausar_entreNiveles(settings);
            instanciar_fireWorks();

            Fondo.check_lineDone(settings);
            Pieza.gravedad_piezas(settings);
            
            instanciar_pieza();
            pieza.actualiza(settings);

        } else if (settings.estado.isGameOver()) {

            pausa_optionPane();

        } else if (settings.estado.isEntreNiveles()) {

            pausa_optionPane();

        } else if (settings.estado.isMenuPrincipal()) {

            pausa_optionPane();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (settings.estado.isEnJuego()) {

                if (key == KeyEvent.VK_LEFT) {
                    //System.out.println("iz");
                    settings.controles.setIzquierda(true);
                }

                if (key == KeyEvent.VK_RIGHT) {
                    //System.out.println("de");
                    settings.controles.setDerecha(true);
                }

                if (key == KeyEvent.VK_CONTROL || key == KeyEvent.VK_SPACE) {
                    //System.out.println("up");
                    settings.controles.setRotar(true);
                }

                if (key == KeyEvent.VK_DOWN) {
                    //System.out.println("do");
                    settings.controles.setAbajo(true);
                }
            }

            if (!settings.estado.isEnJuego()) {

                // if (key == KeyEvent.VK_ENTER) {
                //     System.out.println("Rejugar");
                //     settings.estado.setEnJuego(true);
                //     comenzar();
                // }
            }

            if (key == KeyEvent.VK_ESCAPE) {
                Toolkit.getDefaultToolkit().beep();
                System.exit(0);
            }
        }
    }
}
