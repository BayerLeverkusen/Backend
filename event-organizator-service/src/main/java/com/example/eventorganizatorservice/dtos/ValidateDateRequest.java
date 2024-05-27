package com.example.eventorganizatorservice.dtos;

import com.example.eventorganizatorservice.model.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidateDateRequest {
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate startingDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate endingDate;
    public Type type;
}
