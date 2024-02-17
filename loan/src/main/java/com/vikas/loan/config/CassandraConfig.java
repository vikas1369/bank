package com.vikas.loan.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;


//This is needed otherwise cassandra template won't be created which is required in cassandra repositories
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "mykeyspace";
    }


}