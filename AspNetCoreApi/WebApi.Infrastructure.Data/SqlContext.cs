using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.Domain.Model;

namespace WebApi.Infrastructure.Data
{
    public class SqlContext : DbContext
    {
        DbSet<Client> Client { get; set; }

        DbSet<Product> Product { get; set; }

        public SqlContext(DbContextOptions<SqlContext> options) : base(options)
        {
                
        }
    }
}
