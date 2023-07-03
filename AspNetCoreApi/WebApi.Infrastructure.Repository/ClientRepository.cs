using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.Domain.Core.Interface.Repository;
using WebApi.Domain.Model;
using WebApi.Infrastructure.Data;

namespace WebApi.Infrastructure.Repository
{
    public class ClientRepository : BaseRepository<Client>, IClientRepository
    {
        public ClientRepository(SqlContext context) : base(context)
        {
        }
    }
}
