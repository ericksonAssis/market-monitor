package br.com.erickson.marketmonitor.service;

import br.com.erickson.marketmonitor.dto.ProductDTO;
import br.com.erickson.marketmonitor.entity.SearchAlert;

import java.util.List;

public interface MarketplaceClient {

    List<ProductDTO> search(SearchAlert alert);

}