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
    public class ProdutcRepository : BaseRepository<Product>, IProductRepository
    {
        public ProdutcRepository(SqlContext sqlContext) : base(sqlContext)
        {

        }
    }
}
