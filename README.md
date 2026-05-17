# Árbol Binario de Búsqueda (BST)

## Descripción del Proyecto

Este proyecto implementa un **Árbol Binario de Búsqueda (BST)** en Java, una estructura de datos fundamental que permite organizar y gestionar datos de forma eficiente. 

### Características Principales

- **Inserción**: Agrega valores al árbol manteniendo la propiedad de búsqueda (valores menores a la izquierda, mayores a la derecha)
- **Búsqueda**: Localiza un valor específico en el árbol
- **Eliminación**: Remueve nodos del árbol, incluyendo casos complejos como nodos con dos hijos
- **Recorridos**: Implementa tres tipos de recorrido:
  - **In-Order**: Devuelve los valores en orden ascendente
  - **Pre-Order**: Procesa el nodo antes que sus hijos
  - **Post-Order**: Procesa el nodo después de sus hijos
- **Interfaz Interactiva**: Menú de línea de comandos para realizar todas las operaciones

## Requisitos

- **JDK 21** o superior
- Java instalado y configurado en la variable de entorno `PATH`

## Compilación

Para compilar el proyecto, utiliza el siguiente comando:

```bash
javac BST.java
```

Este comando genera el archivo compilado `BST.class` que contiene el bytecode ejecutable.

## Ejecución

Para ejecutar el programa, utiliza:

```bash
java BST
```

Al iniciar, verás un menú interactivo con las siguientes opciones:

1. **Insertar valor** - Añade un número al árbol
2. **Buscar valor** - Busca si existe un número en el árbol
3. **Eliminar valor** - Elimina un número del árbol (solo si existe)
4. **Imprimir In-Order** - Muestra los valores en orden ascendente
5. **Imprimir Pre-Order** - Muestra los valores en orden de recorrido previo
6. **Imprimir Post-Order** - Muestra los valores en orden de recorrido posterior
7. **Salir** - Cierra el programa

## Ejemplo de Uso

```
=========================================
  ÁRBOL BINARIO DE BÚSQUEDA (BST)        
=========================================

--- MENÚ PRINCIPAL ---
1. Insertar valor
2. Buscar valor
3. Eliminar valor
4. Imprimir In-Order
5. Imprimir Pre-Order
6. Imprimir Post-Order
7. Salir
Selecciona una opción: 1
Ingresa el valor numérico a insertar: 50
==> Valor 50 insertado.
```

## Estructura del Código

- **Clase `Nodo`**: Representa cada nodo del árbol con un valor y referencias a sus hijos (izquierdo y derecho)
- **Clase `BST`**: Implementa la lógica del árbol binario con métodos recursivos para todas las operaciones
- **Método `main`**: Proporciona la interfaz interactiva del programa

## Notas Técnicas

- El programa utiliza recursión para las operaciones principales
- Manejo de excepciones para entradas inválidas
- Validación de nodos existentes antes de eliminar
- Compatible con JDK 21 y versiones posteriores
