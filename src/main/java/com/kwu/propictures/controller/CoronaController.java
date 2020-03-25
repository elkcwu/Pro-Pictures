package com.kwu.propictures.controller;

import com.kwu.propictures.model.Coronavirus;
import com.kwu.propictures.service.CoronaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/corona")
public class CoronaController {

        @Autowired
        CoronaService coronaService;

        @GetMapping("/daily")
        public List<Coronavirus> getCoronaReport() throws IOException {
            List<Coronavirus> result = coronaService.getCoronaLatest();
            result.forEach(System.out::println);
            return result;
        }



}
