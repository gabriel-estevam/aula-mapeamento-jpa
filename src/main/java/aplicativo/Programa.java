package aplicativo;

//imports da persistencia, entityManager e entityManagerFactory
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa 
{
	public static void main(String[] args) 
	{
		/*Funcionamento:
		 * Abaixo estamos instaciando tres objetos do tipo Pessoa, passando valores para o construtor;
		 * Na sequncia chamamos o metodo createEntityManagerFactory("nome_persistence-unit") passando como parametro
		 o nome da persistence-unit do xml, que é aquele apelido que demos a ele;
		 O entityManager é um objeto responsavel por efetuar operações de acesso a dados em entidades;
		 O entityManagerFactory é utilizado para instanciar objetos entityManager
		 * */
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //aqui estamos fazendo a conexão
//com o banco de dados, esse objeto tem todas aquelas informações do xml, como o nome do banco, usuario,senha...
		EntityManager em = emf.createEntityManager(); //aqui estamos passando a conexão com o banco e a persistencia implementada
		em.getTransaction().begin(); //esse metodo incia uma trasação no banco de dados
		em.persist(p1); //Pega o objeto e salva no banco de dados
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit(); //confima a transação
		System.out.println("Pronto!");
		em.close(); //fecha a conexão com entityManager
		emf.close(); //fecha a conexão com entityManagerFactory
		
		//com isso, podemos observar que com o hibernate não precisamos fazer toda a implementação de acesso a dados
		//com um unico objeto conseguimos inserir no banco de dados
	}
}
