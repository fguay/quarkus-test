package fr.guic;

import fr.guic.model.Person;
import fr.guic.model.PersonStatus;
import io.quarkus.panache.common.Page;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Path("/person")
public class PersonResource {
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Transactional
    public void create(Person p){
        Person.persist(p);
    }

    @GET
    @Produces("application/json")
    public List<Person> get(@QueryParam("start") Integer start, @QueryParam("max") Integer max){
        return Person.findAll()
                .page(start, max)
                .nextPage()
                .list();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Person get(@PathParam("id") Long id){
        return Person.findById(id);
    }

    @GET
    @Path("/init")
    @Produces("application/json")
    @Transactional
    public void init(){
        Person p = new Person("toto", LocalDate.now(), PersonStatus.Alive);
        p.persist();
    }

}
