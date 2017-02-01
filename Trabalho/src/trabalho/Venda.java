/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;


public class Venda {
       
        Estoque e;
        Loja l;
        
        public Venda(Estoque e, Loja l) {
           
            this.l=l;
            this.e=e;
           
         }
       
        public void vender(String cpf,int numerocaixa, double qtd, int codprod ){
            if (codprod>0){
            double valortotal = e.consultacod(codprod)*qtd;
            e.vender(codprod, qtd);
            String a=l.consultacpf(cpf);
            l.addcaixa(a,numerocaixa,valorfinal(codprod,qtd));
            }
            else{
                System.out.println("Produto inexistente");
            }
            
        }
        
        public double valorfinal(int codprod, double qtd){
            double valortotal;
            return ( valortotal = e.consultacod(codprod)*qtd);
        }

    
}