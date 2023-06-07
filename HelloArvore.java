package arvore;

public class HelloArvore {

	public static void main(String[] args) {
		
		ArvoreBinario arvoreBinario = new ArvoreBinario();
		
		arvoreBinario.adicionar2(String.valueOf(1));
		arvoreBinario.adicionar2(String.valueOf(2));
		arvoreBinario.adicionar2(String.valueOf(3));
		arvoreBinario.removeNo("2");
		
		for (int i = 4; i <=12; i++) {
			arvoreBinario.adicionar2(String.valueOf(i));
		}
	    arvoreBinario.imprimir(System.out);
	}
}
