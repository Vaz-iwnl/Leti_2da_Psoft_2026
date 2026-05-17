package com.aisafe.controller;

import com.aisafe.model.Airport;
import com.aisafe.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Estes dois imports mágicos são para os links do HATEOAS
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    // US106 - Criar Aeroporto
    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

    // US107 - Ver todos os aeroportos
    @GetMapping
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    // US107 + Requisito 3.6.1 - Ver detalhes COM HATEOAS (Links)
    @GetMapping("/{iata}")
    public ResponseEntity<EntityModel<Airport>> getAirportById(@PathVariable String iata) {
        return airportRepository.findById(iata)
                .map(airport -> {
                    EntityModel<Airport> model = EntityModel.of(airport);
                    // Adiciona o link para ele
                    model.add(linkTo(methodOn(AirportController.class).getAirportById(iata)).withSelfRel());
                    // Adiciona o link para voltar à lista geral
                    model.add(linkTo(methodOn(AirportController.class).getAllAirports()).withRel("all-airports"));
                    return ResponseEntity.ok(model);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // US108 - Procurar por cidade
    @GetMapping("/search")
    public List<Airport> searchAirports(@RequestParam String city) {
        return airportRepository.findAll().stream()
                .filter(a -> a.getCity() != null && a.getCity().equalsIgnoreCase(city))
                .toList();
    }

    // US109 - Atualizar estado operacional
    @PatchMapping("/{iata}/status")
    public ResponseEntity<Airport> updateStatus(@PathVariable String iata, @RequestParam String newStatus) {
        return airportRepository.findById(iata)
                .map(airport -> {
                    airport.setStatus(newStatus);
                    return ResponseEntity.ok(airportRepository.save(airport));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}