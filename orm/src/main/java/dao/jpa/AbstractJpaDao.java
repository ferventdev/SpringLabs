package dao.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class AbstractJpaDao {

    @Getter
	@Setter(onMethod = @__(@PersistenceUnit))
	private EntityManagerFactory emf;

}