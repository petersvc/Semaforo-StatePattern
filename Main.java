
// Main.java
public class Main {

	public static void main(String[] args) {
		Semaforo epitacio = new Semaforo("12356");
		System.out.println("Estado Inicial: " + epitacio);

		epitacio.start();

		System.out.println("Fim da simulação.");
		System.out.println(epitacio);
	}
}
