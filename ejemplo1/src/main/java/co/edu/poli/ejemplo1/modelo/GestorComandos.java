package co.edu.poli.ejemplo1.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorComandos {
    private List<Comando> historial = new ArrayList<>();

    public void ejecutarComando(Comando comando) {
        comando.ejecutar();
        historial.add(comando); // Podrías usarlo para deshacer más adelante
    }
}
