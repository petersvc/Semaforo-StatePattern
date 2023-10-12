public class EstadoVermelho implements EstadoSemaforo {
    @Override
    public void mostrarSinal() {
        System.out.println("Sinal Vermelho: Pare imediatamente!");
    }

    @Override
    public void realizarTransicao(Semaforo semaforo) {
        semaforo.setEstado(new EstadoVerde());
    }

    @Override
    public String toString() {
        return "Vermelho";
    }
}
