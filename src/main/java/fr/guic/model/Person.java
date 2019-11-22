package fr.guic.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;



@Entity
public class Person extends PanacheEntity {
    public String name;
    public LocalDate birth;
    public PersonStatus status;

    public Person(){
    }

    public Person(String name, LocalDate date, PersonStatus status){
        this.name = name;
        this.birth = date;
        this.status = status;
    }

    public static Person findByName(String name){
        return find("name", name).firstResult();
    }

    public static List<Person> findAlive(){
        return list("status", PersonStatus.Alive);
    }

    public static void deleteStefs(){
        delete("name", "Stef");
    }
}