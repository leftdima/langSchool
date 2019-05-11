package com.baranchik.composits;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ClientStats {
    private BigDecimal avgCost;
    private BigDecimal sumCost;
    private BigInteger countOfOrders;

    public ClientStats(BigDecimal avgCost, BigDecimal sumCost, BigInteger countOfOrders) {
        this.avgCost = avgCost;
        this.sumCost = sumCost;
        this.countOfOrders = countOfOrders;
    }

    public BigDecimal getAvgCost() {
        return avgCost;
    }

    public BigDecimal getSumCost() {
        return sumCost;
    }

    public BigInteger getCountOfOrders() {
        return countOfOrders;
    }
}
