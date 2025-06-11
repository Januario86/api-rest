//package org.fj.minhaapi.rest.filter;
//
//import org.fj.minhaapi.model.Usuario;
//import org.fj.minhaapi.service.UsuarioService;
//import org.fj.minhaapi.utils.TokenUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.annotation.Priority;
//import javax.ws.rs.Priorities;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.container.ResourceInfo;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.HttpHeaders;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.Provider;
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.Collections;
//import java.util.Map;
//import java.util.Set;
//
//@Provider
//@Priority(Priorities.AUTHORIZATION)
//public class AuthFilter implements ContainerRequestFilter {
//
//    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);
//
//    @Context
//    private ResourceInfo resourceInfo;
//
//    public void filter(ContainerRequestContext requestContext) {
//
//        Class<?> resourceClass = resourceInfo.getResourceClass();
//        Method resourceMethod = resourceInfo.getResourceMethod();
//
//        Usuario usuario = services().getUsuarioLogado();
//        if (precisaAutorizacao(resourceClass, resourceMethod)) {
//            try {
//                Map<DicionarioEnum, Set<PermissaoEnum>> acessos = extractAcesso(resourceMethod, getTipoPermissao(requestContext.getMethod()));
//
//                if (acessos.isEmpty()) {
//                    Set<DicionarioEnum> dicionarios = extractDicionario(resourceClass, resourceMethod);
//                    Set<PermissaoEnum> permissoes = extractPermissao(resourceMethod, requestContext.getMethod());
//                    for (DicionarioEnum dic : dicionarios) {
//                        acessos.put(dic, permissoes);
//                    }
//                }
//
//                if (services().permissao()
//                        .pesquisarStream(new Permissao(usuario.getPerfil(), null, TipoPermissaoEnum.DICIONARIO))
//                        .noneMatch(p -> acessos.getOrDefault(p.getDicionario(), Collections.emptySet())
//                                .stream()
//                                .anyMatch(a -> a.getFilter().test(p)))) {
//                    requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).entity("Você não tem permissão para relizar essa ação.").build());
//                }
//            } catch (Exception e) {
//                logger.error("Erro ao buscar permissoes de acesso para usuario {}, path {}", usuario.getCodigo(), requestContext.getUriInfo().getPath(), e);
//                requestContext.abortWith(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
//            }
//        }
//    }
//
//    private ServiceFactory services() {
//        return SpringApplicationContext.getServiceFactory();
//    }
//
//    @Override
//    public void filter(ContainerRequestContext requestContext) throws IOException {
//        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
//        //Usuario usuario = usuarioService.login()
//        //Usuario usuario = services().getUsuarioLogado();
//
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
//            return;
//        }
//
//        String token = authHeader.substring("Bearer ".length());
//        String username = TokenUtil.validateToken(token);
//
//        if (username == null) {
//            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
//        }
//    }
//}
