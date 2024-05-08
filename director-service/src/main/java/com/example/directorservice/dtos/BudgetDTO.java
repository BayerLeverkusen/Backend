package com.example.directorservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetDTO {
    private String marketingAmmount;
    private String eventOrgAmmount;
    private String sportingAmmount;

}
