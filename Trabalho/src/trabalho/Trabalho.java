/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

public class Trabalho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Loja loja = new Loja();
        Estoque estoque = new Estoque();
        
        Menu menu = new Menu(estoque, loja);
        menu.primeiromenu();
        
    }
    
}
