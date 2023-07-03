using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.application.Dto;
using WebApi.application.Interface;
using WebApi.Domain.Core.Interface.Service;
using WebApi.Infrastructure.CrossCutting.Adapter.Interface;

namespace WebApi.application.Service
{
    public class ProductApplicationService : IProductApplicationService
    {
        private readonly IProductDomainService _productDomainService;
        private readonly IProductMapper _productMapper;

        public ProductApplicationService(IProductDomainService productDomainService, IProductMapper productMapper)
        {
            _productDomainService = productDomainService;
            _productMapper = productMapper;
        }

        public void Add(ProductDto obj)
        {
            var objProduct = _productMapper.MapperToEntity(obj);

            _productDomainService.Add(objProduct);
        }

        public void Dispose()
        {
            _productDomainService.Dispose();
        }

        public IEnumerable<ProductDto> GetAll()
        {
            var objProducts = _productDomainService.GetAll();

            return _productMapper.MapperListProdutos(objProducts);
        }

        public ProductDto GetById(int id)
        {
            var objProduct = _productDomainService.GetById(id);

            return _productMapper.MapperToDTO(objProduct);
        }

        public void Remove(ProductDto obj)
        {
            var objProduct = _productMapper.MapperToEntity(obj);

            _productDomainService.Remove(objProduct);
        }

        public void Update(ProductDto obj)
        {
            var objProduct = _productMapper.MapperToEntity(obj);

            _productDomainService.Update(objProduct);
        }
    }
}
