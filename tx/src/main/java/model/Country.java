package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class Country implements Serializable {

    private int id;
    private String name;
    private String codeName;
}