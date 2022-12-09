/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_9.pkg10;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
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
    private int x2;
    private int y2;

    public Movimiento(String input, Culebra culebra, String[][] matriz, JTextArea map, JTextField inp) {
        this.input = input;
        this.culebra = culebra;
        this.matriz = matriz;
        this.map = map;
        this.inp = inp;
    }

    public JTextField getInp() {
        return inp;
    }

    public void setInp(JTextField inp) {
        this.inp = inp;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
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
        int y = culebra.getY1();
        int x = culebra.getX1();
        input.toLowerCase();
        while (true) {
            input = inp.getText();
        if (input.equals("w") ) {
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
            actualizarmapa();
            
            if (culebra.getX1() == 0 | culebra.getX1() == 32 | culebra.getY1() == 0 | culebra.getY1() == 12) {
                JOptionPane.showMessageDialog(null, "Ha perdido");
                culebra.setX1(17);
                culebra.setY1(7);
                break;
            }
        try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
    public void actualizarmapa() {
        String mapas = "";
        Random r = new Random();
//        System.out.println("X 0 es: " + culebra.getX().get(0).toString());
//        System.out.println("X 1 es: " + culebra.getX().get(1).toString());

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                
                if (culebra.getY1() == x2 && culebra.getX1() == y2) {
                    matriz[x2][y2] = " ";
                    x2 = 1 + r.nextInt(11);
                    y2 = 1 + r.nextInt(31);
                    matriz[x2][y2] = "O";
                    //X n = new X(culebra.getX().get(culebra.getX().size() - 1).getX() - 1, culebra.getX().get(culebra.getX().size() - 1).getY() - 1 );
                }
                if (x2 != i | y2 != j) {
                    if (i == 0 | i == matriz.length - 1) {
                        matriz[i][j] = "*";
                    } else if (j == 0 | j == 32) {
                        matriz[i][j] = "*";
                    } else if (culebra.getY1() == i && culebra.getX1() == j) {
                        matriz[i][j] = culebra.getCabesa();
                    } else {
                        matriz[i][j] = " ";
                    }
                }
                mapas += matriz[i][j];
            }
            mapas += "\n";
        }
        if (culebra.getX1() == x2 && culebra.getY1() == y2) {
            x2 = 1 + r.nextInt();
            y2 = 1 + r.nextInt();
            matriz[x2][y2] = "O";
        }
        map.setText(mapas);
    }
}
