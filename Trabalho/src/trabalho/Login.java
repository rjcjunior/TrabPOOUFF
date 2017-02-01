/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author Ricardo
 */
public class Login {
    Loja l;
    public Login(Loja l){
        this.l=l;
    }
    
    public boolean logar(String cpf){
        if (l.consultacpfgerente(cpf)){
            return true;
        }
        return false;
    }
}
