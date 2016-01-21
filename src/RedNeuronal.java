
import controladores.ControladorPesos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class RedNeuronal {
    CapaNeuronas arregloCapaNeuronas[];
    MatrizPesos arregloMatrizPesos[];
    ControladorPesos controlador;
    int[] entrada;
    
    public void calcular(){
        controlador=new ControladorPesos();
        arregloCapaNeuronas=new CapaNeuronas[3];
        arregloCapaNeuronas[0]=new CapaNeuronas(2); //capa de entrada: 2 neuronas
        arregloCapaNeuronas[1]=new CapaNeuronas(4); //capa oculta: 3 neuronas
        arregloCapaNeuronas[2]=new CapaNeuronas(1); //capa salida: 1 neurona
        
        arregloMatrizPesos=new MatrizPesos[2];
        arregloMatrizPesos[0]=new MatrizPesos(2,4);//Primera matriz de pesos de 2*3
        arregloMatrizPesos[1]=new MatrizPesos(4,1);//Segunda matriz de pesos 3*1
        llenarPesos();
        mostrarPesos();
        obtenerEntrada();
        obtenerSalida();
    }
    
    public void obtenerSalida(){
        arregloCapaNeuronas[0].establecerEntradas(entrada);
        for(int i = 1; i <= 2; i++)
        {
            arregloCapaNeuronas[i].calcularEntrada(arregloCapaNeuronas[i - 1], arregloMatrizPesos[i - 1]);
            arregloCapaNeuronas[i].calcularSalida();
        }
        float[] rpta = arregloCapaNeuronas[2].getSalidas();
        System.out.println(rpta[0]);
    }
    
    public void llenarPesos(){
        ArrayList<Float> pesos=new ArrayList();
        try {
            pesos=controlador.consultarPesos();
        } catch (SQLException ex) {
            Logger.getLogger(RedNeuronal.class.getName()).log(Level.SEVERE, null, ex);
        }
        arregloMatrizPesos[0].llenarPesos(pesos,0);
        arregloMatrizPesos[1].llenarPesos(pesos,(2*4+4));
        //El segundo parametro es el indice desde el cual comenzara a agregar los pesos
    }
    
    public void obtenerEntrada(){
        try {
            entrada=controlador.consultarEntrada();
        } catch (SQLException ex) {
            Logger.getLogger(RedNeuronal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarPesos(){
        arregloMatrizPesos[0].mostrarPesos();
        arregloMatrizPesos[1].mostrarPesos();
    }
}
