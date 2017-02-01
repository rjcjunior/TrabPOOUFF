/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.ArrayList;


public class Caixa {
    private int codigo;
    
    private ArrayList<RelatorioVenda> rv;

    
    public Caixa (){
        rv=new ArrayList<>();
    }
    
    public Caixa (int codigo){
        this.codigo=codigo;
        rv=new ArrayList<>();
    }
    
    public void addvenda(double valor, String funcionario){
        boolean a=true;
        for(RelatorioVenda r:rv){
            if (r.getnome().equalsIgnoreCase(funcionario)){
                r.adicionarvenda(valor);
                a=false;
            }
        }
        if (a==true){
            addfunc(funcionario);
            addvenda(valor, funcionario);
        }
    }
    
    public void addfunc(RelatorioVenda r,String funcionario){
        boolean a=false;  
        for(RelatorioVenda rv1:rv){
            if (rv1.getnome().equalsIgnoreCase(funcionario)){
                a=true;
                break;
            }
        }
        if (!a){
            r.setnome(funcionario);
            r.setcod(codigo);
            rv.add(r);
        }
        
        
    }
    public void addfunc(String funcionario){
        boolean a=false;  
        for(RelatorioVenda rv1:rv){
            if (rv1.getnome().equalsIgnoreCase(funcionario)){
                a=true;
                break;
            }
        }
        if (!a){
            RelatorioVenda r = new RelatorioVenda();
            r.setnome(funcionario);
            r.setcod(codigo);
            rv.add(r);
        }
        
        
    }
    
    public void gerarrelatorio(){
            if (!rv.isEmpty()){
            for(RelatorioVenda r:rv){
                r.gerarelatorio(codigo);
                
            }
            }
            else{
                    System.out.println("Caixa "+ getcod()+" Não vendeu nada");
                    }
    }    
    
    
    
    
    public int getcod(){
        return codigo;
    }
    
    public void setcod(int i){
        this.codigo = i;
    }
    
    
    
}
