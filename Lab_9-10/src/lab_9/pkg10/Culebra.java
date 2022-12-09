/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_9.pkg10;

import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class Culebra {
    private String cabesa;
    private int x1,y1;
    private ArrayList<X> x = new ArrayList();

    public Culebra(String cabesa, ArrayList<X> x, int x1, int y1) {
        this.cabesa = cabesa;
        this.x = x;
        this.x1 = x1;
        this.y1 = y1;
    }
    
    public Culebra() {
    }

    public String getCabesa() {
        return cabesa;
    }

    public void setCabesa(String cabesa) {
        this.cabesa = cabesa;
    }

    public ArrayList<X> getX() {
        return x;
    }

    public void setX(ArrayList<X> x) {
        this.x = x;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    @Override
    public String toString() {
        return "Culebra{" + "cabesa=" + cabesa + ", x=" + x + ", x1=" + x1 + ", y1=" + y1 + '}';
    }
    
    
}
