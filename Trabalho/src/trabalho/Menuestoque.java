/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import java.util.Scanner;


public class Menuestoque implements Menubase{
    Estoque e;
    Scanner ler;

    public Menuestoque(Estoque e){
        this.e=e;
        ler = new Scanner(System.in);

    }
    public void gerarmenu(){
        System.out.println("============ Menu Estoque ============");
        System.out.println("1) Adicionar item ");
        System.out.println("2) Listar Estoque ");
        System.out.println("3) Voltar ");
        int op = ler.nextInt();
        switch(op){
            case(1):{
                System.out.println("Entre com o nome do produto");
                String nome = ler.next();
                System.out.println("Entre com a quantidade");
                double qtd = ler.nextDouble();
                System.out.println("Medido em KG ou Unidades?");
                String unidade = ler.next();
                System.out.println("Entre com o valor");
                double valor = ler.nextFloat();
                if(unidade.equalsIgnoreCase("kg") || unidade.equalsIgnoreCase("unidades")){
                    if(unidade.equalsIgnoreCase("kg")){
                        ProdutoPesavel p = new ProdutoPesavel(nome,valor, qtd);
                        e.add(p);
                        
                    }
                    else{
                        ProdutoUnitario p = new ProdutoUnitario(nome,valor, (int) qtd);
                        e.add(p);
                        System.out.println("Produto adicionado");
                        break;                        
                    }
                }
                else{
                    System.out.println("Medida incorreta");
                    gerarmenu();
                    break;
                }
                break;
            }
            case(2):{
                e.listarEstoque();
                break;
            }
            case (3):{
                break;
            }
            default:{
                System.out.println("Opcao Invalida");
                gerarmenu();
            }
        }
    }
    
    
}
