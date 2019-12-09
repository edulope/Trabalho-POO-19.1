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
public class somatorio implements Runnable {
    static final int max = 2000000000;
    static long soma;
    int inicio;
    int fim;

    static void inicializa(){
        soma = 0l;
    }

    public somatorio(int i, int f){
        this.inicio = i;
        this.fim = f;
        return;
    }

    @Override
    public void run() {
        for(long a = inicio; a<fim+1; a++){
            soma += a;
            if(a >= max)a = fim+1;
        }
    }
}
