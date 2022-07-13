package com.example.project;

public class Exercise3 {

    public static void main(String[] args) {
        Exercise3 obj = new Exercise3();

        BST<Integer> tree = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree.insert(value);
        }

        System.out.print(obj.bstEstrictamenteBinario(tree));
        
    }
    
    // PÚBLICO
    public <T extends Comparable<T>> boolean bstEstrictamenteBinario(BST<T> a){
        return bstEstrictamenteBinario(a.root);
    }
    
    protected <T extends Comparable<T>> boolean bstEstrictamenteBinario(Node<T> node) {
		// SI EL ARBOL ESTÁ VACÍO
		if (node == null)
			return true;

		// SI ES NODO HOJA
		else if (node.left == null && node.right == null)
			return true;
        
		// SI NINGUNO LADO ES NULO ES ESTRICTAMENTE BST
		else if (node.left != null && node.right != null) {
			System.out.println("ASdsa");
			return bstEstrictamenteBinario(node.left) && bstEstrictamenteBinario(node.right);
		}

		// EN CASO DE QUE UN LADO TENGA NULL Y EL OTRO NO
		return false;
	}
}
