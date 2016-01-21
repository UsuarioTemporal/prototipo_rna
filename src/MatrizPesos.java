
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class MatrizPesos {
    float peso[][];
    float bias[];
    
    public MatrizPesos(int n1, int n2)
    {   
        peso= new float[n1][n2];
        bias = new float[n2];    
    }
    
    public void llenarPesos(ArrayList<Float> pesos,int inicio){
        int k=inicio;
        for(int i=0;i<peso.length;i++){
            for(int j=0;j<peso[0].length;j++){
                peso[i][j]=pesos.get(k);
                k++;
            }
        }
        for(int l = 0; l < peso[0].length; l++){
            bias[l]=pesos.get(k);
            k++;
        }
    }
    
    public void mostrarPesos(){
        for(int i = 0; i < peso.length; i++)
        {
            for(int j = 0; j < peso[0].length; j++){
                System.out.println("valor de weight["+i+"]["+j+"]: "+peso[i][j]);
            }
        }

        for(int k = 0; k < peso[0].length; k++){
            System.out.println("valor de bias["+k+"]: "+bias[k]);
        }
    }
    
    float[] getPesosSalida(int i)
    {
        float pesosSalida[] = new float[peso[0].length];
        for(int j = 0; j < peso[0].length; j++){
            pesosSalida[j] = peso[i][j];
        }
        return pesosSalida;
    }
    
     float[] getPesosEntrada(int i) 
    {
        float pesosEntrada[] = new float[peso.length + 1];
        for(int j = 0; j < peso.length; j++){
            pesosEntrada[j] = peso[j][i];
        }
        pesosEntrada[peso.length] = bias[i];
        return pesosEntrada;
    }
}
