package exam1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="JpaMember1")
public class Member1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
	private Long id;
	
	private String username;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	public Member1(){}

	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
	

}
