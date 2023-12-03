package com.example.demo.repositorio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Salida;
import com.example.demo.modelo.Servicio;
import com.example.demo.modelo.TipoHabitacion;

import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, ObjectId> {

    @Query("{}")
    List<Reserva> findAllReservas();

    //Delete
    @Query(value = "{_id : ?0}", delete =  true)
    void deleteById(String id);

    //Update
    @Query(value = "{_id : ?0}")
    Reserva updateReserva(String id, Reserva reserva);

    @Aggregation(pipeline = {
        "{ $group: { _id: \"$habitacion.tipo.nombre\", tipo: { $first: \"$habitacion.tipo\" } } }",
        "{ $replaceWith: \"$tipo\" }"})
    List<TipoHabitacion> getUniqueTipos();

    @Aggregation(pipeline = {
        "{ $group: { _id: \"$habitacion.numero\", habitacion: { $first: \"$habitacion\" } } }",
        "{ $replaceWith: \"$habitacion\" }",
        "{ $sort: { \"numero\": 1 } }"})
    List<Habitacion> getUniqueHabitaciones();

    @Aggregation(pipeline = {
        "{ $unwind: \"$habitacion.clientes\" }",
        "{ $unwind: \"$habitacion.clientes.consumos\" }",
        "{$group: {_id: \"$habitacion.clientes.consumos.nombre\",precio: {$first: \"$habitacion.clientes.consumos.precio\"}}}",
        "{$project: {_id: 0,nombre: \"$_id\",precio: 1}}",
        "{ $sort: { \"nombre\": 1 } }"})
    List<Servicio> getUniqueServicios();

    @Aggregation(pipeline = {
        "{ $unwind: \"$habitacion.clientes\" }",
        "{ $group: { _id: \"$habitacion.clientes.salida\", clientes: { $push: { _id: \"$habitacion.clientes.id\", nombre: \"$habitacion.clientes.nombre\" } } } }",
        "{ $project: { fecha: \"$_id\", clientes: 1, _id: 0 } }"})
    List<Salida> getSalidas();
}