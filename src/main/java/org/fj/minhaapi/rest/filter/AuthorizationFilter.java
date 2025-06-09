//package org.fj.minhaapi.rest.filter;
//
//import br.com.metaway.mentor.enums.DicionarioEnum;
//import br.com.metaway.mentor.enums.PermissaoEnum;
//import br.com.metaway.mentor.enums.TipoPermissaoEnum;
//import br.com.metaway.mentor.filtro.SpringApplicationContext;
//import br.com.metaway.mentor.modelo.dto.Usuario;
//import br.com.metaway.mentor.modelo.dto.permissao.Permissao;
//import br.com.metaway.mentor.rest.annotation.Acesso;
//import br.com.metaway.mentor.rest.annotation.Operacao;
//import br.com.metaway.mentor.rest.annotation.Seguro;
//import br.com.metaway.mentor.rest.annotation.SeguroOperacao;
//import br.com.metaway.mentor.service.base.ServiceFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.annotation.Priority;
//import javax.ws.rs.Priorities;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.container.ResourceInfo;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.Provider;
//import java.lang.reflect.AnnotatedElement;
//import java.lang.reflect.Method;
//import java.util.*;
//
//@Provider
//@Priority(Priorities.AUTHORIZATION)
//public class AuthorizationFilter implements ContainerRequestFilter {
//
//	private static final Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class);
//
//	@Context
//	private ResourceInfo resourceInfo;
//
//	@Override
//	public void filter(ContainerRequestContext requestContext) {
//		// Recupera o resource class vinculado com a URL requisitada
//		Class<?> resourceClass = resourceInfo.getResourceClass();
//		// Recuperando anotacoes declaradas no metodo
//		Method resourceMethod = resourceInfo.getResourceMethod();
//		Usuario usuario = services().getUsuarioLogado();
//		if (precisaAutorizacao(resourceClass, resourceMethod)) {
//			try {
//				Map<DicionarioEnum, Set<PermissaoEnum>> acessos = extractAcesso(resourceMethod, getTipoPermissao(requestContext.getMethod()));
//
//				if (acessos.isEmpty()) {
//					Set<DicionarioEnum> dicionarios = extractDicionario(resourceClass, resourceMethod);
//					Set<PermissaoEnum> permissoes = extractPermissao(resourceMethod, requestContext.getMethod());
//					for (DicionarioEnum dic : dicionarios) {
//						acessos.put(dic, permissoes);
//					}
//				}
//
//				if (services().permissao()
//				              .pesquisarStream(new Permissao(usuario.getPerfil(), null, TipoPermissaoEnum.DICIONARIO))
//				              .noneMatch(p -> acessos.getOrDefault(p.getDicionario(), Collections.emptySet())
//				                                     .stream()
//				                                     .anyMatch(a -> a.getFilter().test(p)))) {
//					requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).entity("Você não tem permissão para relizar essa ação.").build());
//				}
//			} catch (Exception e) {
//				logger.error("Erro ao buscar permissoes de acesso para usuario {}, path {}", usuario.getCodigo(), requestContext.getUriInfo().getPath(), e);
//				requestContext.abortWith(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
//			}
//		}
//	}
//
//	private ServiceFactory services() {
//		return SpringApplicationContext.getServiceFactory();
//	}
//
//	private boolean precisaAutorizacao(AnnotatedElement clazzElement, AnnotatedElement methodElement) {
//		return (clazzElement != null && clazzElement.isAnnotationPresent(Seguro.class))
//				|| (methodElement != null && (methodElement.isAnnotationPresent(Seguro.class) || methodElement.isAnnotationPresent(SeguroOperacao.class)));
//	}
//
//	private Map<DicionarioEnum, Set<PermissaoEnum>> extractAcesso(AnnotatedElement methodElement, PermissaoEnum padrao) {
//		Map<DicionarioEnum, Set<PermissaoEnum>> retorno = new HashMap<>();
//		if (methodElement != null && methodElement.isAnnotationPresent(SeguroOperacao.class)) {
//			for (Acesso acesso : methodElement.getAnnotation(SeguroOperacao.class).value()) {
//				Set<PermissaoEnum> operacoes = new HashSet<>();
//				if (acesso.operacoes().length > 0) {
//					Collections.addAll(operacoes, acesso.operacoes());
//				} else {
//					operacoes.add(padrao);
//				}
//				retorno.put(acesso.value(), operacoes);
//			}
//		}
//		return retorno;
//	}
//
//	private Set<DicionarioEnum> extractDicionario(AnnotatedElement clazzElement, AnnotatedElement methodElement) {
//		Set<DicionarioEnum> retorno = new HashSet<>();
//		if (methodElement != null && methodElement.isAnnotationPresent(Seguro.class)) {
//			Collections.addAll(retorno, methodElement.getAnnotation(Seguro.class).value());
//		} else if (clazzElement != null && clazzElement.isAnnotationPresent(Seguro.class)) {
//			Collections.addAll(retorno, clazzElement.getAnnotation(Seguro.class).value());
//		}
//		return retorno;
//	}
//
//	private Set<PermissaoEnum> extractPermissao(AnnotatedElement methodElement, String HTTPVerb) {
//		Set<PermissaoEnum> retorno = new HashSet<>();
//		if (methodElement != null && methodElement.isAnnotationPresent(Operacao.class)) {
//			Collections.addAll(retorno, methodElement.getAnnotation(Operacao.class).value());
//		} else {
//			retorno.add(getTipoPermissao(HTTPVerb));
//		}
//		return retorno;
//	}
//
//	private static PermissaoEnum getTipoPermissao(String HTTPVerb) {
//		if (HTTPVerb.equalsIgnoreCase("GET")) {
//			return PermissaoEnum.VISUALIZAR;
//		} else if (HTTPVerb.equalsIgnoreCase("PUT")) {
//			return PermissaoEnum.ALTERAR;
//		} else if (HTTPVerb.equalsIgnoreCase("POST")) {
//			return PermissaoEnum.INSERIR;
//		} else if (HTTPVerb.equalsIgnoreCase("DELETE")) {
//			return PermissaoEnum.EXCLUIR;
//		} else {
//			return null;
//		}
//	}
//}
