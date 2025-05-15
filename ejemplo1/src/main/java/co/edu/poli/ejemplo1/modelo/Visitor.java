package co.edu.poli.ejemplo1.modelo;

public interface Visitor {
    void visit(ProductoAlimenticio producto);

    void visit(ProductoElectrico producto);
}