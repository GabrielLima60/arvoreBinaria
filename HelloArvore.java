package arvore;

public class HelloArvore {

	public static void main(String[] args) {
		
	ArvoreBinario arvoreBinario = new ArvoreBinario();

	for (int i = 1; i <=30; i++) {
		arvoreBinario.adicionar2(String.valueOf(i));
	}
	
	//arvoreBinario.removeNo("10");

    arvoreBinario.imprimir(System.out);

	}

}