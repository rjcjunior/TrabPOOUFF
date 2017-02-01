/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;


public class ProdutoPesavel extends Produto {
    private double peso;
    
    public ProdutoPesavel(String nome, double valor, double peso) {
        super(nome,valor);
        isPesavel = true;
        this.peso=peso;
    }
    public String getunidade() {
        return "KG";
    }
    public double getTotal() {
        return peso;
    }
    public void setTotal(double peso) {
        this.peso=peso;
    }

}
