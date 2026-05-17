import java.util.Scanner;

// Clase que representa un elemento del árbol
class Nodo {
    int valor;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}

// Clase principal del Árbol Binario de Búsqueda
public class BST {
    private Nodo raiz;

    public BST() {
        this.raiz = null;
    }

    // MÉTODO: INSERCIÓN
    public void insert(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        }
        return actual;
    }

    // MÉTODO: BÚSQUEDA
    public boolean search(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo actual, int valor) {
        if (actual == null) return false;
        if (valor == actual.valor) return true;
        
        return valor < actual.valor 
            ? buscarRecursivo(actual.izquierdo, valor) 
            : buscarRecursivo(actual.derecho, valor);
    }

    // MÉTODO: ELIMINACIÓN
    public void delete(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo actual, int valor) {
        if (actual == null) return null;

        if (valor < actual.valor) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = eliminarRecursivo(actual.derecho, valor);
        } else {
            // Nodo sin hijos o con un solo hijo
            if (actual.izquierdo == null) return actual.derecho;
            if (actual.derecho == null) return actual.izquierdo;

            // Nodo con dos hijos
            actual.valor = encontrarMinimo(actual.derecho);
            actual.derecho = eliminarRecursivo(actual.derecho, actual.valor);
        }
        return actual;
    }

    private int encontrarMinimo(Nodo actual) {
        int minv = actual.valor;
        while (actual.izquierdo != null) {
            minv = actual.izquierdo.valor;
            actual = actual.izquierdo;
        }
        return minv;
    }

    // MÉTODOS: Recorridos (In-Order, Pre-Order, Post-Order)
    public void recorridoInOrder() {
        inOrder(raiz);
        System.out.println();
    }
    private void inOrder(Nodo nodo) {
        if (nodo != null) {
            inOrder(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrder(nodo.derecho);
        }
    }

    public void recorridoPreOrder() {
        preOrder(raiz);
        System.out.println();
    }
    private void preOrder(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrder(nodo.izquierdo);
            preOrder(nodo.derecho);
        }
    }

    public void recorridoPostOrder() {
        postOrder(raiz);
        System.out.println();
    }
    private void postOrder(Nodo nodo) {
        if (nodo != null) {
            postOrder(nodo.izquierdo);
            postOrder(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    // MÉTODO MAIN: Menú Interactivo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST arbol = new BST();
        int opcion = 0;

        System.out.println("=========================================");
        System.out.println("  ÁRBOL BINARIO DE BÚSQUEDA (BST)        ");
        System.out.println("=========================================");

        while (opcion != 7) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Insertar valor");
            System.out.println("2. Buscar valor");
            System.out.println("3. Eliminar valor");
            System.out.println("4. Imprimir In-Order");
            System.out.println("5. Imprimir Pre-Order");
            System.out.println("6. Imprimir Post-Order");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa el valor numérico a insertar: ");
                        int valInsert = Integer.parseInt(scanner.nextLine());
                        arbol.insert(valInsert);
                        System.out.println("==> Valor " + valInsert + " insertado.");
                        break;
                    case 2:
                        System.out.print("Ingresa el valor a buscar: ");
                        int valSearch = Integer.parseInt(scanner.nextLine());
                        boolean encontrado = arbol.search(valSearch);
                        if(encontrado) {
                            System.out.println("==> El valor " + valSearch + " SÍ existe en el árbol.");
                        } else {
                            System.out.println("==> El valor " + valSearch + " NO existe en el árbol.");
                        }
                        break;
                    case 3:
                        System.out.print("Ingresa el valor a eliminar: ");
                        int valDelete = Integer.parseInt(scanner.nextLine());
                        
                        // Aquí se valida si el valor existe o esta guardado antes de eliminarlo
                        if (arbol.search(valDelete)) {
                            arbol.delete(valDelete);
                            System.out.println("[ÉXITO] Se eliminó el valor " + valDelete + " correctamente.");
                        } else {
                            System.out.println("[ERROR] El valor " + valDelete + " no existe en el árbol. No se puede eliminar.");
                        }
                        break;
                    case 4:
                        System.out.print("Recorrido In-Order: ");
                        arbol.recorridoInOrder();
                        break;
                    case 5:
                        System.out.print("Recorrido Pre-Order: ");
                        arbol.recorridoPreOrder();
                        break;
                    case 6:
                        System.out.print("Recorrido Post-Order: ");
                        arbol.recorridoPostOrder();
                        break;
                    case 7:
                        System.out.println("Saliendo del programa... ¡Éxitos en tu proyecto!");
                        break;
                    default:
                        System.out.println("[ERROR] Opción no válida. Intenta de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Por favor ingresa un número válido.");
            }
        }
        scanner.close();
    }
}