package com.example.eventorganizatorservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class delRequest {
    private int idRH;
    private int idRT;
    private int idRF;

}
