package co.anbora.labs.claro.addon;

import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;

import javax.inject.Inject;

@Controller()
public class AddonController {

    @Inject IClaroVideoRepository claroVideoRepository;

    @Get("/")
    public HttpStatus index() {
        if (claroVideoRepository != null) {
            System.out.println("hola");
        }
        return HttpStatus.OK;
    }
}