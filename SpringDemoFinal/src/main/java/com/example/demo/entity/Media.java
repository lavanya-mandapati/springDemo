package com.example.demo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="media")
public @Data
@NoArgsConstructor
class Media {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="media_name")
    private String mediaName;
    @Column(name="media_type")
    private String mediaType;

    @Column(name="media_visibility")
    private String mediaVisibility;

    public Media(String mediaType,String mediaVisibility,String mediaName)
    {
        this.mediaName=mediaName;
        this.mediaType=mediaType;
        this.mediaVisibility=mediaVisibility;
    }
}
