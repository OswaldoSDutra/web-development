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
    public class ProductDomainService : BaseDomainService<Product>, IProductDomainService
    {
        private readonly IProductRepository _productRepository;
        public ProductDomainService(IProductRepository productRepository) 
            :base(productRepository)
        {
            _productRepository = productRepository;
        }
    }
}
