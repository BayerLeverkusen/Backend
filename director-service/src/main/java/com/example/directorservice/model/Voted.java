package com.example.directorservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voted")
public class Voted {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    @Column
    public String voterId;

    @Column
    public int proposaId;


    public Voted(String voterId, int proposaId) {
        this.voterId = voterId;
        this.proposaId = proposaId;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public int getProposaId() {
        return proposaId;
    }

    public void setProposaId(int proposaId) {
        this.proposaId = proposaId;
    }
}
