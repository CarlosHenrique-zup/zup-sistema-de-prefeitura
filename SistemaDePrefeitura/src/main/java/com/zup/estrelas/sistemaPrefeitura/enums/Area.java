package com.zup.estrelas.sistemaPrefeitura.enums;

public enum Area {

	SAUDE("saude"), EDUCACAO("educacao"), TRANSITO("transito"), ANIMAIS("animais"), TRABALHO("trabalho"),
	MORADIA("moradia"), TRANSPORTE("transporte"), CULTURA("cultura"), LAZER("LAZER"), SEGURANCA("seguranca"),
	CIDADANIA("cidadania"), AGRICULTURA("agricultura"), COMUNICACAO("comunicacao"), FAZENDA("fazenda");

	private String value;

	Area(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
