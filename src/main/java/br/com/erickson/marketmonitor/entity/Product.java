package br.com.erickson.marketmonitor.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Marketplace marketplace;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(length = 3)
    private String currency;

    @Column(nullable = false, unique = true, length = 1000)
    private String url;

    private String seller;

    private String location;

    @Column(length = 1000)
    private String imageUrl;

    /**
     * Hash para identificar anúncios repetidos
     */
    @Column(nullable = false, unique = true)
    private String hash;

    /**
     * Data em que o anúncio foi encontrado pela primeira vez
     */
    @Column(nullable = false)
    private LocalDateTime firstSeenAt;

    /**
     * Última vez em que o anúncio apareceu na busca
     */
    @Column(nullable = false)
    private LocalDateTime lastSeenAt;

}