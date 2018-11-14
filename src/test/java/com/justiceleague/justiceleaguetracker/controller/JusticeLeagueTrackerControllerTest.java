package com.justiceleague.justiceleaguetracker.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justiceleague.justiceleaguetracker.JusticeLeagueTrackerApplication;
import com.justiceleague.justiceleaguetracker.dto.SuperHero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {JusticeLeagueTrackerApplication.class})
@ActiveProfiles("test")
public class JusticeLeagueTrackerControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldGetJusticeLeague() throws Exception {
        String response = mockMvc.perform(get("/v1/jl")).andExpect(status().isOk()).andReturn().
                getResponse().getContentAsString();
        List<SuperHero> actual = new ObjectMapper().readValue(response, new TypeReference<List<SuperHero>>() {
        });
        List<SuperHero> expected = getJusticeLeague();

        assertEquals(expected, actual);
    }

    private List<SuperHero> getJusticeLeague() {
        SuperHero superMan = new SuperHero("Clark Kent", Arrays.asList("Flight", "Super human strength",
                "X-ray vision"), "Metropolis");
        SuperHero flash = new SuperHero("Barry Allen", Arrays.asList("Super speed",
                "Tapping into the speed force", "Time travel"), "Central city");
        SuperHero batman = new SuperHero("Bruce Wayne", Arrays.asList("Super rich", "Cool Gadgets"),
                "Gotham");
        return Arrays.asList(superMan, flash, batman);
    }
}