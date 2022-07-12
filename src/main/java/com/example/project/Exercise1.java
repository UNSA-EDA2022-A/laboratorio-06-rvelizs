package com.example.project;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();

        BST<Integer> tree1 = new BST<Integer>();
        BST<Integer> tree2 = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree1.insert(value);
            tree2.insert(value);
        }

        System.out.print(obj.bstSimilares(tree1, tree2));
        
    }

    public <T extends Comparable<T>> boolean bstSimilares(BST<T> a1, BST<T> a2){
        // CÁLCULO DE ALTURAS
		int leftAltura = altura(a1.root);
		int rightAltura = altura(a1.root);

		// LO QUE SE RETORNA
		boolean retorno = true;

		// SI NO TIENEN MISMA ALTURA
		if (leftAltura != rightAltura)
			retorno = false;

		// ARREGLOS DEL TAMAÑO DE LA ALTURA DE CADA SUBARBOL
		int[] sumaAlturasLeft = new int[leftAltura];
		int[] sumaAlturasRight = new int[leftAltura];

		// PROCESO POR LA IZQUIERDA Y DERECHA
		contador(a1.root, leftAltura, sumaAlturasLeft);
		contador(a2.root, rightAltura, sumaAlturasRight);

		// SI AMBOS ARREGLOS SON IGUALES
		for (int i = 0; i < sumaAlturasLeft.length; i++) {
			if (sumaAlturasLeft[i] != sumaAlturasRight[i])
				retorno = false;
		}

		return retorno;
    }
    
    protected <T extends Comparable<T>> int altura(Node<T> a) {
		if (a == null)
			return 0;
		else
			// ALTURA POR UNO (NO SE CUENTA UN NODO)
			return 1 + Math.max(altura(a.left), altura(a.right));
	}
    
    protected <T extends Comparable<T>> void contador(Node<T> t, int altura, int[] tabla) {
		if (t == null || altura == 0)
			return;

		// INCREMENTA SI EXISTE NODO IZQUIERDO O DERECHO
		tabla[altura - 1]++;

		// RECURSIVO POR LA IZQUIERDA Y DERECHA
		contador(t.left, altura - 1, tabla);
		contador(t.right, altura - 1, tabla);
	}
}
