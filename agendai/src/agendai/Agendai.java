/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendai;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 *
 * @author Joâo Pedro
 */
public class Agendai {
    
    static Scanner teclado = new Scanner(System.in);
    static List<pessoa>pessoas;
    static String [] nome_pessoas;
   
    public static void main(String[] args) {
    Agendainterface agenda = new Agendainterface();
    agenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    agenda.setSize(1050, 400);
    agenda.setVisible(true);
    JFrame inst = new JFrame();
    inst.setSize(400, 400);
    String texto = "BEM VINDO A INTERFACE DE AGENDA DIGITAL MODERNA 3000\n utilizacao:\n1->adicionar:\n insira os dados nos espacos \n clique em adicionar\n2->remover\n selecione o contato\n aperte remover\n3->exibir\n selecione o contato desejado\n clique em exibir Informações\n 4-> editar\n selecione o contato\n escreva os dados nos campos \n aperte Aplicar alterações";
    JTextArea text = new JTextArea(texto);
  
    inst.add(text);
    inst.pack();
    inst.setVisible(true);
    }
}

