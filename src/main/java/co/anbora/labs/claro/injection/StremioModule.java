package co.anbora.labs.claro.injection;

import co.anbora.labs.claro.domain.constants.StremioConstants.Plugin;
import co.anbora.labs.claro.domain.model.stremio.Manifest;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class StremioModule {

    @Bean
    @Singleton
    Manifest provideManifest() {
        return new Manifest(
                Plugin.ID,
                Plugin.VERSION,
                Plugin.NAME,
                Plugin.DESCRIPTION,
                Plugin.ID_PREFIXES,
                Plugin.RESOURCES,
                Plugin.TYPES,
                Plugin.CATALOGS,
                Plugin.BACKGROUND,
                Plugin.LOGO,
                Plugin.CONTACT_EMAIL
        );
    }

}
