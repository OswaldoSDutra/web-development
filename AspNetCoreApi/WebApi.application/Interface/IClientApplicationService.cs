using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.application.Dto;

namespace WebApi.application.Interface
{
    public interface IClientApplicationService : IDisposable
    {
        void Add(ClientDto obj);

        ClientDto GetById(int id);

        IEnumerable<ClientDto> GetAll();

        void Update(ClientDto obj);

        void Remove(ClientDto obj);

    }
}
