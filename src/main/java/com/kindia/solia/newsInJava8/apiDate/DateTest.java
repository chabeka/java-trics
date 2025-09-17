package com.kindia.solia.newsInJava8.apiDate;

import java.time.*;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

public class DateTest {

    // Instant ==> un instant t en micro/nano seconde dans la ligne de date
    Date d = new Date();
    Instant  instant = Instant.now();
    void m(){

    }
    // L'instant est associé à une notion de Duration
    // Duration ==> durée entre deux instant
    Duration duration = Duration.between(instant, Instant.now());

    // LocalDate ==> une date (journée) donnée exemple (12 Septembre 2011)
    LocalDate localDate = LocalDate.of(2011, Month.SEPTEMBER, 12);

    // La LocalDate est associé à une notion de période
    // Période espace entre 2 dates

    LocalDate local2022 = LocalDate.of(2022, Month.JANUARY, 01);
    Period period = localDate.until(local2022);

    // TemporalAdjuster ==> faire de l'arithmetique sur les dates
    LocalDate localDateNow = LocalDate.now();
    LocalDate nexDateLundi = localDateNow.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

    // Le temps dans une journée
    LocalTime localTime = LocalTime.now();
    LocalTime localDate1 = LocalTime.of(10, 20);

    // Date localisé avec fuseau horaire
    Set<String> allZones = ZoneId.getAvailableZoneIds();
    // Créer une date dans un fuseau horaire donnée
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, ZoneId.of("Europe/London"));


}
