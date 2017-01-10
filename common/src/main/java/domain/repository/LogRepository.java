package domain.repository;

import domain.entity.LogData;

/**
 * @author Claudio E. de Oliveira
 * @date 19/12/16.
 * @email claudioed.oliveira@gmail.com Project logify
 */
public interface LogRepository {

    void save(LogData data);

}
