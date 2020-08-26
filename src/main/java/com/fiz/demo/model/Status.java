package com.fiz.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Status {

	Görüşüldü(01), Beklemede(02), İptal(03);

	@Getter
	private int statusCode;

}
