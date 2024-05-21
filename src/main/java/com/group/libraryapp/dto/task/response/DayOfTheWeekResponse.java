package com.group.libraryapp.dto.task.response;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayOfTheWeekResponse {

    private DayOfWeek dayOfTheWeek;

    public DayOfTheWeekResponse(String date) {
        LocalDate localDate = (date == null || date.isBlank()) ? LocalDate.now() : LocalDate.parse(date);
        this.dayOfTheWeek = localDate.getDayOfWeek();
    }

    public DayOfWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
