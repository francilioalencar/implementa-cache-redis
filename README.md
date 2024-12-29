# Implementação de servidor de cache com Redis


## Requisitos:
 1. Docker
 2. Mysql
 3. Redis
 4. Java 17




## Docker

#### Arquivos docker-compose.yml
```

version: '3.8'

services:
  cache-redis:
    image: redis
    ports:
      - "6379:6379"
  mysql:
    image: mysql:8.0.36
    container_name: mysql-cache
    ports:
      - "3306:3306"
    restart: unless-stopped
    volumes:
      - ./mysql-data-cache-redis:/var/lib/mysql
    env_file:
      - ./env/mysql.env

volumes:
  mysql-data-cache-redis:

```

#### Passos para executar localmente:

 1. Clone o repositório
 2. No diretorio raiz do projeto, execute o seguinte comando: ``` docker-compose up -d ```
 3. Na pasta raiz do projeto execute o comando: ``` mvn spring-boot:run ```
 4. Acesse a documentação e faça os testes de Post e Get nos EndPoints: http://localhost:8080/swagger-ui/index.html
 5. Ao realizar as requisições observer que o spring exibirá as consultas SQL no console


| Requisição  | Endpoint | Ação|
| ------------- |:-------------:|:-------------:|
| Get      | /v1/state     |Armazena cache Redis|
| Get      | /v1/city     |Armazena cache Redis|
| Post      | /v1/city     |Limpa cache Redis|
| Post      | /v1/city     |Limpa cache Redis|


##
## Configuração necessário

#### pom.xml
Inclusão da dependência relacionada ao Redis
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

#### application.properties
Adicionar linnhas 
```
# informa ao spring boot que o tipo de chache
spring.cache.type=redis
# informa ao spring boot o local do Redis
spring.redis.host=localhost
# informa ao spring boot a porta do Redis
spring.redis.port=6379
# informa ao spring boot o tempo de vida da cache
spring.cache.redis.time-to-live=10000
```
#### Na classe principal do projeto
Incluir juntamento com :
```
@SpringBootApplication
```
A notação para habilitar o cache
```
@EnableCaching
```
Ficando da seguinte forma:
```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

}

```

No metodos ondem serão responsáveis pelo armazenamento do cache e exclusão incluir as anotações:

| Anotação  | Ação|
| ------------- |:-------------:|
| @Cacheable(value = "ID-DO-CACHE")      | Armazena cache |
| @CacheEvict(value = "ID-DO-CACHE", allEntries = true)      | Limpa o cache relacionado ao ID informado |

As classes de retorno dos métodos que utilizam as anotação citadas, devem implementar a classe Serializable do pacote import java.io.Serializable;
```


public class ClasseExemplo implements Serializable {
    private Long id;
    private String descricao;
}



// armazena em cache
@Cacheable(value = "cache-metodo-teste")
public ClasseExemplo metodoTeste1(){
    ...
}


// limpa o cache relacionado ao ID
@CacheEvict(value = "cache-metodo-teste", allEntries = true)
public ClasseExemplo metodoTeste2(){
    ...
}



```
