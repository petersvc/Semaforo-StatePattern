import java.util.HashMap;
import java.util.Map;

import java.lang.Thread;

public class Semaforo {
	private String numTombamento;
	private EstadoSemaforo estado;
	private final Map<String, Integer> transicao;

	public Semaforo(String numTombamento) {
		this.numTombamento = numTombamento;
		this.estado = new EstadoVermelho(); // Estado inicial: Vermelho
		this.transicao = new HashMap<>();

		// Tempo de transicao em segundos
		this.transicao.put("Vermelho", 3);
		this.transicao.put("Amarelo", 1);
		this.transicao.put("Verde", 5);
	}

	public String getNumTombamento() {
		return numTombamento;
	}

	public void setNumTombamento(String numTombamento) {
		this.numTombamento = numTombamento;
	}

	public String getEstado() {
		return estado.toString();
	}

	public void setEstado(EstadoSemaforo estado) {
		this.estado = estado;
	}

	public void mostrarSinal() {
		estado.mostrarSinal();
	}

	public void realizarTransicao() {
		estado.realizarTransicao(this);
	}

	public void showVisorRegressivo() {
		int timeInSeconds = transicao.get(getEstado());
		for (int i = timeInSeconds; i > 0; i--) {
			System.out.println(i + " segundo(s)");
			try {
				// 1000 milisegundos equivale a 1 segundo
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		int timeInSeconds = 10;

		while (timeInSeconds > 0) {
			System.out.println("Tempo restante da simulação: " + timeInSeconds + " segundos");
			mostrarSinal();
			System.out.println(transicao.get(getEstado()) + " segundos.");
			System.out.println(getEstado());
			timeInSeconds -= transicao.get(getEstado());
			System.out.println(timeInSeconds + " segundos restantes.");
			showVisorRegressivo();
			realizarTransicao();
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "Semaforo{" +
				"numTombamento='" + numTombamento + '\'' +
				", estado=" + estado.getClass().getSimpleName() +
				'}';
	}
}





//public class Semaforo {
//
//	private String numTombamento = null;
//
//	private boolean[] estado = {true,false,false};
//	private Map<Sinal, Integer> transicao = new HashMap<Sinal,Integer>();
//
//	public Semaforo(String numTombamento) {
//        this.numTombamento = numTombamento;
//        // tempo de transicao em segundos
//        transicao.put(Sinal.VERMELHO,3);
//        transicao.put(Sinal.AMARELO,1);
//        transicao.put(Sinal.VERDE,5);
//	}
//
//	public String getNumTombamento() {
//		return numTombamento;
//	}
//
//	public void setNumTombamento(String numTombamento) {
//		this.numTombamento = numTombamento;
//	}
//
//	public Sinal getEstadoAtual() {
//		return estado[0]?Sinal.VERMELHO: (estado[1]?Sinal.AMARELO:Sinal.VERDE);
//	}
//
//	public void setup(Sinal estagio, int novo_tempo_transicao) {
//		this.transicao.put(estagio,novo_tempo_transicao);
//	}
//
//	public void exibir() {
//		System.out.println(" vermelho  ( " + (estado[0] == true?"X":" ") + " )");
//		System.out.println(" amarelo   ( " + (estado[1] == true?"X":" ") + " )");
//		System.out.println(" verde     ( " + (estado[2] == true?"X":" ") + " )");
//	}
//
//	public void efetuarTransicao() {
//	    // se a luz vermelha está ativa
//	    // time.sleep(self.transicao[self.estadoAtual()])
//		if (estado[0] == true) { // o [0] é o vermelho
//	        estado[0]= false; // desativa o vermelho
//	        estado[2]= true;  // ativa o verd
//		} else if (estado[1] == true) {
//	        // se a luz laranja está ativa
//	        estado[1]= false; // desativa o laranja
//	        estado[0]= true;  // ativa o vermelho
//		} else {
//	       // só pode ser o verde que está ativo
//	        estado[2]= false; // desativa o verde
//	        estado[1]= true;  // ativa o laranja
//		}
//	}
//
//	public void showVisorRegressivo() {
//		for (int i = transicao.get(getEstadoAtual()); i >0 ; i--) {
//			System.out.println(i + " segundo(s)");
//			try {
//				// 1000 milisegundos equivale a 1 segundo
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//		}
//	}
//
//	public void start() {
//		this.start(10);
//	}
//
//	public void start(int time_in_seconds) {
//		while(time_in_seconds > 0) {
//			System.out.println("Tempo restante da simulacao: " + time_in_seconds + " segundos");
//			System.out.println( getEstadoAtual() + " : " + transicao.get(getEstadoAtual()) + " segundos.");
//			exibir();
//			time_in_seconds -= transicao.get(getEstadoAtual());
//			showVisorRegressivo();
//			efetuarTransicao();
//			System.out.println();
//
//		}
//
//	}
//
//	public String toString() {
//		String s = "";
//		s += "Numero Tombamento: " + numTombamento + "\n";
//		s += "Tempo de permanencia em cada estagio:\n";
//		s += Sinal.VERMELHO + " : " + transicao.get(Sinal.VERMELHO) + " segundos\n";
//		s += Sinal.AMARELO + " : " + transicao.get(Sinal.AMARELO) + " segundos\n";
//		s += Sinal.VERDE + " : " + transicao.get(Sinal.VERDE) + " segundos\n";
//		return s;
//	}
//
//
//}
