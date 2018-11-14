package com.justiceleague.justiceleaguetracker.controller;

import com.justiceleague.justiceleaguetracker.dto.SuperHero;
import com.justiceleague.justiceleaguetracker.service.JusticeLeagueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class will be the controller exposing the API's needed by the Justice league tracker system.
 *
 * @author dinuka
 */
@RestController
@RequestMapping("/v1/jl")
public class JusticeLeagueTrackerController {

    private static Logger log = LoggerFactory.getLogger(JusticeLeagueTrackerController.class);

    @Autowired
    private JusticeLeagueService justiceLeagueService;

    @ResponseBody
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SuperHero> getJusticeLeague() {
        log.info("Received a request to retrive the justice league");
        return justiceLeagueService.getJusticeLeague();
    }
}
