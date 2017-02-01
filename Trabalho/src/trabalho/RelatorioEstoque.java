/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.ArrayList;


public class RelatorioEstoque {
    
   
    Estoque iniciodia;
    public RelatorioEstoque(Estoque e){     
        iniciodia = new Estoque();
        for(Produto est:e.getprodutos()){
            iniciodia.add(est.getnome(),est.getunidade(),est.getTotal(),est.getValor());
        }
        
    }
    
    public void geraRelatorio(Estoque a){
           ArrayList<Produto> p = a.getprodutos();
           for (Produto prod:p){
               for (Produto prod1:iniciodia.getprodutos()){
                   if(prod.getCodigo()== prod1.getCodigo()){
                       System.out.println("");
                       System.out.println("Nome: " + prod.getnome() );
                       if (prod.getunidade().equalsIgnoreCase("KG")){
                       System.out.println("Qnt começo do dia: " + prod1.getTotal()+" KG" );
                       System.out.println("Final do dia: " + prod.getTotal()+" KG" );
                       System.out.println("");
                       }
                       else {
                           System.out.println("Qnt começo do dia: " + (int)prod1.getTotal()+" Unidades" );
                           System.out.println("Final do dia: " + (int)prod.getTotal()+" Unidades" );
                           System.out.println("");
                       }
                       
                       break;
                   }
                   
               }
           }
               
           
               
      
    }
}

