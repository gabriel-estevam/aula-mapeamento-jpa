package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //aqui estamos dizendo que essa classe é a entidade do dominio
public class Pessoa implements Serializable
{
	private static final long serialVersionUID = 1L;
	//os atributos abaixo sera as colunas no banco de dados
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //aqui estamos dizendo que o id abaixo sera auto_increment
	private Integer id;
	//@Column (name="nomecompleto") fazendo desse jeito, estamos dizendo para o jpa que queremos uma coluna com esse nome
	private String nome;
	private String email;
	
	public Pessoa() {
		
	}

	public Pessoa(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
	
	
}
