package co.edu.poli.ejemplo1.modelo;

public class PayPalAdapter implements Pagos {
    private PayPal paypal;
    private double valorDolar = 4200;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    @Override
    public double Cobro(double costoTotal) {
        paypal.calcularCostos(costoTotal);
        return paypal.getCostoDolar()/valorDolar + paypal.getCostoAdaptable();
    }
}