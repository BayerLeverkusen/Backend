package com.example.eventorganizatorservice.dtos;

import com.example.eventorganizatorservice.model.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelReservationRequest {
    public String resourceName;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate startDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate endDate;
    public String city;
    public String country;
    public Type type;
}
