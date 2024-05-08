package com.example.directorservice.controller;

import com.example.directorservice.dtos.BudgetDTO;
import com.example.directorservice.dtos.BudgetProposalDTO;
import com.example.directorservice.dtos.VotedDTO;
import com.example.directorservice.model.BudgetProposal;
import com.example.directorservice.service.BudgetProposalService;
import com.example.directorservice.service.VotedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/auth")
    public class DirectorController {

        @Autowired
        private BudgetProposalService budgetProposalService;

        @Autowired
        private VotedService votedService;

        @PutMapping("/addProposal")
        public ResponseEntity<String> addProposal(@RequestBody BudgetDTO budgetDTO)
        {
            try
            {
                budgetProposalService.addBudgetProposal(budgetDTO);
                return ResponseEntity.ok().build();
            }
            catch (Exception e)
            {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add proposal " + e.getMessage());
            }

        }

        @GetMapping("/getProposals")
        public List<BudgetProposalDTO> getProposals(String userId)
        {
            try
            {
                return budgetProposalService.getBudgetProposalsDTOs(userId);
            }
            catch (Exception e)
            {
                return null;
            }
        }

        @PutMapping("/vote")
        public ResponseEntity<String> vote(@RequestBody VotedDTO votedDTO)
        {
            try
            {
                votedService.saveVote(votedDTO.getUserId(),votedDTO.getProposalId());
                budgetProposalService.increaseCount(votedDTO.getProposalId());
                return ResponseEntity.ok().build();
            }
            catch (Exception e)
            {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to vote " + e.getMessage());
            }
        }


    }

