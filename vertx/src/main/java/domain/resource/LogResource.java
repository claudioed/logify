package domain.resource;

import com.google.gson.Gson;
import com.google.inject.Inject;

import domain.repository.LogRepository;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.web.Router;

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
        router.post("/log").handler(ctx -> {
            ctx.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            ctx.response().setStatusCode(200).end("");
        });
        vertx.createHttpServer().requestHandler(router::accept).listen(8005);
    }

}