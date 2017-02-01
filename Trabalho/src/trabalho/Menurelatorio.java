/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.Scanner;

public class Menurelatorio implements Menubase{
    RelatorioEstoque re;
    Loja l;         
    Estoque e;
    Scanner ler;

    public Menurelatorio(RelatorioEstoque re, Loja l, Estoque e){
        this.e=e;
        this.re=re;
        this.l=l;
        
        ler = new Scanner(System.in);

    }
    public void gerarmenu(){
        System.out.println("============ Menu Relatorio ============");
        System.out.println("1) Relatorio Venda ");
        System.out.println("2) Relatorio Estoque ");
        System.out.println("3) Voltar ");
        int op = ler.nextInt();
        switch(op){
            case(1):{
                if(l.getcaixa().isEmpty()){
                    System.out.println("Ainda não houve venda");
                }
                for(Caixa c: l.getcaixa()){
                    
                    
                    c.gerarrelatorio();
                    
                }
                break;
            }
            case(2):{
                re.geraRelatorio(e);
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
