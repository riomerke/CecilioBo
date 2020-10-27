package com.solvertic.disfruta.entity;

public enum TiposDeAtributos {
	Valor("Atributos de Valor"), Texto("Atributos de Texto");
	
 private final String displayValue;
    
    private TiposDeAtributos(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }

}
