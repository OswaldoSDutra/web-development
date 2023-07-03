using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.application.Dto;
using WebApi.Domain.Model;
using WebApi.Infrastructure.CrossCutting.Adapter.Interface;

namespace WebApi.Infrastructure.CrossCutting.Adapter.Mapper
{
    public class ClientMapper : IClientMapper
    {
        List<ClientDto> clienteDTOs = new List<ClientDto>();

        public IEnumerable<ClientDto> MapperListClientes(IEnumerable<Client> clientes)
        {
            foreach(Client client in clientes)
            {
                ClientDto clientDto = new ClientDto()
                {
                    Email = client.Email,
                    LastName = client.LastName,
                    Name = client.Name,
                    Id = client.Id
                };

                clienteDTOs.Add(clientDto);
            }

            return clienteDTOs;
        }

        public ClientDto MapperToDTO(Client Cliente)
        {
            ClientDto client = new ClientDto() { 
                Email = Cliente.Email,
                LastName = Cliente.LastName,
                Name = Cliente.Name,
                Id = Cliente.Id
            };

            return client;
        }

        public Client MapperToEntity(ClientDto clienteDTO)
        {
            Client client = new Client()
            {
                Email = clienteDTO.Email,
                LastName = clienteDTO.LastName,
                Name = clienteDTO.Name,
                Id = clienteDTO.Id
            };

            return client;
        }
    }
}
