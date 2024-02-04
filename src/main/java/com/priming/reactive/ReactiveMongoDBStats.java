package com.priming.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ReactiveMongoDBStats implements CommandLineRunner {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ReactiveMongoDBStats.class, args);
    }

    @Override
    public void run(String... args) {
        // Substitua pelos valores reais
        String usuario = "junior";
        String senha = "debian23";
        String nomeDoBanco = "primeDB";

        // Construa a URI de conexão com o MongoDB
        String uri = String.format("mongodb+srv://%s:%s@prime.0zjimdw.mongodb.net/%s?retryWrites=true&w=majority",
                usuario, senha, nomeDoBanco);

        // Lista as coleções no banco de dados
        reactiveMongoTemplate.getCollectionNames()
                .flatMap(colecao -> {
                    return reactiveMongoTemplate.count(Query.query(Criteria.where("_id").exists(true)), colecao)
                            .map(numeroDocumentos -> {
                                double tamanhoGB = 0; // Coloque a lógica para calcular o tamanho em GB
                                System.out.printf("%s: %d documentos, %.2f GB%n", colecao, numeroDocumentos, tamanhoGB);
                                return colecao;
                            });
                })
                .doFinally(signalType -> {
                    // Fecha a conexão com o MongoDB
                    // Não é necessário fechar explicitamente a conexão no Spring WebFlux
                })
                .subscribe();
    }
}
