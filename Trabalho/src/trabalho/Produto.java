/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;


public abstract class Produto implements InterfacecomumItens{
        private int codigo;
        private String nome;
        private double valor;
        protected boolean isPesavel;
        
        public Produto(String nome, double valor) {
                
                setnome(nome);
                setValor(valor);
        }        
        
        public int getCodigo() {
            return codigo;
        }
        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }
        
        public void setnome(String nome) {
            this.nome = nome;
        }
        public String getnome() {
            return this.nome;
        }
        
        public void setValor(double valor) {
            this.valor = valor;
        }
        public double getValor() {
            return this.valor;
        }
            
        public boolean equals(Object produto){
             return this.nome.equalsIgnoreCase(((Produto)produto).getnome());
    }
        public abstract void setTotal(double aux);
        public abstract double getTotal();
        public abstract String getunidade();
        
}