using ExemploWebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    public class HeroisController : ApiController
    {

        private static List<Heroi> ListaHeroi = new List<Heroi>();
        private static int id = 0;

        public IEnumerable<Heroi> Get( int? id = null)
        {         
            return ListaHeroi;          
        }

        public IHttpActionResult Post(Heroi heroi)
        {            
            ListaHeroi.Add(heroi);
            heroi.Id = ++id;
            return Ok("Herois Cadastrado");            
        }

    }
}
