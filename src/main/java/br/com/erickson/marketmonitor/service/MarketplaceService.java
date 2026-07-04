package br.com.erickson.marketmonitor.service;

import br.com.erickson.marketmonitor.entity.Product;

import java.util.List;

public interface MarketplaceService {

    List<Product> search(String keyword);

}