package domain.controller;

import javax.inject.Inject;

import domain.entity.LogData;
import domain.entity.LogVO;
import domain.repository.LogRepository;
import ratpack.exec.Promise;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

/**
 * @author Claudio E. de Oliveira
 * @date 09/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
public class LogController implements Handler {

    private final LogRepository logRepository;

    @Inject
    public LogController(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        Promise<LogVO> wrapper = ctx.parse(Jackson.fromJson(LogVO.class));
        wrapper.then(data -> {
            final LogData logData = new LogData(data.getLevel(), data.getMessage());
            logRepository.save(logData);
            ctx.getResponse().send("");
        });

    }

}
