/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;


public class ProdutoUnitario extends Produto {
    private int qtd;
    
    public ProdutoUnitario(String nome, double valor,int qtd) {
        super(nome,valor);
        isPesavel = false;
        this.qtd=qtd;
    }
    
    public void setTotal(double aux) {
        this.qtd = (int) aux;
    }
   
    public double getTotal() {
        return qtd;
    }
    
    
    public String getunidade() {
        return "Unidades";
    }
}