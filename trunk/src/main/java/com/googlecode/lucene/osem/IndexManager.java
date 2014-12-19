package com.googlecode.lucene.osem;

import java.util.List;

interface IndexManager {

    /**
     * Get current index name
     * 
     * @return indexName current index name
     */
    String getIndexName();

    /**
     * Index an object
     * 
     * @param object
     *            object to index
     */
    void index(Object... objects);

    /**
     * Remove an object
     * 
     * @param object
     *            object to delete
     */
    void remove(Object... objects);

    /**
     * Check index exist or not
     * 
     * @return index exist or not
     */
    boolean indexExist();

    /**
     * Delete the index if exist
     */
    void deleteIndex();

    /**
     * TODO: ¿es necesario este método o va fuera?
     */
    void optimize();

    /**
     * Get an object by id
     * 
     * @param clazz
     *            class of the object
     * @param id
     *            id of the object
     * @return object from index
     */
    <T> T getById(Class<T> clazz, String id);

    /**
     * Get objects by id list
     * 
     * @param clazz
     *            class of the objects
     * @param ids
     *            id list of the ojects
     * @return list of objects from index
     */
    <T> List<T> getByIds(Class<T> clazz, List<String> ids);

    /**
     * Count the number of objects in ElasticSearch for given class
     * 
     * @param clazz
     *            class to count
     * @param queryBuilder
     *            optional count query
     * @return number of objects
     */
    // Long count(Class clazz, @Nullable QueryBuilder queryBuilder);
    <T> Long count(Class<T> clazz);

    /**
     * Perform search in ElasticSearch and convert search result to original object
     * 
     * @param clazz
     *            class to search
     * @param queryBuilder
     *            optional query builder
     * @return list of object from search result
     */
    // <T> List<T> search(Class<T> clazz, @Nullable QueryBuilder queryBuilder);
    <T> List<T> search(Class<T> clazz);
}
