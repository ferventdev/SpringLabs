package model;

import lombok.Value;

import java.io.Serializable;

@Value
public class Country implements Serializable {

    private int id;
    private String name;
    private String codeName;
}