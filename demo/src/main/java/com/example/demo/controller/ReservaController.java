package com.example.demo.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.Consumo;
import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Reserva;
import com.example.demo.repositorio.ReservaRepository;


@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservasRepository;

    @GetMapping("/reservas")
    public String obtenerTodasLasReservas(Model model) {
        model.addAttribute("reservas", reservasRepository.findAllReservas());
        return "reservas";
    }

    @GetMapping("/habitaciones")
    public String obtenerHabitaciones(Model model) {
        model.addAttribute("habitaciones", reservasRepository.getUniqueHabitaciones());
        return "habitaciones";
    }

    @GetMapping("/tiposhabitaciones")
    public String obtenerTiposHabitaciones(Model model) {
        model.addAttribute("tiposhabitaciones", reservasRepository.getUniqueTipos());
        return "tiposhabitaciones";
    }

    @GetMapping("/servicios")
    public String obtenerServicios(Model model) {
        model.addAttribute("servicios", reservasRepository.getUniqueServicios());
        return "servicios";
    }

    @GetMapping("/consumos")
    public String obtenerConsumos(Model model) {
        model.addAttribute("clientes", reservasRepository.getUniqueConsumos());
        return "consumos";
    }

    @GetMapping("/RFC7")
    public String obtenerClientesRequerimiento7(Model model) {
        model.addAttribute("RFC7", reservasRepository.getReq7());
        return "RFC7";
    } 

    @GetMapping("/RFC3")
    public String RFC3(Model model, int id, Date fechaInicio, Date fechaFin) {
        model.addAttribute("RFC3", reservasRepository.getReq3(id, fechaInicio, fechaFin));
        return "RFC3";
    } 

    @GetMapping("/RFC2")
    public String obtenerPorcentajeOcupacion(Model model) {
        model.addAttribute("RFC2", reservasRepository.getReq2());
        return "RFC2";
    }

    @GetMapping("/RFC1")
    public String obtenerConsumoTotal(Model model) {
        model.addAttribute("RFC1", reservasRepository.getReq1());
        return "RFC1";
    }

    @GetMapping("/salidas")
    public String obtenerSalida(Model model) {
        model.addAttribute("salidas", reservasRepository.getSalidas());
        return "salidas";
    }

    @GetMapping("/entradas")
    public String obtenerEntrada(Model model) {
        model.addAttribute("entradas", reservasRepository.getEntradas());
        return "entradas";
    }

    @GetMapping("/crearConsumo")
    public String crearConsumo(Model model) {
        model.addAttribute("consumoNuevo",new Consumo());
        return "consumoForm";
    }

    @PostMapping("/crearBebidaNueva")
    public String crearConsumoNuevo(@ModelAttribute("consumoNuevo") Consumo consumo) {
        Consumo nuevo = new Consumo(
            consumo.getNombre(), consumo.getFecha(), consumo.getPrecio(), consumo.getServicio());
        /*reservasRepository.save(nuevo);*/
        return "redirect:/consumos";
    }

    @GetMapping("/crearReserva")
    public String crearReserva(Model model) {
        model.addAttribute("reservaNueva", new Reserva());
        return "reservaForm";
    }

    @PostMapping("/crearReservaNueva")
    public String crearReservaNueva(@ModelAttribute("reservaNueva") Reserva reserva) {
        Reserva nueva = new Reserva(
            reserva.getInicio(), reserva.getFin(), new Habitacion());
        reservasRepository.save(nueva);
        return "redirect:/reservas";
    }

    @PostMapping("/deleteReserva")
    public String eliminarReserva(@RequestParam(name = "id", required = false) String id){
        reservasRepository.deleteById(id);
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/delete")
    public String reservasEliminar(@PathVariable("id") String id) {

        reservasRepository.deleteById(id);
        return "redirect:/reservas";
    }
/* 
    @GetMapping("/reservas/{id}/edit")
    public String reservasEditar(@PathVariable("id") String id, Model model) {
        reservasRepository.deleteById(id);
        model.addAttribute("habitaciones", habitacionRepository.findAllHabitaciones());
        return "reservasNuevo";
    }
*/
}
