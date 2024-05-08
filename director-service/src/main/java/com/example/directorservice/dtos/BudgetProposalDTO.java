package com.example.directorservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetProposalDTO
{
    private int id;
    private int marketingAmmount;
    private int eventOrgAmmount;
    private int sportingAmmount;
    private boolean voted;
}
