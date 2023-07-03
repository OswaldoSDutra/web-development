using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.application.Dto;
using WebApi.application.Interface;
using WebApi.Domain.Core.Interface.Service;
using WebApi.Infrastructure.CrossCutting.Adapter.Interface;

namespace WebApi.application.Service
{
    public class ClientApplicationService : IClientApplicationService
    {
        private readonly IClientDomainService _serviceClient;
        private readonly IClientMapper _mapperClient;

        public ClientApplicationService(IClientDomainService serviceClient, IClientMapper mapperClient)
        {
            _serviceClient = serviceClient;
            _mapperClient = mapperClient;
        }   

        public void Add(ClientDto obj)
        {
            var objClient = _mapperClient.MapperToEntity(obj);
            
            _serviceClient.Add(objClient);
        }

        public void Dispose()
        {
            _serviceClient.Dispose();
        }

        public IEnumerable<ClientDto> GetAll()
        {
            var objClients = _serviceClient.GetAll();

            return _mapperClient.MapperListClientes(objClients);
        }

        public ClientDto GetById(int id)
        {
            var objClient = _serviceClient.GetById(id);

            return _mapperClient.MapperToDTO(objClient);
        }

        public void Remove(ClientDto obj)
        {
            var objClient = _mapperClient.MapperToEntity(obj);

            _serviceClient.Remove(objClient);
        }

        public void Update(ClientDto obj)
        {
            var objClient = _mapperClient.MapperToEntity(obj);

            _serviceClient.Update(objClient);
        }
    }
}
