package es.unican.is2.ListaOrdenadaAcotada;

public interface IListaAcotada<E> {
	

	/**
	 * Lectura posicional: Retorna el elemento que ocupa la
	 * posici?n indicada
	 * @param indice
	 * @return Elemento que ocupa la posici?n indice
	 * @throws IndexOutOfBoundsException si el indice es incorrecto
	 */
    public E get(int indice);
    
    /**
     * A?ade un elemento en la posici?n que le corresponde
     * @param elemento a a?adir
     * @throws Lanza IllegalStateException si el elemento no cabe
     */
    public void add(E elemento);
    
    /**
     * Elimina el elemento que ocupa la posici?n indicada
     * @param indice Posici?n del elemento a eliminar
     * @return Elemento que ocupaba la posici?n indicada
     * Lanza IndexOutOfBoundsException si el indice es incorrecto
     */
    public E remove(int indice);
    
    /**
     * Retorna el tama?o de la lista
     * @return Tama?o de la lista
     */
    public int size();
    
    /**
     * Hace nula la lista
     */
     public void clear();
     
}
