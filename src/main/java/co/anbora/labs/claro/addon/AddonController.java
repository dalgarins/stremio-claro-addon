package co.anbora.labs.claro.addon;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;

@Controller()
public class AddonController {

    @Get("/")
    public HttpStatus index() {
        return HttpStatus.OK;
    }
}