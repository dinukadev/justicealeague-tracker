package com.justiceleague.justiceleaguetracker.service;

import com.justiceleague.justiceleaguetracker.dto.SuperHero;

import java.util.List;

public interface JusticeLeagueService {
    /**
     * This method will return all the existing justice league
     *
     * @return a list of {@link SuperHero}
     */
    List<SuperHero> getJusticeLeague();
}
