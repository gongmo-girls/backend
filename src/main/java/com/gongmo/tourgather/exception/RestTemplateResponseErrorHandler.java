package com.gongmo.tourgather.exception;

import static com.gongmo.tourgather.exception.GlobalErrorCode.HTTP_CLIENT_ERROR;
import static com.gongmo.tourgather.exception.GlobalErrorCode.HTTP_SERVER_ERROR;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import lombok.extern.java.Log;

@Log
public class RestTemplateResponseErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {
        log.info(String.format("[외부 API 연동 실패] %s %s", httpResponse.getStatusCode(), httpResponse.getStatusText()));

        if (httpResponse.getStatusCode().is5xxServerError()) {
            throw new ApplicationException(HTTP_SERVER_ERROR);
        } else if (httpResponse.getStatusCode().is4xxClientError()) {
            throw new ApplicationException(HTTP_CLIENT_ERROR);
        }
    }
}
