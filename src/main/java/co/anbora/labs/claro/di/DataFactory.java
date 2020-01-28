package co.anbora.labs.claro.di;

import co.anbora.labs.claro.data.remote.ClaroVideoRepositoryImpl;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Property;

@Factory
public class DataFactory {

    private String urlConfigClaro;

    public DataFactory(@Property(name = "claro.url_config") String urlConfig) {
        this.urlConfigClaro = urlConfig;
    }

    @Bean
    IClaroVideoRepository provideRemoteRepository() {
        return new ClaroVideoRepositoryImpl();
    }


}
