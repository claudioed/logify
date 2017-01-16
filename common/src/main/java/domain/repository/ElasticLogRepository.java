package domain.repository;

import com.google.gson.Gson;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

import javax.inject.Inject;
import javax.inject.Singleton;

import domain.entity.LogData;
import lombok.NonNull;

/**
 * @author Claudio E. de Oliveira
 * @date 19/12/16.
 * @email claudioed.oliveira@gmail.com Project logify
 */
@Singleton
public class ElasticLogRepository implements LogRepository {

    private static final String INDEX_TYPE = "log-data";

    private static final String INDEX = "logs";

    private final Client client;

    private final Gson gson;

    @Inject
    public ElasticLogRepository(Client client, Gson gson) {
        this.client = client;
        this.gson = gson;
    }

    @Override
    public void save(@NonNull final LogData data) {
        final IndexRequest indexRequest = new IndexRequest(INDEX,INDEX_TYPE,data.getUuid());
        indexRequest.source(this.gson.toJson(data));
        final IndexResponse response = this.client.index(indexRequest).actionGet();
    }

}
