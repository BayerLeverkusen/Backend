package com.example.directorservice.repository;

import com.example.directorservice.model.Voted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotedRepository extends JpaRepository<Voted,Integer>
{
    Voted save(Voted voted);

    List<Voted> getAllByVoterId(String voterId);
}
