public class EstadoVerde implements EstadoSemaforo {
    @Override
    public void mostrarSinal() {
        System.out.println("Sinal Verde: Siga em frente!");
    }

    @Override
    public void realizarTransicao(Semaforo semaforo) {
        semaforo.setEstado(new EstadoAmarelo());
    }

    @Override
    public String toString() {
        return "Verde";
    }
}
