package openJPA;
import java.io.Serializable;
import javax.persistence.*;

@Entity()
@Table(name = "producer")
public class Producer implements Serializable {

	private static final long serialVersionUID = -6598680943099639958L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "producer_SEQ")
	@SequenceGenerator(name = "producer_SEQ", sequenceName
	 ="producer_id_seq", allocationSize = 1)
	private long id;
	private String name;

	protected Producer() {

	}

	protected Producer(String name) {
		this.name = name;
	}

//	public long getId() {
//		return this.id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return this.name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

}
