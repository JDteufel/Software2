package co.edu.poli.ejemplo1.modelo;

public class PayPalAdapter implements Pagos{
    private PayPal paypal;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    @Override
    public double Cobro() {
        double total = paypal.conversion() + paypal.impuesto();
        return total;
    }
}