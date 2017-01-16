package domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;

/**
 * @author Claudio E. de Oliveira
 * @date 09/01/17.
 * @email claudioed.oliveira@gmail.com Project logify
 */
public class LogData {

    @Getter
    private final String uuid = UUID.randomUUID().toString();

    @Getter
    private final String level;

    @Getter
    private final String message;

    @Getter
    private final LocalDateTime loggedAt;

    public LogData(String level, String message) {
        this.level = level;
        this.message = message;
        this.loggedAt = LocalDateTime.now();
    }

}
