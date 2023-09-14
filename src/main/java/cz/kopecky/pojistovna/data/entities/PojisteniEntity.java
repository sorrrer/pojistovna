package cz.kopecky.pojistovna.data.entities;

import jakarta.persistence.*;

@Entity
public class PojisteniEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pojisteniId;
    @Column(nullable = false)
    private String predmetPojisteni;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int timeFrom;
    @Column(nullable = false)
    private int timeTo;


}
