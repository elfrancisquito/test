package com.ecommerce.product_service.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "product-db";
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        MongoCredential credential = MongoCredential.createCredential(
                "root", "admin", "password".toCharArray()
        );

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://localhost:27017/?authSource=admin"))
                .credential(credential)
                .build();

        return MongoClients.create(mongoClientSettings);
    }
}
