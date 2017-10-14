package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Country implements Serializable{

	private int id;
    private String name;
    private String codeName;

    public Country(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }
}
