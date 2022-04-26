package de.kreth.clubhelper.model.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClubController<T> {

    /*
     * ************* REST Methoden ************
     */

    /**
     * Rest: PUT - Change object (update)
     * <p>
     * Mapping: /{id}
     *
     * @param id       Id of updated object
     * @param toUpdate Object with updated data.
     * @return updated object
     */
    void put(@PathVariable("id") long id, @RequestBody T toUpdate);

    /**
     * Rest: POST - Create Object without Id.
     *
     * @param toCreate object with data to insert.
     * @return created and corrected object
     */
    T post(@RequestBody T toCreate);

    /**
     * Rest: POST - Create Object with or without Id.
     *
     * @param id       -1 for new Id
     * @param toCreate Object to create.
     * @return created object with updated id and dates.
     */
    T post(@PathVariable("id") Long id, @RequestBody T toCreate);

    /**
     * Rest: GET - return object
     * <p>
     * Mapping: /{id}
     *
     * @param id id to find object for.
     * @return Object for matching id
     */
    T getById(@PathVariable("id") long id);

    /**
     * Rest: GET - return List of all objects
     * <p>
     * Mapping: /
     *
     * @return List of all Objects - sorted if configured.
     */
    List<T> getAll();

    /**
     * Rest: DELETE - deletes object with the Id.
     * <p>
     * Mapping: /{id}
     *
     * @param id Id of the object to delete.
     * @return deleted object.
     */
    ResponseEntity<T> delete(@PathVariable("id") long id);

    /**
     *
     * @param changed date of last change included
     * @return list of objects changed since changed date.
     */
    List<T> getChangedSince(long changed);

}