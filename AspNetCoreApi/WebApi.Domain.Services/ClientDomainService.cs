using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.Domain.Core.Interface.Repository;
using WebApi.Domain.Core.Interface.Service;
using WebApi.Domain.Model;

namespace WebApi.Domain.Services
{
    public class ClientDomainService : BaseDomainService<Client>, IClientDomainService
    {
        private readonly IClientRepository _clientRepository;   
        
        public ClientDomainService(IClientRepository clientRepository) 
            : base(clientRepository) 
        {

            _clientRepository = clientRepository;
        }

        public override void Add(Client obj) { 
         
            obj.RegistrationDate = DateTime.Now;

            base.Add(obj);
        }

    }
}
