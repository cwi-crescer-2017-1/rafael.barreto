﻿using Locadora.Dominio;
using Locadora.infraestrutura.Repositorio;
using System;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Security.Principal;
using System.Text;
using System.Threading;
using System.Web;
using System.Web.Http;
using System.Web.Http.Controllers;

namespace Locadora.api
{
    public class BasicAuthorization : AuthorizeAttribute
    {
        readonly UsuarioRepositorio _usuarioRepositorio;

        public BasicAuthorization()
        {
            _usuarioRepositorio = new UsuarioRepositorio();
        }

        public override void OnAuthorization(HttpActionContext actionContext)
        {
            // validar se foi informado no cabeçalho da mensagem o parâmetro de autenticação.
            if (actionContext.Request.Headers.Authorization == null)
            {
                // responde para o cliente como não autorizado
                var dnsHost = actionContext.Request.RequestUri.DnsSafeHost;
                actionContext.Response = actionContext.Request.CreateResponse(HttpStatusCode.Unauthorized);
                actionContext.Response.Headers.Add("WWW-Authenticate", string.Format("Basic realm=\"{0}\"", dnsHost));
                return;
            }
            else
            {
                //obtém o parâmetro (token de autenticação)
                string tokenAutenticacao =
                    actionContext.Request.Headers.Authorization.Parameter;

                // decodifica o parâmetro, pois ele deve vir codificado em base 64
                string decodedTokenAutenticacao =
                    Encoding.Default.GetString(Convert.FromBase64String(tokenAutenticacao));

                // obtém o login e senha (usuario:senha)
                string[] userNameAndPassword = decodedTokenAutenticacao.Split(':');

                // validar as credenciais obtidas com as cadastradas no sistema
                Usuario usuario = null;
                if (ValidarUsuario(userNameAndPassword[0], userNameAndPassword[1], out usuario))
                {
                    
                    var identidade = new GenericIdentity(usuario.Nome);
                    var genericUser = new GenericPrincipal(identidade, new[] {usuario.Gerente ? "Gerente" : "Usuario"});

                    // confere o perfil da action com os do usuário
                    if (string.IsNullOrEmpty(Roles))
                    {
                        // atribui o usuário informado no contexto da requisição atual
                        Thread.CurrentPrincipal = genericUser;
                        if (HttpContext.Current != null)
                            HttpContext.Current.User = genericUser;

                        return;
                    }
                    else
                    {
                        var currentRoles = Roles.Split(',');
                        foreach (var currentRole in currentRoles)
                        {
                            if (genericUser.IsInRole(currentRole))
                            {
                                // atribui o usuário informado no contexto da requisição atual
                                Thread.CurrentPrincipal = genericUser;
                                if (HttpContext.Current != null)
                                    HttpContext.Current.User = genericUser;

                                return;
                            }
                        }
                    }
                }
            }

            actionContext.Response =
                actionContext.Request.CreateResponse(HttpStatusCode.Unauthorized, new { mensagens = new string[] { "Usuário ou senha inválidos." } });
        }

        private bool ValidarUsuario(string login, string senha, out Usuario usuarioRetorno)
        {
            usuarioRetorno = null;

            var usuario = _usuarioRepositorio.Obter(login);

            if (usuario != null && usuario.Senha == senha)
                usuarioRetorno = usuario;
            else
                usuario = null;
            return usuario != null;
        }
    }
}