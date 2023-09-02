package com.teste.rotinacredito.entities;

public enum TipoOperacao {
    COMPRA_A_VISTA("compra à vista", "negativo"),
    COMPRA_PARCELADA("compra parcelada", "negativo"),
    SAQUE("saque", "negativo"),
    PAGAMENTO("pagmento", "positivo");

    TipoOperacao(String tipo, String gerenciamentoCaixa) {
    }
}