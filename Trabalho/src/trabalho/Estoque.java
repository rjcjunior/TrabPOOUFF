/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.ArrayList;

public class Estoque {
        private ArrayList<Produto> produtos;
        private int cod=0000;
        private int totalitens=0;

        public Estoque() {
            produtos = new ArrayList<Produto>();

        }
        
        public ArrayList<Produto> getprodutos(){
            return produtos;
        }
       
        public void listarEstoque() {
            System.out.println("============ Estoque: ============");
            System.out.println("================================");
            for (Produto p : produtos) {
                System.out.println("Codigo: "+p.getCodigo());
                System.out.println("Nome: "+p.getnome());
                if (p.isPesavel) System.out.println(p.getTotal()+" kilos");
                else System.out.println((int)p.getTotal()+" unidades");
                System.out.println("================================");
            }
        }
        
        public void add(String nome, String unidade, double qtd,double valor){
            
            if(unidade.equalsIgnoreCase("kg") || unidade.equalsIgnoreCase("unidades")){
                    if(unidade.equalsIgnoreCase("kg")){
                        ProdutoPesavel p = new ProdutoPesavel(nome, valor, qtd);
                        Estoque.this.add(p);
                        
                    }
                    else{
                        ProdutoUnitario p = new ProdutoUnitario(nome, valor, (int) qtd);
                        Estoque.this.add(p);
                        
                        
                    }
            }        
            else{
                             System.out.println("Medida incorreta, Produto não adicionado");
                            }        
        }
        
        public void add(Produto p){
          
           if (contem(p)){
               int i=0;
               while (!p.getnome().equalsIgnoreCase(produtos.get(i).getnome())){
                   i+=1;
               }
            double aux= produtos.get(i).getTotal();
            aux += p.getTotal();
            produtos.get(i).setTotal(aux);
            produtos.get(i).setValor(p.getValor());
           }
           else{
               cod+=1;
               p.setCodigo(cod);
               produtos.add(p);
               totalitens+=1;
           }
        }
        public int gettotalitens(){
            return totalitens;
        }
        public void removerProduto(Produto p) {
            produtos.remove(p);
        }
        
        public boolean contem(Produto p) {
             return produtos.stream().anyMatch((produto) -> (produto.getnome().equalsIgnoreCase(p.getnome())));
        }
        
        public int contem(int cod){
            int i=0;
           
            for (Produto p:produtos){
                if(p.getCodigo()==cod){
                    return i;
                    
                }
                i++;
            }
            return -1;
        }
        
        public void vender(int cod, int qnt){
           int i=contem(cod);
           double aux = produtos.get(i).getTotal();  
           if (contem(cod)>=0 && (aux>=qnt)){
               aux = aux - qnt;
               produtos.get(i).setTotal(aux);

           }
           else{
               System.out.println("Produto inexistente ou Qntd excedente, Venda não concluida");
           }
        }
        public void vender(int cod, double qnt){
           int i=contem(cod);
           double aux = produtos.get(i).getTotal();               
           if (contem(cod)>=0 && (aux>=qnt)){
               aux = aux - qnt;
               produtos.get(i).setTotal(aux);

           }
           else{
               System.out.println("Produto inexistente ou Qntd excedente, Venda não concluida");
           }
        }
        
        public double consultacod(int cod){  
            boolean aux = false;
            int i = 0;         
             for (Produto produto: produtos){
                if (produto.getCodigo()== cod){ 
                    aux = true;
                    break;
               }
                i+=1;
             }
            if (aux){ 
                return produtos.get(i).getValor();
            }
            else
            {   return -1;
                }
            }
        public int codnome(String name){
            
            boolean aux = false;                    
             for (Produto produto: produtos){
                if (produto.getnome().equalsIgnoreCase(name)){ 
                    return produto.getCodigo();
               }

             }
            
               return -1;

        }
        public double consultanome(String name){
            
            int i = 0;            
            boolean aux = false;                    
             for (Produto produto: produtos){
                if (produto.getnome().equalsIgnoreCase(name)){ 
                    aux = true;
                    break;
               }
                i+=1;
             }
            if (aux){ 
                return produtos.get(i).getValor();
            }
            else
            {   return -1;
                }
            }

            
        }
