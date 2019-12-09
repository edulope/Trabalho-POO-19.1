/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendai;

import static agendai.Agendai.pessoas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Joâo Pedro
 */
public class Agendainterface extends JFrame {
    private List<pessoa>pessoas = new ArrayList<pessoa>();
    private pessoa a = new pessoa();
    private JList lista = new JList();
    public JPanel plista;
    public int b;
    private JTextField nomef;
    private JTextField telf;
    private JTextArea delf;
    JScrollPane scroll;
    private int index;
    
    public Agendainterface() throws HeadlessException {
        super("agenda");
        criamenu();
        crialista();
        String s = pessoas.get(0).getnome();
        
    }
    private void criamenu(){
        JMenu opcoes = new JMenu("Contato");
        Add add = new Add();
        Rem rem = new Rem();
        JMenuItem menuAdd = new JMenuItem("Adicionar contato");
        menuAdd.addActionListener(add);
        JMenuItem menuPop = new JMenuItem("Remover contato");
        menuPop.addActionListener(rem);
        opcoes.add(menuAdd);opcoes.add(menuPop);
        JMenuBar barra = new JMenuBar();
        barra.add(opcoes);
        setJMenuBar(barra);
    }
    
    private void crialista(){
        setLayout(new BorderLayout());
        plista = lista();
        JPanel infos = infos();
        add(plista, BorderLayout.WEST);
        add(infos, BorderLayout.CENTER);
    }
    
    
    public JPanel lista(){
        pessoas.add(a);
        JPanel j = new JPanel();
        JLabel titulo = new JLabel("Lista de contatos:");
        lista = new JList (atualiza(pessoas));
        lista.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        scroll= new JScrollPane (lista);
        j.add(titulo);
        j.add(scroll);
        return j;
    }
    
    private JPanel infos(){
        JPanel j = new JPanel();
        j.setLayout(new FlowLayout());
        JLabel nomel = new JLabel("nome:");
        nomef = new JTextField(10);
        JPanel nome = new JPanel();
        nome.add(nomel);
        nome.add(nomef);
        
        JLabel tell = new JLabel("telefone:");
        telf = new JTextField(10);
        JPanel tel = new JPanel();
        tel.add(tell);
        tel.add(telf);
        
        JLabel dell = new JLabel("detalhes:");
        delf = new JTextArea(10,20);
        JPanel del = new JPanel();
        del.add(dell);
        del.add(delf);
        JPanel botoes = new JPanel();
        JLabel titulo = new JLabel("Informações do contato:");
        JButton aplicar = new JButton("Aplicar alterações");
        aplicar.addMouseListener(new Edit());
        JButton mostrar = new JButton("exibir Informações");
        mostrar.addMouseListener(new Mostra());
        botoes.add(aplicar);
        botoes.add(mostrar);
        
        j.add(titulo);
        j.add(nome);
        j.add(tel);
        j.add(del);
        j.add(botoes);
        return j;
    }

    private class Rem implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            index = lista.getSelectedIndex();
            if(index > 0){pessoas.remove(index);
            plista.removeAll();
           JPanel j = new JPanel();
            JLabel titulo = new JLabel("Lista de contatos:");
            lista = new JList (atualiza(pessoas));
            lista.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
            scroll= new JScrollPane (lista);
            j.add(titulo);
            j.add(scroll); 
            plista.add(j);
            plista.validate();
            nomef.setText("");
            telf.setText("");
            delf.setText("");
            }
        }


    }

    private class Add implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent Event) {
           a = new pessoa();
           a.setnome(nomef.getText());
           a.settelefone(telf.getText());
           a.setdetalhes(delf.getText());
           pessoas.add(a);
           plista.removeAll();
           JPanel j = new JPanel();
            JLabel titulo = new JLabel("Lista de contatos:");
            lista = new JList (atualiza(pessoas));
            lista.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
            scroll= new JScrollPane (lista);
            j.add(titulo);
            j.add(scroll); 
            plista.add(j);
            plista.validate();
            nomef.setText("");
            telf.setText("");
            delf.setText("");

        }
    }
    private class Edit implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent Event) {
            index = lista.getSelectedIndex();
            if(index > 0){
            pessoas.get(index).setnome(nomef.getText());
            pessoas.get(index).settelefone(telf.getText());
            pessoas.get(index).setdetalhes(delf.getText());
            plista.removeAll();
           JPanel j = new JPanel();
            JLabel titulo = new JLabel("Lista de contatos:");
            lista = new JList (atualiza(pessoas));
            lista.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
            scroll= new JScrollPane (lista);
            j.add(titulo);
            j.add(scroll); 
            plista.add(j);
            plista.validate();
            }
            
        }

        @Override
        public void mousePressed(MouseEvent arg0) { 
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
        }
        
    }
    private class Mostra implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent Event) {
            index = lista.getSelectedIndex();
            if(index != -1){
            nomef.setText(pessoas.get(index).getnome());
            telf.setText(pessoas.get(index).gettelefone());
            delf.setText(pessoas.get(index).getdetalhes());
            }
            
        }

        @Override
        public void mousePressed(MouseEvent arg0) { 
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
        }
        
    }
    
    static String[] atualiza(List<pessoa>pessoas){
       String [] nome_pessoas = new String[pessoas.size()];
       int i = 0;
       for(pessoa a: pessoas){
           nome_pessoas[i] = a.getnome();
           i++;
       }
       /*for(i = 0; i<nome_pessoas.length;i++){
           int menor = i;
           for(int j = i; j<nome_pessoas.length;j++){
               if(0 > nome_pessoas[j].compareTo(nome_pessoas[i])){
                   menor = j;
               }
           }
           if(menor != i){
             String s = nome_pessoas[menor]; 
             nome_pessoas[menor] = nome_pessoas[i];
             nome_pessoas[i] = s;
           }
       }*/
       return nome_pessoas;
    }
}
