/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import static basedatos.BDConector.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ControladorPesos {
    public ArrayList<Float> consultarPesos()throws SQLException{
        ArrayList<Float> pesos=new ArrayList();
        String consulta="select * from peso";
        PreparedStatement select=(PreparedStatement) Conexion.prepareStatement(consulta);
        ResultSet dts=select.executeQuery();
        while(dts.next()){
            pesos.add(dts.getFloat(2));
        }
        select.close();
        return pesos;
    }
    
    public int[] consultarEntrada() throws SQLException{
        int[] entrada=new int[2];
        String consulta="select * from entrada";
        PreparedStatement select=(PreparedStatement) Conexion.prepareStatement(consulta);
        ResultSet dts=select.executeQuery();
        while(dts.next()){
            for(int i=0;i<2;i++){
                entrada[i]=dts.getInt(i+2);
            }
        }
        select.close();
        return entrada;
    }
}
