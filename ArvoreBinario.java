package arvore;

import static java.lang.Math.random;
import java.io.PrintStream;
import java.security.KeyPair;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.NoSuchElementException;

public class ArvoreBinario {
	private NoBinario root;

	public ArvoreBinario() {
		super();
		this.root = new NoBinario("raiz");
	}

	public ArvoreBinario(NoBinario root) {
		super();
		if (root == null) {
			this.root = new NoBinario("raiz");
		} else {
			this.root = root;
		}
	} 

	
  //imprimir a lista
  public void traversePreOrder(StringBuilder sb, String padding, String pointer, NoBinario No) {
    if (No != null) {
    	sb.append(padding);
    	sb.append(pointer);	
        sb.append(No.getDescricao());
        sb.append("\n");
        
        StringBuilder paddingBuilder = new StringBuilder(padding);
        paddingBuilder.append("│  ");

        String paddingForBoth = paddingBuilder.toString();
        String pointerForRight = "└──";
        String pointerForLeft = (No.getDireita() != null) ? "├──" : "└──";
        
        traversePreOrder(sb, paddingForBoth, pointerForLeft, No.getEsquerda());
        traversePreOrder(sb, paddingForBoth, pointerForRight, No.getDireita());
    }
  }  
  
  public void imprimir(PrintStream os) {
    StringBuilder sb = new StringBuilder();
    traversePreOrder(sb,"","", this.root);
    os.print(sb.toString());
  }
  
  //adicionar No binario em locar aleatório
  
	public void adicionar0(String Add) {
  		adicionar0(Add, this.root);
  	}
 
	private void adicionar0(String Add, NoBinario noPai) {
    if (random() < 0.5) {
      if (noPai.getEsquerda() == null){
        addNo(Add, "esquerda", noPai);
      }
      else {
        adicionar0(Add, noPai.getEsquerda());
      }
    }
    else {
      if (noPai.getDireita() == null){
        addNo(Add, "direita", noPai);
      }
      else {
        adicionar0(Add, noPai.getDireita());
      }
    }
  }  
  	
  	public void adicionar1(String Add) {
  		adicionar1(Add, this.root);
  	}
  	
  	private void adicionar1(String Add, NoBinario noPai) {
  	      if (noPai.getEsquerda() == null){
  	        addNo(Add, "esquerda", noPai);
  	      }
  	      else {
  	        adicionar1(Add, noPai.getEsquerda());
  	      }
  	    
  	      if (noPai.getDireita() == null){
  	        addNo(Add, "direita", noPai);
  	      }
  	      else {
  	        adicionar1(Add, noPai.getDireita());
  	      }
  	    
  	}
  	
  	private int profundidade(NoBinario noPai) {
  		if (noPai.getEsquerda() == null || noPai.getDireita() == null) {
  			return 1;
  		}
  		else {	

  			return 1 + profundidade(noPai.getDireita());
  			
  		}
  	}

  	public void adicionar2(String Add) {
  		adicionar2(Add, this.root);
  	}
  	
  	private void adicionar2(String Add, NoBinario noPai){
  		
  		if (noPai.getEsquerda() == null) 
  			addNo(Add, "esquerda", noPai);

  		else if (noPai.getDireita() == null)
  			addNo(Add, "direita", noPai);		
  		
  		else if (profundidade(noPai.getEsquerda()) <= profundidade(noPai.getDireita())) 
  			adicionar2(Add,noPai.getEsquerda());	
  		
  		else 
  			adicionar2(Add, noPai.getDireita());
  	}

  	
	public void addNo(String Add, String posicao, NoBinario noPai) {
		NoBinario noToAdd = new NoBinario(Add);
		if (noPai == null) {
			addFilho(noToAdd, posicao, root);
		} else {
			addFilho(noToAdd, posicao, noPai);
		}
	} 

	private void addFilho(NoBinario noToAdd, String posicao, NoBinario pai) {
		if (posicao.equals("direita")) {
			pai.setDireita(noToAdd);
		} else {
			pai.setEsquerda(noToAdd);
		}
	}
	
	//remover No binario
	
	public void removeNo(String remove) {
		removeNo(remove, this.root);
	}
	
	private void removeNo(String remove, NoBinario noPai) {
	
		if (noPai.getEsquerda() == null) {}
		
		else {
			if (noPai.getEsquerda().getDescricao().equals(remove)){
	  	        noPai.setEsquerda(null);
	  	      }
	  	      else {
	  	        removeNo(remove, noPai.getEsquerda());
	  	      }
		}	
	  	    
		if (noPai.getDireita() == null) {}	
		
		else {
	  	    if (noPai.getDireita().getDescricao().equals(remove)){
	  	    	noPai.setDireita(null);
	  	      }
	  	      else {
	  	        removeNo(remove, noPai.getDireita());
	  	      } 
		}
	}
}




