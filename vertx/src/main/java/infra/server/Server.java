package infra.server;

import com.google.inject.Guice;
import com.google.inject.Injector;

import infra.module.LogModule;
import io.vertx.core.Vertx;

/**
 * @author Claudio E. de Oliveira
 * @date 09/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
public class Server {

    public static void main(String... args) throws Exception {
        final Vertx vertx = Vertx.vertx();
        final Injector injector = Guice.createInjector(new LogModule(vertx));
    }

}
