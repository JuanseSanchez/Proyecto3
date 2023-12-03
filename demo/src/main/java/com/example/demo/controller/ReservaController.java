package com.example.demo.controller;

import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
