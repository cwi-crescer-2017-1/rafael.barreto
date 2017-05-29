using ChatAPI.Models;
using System.Text.RegularExpressions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;


namespace ChatAPI.Controllers
{  

    public class MensagemController : ApiController
    {
        private static Object mensagemLock = new object();
        private static List<Mensagem> listaMensagens = new List<Mensagem>();
        private static int contador = 1;

        public List<Mensagem> Get()
        {
            return listaMensagens;
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            lock (mensagemLock) {
                mensagem.Mensagen = mensagem.Mensagen.Replace("andre nunes","$$$$$ $$$$$");                
                listaMensagens.Add(mensagem);                
                return Ok("cadastrado com sucesso");
            }
        }
    }
}
