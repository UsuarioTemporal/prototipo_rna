/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Neurona {
    float entrada;
    float salida;

    public float getEntrada() {
        return entrada;
    }

    public void setEntrada(float entrada) {
        this.entrada = entrada;
    }

    public float getSalida() {
        return salida;
    }

    public void setSalida(float salida) {
        this.salida = salida;
    }
    
    public void inicializar(float f){
        this.entrada=f;
        this.salida=f;
    }
    
    public void calcularEntrada(float salidas[],float pesos[]){
        entrada = 0.0F;
        for(int i = 0; i < salidas.length; i++){
            if(salidas[i] != 0.0F && pesos[i] != 0.0F){
                entrada += salidas[i] * pesos[i];
            }
        }
        entrada += pesos[pesos.length - 1];
    }
    
    void activarSigmoide()
    {
        salida = 1.0F / (1.0F + (float)Math.exp(-entrada));
    }
}
