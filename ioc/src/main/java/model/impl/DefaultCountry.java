package model.impl;

import lombok.Value;
import model.Country;

@Value
public class DefaultCountry implements Country {
	private int id;
    private String name;
    private String codeName;
}
