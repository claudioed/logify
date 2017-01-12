package infra.server;

import domain.controller.LogController;
import infra.module.DataModule;
import infra.module.RatpackModule;
import ratpack.guice.Guice;
import ratpack.server.RatpackServer;

/**
 * @author Claudio E. de Oliveira
 * @date 09/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
public class Server {

    public static void main(String... args) throws Exception {
        RatpackServer.start(s -> s
                .serverConfig(c -> c.port(9001))
                .registry(Guice.registry(b -> b.module(RatpackModule.class)))
                .handlers(chain -> chain.post("log",LogController.class))
        );
    }

}
