package domain.controller;

import org.jooby.mvc.POST;
import org.jooby.mvc.Path;

import javax.inject.Inject;

import domain.entity.LogData;
import domain.entity.LogVO;
import domain.repository.LogRepository;

/**
 * @author Claudio E. de Oliveira
 * @date 11/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
@Path("/log")
public class LogController {

    private final LogRepository logRepository;

    @Inject
    public LogController(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @POST
    public void logEntry(LogVO logVO){
        this.logRepository.save(new LogData(logVO.getLevel(),logVO.getMessage()));

    }
}
