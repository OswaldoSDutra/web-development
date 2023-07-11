using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.application.Dto;
using WebApi.Domain.Model;

namespace TestApi.Data
{
    public class ClientData
    {
        public static List<ClientDto> GetClients() {

            return new List<ClientDto>  {
             new ClientDto { Email = "client_a@emai.com", Id = 1, LastName = "a_last_name", Name= "A"  },
             new ClientDto { Email = "client_a@emai.com", Id = 2, LastName = "b_last_name", Name= "B"  }
            };
        }

        public static ClientDto GetClient()
        {
                return new ClientDto { Email = "client_a@emai.com", Id = 1, LastName = "a_last_name", Name = "A" };
        }
    }
}
