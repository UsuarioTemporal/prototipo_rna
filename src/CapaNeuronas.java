/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class CapaNeuronas {
    Neurona neurona[];
    
    CapaNeuronas(int i)
    {
        neurona = new Neurona[i];
        for(int j = 0; j < i; j++){
            neurona[j] = new Neurona();
        }
    }
    
    public void establecerEntradas(int[] entrada){    
        for(int i=0;i<entrada.length;i++){
            neurona[i].inicializar(entrada[i]);
        }
    }
    
    void calcularEntrada(CapaNeuronas capaneuronas, MatrizPesos matrizpesos)
    {
        for(int i = 0; i < neurona.length; i++){
            neurona[i].calcularEntrada(capaneuronas.getSalidas(), matrizpesos.getPesosEntrada(i));
        }
    }

    void calcularSalida()
    {
        for(int i = 0; i < neurona.length; i++){
            neurona[i].activarSigmoide();
        }
    }
    
    float[] getSalidas()
    {
        float salidas[] = new float[neurona.length];
        for(int i = 0; i < neurona.length; i++){
            salidas[i] = neurona[i].getSalida();
        }
        return salidas;
    }
}
