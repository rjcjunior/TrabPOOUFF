/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.text.DecimalFormat;


public class Pagcartao implements Pagamento {
    
    private double valor;
    DecimalFormat df = new DecimalFormat("#.###");     

    public Pagcartao(double valorEntregue) {
        this.valor = valorEntregue;   
    }
    
    public double getvalor(){
        return valor;
    }
    
    public void pagfeito(){
         System.out.println("Pagamento de R$" + df.format(valor) +" feito com sucesso pelo cartão");   
    }
    
}
