package domain.controller;

import javax.inject.Inject;
import javax.inject.Singleton;

import domain.repository.LogRepository;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

/**
 * @author Claudio E. de Oliveira
 * @date 09/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
@Singleton
public class LogController implements Handler<RoutingContext> {

    private final LogRepository logRepository;

    @Inject
    public LogController(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void handle(RoutingContext routingContext) {

    }

}
