package com.example.directorservice.service;

import com.example.directorservice.dtos.BudgetDTO;
import com.example.directorservice.dtos.BudgetProposalDTO;
import com.example.directorservice.model.BudgetProposal;
import com.example.directorservice.model.Voted;
import com.example.directorservice.repository.BudgetProposalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetProposalService {

    @Autowired
    private BudgetProposalRepository budgetProposalRepository;

    @Autowired
    private VotedService votedService;


    public void addBudgetProposal(BudgetDTO budgetDTO)
    {
        BudgetProposal budgetProposal = new BudgetProposal( Integer.parseInt(budgetDTO.getMarketingAmmount()),Integer.parseInt(budgetDTO.getEventOrgAmmount()),Integer.parseInt(budgetDTO.getSportingAmmount()));
        budgetProposalRepository.save(budgetProposal);
    }

    public void increaseCount(int id)
    {
        BudgetProposal budgetProposal = budgetProposalRepository.getBudgetProposalsById(id);
        budgetProposal.setNumOfVotes(budgetProposal.getNumOfVotes()+1);
        budgetProposalRepository.save(budgetProposal);
    }


    public List<BudgetProposal> getBudgetProposals()
    {
        return budgetProposalRepository.findAll();
    }


    public List<BudgetProposalDTO> getBudgetProposalsDTOs(String userId)
    {
        return convertToDTO(getNonVotedProposals(userId));

    }


    public List<BudgetProposal> getNonVotedProposals(String userId)
    {
        List<BudgetProposal> proposals = new ArrayList<>();

        List<Voted> votedList = votedService.getVotesByUser(userId);

        if(!hasVoted(userId))
        {
            proposals = budgetProposalRepository.findAll();
            return proposals;
        }
        else
        {
            return proposals;
        }
    }

    public boolean hasVoted(String userId)
    {
        List<Voted> votedList = votedService.getVotesByUser(userId);

        if(votedList.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }



    public List<BudgetProposalDTO> convertToDTO(List<BudgetProposal> budgetProposals)
    {
        List<BudgetProposalDTO> budgetProposalDTOS = new ArrayList<>();

        for (BudgetProposal budgetProposal:budgetProposals)
        {
            BudgetProposalDTO budgetProposalDTO = new BudgetProposalDTO();
            budgetProposalDTO.setId(budgetProposal.getId());
            budgetProposalDTO.setSportingAmmount(budgetProposal.getSportingAmmount());
            budgetProposalDTO.setEventOrgAmmount(budgetProposal.getEventOrgAmmount());
            budgetProposalDTO.setMarketingAmmount(budgetProposal.getMarketingAmmount());
            budgetProposalDTO.setVoted(false);

            budgetProposalDTOS.add(budgetProposalDTO);
        }

        return budgetProposalDTOS;
    }



}
