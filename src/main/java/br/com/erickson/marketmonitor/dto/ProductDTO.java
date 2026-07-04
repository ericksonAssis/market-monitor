package br.com.erickson.marketmonitor.dto;

import br.com.erickson.marketmonitor.entity.Marketplace;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductDTO(

        Marketplace marketplace,

        String title,

        String description,

        BigDecimal price,

        String currency,

        String url,

        String imageUrl,

        String seller,

        String location,

        String condition,

        LocalDateTime publishedAt

) {
}