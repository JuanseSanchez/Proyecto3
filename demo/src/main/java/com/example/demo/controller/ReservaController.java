package com.example.demo.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/RFC3_menu")
    public String RFC3(Model model,
                    @RequestParam(name = "id") int id,
                    @RequestParam(name = "fechaI") String fechaI,
                    @RequestParam(name = "fechaF") String fechaF) {

        // Convert String dates to Date objects in ISO 8601 format (YYYY-MM-DD)
        SimpleDateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedFechaI = null;
        Date parsedFechaF = null;
        try {
            parsedFechaI = (Date) isoDateFormat.parse(fechaI);
            parsedFechaF = (Date) isoDateFormat.parse(fechaF);
        } catch (ParseException e) {
            // Handle parsing exception if needed
            e.printStackTrace();
        }

        model.addAttribute("RFC3_menu", reservasRepository.getReq3(id, parsedFechaI, parsedFechaF));
        return "RFC3_menu";
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
