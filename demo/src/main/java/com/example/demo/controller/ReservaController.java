package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

<<<<<<< HEAD
    @GetMapping("/consumos")
    public String obtenerConsumos(Model model) {
        model.addAttribute("clientes", reservasRepository.getUniqueConsumos());
        return "consumos";
    }

    @GetMapping("/clientes/requerimiento7")
    public String obtenerClientesRequerimiento7(Model model) {
        model.addAttribute("clientes", reservasRepository.getReq7());
        return "clientes";
    } 

    @GetMapping("/habitaciones/requerimiento2")
    public String obtenerPorcentajeOcupacion(Model model) {
        model.addAttribute("habitaciones", reservasRepository.getReq2());
        return "habitaciones";
    }

    @GetMapping("/habitaciones/requerimiento2")
    public String obtenerConsumoTotal(Model model) {
        model.addAttribute("habitaciones", reservasRepository.getReq1());
        return "habitaciones";
    }

=======
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
>>>>>>> f69e3cea4a73a230b7124e586c58fda8c8f08552

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
