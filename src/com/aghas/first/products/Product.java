package com.aghas.first.products;

import com.aghas.first.managers.SaleManager;

public interface Product extends SaleManager.Saleable {
    String appearance();

    String getName();
}
