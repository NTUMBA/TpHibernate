package com.TpDating.cahierDeCharge.enumerations;

public enum AdressTypeStreet {
    ALLEE ("ALLÉE"),
    AVENUE ("AVENUE"),
    BOULEVARD ("BOULEVARD"),
    CHEMIN ("CHEMIN"),
    CHAUSSEE ("CHAUSSÉE"),
    CORNICHE ("CORNICHE"),
    COURS ("COURS"),
    DOMAINE ("DOMAINE"),
    ESPLANADE ("ESPLANADE"),
    FAUBOURG ("FAUBOURG"),
    HAMEAU ("HAMEAU"),
    HALLE ("HALLE"),
    IMPASSE ("IMPASSE"),
    LIEUDIT("LIEU-DIT"),
    LOTISSEMENT ("LOTISSEMENT"),
    MARCHE ("MARCHÉ"),
    PASSAGE ("PASSAGE"),
    PLACE ("PLACE"),
    PROMENADE ("PROMENADE"),
    PARVIS ("PARVIS"),
    QUAI ("QUAI"),
    RUELLE ("RUELLE"),
    ROCADE ("ROCADE"),
    RONDPOINT ("ROND-POINT"),
    ROUTE ("ROUTE"),
    RUE ("RUE"),
    SENTIER ("SENTE - SENTIER"),
    SQUARE ("SQUARE"),
    TERREPLEIN ("TERRE-PLEIN"),
    TRAVERSE ("TRAVERSE");

    private String name = "";

    AdressTypeStreet(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
