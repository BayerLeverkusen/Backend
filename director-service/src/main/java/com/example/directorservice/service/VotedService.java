package com.example.directorservice.service;

import com.example.directorservice.model.BudgetProposal;
import com.example.directorservice.model.Voted;
import com.example.directorservice.repository.BudgetProposalRepository;
import com.example.directorservice.repository.VotedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VotedService
{
    @Autowired
    VotedRepository votedRepository;


    public void saveVote(String userId,int proposalId)
    {
        Voted voted = new Voted(userId,proposalId);
        votedRepository.save(voted);
    }

    public List<Voted> getByUser(String userId)
    {
        List<Voted> voted = new ArrayList<>();

        for (Voted vote:votedRepository.findAll())
        {
            if(userId.equals(vote.getVoterId()))
            {
                voted.add(vote);
            }
        }

        return voted;
    }


    public List<Voted> getVotes()
    {
        return votedRepository.findAll();
    }
}
