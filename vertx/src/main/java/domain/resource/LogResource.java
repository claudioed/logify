package domain.resource;

import com.google.gson.Gson;
import com.google.inject.Inject;

import domain.entity.LogData;
import domain.repository.LogRepository;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class LogResource extends AbstractVerticle {

    private final Gson gson;

    private final LogRepository logRepository;

    @Inject
    public LogResource(Gson gson,LogRepository logRepository) {
        this.gson = gson;
        this.logRepository = logRepository;
    }

    @Override
    public void start() throws Exception {
        final Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.post("/log").handler((RoutingContext ctx) -> {
            ctx.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            final JsonObject bodyAsJson = ctx.getBodyAsJson();
            final String level = bodyAsJson.getString("level");
            final String message = bodyAsJson.getString("message");
            this.logRepository.save(new LogData(level,message));
            ctx.response().setStatusCode(201).end("");
        });
        vertx.createHttpServer().requestHandler(router::accept).listen(8005);
    }

}