/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.text.DecimalFormat;

public class RelatorioVenda implements InterfacecomumItens {
    
    private String nome;
    private double valor=0;
    private int cod;
    DecimalFormat df = new DecimalFormat("#.###");     

    public RelatorioVenda(){
       
    }
    
    
    public void adicionarvenda(double val){
           valor=valor+val;
    }
    
    public String getnome(){
        return nome;
    }
    
    public void setnome(String name){
        this.nome=name;
    }
    public void setcod(int aux){
        this.cod=aux;
    }
    
    public void gerarelatorio(int cod){
       
         System.out.println("Funcionario Responsavel: " + this.nome );
         System.out.println("Caixa usada: " + this.cod  );
         System.out.println("Venda do dia: " + df.format(this.valor)  );
         
          
    }
}

