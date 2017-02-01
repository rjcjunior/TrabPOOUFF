/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import java.text.DecimalFormat;



public class Pagmoney implements Pagamento{
    
    private double money;
    private double valor;
    DecimalFormat df = new DecimalFormat("#.###");     

    public Pagmoney(double valor, double money){
        this.money = money;
        this.valor = valor;

    }
    
    public double troco(){
        if (money>valor){
            return (money - valor);
        }
        
        else{
            return 0.00;          
        }
    }
    
    public void pagfeito(){
        System.out.println("O valor recebido da compra é: "+ df.format(valor));
        System.out.println("Valor recebido é de: "+ df.format(money));
        System.out.println("Entregue de troco o total de: "+ df.format(troco()));
    }
    
}
