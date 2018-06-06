package per.demo.common;

import org.springframework.http.*;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.server.EntityResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/**
 * DefaultResponse
 *
 * @author Wilson
 * @date 18-5-8
 */
public class DefaultResponse implements EntityResponse.Builder {
    private Object data = null;
    private int status = HttpStatus.OK.value();


    private BodyInserter<Object, ? super ServerHttpResponse> inserter;
    private HttpHeaders headers = new HttpHeaders();

    private MultiValueMap<String, ResponseCookie> cookies = new LinkedMultiValueMap<>();

    private Map<String, Object> hints = new HashMap<>();

    public DefaultResponse(Object data, BodyInserter<Object, ? super ServerHttpResponse> inserter) {
        this.data = data;
        this.inserter = inserter;
    }

    @Override
    public EntityResponse.Builder header(String headerName, String... headerValues) {
        return null;
    }

    @Override
    public EntityResponse.Builder headers(HttpHeaders headers) {
        return null;
    }

    @Override
    public EntityResponse.Builder status(HttpStatus status) {
        return null;
    }

    @Override
    public EntityResponse.Builder status(int status) {
        return null;
    }

    @Override
    public EntityResponse.Builder cookie(ResponseCookie cookie) {
        return null;
    }

    @Override
    public EntityResponse.Builder cookies(Consumer cookiesConsumer) {
        return null;
    }

    @Override
    public EntityResponse.Builder allow(HttpMethod... allowedMethods) {
        return null;
    }

    @Override
    public EntityResponse.Builder allow(Set allowedMethods) {
        return null;
    }

    @Override
    public EntityResponse.Builder eTag(String eTag) {
        return null;
    }

    @Override
    public EntityResponse.Builder lastModified(ZonedDateTime lastModified) {
        return null;
    }

    @Override
    public EntityResponse.Builder location(URI location) {
        return null;
    }

    @Override
    public EntityResponse.Builder cacheControl(CacheControl cacheControl) {
        return null;
    }

    @Override
    public EntityResponse.Builder varyBy(String... requestHeaders) {
        return null;
    }

    @Override
    public EntityResponse.Builder contentLength(long contentLength) {
        return null;
    }

    @Override
    public EntityResponse.Builder contentType(MediaType contentType) {
        return null;
    }

    @Override
    public EntityResponse.Builder hint(String key, Object value) {
        return null;
    }

    @Override
    public Mono<EntityResponse> build() {
        return null;
    }
}
