package openJPA;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.apache.openjpa.persistence.OpenJPAPersistence;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Producer p = new Producer("Maribo");
		EntityManagerFactory fac = getWithoutConfig();
		//EntityManagerFactory fac = Persistence.createEntityManagerFactory(
		//		"openjpa", System.getProperties());

		EntityManager e = fac.createEntityManager();

		EntityTransaction t = e.getTransaction();
		 t.begin();
		 e.persist(p);
		 t.commit(); // all ok commit
		// all Data is saved in database now

		 t.begin();
		// QBE
		for (Object o : e.createQuery("SELECT c FROM Producer c")
				.getResultList()) {
			System.out.println(o);
			Producer c = (Producer) o;
		}
		t.commit(); // all ok commit

		e.close();
		fac.close();

	}

	public static EntityManagerFactory getWithoutConfig() {

		Map<String, String> map = new HashMap<String, String>();

		map.put("openjpa.ConnectionURL",
				"jdbc:postgresql://java.is.uni-due.de:5432/producer/");
		map.put("openjpa.ConnectionDriverName", "org.postgresql.Driver");
		map.put("openjpa.ConnectionUserName", "ws1011");
		map.put("openjpa.ConnectionPassword", "ftpw10");
		map.put("openjpa.RuntimeUnenhancedClasses", "supported");
		map.put("openjpa.jdbc.SynchronizeMappings", "false");

		// find all classes to registrate them
		List<Class<?>> types = new ArrayList<Class<?>>();
		types.add(Producer.class);

		if (!types.isEmpty()) {
			StringBuffer buf = new StringBuffer();
			for (Class<?> c : types) {
				if (buf.length() > 0)
					buf.append(";");
				buf.append(c.getName());
			}
			// <class>Producer</class>
			map.put("openjpa.MetaDataFactory", "jpa(Types=" + buf.toString()
					+ ")");
		}

		return OpenJPAPersistence.getEntityManagerFactory(map);

	}

}
