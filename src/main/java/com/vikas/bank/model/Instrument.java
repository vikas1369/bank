package com.vikas.bank.model;

public class Instrument {
    Integer instrumentId;
    Integer id;

    public Instrument(Integer instrumentId, Integer id) {
        this.instrumentId = instrumentId;
        this.id = id;
    }

    public Integer getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
