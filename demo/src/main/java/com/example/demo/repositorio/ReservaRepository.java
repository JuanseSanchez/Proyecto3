package com.example.demo.repositorio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.RFC1;
import com.example.demo.modelo.RFC2;
import com.example.demo.modelo.RFC3;
import com.example.demo.modelo.RFC7;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.EntradaSalida;
import com.example.demo.modelo.Servicio;
import com.example.demo.modelo.TipoHabitacion;

import java.sql.Date;
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
        "{ $match: { \"habitacion.tipo.nombre\": { $ne: null } } }",
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
        "{ $unwind: \"$habitacion.clientes.consumos\" }",
        "{$group: {_id: \"$habitacion.clientes.id\",nombre: {$first: \"$habitacion.clientes.nombre\"},consumos: {$push: \"$habitacion.clientes.consumos\"}}}"})
    List<Cliente> getUniqueConsumos();

    @Aggregation(pipeline = {"{ $unwind: \"$habitacion.clientes\" }", "{ $unwind: \"$habitacion.clientes.consumos\" }",
        "{ $match: { $expr: { $and: [ { $gte: [ { $toDate: \"$habitacion.clientes.consumos.fecha\" }, { $subtract: [new Date(), {$multiply:[365, 24, 60, 60, 1000]}] } ] }, { $lte: [ { $toDate: \"$habitacion.clientes.consumos.fecha\" }, new Date() ] } ] } } }",
        "{ $group: { _id: { hotel: \"$habitacion.hotel\", habitacion: \"$habitacion.numero\" }, totalConsumption: { $sum: \"$habitacion.clientes.consumos.precio\" } } }",
        "{ $project: { _id: 0, hotel: \"$_id.hotel\", numero: \"$_id.habitacion\", totalConsumption: 1 } }"})
    List<RFC1> getReq1();

    @Aggregation(pipeline = {
        "{ $unwind: { path: \"$habitacion.clientes\", includeArrayIndex: \"string\", preserveNullAndEmptyArrays: true } }",
        "{ $group: { _id: \"$habitacion.clientes.id\", _nombre: { $first: \"$habitacion.clientes.nombre\" }, _fechas: { $push: \"$habitacion.clientes.entrada\" }, _salidas: { $push: \"$habitacion.clientes.salida\" } } }",
        "{ $project: { _nombre: \"$_nombre\", buencliente: [ { $anyElementTrue: { $map: { input: \"$_fechas\", in: { $cond: { if: { $and: [ { $gte: [\"$$this\", \"2023-01-01T00:00:00Z\"] }, { $lt: [\"$$this\", \"2023-04-01T00:00:00Z\"] } ] }, then: 1, else: 0 } } } } }, { $anyElementTrue: { $map: { input: \"$_fechas\", in: { $cond: { if: { $and: [ { $gte: [\"$$this\", \"2023-04-01T00:00:00Z\"] }, { $lt: [\"$$this\", \"2023-07-01T00:00:00Z\"] } ] }, then: 1, else: 0 } } } } }, { $anyElementTrue: { $map: { input: \"$_fechas\", in: { $cond: { if: { $and: [ { $gte: [\"$$this\", \"2023-07-01T00:00:00Z\"] }, { $lt: [\"$$this\", \"2023-10-01T00:00:00Z\"] } ] }, then: 1, else: 0 } } } } }, { $anyElementTrue: { $map: { input: \"$_fechas\", in: { $cond: { if: { $and: [ { $gte: [\"$$this\", \"2023-10-01T00:00:00Z\"] }, { $lte: [\"$$this\", \"2023-12-31T00:00:00Z\"] } ] }, then: 1, else: 0 } } } } } ] } }",
        "{ $project: { _nombre: 1, allTrue: { $gte: [ { $size: { $filter: { input: \"$buencliente\", as: \"bool\", cond: { $eq: [\"$$bool\", true] } } } }, 4 ] } } }",
        "{ $match: { allTrue: true } }",
        "{ $project: { _id: 1, nombre: \"$_nombre\" } }"})
    List<RFC7> getReq7();

    @Aggregation(pipeline = {"{ $match: { $expr: { $and: [ { $gte: [ { $toDate: \"$inicio\" }, { $subtract: [new Date(), {$multiply:[365, 24, 60, 60, 1000]}] } ] }, { $lte: [ { $toDate: \"$fin\" }, new Date() ] } ] } } }",
        "{ $group: { _id: { hotel: \"$habitacion.hotel\", numero: \"$habitacion.numero\" }, totalDays: { $sum: { $dateDiff: { startDate: { $toDate: \"$inicio\" }, endDate: { $toDate: \"$fin\" }, unit: \"day\" } } } } }",
        "{ $project: { _id: 0, hotel: \"$_id.hotel\", numero: \"$_id.numero\", porcentajeOcupacion: { $round: [ { $multiply: [ { $divide: [\"$totalDays\", 365] }, 100 ] }, 2 ] } } }"})
    List<RFC2> getReq2();


    @Aggregation(pipeline = {
        "{ $unwind: \"$habitacion.clientes\" }",
        "{ $group: { _id: \"$habitacion.clientes.salida\", clientes: { $push: { _id: \"$habitacion.clientes.id\", nombre: \"$habitacion.clientes.nombre\" } } } }",
        "{ $project: { fecha: \"$_id\", clientes: 1, _id: 0 } }",
        "{ $sort: { \"fecha\": 1 } }"})
    List<EntradaSalida> getSalidas();

    @Aggregation(pipeline = {
        "{ $unwind: \"$habitacion.clientes\" }",
        "{ $group: { _id: \"$habitacion.clientes.entrada\", clientes: { $push: { _id: \"$habitacion.clientes.id\", nombre: \"$habitacion.clientes.nombre\" } } } }",
        "{ $project: { fecha: \"$_id\", clientes: 1, _id: 0 } }",
        "{ $sort: { \"fecha\": 1 } }"})
    List<EntradaSalida> getEntradas();

    @Aggregation(pipeline = {
        "{ $unwind: \"$habitacion.clientes\" }",
        "{ $match: { \"habitacion.clientes.id\": ?0 } }",
        "{ $unwind: \"$habitacion.clientes.consumos\" }",
        "{ $match: { \"habitacion.clientes.consumos.fecha\": { $gte: ?1, $lt: ?2 } } }",
        "{ $group: { _id: \"$habitacion.clientes.id\", nombreC: { $first: \"$habitacion.clientes.nombre\" }, totalConsumos: { $sum: \"$habitacion.clientes.consumos.precio\" } } }",
        "{ $project: { _id: 0, clienteId: \"$_id\", clienteNombre: \"$nombreC\", totalConsumos: 1} }"
    })
    List<RFC3> getReq3(int id, String fechaI, String fechaF);
    
}