package co.edu.poli.ejemplo2.modelo;
import java.util.HashMap;
import java.util.Map;

public class FormaDePago {
    private Map<String, Boolean> formasPago = new HashMap<>();

    public void agregarFormaDePago(String tipo) {
        formasPago.put(tipo, true);
    }

    public void bloquearFormaDePago(String tipo) {
        formasPago.put(tipo, false);
    }

    public void activarFormaDePago(String tipo) {
        formasPago.put(tipo, true);
    }

    public Map<String, Boolean> verFormasDePago() {
        return formasPago;
    }
}
