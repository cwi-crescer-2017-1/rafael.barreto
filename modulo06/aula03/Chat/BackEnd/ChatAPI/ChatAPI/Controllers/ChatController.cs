using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ChatAPI.Controllers
{  

    public class ChatController : ApiController
    {
        private static List<string> listaMensagens = new List<string>();

        public List<String> BuscarMenssagens()
        {
            return listaMensagens;
        }

        public void inserirMensagemn(string menssagen)
        {
            listaMensagens.Add(menssagen);
        }
    }
}
