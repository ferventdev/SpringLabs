package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "Country")
@Table(name = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String codeName;
}
