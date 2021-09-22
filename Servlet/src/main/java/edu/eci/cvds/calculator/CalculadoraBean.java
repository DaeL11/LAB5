package edu.eci.cvds.calculator;

import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "calculadoraBean")
@ApplicationScoped
public class CalculadoraBean {
    private ArrayList<Double> lista;
    private double media;
    private double moda;
    private double desviacionEstandar;
    private double varianza;

    public CalculadoraBean(){

    }

    public ArrayList<Double> getLista() {
        return lista;
    }
    public double getMedia() {
        return media;
    }
    public double getDesviacionEstandar() {
        return desviacionEstandar;
    }
    public double getModa() {
        return moda;
    }
    public double getVarianza() {
        return varianza;
    }


    public void setDesviacionEstandar(double desviacionEstandar) {
        this.desviacionEstandar = desviacionEstandar;
    }
    public void setLista(ArrayList<Double> lista) {
        this.lista = lista;
    }
    public void setMedia(double media) {
        this.media = media;
    }
    public void setModa(double moda) {
        this.moda = moda;
    }
    public void setVarianza(double varianza) {
        this.varianza = varianza;
    }

    public double calculateMean(ArrayList<Double> lista){
        double res = 0;
        for(double x : lista){
            res += x;
        }
        return (res/lista.size());
    }

    public double calculateStandardDeviation(ArrayList<Double> lista){
        return Math.sqrt(calculateVariance(lista));
    }

   public double calculateVariance(ArrayList<Double> lista){
    double mean = calculateMean(lista);
    double res = 0;
    for(double x : lista){
        res += Math.pow(x-mean,2);
    }
    return(res/lista.size());
   } 

   public double calculateMode(ArrayList<Double>lista){
        int max= 0;
        double moda= 0;
        for(double i : lista){
            int repe= 0;
            for(double j : lista){
                if(i==j){
                    repe++;
                }
                if(repe>max){
                    moda= i;
                    max=repe;
                }
            }
        }
        return moda;
    }

    public void restart(){
        
    }

}
