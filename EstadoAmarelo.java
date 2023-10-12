public class EstadoAmarelo implements EstadoSemaforo {
    @Override
    public void mostrarSinal() {
        System.out.println("Sinal Amarelo: Esteja atento à mudança!");
    }

    @Override
    public void realizarTransicao(Semaforo semaforo) {
        semaforo.setEstado(new EstadoVermelho());
    }

    @Override
    public String toString() {
        return "Amarelo";
    }
}
