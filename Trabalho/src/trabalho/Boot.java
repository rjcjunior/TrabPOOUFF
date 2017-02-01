/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;


public class Boot {
    Estoque e;
    Loja l;
    public Boot(Estoque e, Loja l){
        this.e=e;
        this.l=l;    
    }
    
    public void Iniciarboot(){
        e.add("Arroz", "KG", 15043, 12.2);
        e.add("Feijão", "KG", 15043, 10);
        e.add("Tomate", "KG", 15043, 4);
        e.add("Pera", "KG", 15043, 2.5);
        e.add("Biscoito", "Unidades", 15043, 2.4);
        e.add("Refrigerante", "Unidades", 15043, 2.3);
        e.add("Chocolate", "Unidades", 30, 3.3);
        e.add("Chocolate Branco", "Unidades", 30, 4.3);
        e.add("Sabonete", "Unidades", 30, 5.3);
        e.add("Gilette", "Unidades", 30, 6.3);
        e.add("Amendoim", "Unidades", 30, 7.3);
        e.add("Jujuba", "Unidades", 30, 8.3);
        e.add("Camisa", "Unidades", 30, 9.3);
        e.add("Shampoo", "Unidades", 30, 11.3);
        e.add("Fogao", "Unidades", 30, 2300);
        e.add("Geladeira", "Unidades", 30, 4300);
        l.addgerente("Ricardo", "12345678901");
        l.addfuncionario("Anderson", "12345678902");
        l.addfuncionario("Erika", "12345678903");
        l.addfuncionario("Rodrigo", "12345678904");
        l.addfuncionario("Martin", "12345678905");
        l.addfuncionario("Luan", "12345678906");
        
        
    }
}
