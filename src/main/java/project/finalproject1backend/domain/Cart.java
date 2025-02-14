package project.finalproject1backend.domain;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User cartUser;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product cartProduct;
}
