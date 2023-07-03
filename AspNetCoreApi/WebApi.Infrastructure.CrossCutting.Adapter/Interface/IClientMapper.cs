using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.application.Dto;
using WebApi.Domain.Model;

namespace WebApi.Infrastructure.CrossCutting.Adapter.Interface
{
    public interface IClientMapper
    {
        Client MapperToEntity(ClientDto clienteDTO);

        IEnumerable<ClientDto> MapperListClientes(IEnumerable<Client> clientes);

        ClientDto MapperToDTO(Client Cliente);
    }
}
