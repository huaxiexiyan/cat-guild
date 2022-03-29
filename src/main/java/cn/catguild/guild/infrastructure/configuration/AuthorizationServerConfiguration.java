//package cn.catguild.butler.infrastructure.configuration;
//
///*
// * Copyright 2020-2021 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      https://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//import java.util.UUID;
//
//import cn.catguild.butler.auth.jose.Jwks;
//import com.nimbusds.jose.jwk.JWKSet;
//import com.nimbusds.jose.jwk.RSAKey;
//import com.nimbusds.jose.jwk.source.JWKSource;
//import com.nimbusds.jose.proc.SecurityContext;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.security.oauth2.core.oidc.OidcScopes;
//import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationConsentService;
//import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
//import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
//import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
//import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
//import org.springframework.security.oauth2.server.authorization.config.ClientSettings;
//import org.springframework.security.oauth2.server.authorization.config.ProviderSettings;
//import org.springframework.security.web.SecurityFilterChain;
//
///**
// * Spring Security OAuth2 授权服务器配置
// * <p>
// * 在该配置中，设置了授权服务Endpoint的相关信息（端点的位置、请求方法、使用怎样的令牌、支持怎样的客户端）
// * 以及针对OAuth2的密码模式所需要的用户身份认证服务和用户详情查询服务
// *
// * @author Joe Grandja
// * @since 0.0.1
// */
//@Configuration(proxyBeanMethods = false)
//public class AuthorizationServerConfiguration  {
//
//	/**
//	 * 配置授权服务器的安全策略
//	 *
//	 * @param http
//	 * @return
//	 * @throws Exception
//	 */
//	@Bean
//	@Order(Ordered.HIGHEST_PRECEDENCE)
//	public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
//		OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
//		return http.formLogin(Customizer.withDefaults()).build();
//	}
//
//	/**
//	 * 注册客户端信息
//	 *
//	 * @param jdbcTemplate
//	 * @return
//	 */
//	// @formatter:off
//	@Bean
//	public RegisteredClientRepository registeredClientRepository(JdbcTemplate jdbcTemplate) {
//		RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
//			.clientId("messaging-client")
//			.clientSecret("{noop}secret")
//			.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//			.authorizationGrantTypes((set)->{
//				set.add(AuthorizationGrantType.AUTHORIZATION_CODE);
//				set.add(AuthorizationGrantType.PASSWORD);
//				set.add(AuthorizationGrantType.REFRESH_TOKEN);
//				set.add(AuthorizationGrantType.CLIENT_CREDENTIALS);
//			})
//			//.redirectUri("http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc")
//			//.redirectUri("http://127.0.0.1:8080/authorized")
//			.redirectUri("http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc")
//			.redirectUri("http://www.baidu.com")
//			.scope(OidcScopes.OPENID)
//			.scope("message.read")
//			.scope("message.write")
//			.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//			.build();
//
//		// Save registered client in db as if in-memory
//		JdbcRegisteredClientRepository registeredClientRepository = new JdbcRegisteredClientRepository(jdbcTemplate);
//		registeredClientRepository.save(registeredClient);
//
//		return registeredClientRepository;
//	}
//	// @formatter:on
//
//	@Bean
//	public OAuth2AuthorizationService authorizationService(JdbcTemplate jdbcTemplate, RegisteredClientRepository registeredClientRepository) {
//		return new JdbcOAuth2AuthorizationService(jdbcTemplate, registeredClientRepository);
//	}
//
//	@Bean
//	public OAuth2AuthorizationConsentService authorizationConsentService(JdbcTemplate jdbcTemplate, RegisteredClientRepository registeredClientRepository) {
//		return new JdbcOAuth2AuthorizationConsentService(jdbcTemplate, registeredClientRepository);
//	}
//
//	@Bean
//	public JWKSource<SecurityContext> jwkSource() {
//		RSAKey rsaKey = Jwks.generateRsa();
//		JWKSet jwkSet = new JWKSet(rsaKey);
//		return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
//	}
//
//	@Bean
//	public ProviderSettings providerSettings() {
//		return ProviderSettings.builder().issuer("http://auth-server:9000").build();
//	}
//
//	//@Bean
//	//public EmbeddedDatabase embeddedDatabase() {
//	//	// @formatter:off
//	//	return new EmbeddedDatabaseBuilder()
//	//		.generateUniqueName(true)
//	//		.setType(EmbeddedDatabaseType.H2)
//	//		.setName("test")
//	//		.setScriptEncoding("UTF-8")
//	//		.addScript("org/springframework/security/oauth2/server/authorization/oauth2-authorization-schema.sql")
//	//		.addScript("org/springframework/security/oauth2/server/authorization/oauth2-authorization-consent-schema.sql")
//	//		.addScript("org/springframework/security/oauth2/server/authorization/client/oauth2-registered-client-schema.sql")
//	//		.build();
//	//	// @formatter:on
//	//}
//
//}
