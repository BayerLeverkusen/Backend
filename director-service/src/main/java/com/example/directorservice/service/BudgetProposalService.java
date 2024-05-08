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

    public void increaseCount1(int id)
    {
        BudgetProposal budgetProposal = budgetProposalRepository.getBudgetProposalsById(id);
        budgetProposalRepository.deleteById(id);
        budgetProposal.numOfVotes = budgetProposal.numOfVotes+1;
        budgetProposalRepository.save(budgetProposal);
    }

    public void increaseCount(int id)
    {
        List<BudgetProposal> budgetProposals = getBudgetProposals();
        for (BudgetProposal budgetProposal:budgetProposals)
        {
            if(budgetProposal.getId()==id)
            {
                budgetProposal.setNumOfVotes(budgetProposal.getNumOfVotes()+1);
            }
        }

        budgetProposalRepository.deleteAll();
        budgetProposalRepository.saveAll(budgetProposals);
    }

    public List<BudgetProposal> getBudgetProposals()
    {
        return budgetProposalRepository.findAll();
    }


    public List<BudgetProposalDTO> getBudgetProposalsDTOs(String userId)
    {
        List<BudgetProposalDTO> budgetProposalDTOS = convertToDTO();
        List<Voted> voted = votedService.getByUser(userId);

        for (BudgetProposalDTO budgetProposalDTO:budgetProposalDTOS)
        {
            for (Voted voted1:voted)
            {
                if(voted1.getProposaId()== budgetProposalDTO.getId())
                {
                    budgetProposalDTO.setVoted(true);
                }

            }
        }

        return budgetProposalDTOS;

    }

    public List<BudgetProposalDTO> convertToDTO()
    {
        List<BudgetProposalDTO> budgetProposalDTOS = new ArrayList<>();

        for (BudgetProposal budgetProposal:getBudgetProposals())
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


    public List<BudgetProposal> getVotedPropositions(String userId)
    {
        List<BudgetProposal> nonVotedProposals = budgetProposalRepository.findAll();
        List<BudgetProposal> votedProposals = new ArrayList<>();

        for (Voted voted:votedService.getVotes())
        {
            if(voted.voterId.equals(userId))
            {
                nonVotedProposals.removeIf(proposal -> proposal.getId() == voted.proposaId);
            }
        }

        return nonVotedProposals;

    }
}
