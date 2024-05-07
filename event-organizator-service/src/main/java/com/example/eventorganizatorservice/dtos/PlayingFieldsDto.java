package com.example.eventorganizatorservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayingFieldsDto {
    private String playingFieldsName;
    private String playingFieldsCity;
    private String playingFieldsCountry;
    private double playingFieldsPrice;
    private double playingFieldsRating;

}
