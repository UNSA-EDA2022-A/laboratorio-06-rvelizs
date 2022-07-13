package com.example.project;

public class Exercise2 {

    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();

        BST<Integer> tree1 = new BST<Integer>();
        BST<Integer> tree2 = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree1.insert(value);
            tree2.insert(value);
        }

        System.out.print(obj.bstIguales(tree1, tree2));
        
    }


    public <T extends Comparable<T>> boolean bstIguales(BST<T> a1, BST<T> a2){
        return esIgual(a1.root, a2.root);
    }
    
    protected <T extends Comparable<T>> boolean esIgual(Node<T> rootA1, Node<T> rootA2) {
		// SI AMBOS ESÁN VACÍOS
		if (rootA1 == null && rootA2 == null)
			return true; // SON IGUALES

		// SI UNO ESTA VACÍO Y EL OTRO NO
		else if (rootA1 != null && rootA2 == null)
			return false; // NO SON IGUALES
		else if (rootA1 == null && rootA2 != null)
			return false; // NO SON IGUALES

		else {
			// SI AMBOS ÁRBOLES SON IGUALES EN .data Y EN SUBÁRBOLES IZQUIERDO Y DERECHO
			if (rootA1.data == rootA2.data && esIgual(rootA1.left, rootA2.left) && esIgual(rootA1.right, rootA2.right))
				return true; // SON IGUALES
			else
				return false; // NO SON IGUALES
		}
	}
}
