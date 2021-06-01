package com.challengegs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tb_venda")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( nullable = false)
    private String name;

    @Column( nullable = false)
    private String descricao;

    @Column
    private Double valor;

}
