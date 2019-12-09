/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author Joâo Pedro
 */
public class fibbo implements Runnable {
    static long n2;
    static long n1;
    static int n;
    static int seq;
    int i;
    public fibbo(int i){
        fibbo.inicializa();
        this.i = i;
    }
    static void inicializa(){
       n2 = 0;
       n1 = 0;
       n = 0;
    }

    @Override
    public synchronized void run() {
        while(seq+1 > n){
        if(n == 1) n1 = 1;
        if(n >= 2){
            long aux = n1;
            n1 = n1 + n2;
            n2 = aux;
        }
        n++;
        }
    }

}
