package br.com.erickson.marketmonitor.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "search_alerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Usuário proprietário do alerta
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Ex.: Casio CT-S200
     */
    @Column(nullable = false)
    private String keyword;

    @ElementCollection(targetClass = Marketplace.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "search_alert_marketplaces",
            joinColumns = @JoinColumn(name = "search_alert_id")
    )
    @Column(name = "marketplace")
    @Builder.Default
    private Set<Marketplace> marketplaces = new HashSet<>();

    /**
     * Preço mínimo (opcional)
     */
    @Column(precision = 12, scale = 2)
    private BigDecimal minPrice;

    /**
     * Preço máximo (opcional)
     */
    @Column(precision = 12, scale = 2)
    private BigDecimal maxPrice;

    /**
     * Alerta ativo?
     */
    @Builder.Default
    @Column(nullable = false)
    private Boolean enabled = true;

    /**
     * Data de criação
     */
    @Builder.Default
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

}