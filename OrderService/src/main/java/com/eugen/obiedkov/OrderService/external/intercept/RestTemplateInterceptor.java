package com.eugen.obiedkov.OrderService.external.intercept;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import java.io.IOException;

@AllArgsConstructor
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    private final OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add("Authorization",
                "Bearer " +
                        oAuth2AuthorizedClientManager
                                .authorize(OAuth2AuthorizeRequest
                                        .withClientRegistrationId("internal-client")
                                        .principal("internal")
                                        .build())
                                .getAccessToken().getTokenValue());

        return execution.execute(request, body);
    }
}
