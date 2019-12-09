/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.Scanner;

/**
 *
 * @author Joâo Pedro
 */
public class Threads {

static long inicio;
static long f;
    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        switch(teclado.nextInt()){
            case(0): programasoma();break;
            case(1):nachi(teclado);break;
        }
    
    }
    public static void nachi(Scanner teclado) throws InterruptedException{/*FUNCIONA ATE 46*/
        System.out.println("insira o termo n para as repeticoes da sequencia");
        int n = teclado.nextInt();
        fibbo.seq = n;
        fibbo.n1 = 0;
        fibbo.n2 = 0;
        Thread t = new Thread(new fibbo(1));
        Thread t2 = new Thread(new fibbo(2));
        inicio = System.currentTimeMillis();
        t.start();
        t2.start();
        while(fibbo.seq +1 > fibbo.n){
            continue;
        }
        System.out.println();
        
        System.out.println(fibbo.n1);
        f = System.currentTimeMillis();
        f = f - inicio;
        System.out.println("tempo levado:" + f);
        
        System.out.println("agora por rec");
        inicio = System.currentTimeMillis();
        System.out.println(nacho((long)n));
        f = System.currentTimeMillis();
        f = f - inicio;
        System.out.println("tempo levado:" + f);
        
    }
    
    
    public static long nacho(long n){
        if(n == 1) return 1;
        if(n == 0) return 0;
        return nacho(n-1) + nacho(n-2);
    }
        
    
    
    
    
    
    public static void programasoma() throws InterruptedException{
        int numero = 11;  //vai imprimir 11 vezes "o somatorio e 2000000001000000000" antes de apresentar o resultado final
        boolean b;
        int i;
        long [] vetor = new long[(3*numero)];
        int indice = 0;
        for(int j = 1; j<=1024;j = j*2){
            inicio = System.currentTimeMillis();
            somatorio.inicializa();
            
            Thread [] t = new Thread[j];
            int ini = 0;
            int fim = somatorio.max/j;
            for(i = 0; i<j; i++){
                t[i] = new Thread(new somatorio(ini, fim));
                t[i].start();
                t[i].join();
                ini = fim + 1;
                fim = somatorio.max/j *(i+2);
            }
            b = true;
       System.out.println("o somatorio e " + somatorio.soma);
       f = System.currentTimeMillis();
       vetor[indice] = somatorio.soma;
       vetor[indice + 1] = (j);
       vetor[indice + 2] = f-inicio;
       indice = indice + 3;
    }
            for(i = 0; i<numero*3; i = i+3){
                System.out.println("soma "+vetor[i]+" numero de threads "+vetor[i+1]+" tempo " + vetor[i+2]);
            }
  }
}
