/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendai;
public class pessoa {
    String nome;
    String telefone;
    String detalhes;
    pessoa(){
        this.nome = "NOVO CONTATO";
        this.telefone = "";
        this.detalhes = "";
    }
    String getnome(){
        return this.nome;
    }
    String gettelefone(){
        return this.telefone;
    }
    String getdetalhes(){
        return this.detalhes;
    }
    void setnome(String s){
        this.nome = s;
        return;
    }
    void settelefone(String s){
        this.telefone = s;
        return;
    }
    void setdetalhes(String s){
        this.detalhes = s;
        return;
    }
}

