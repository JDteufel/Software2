package co.edu.poli.ejemplo1.modelo;

public class PayPal {

    private double porcentajeImpuesto = 0.04;
    private double valorDolar = 4200;
    private double costoInicial;
    private double costoDolar;
    private double costoAdaptable;

    public double getCostoInicial() {
        return costoInicial;
    }

    public double getCostoDolar() {
        return costoDolar;
    }

    public double getCostoAdaptable() {
        return costoAdaptable;
    }

    public void setCostoInicial(double costoInicial) {
        this.costoInicial = costoInicial;
    }

    public void setCostoDolar(double costoDolar) {
        this.costoDolar = costoDolar;
    }

    public void setCostoAdaptable(double costoAdaptable) {
        this.costoAdaptable = costoAdaptable;
    }

    public double conversion() {
        costoDolar = (costoInicial * valorDolar) + 9;
        return costoDolar;
    }

    public double impuesto() {
        costoAdaptable = costoInicial * porcentajeImpuesto;
        return costoAdaptable; 
    }

    public void calcularCostos(double costoInicial) {
        this.costoInicial = costoInicial;
        conversion();
        impuesto();
    }
}