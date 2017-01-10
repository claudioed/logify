package infra.module;

import com.google.inject.AbstractModule;

import io.vertx.core.Vertx;

/**
 * @author Claudio E. de Oliveira
 * @date 09/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
public class LogModule extends AbstractModule {

    private final Vertx vertx;

    public LogModule(Vertx vertx) {
        this.vertx = vertx;
    }

    @Override
    protected void configure() {
        install(new DataModule());
    }

}
