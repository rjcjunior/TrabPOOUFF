/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Menu {
    Scanner ler = new Scanner(System.in);
    Estoque e;
    Loja  supermercado;
    RelatorioEstoque re;
    Venda venda;
    Pagar pagar;
    Login l; 
    Boot boot;
    DecimalFormat df = new DecimalFormat("#.###");     

    public Menu(Estoque e,Loja supe){        
        this.e=e;
        this.supermercado=supe;    
        l = new Login(supermercado);       
        pagar = new Pagar();
        boot = new Boot(e,supermercado);
        venda = new Venda(e,supermercado);
        boot.Iniciarboot();
        re = new RelatorioEstoque(e);
        pagar = new Pagar();
    }
    
    
    
    public void primeiromenu(){
        int op;
        System.out.println("============ Bem vindo ============");
        System.out.println("============ Você é ============");
        System.out.println("1) Cliente ");
        System.out.println("2) Funcionario ");
        System.out.println("3) Sair");
        System.out.println("Entre com o valor abaixo: ");
        op = ler.nextInt();
        switch (op){
            case 1:{
                menucliente();
                break;
            }
            case 2:{                
                System.out.println("Digite o CPF: ");
                String cpf = ler.next();
                if (supermercado.contem(cpf)){
                    menufuncionarios(cpf);
                    break;
                }
                else{
                    System.out.println("CPF Invalido");
                    primeiromenu();
                    break;
                }
                
            }    
            case 3:{
                break;
            }
            default:{
                System.out.println("Este não é uma opção valida");
                primeiromenu();
                break;
        }   
                    
            }
    }
    
    public void menufuncionarios(String cpf){
        int op;
        
        System.out.println("============ Você deseja entrar no============");
        System.out.println("1) Gerente ");
        System.out.println("2) Funcionario-Caixa ");
        System.out.println("3) Voltar");
        System.out.println("Entre com o valor abaixo: ");
        op = ler.nextInt();
        switch (op){
            case 1:{
                if(l.logar(cpf)){
                    menugerente(cpf);
                    break;
                }
                else{
                    System.out.println("Você não tem acesso!");
                    menufuncionarios(cpf);
                    break;
                }
            }
            case 2:{
                System.out.println("Qual Caixa deseja entrar?");
                int numcaixa = ler.nextInt();
                menufunc(cpf,numcaixa);
                break;
            }
            case 3:{
                primeiromenu();
                break;
            }
            default:{
                System.out.println("Opção invalida");
                menufuncionarios(cpf);
            }
    }
    }
    
    public void menucliente(){
        int op;
        String aux;
        int aux1;
        System.out.println("============ Menu cliente ============");
        System.out.println("1) Consulta por nome ");
        System.out.println("2) Consulta por codigo ");
        System.out.println("3) Voltar ");
        System.out.println("Entre com o valor abaixo: ");
        op = ler.nextInt();
        switch (op){
            case 1:{
                System.out.println("Entre com o nome abaixo: ");
                aux = ler.next();
                if (e.consultanome(aux)>=0){
                System.out.println("Valor é R$ " + df.format(e.consultanome(aux)));}
                else{
                    System.out.println("Não existe produto com este nome");
                }
                menucliente();
                break;
            }           
            case 2:{
                System.out.println("Entre com o codigo abaixo: ");
                aux1 = ler.nextInt();
                if (e.consultacod(aux1)>= 0){
                System.out.println("Valor é R$ " + df.format(e.consultacod(aux1)));  
                }
                else{
                    System.out.println("Não existe produto com este codigo");
                }
               
                menucliente();
                break;
            }
            case 3:{
                primeiromenu();
                break;
            }
            default:
                System.out.println("Este não é uma opção valida");
                menucliente();
                break;
        }
        
        }
    
    public void menufunc(String cpf, int numerocaixa){
        int op;
        String aux;
        int aux1;
        System.out.println("============ Menu Funcionario-Caixa ============");
        System.out.println("1) Vender ");
        System.out.println("2) Voltar ");
        op = ler.nextInt();
        switch (op){
            case 1:{
                int cod;
                boolean a=true;
                double aux2=0;
                while(a){
                    System.out.println("Insira o codigo do Produto ou -1 terminar a compra ");                    
                    cod = ler.nextInt();                    
                    if(e.gettotalitens()>=cod){
                        if(cod>=0 ){
                            System.out.println("Insira a quantidade em unidades ou kg");
                            double qnt = ler.nextDouble();
                            int aux3 = e.contem(cod);
                            if (e.getprodutos().get(aux3).getTotal()>=qnt){
                                venda.vender(cpf, numerocaixa, qnt, cod);
                                aux2 +=venda.valorfinal(cod, qnt);}
                            else{
                                System.out.println("Qnt excedente");
                            }
                        }
                        else{
                            a=false;
                   
                         }
                    }
                    else{
                        
                            System.out.println("Item inexistente");
                        
                    }
                }
                pagar.pagar(aux2);
                menufunc(cpf, numerocaixa);
                break;
            }
                
                
            case 2:{
                menufuncionarios(cpf);
                break;
            }
            default:
                System.out.println("Este não é uma opção valida");
                menufunc(cpf, numerocaixa);
                break;
        }
        }
    
    public void menugerente(String cpf){
        int op;
        String aux;
        int aux1;
        System.out.println("============ Menu Gerente ============");
        System.out.println("1) Estoque ");
        System.out.println("2) Relatorio ");
        System.out.println("3) Voltar ");
        op = ler.nextInt();
        switch (op){
            case 1:{
                Menuestoque m = new Menuestoque(e);
                m.gerarmenu();
                menugerente(cpf);
                break;
            }
            case 2:{
                Menurelatorio mr = new Menurelatorio(re,supermercado,e);
                mr.gerarmenu();
                menugerente(cpf);
                break;
            }
            case 3:{
                menufuncionarios(cpf);
                break;
            }
            default:
                System.out.println("Este não é uma opção valida");
                menugerente(cpf);
                break;
        }
        
        
        }
    
    
    
    }
    
    
    






    
    
