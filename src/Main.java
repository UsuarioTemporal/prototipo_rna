
import basedatos.BDConector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Main {
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        if(BDConector.conectar_bd()){
            RedNeuronal rn=new RedNeuronal();
            rn.calcular();
        }   
    }
}
