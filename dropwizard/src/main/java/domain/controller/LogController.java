package domain.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import domain.entity.LogData;
import domain.entity.LogVO;
import domain.repository.LogRepository;

/**
 * @author Claudio E. de Oliveira
 * @date 11/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
@Path(value = "/log")
public class LogController {

    private final LogRepository logRepository;

    @Inject
    public LogController(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void logEntry(LogVO logVO){
        this.logRepository.save(new LogData(logVO.getLevel(),logVO.getMessage()));
    }

}
