/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

public class Pagar {
    Scanner ler;
    Pagamento p;
    double valor;
    DecimalFormat df;
    
    public Pagar(){
    ler = new Scanner(System.in);
    df = new DecimalFormat("#.###");     
    }
    
    public void pagar(double valor){
        
        try{
        System.out.println(" Valor foi de R$ "+ df.format(valor) +" Você deseja pagar no:");
        System.out.println("1) Cartão ");
        System.out.println("2) Dinheiro ");
        System.out.println("Entre com o valor abaixo: ");
        int op = ler.nextInt();
        switch (op){
            case(1):{
                 System.out.println("============ Entre com o cartão ============");
                 p = new Pagcartao(valor);
                 p.pagfeito();
                 System.out.println("============ Volte sempre ============");
                 break;
            }
            case(2):{
                 System.out.println("============ Insira a quantia recebida ============");
                 double valorrecebido=ler.nextDouble();
                 if (valorrecebido<valor){
                     System.out.println("Ta faltando dinheiro!");
                     pagar(valor);
                     break;
                 }
                 p = new Pagmoney(valor,valorrecebido);
                 p.pagfeito();
                 System.out.println("============ Volte sempre ============");
                 System.out.println("");
                 break;
                
            }
            default:{
               pagar(valor);
               break;
           } 
        }
    }
        catch (NumberFormatException | InputMismatchException  e){
            System.out.println("Você inseriu um numero incorretamente");
            valor = ler.nextFloat();
            pagar(valor);
            
        }
            
   }
}
