package JantarFilosofos;

public class filosofo extends Thread {

	private final int filosofo; 
	private final Jantar jantar; 

	public filosofo(int chave, Jantar j) {
		this.filosofo = chave;		
		this.jantar = j;
	}

	public int getChave() { 
		return filosofo;
	}

	public void setStatus(int i) {
		switch (i) {
		case 0:
			jantar.SetInfo(filosofo, 0);
			break;
		case 1:
			jantar.SetInfo(filosofo, 1);
			break;
		case 2:
			jantar.SetInfo(filosofo, 2);
			break;
		}
	}

	private void pensando() { 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	private void comendo() { 
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
		}
	}

        @Override
	public void run() {
		while (true) {
			setStatus(0);
			pensando(); 
			jantar.fork.pegar(this);
			comendo(); 
			jantar.fork.liberar(this); 
		}

	}
}
