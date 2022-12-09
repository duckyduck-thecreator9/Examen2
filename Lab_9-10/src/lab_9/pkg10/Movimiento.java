/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_9.pkg10;

import java.util.Random;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author joseph
 */
public class Movimiento implements Runnable{
    private String input;
    private Culebra culebra;
    private String[][] matriz;
    private JTextArea map;
    private JTextField inp;

    public Movimiento(String input, Culebra culebra, String[][] matriz, JTextArea map, JTextField inp) {
        this.input = input;
        this.culebra = culebra;
        this.matriz = matriz;
        this.map = map;
        this.inp = inp;
    }


    public Culebra getCulebra() {
        return culebra;
    }

    public void setCulebra(Culebra culebra) {
        this.culebra = culebra;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }

    public JTextArea getMap() {
        return map;
    }

    public void setMap(JTextArea map) {
        this.map = map;
    }

    @Override
    public void run() {
        Random r = new Random();
        int y = culebra.getY1();
        int x = culebra.getX1();
        input.toLowerCase();
        boolean existe = false;
        matriz[6][12] = "0";
        while (true) {
            System.out.println(existe);
            if (existe == false) {
                int x2 = r.nextInt(13);
                int y2 = r.nextInt(32);
                matriz[x2][y2] = "O";
                existe = true;
            }
            input = inp.getText();
            System.out.println(input);
        if (input.equals("w") ) {
            System.out.println("metido a w");
            culebra.setY1(y - 1);
            y = culebra.getY1();
        } else if (input.equals("s") ) {
            culebra.setY1(y + 1);
            y = culebra.getY1();
        } else if (input.equals("a") ) {
            culebra.setX1(x - 1);
            x = culebra.getX1();
        } else if (input.equals("d") ) {
            culebra.setX1(x + 1);
            x = culebra.getX1();
        }
            System.out.println("posicion x es: " + culebra.getX1());
            System.out.println("posicion y es: " + culebra.getY1());
            actualizarmapa();
        try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
    public void actualizarmapa() {
        String mapas = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == 0 | i == matriz.length - 1) {
                    matriz[i][j] = "*";
                } else if (j == 0 | j == 32 ){
                 matriz[i][j] = "*";
                } else if (culebra.getY1() == i && culebra.getX1() == j) {
                    matriz[i][j] = culebra.getCabesa();
                    //matriz[i][j-1] = "x";
                    //matriz[i][j-2] = "x";
                } else {    
                matriz[i][j] = " ";
                }
                mapas += matriz[i][j];
            }
            mapas += "\n";
        }
        map.setText(mapas);
    }
}
