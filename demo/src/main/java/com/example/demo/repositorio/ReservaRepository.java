package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.modelo.Reserva;

import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, Integer> {

    //Create
    Reserva save(Reserva reserva);

    //Read
    @Query("{_id : ?0}")
    Reserva findById(int id);

    @Query("{}")
    List<Reserva> findAllReservas();

    //Delete
    @Query(value = "{_id : ?0}", delete =  true)
    void deleteById(String id);

    //Update
    @Query(value = "{_id : ?0}")
    Reserva updateReserva(String id, Reserva reserva);
    
}
