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
public class ModRequest {
    private int resID;
    public String resName;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate startDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate endDate;


}
