package es.unican.is2.ListaOrdenadaAcotada;

public interface IListaAcotada<E> {
	

	/**
	 * Lectura posicional: Retorna el elemento que ocupa la
	 * posición indicada
	 * @param indice
	 * @return Elemento que ocupa la posición indice
	 * @throws IndexOutOfBoundsException si el indice es incorrecto
	 */
    public E get(int indice);
    
    /**
     * Añade un elemento en la posición que le corresponde
     * @param elemento a añadir
     * @throws Lanza IllegalStateException si el elemento no cabe
     */
    public void add(E elemento);
    
    /**
     * Elimina el elemento que ocupa la posición indicada
     * @param indice Posición del elemento a eliminar
     * @return Elemento que ocupaba la posición indicada
     * Lanza IndexOutOfBoundsException si el indice es incorrecto
     */
    public E remove(int indice);
    
    /**
     * Retorna el tamaño de la lista
     * @return Tamaño de la lista
     */
    public int size();
    
    /**
     * Hace nula la lista
     */
     public void clear();
     
}
