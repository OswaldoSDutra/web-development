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
    public class ProductMapper : IProductMapper
    {

        List<ProductDto> _products = new List<ProductDto>();  

        public IEnumerable<ProductDto> MapperListProdutos(IEnumerable<Product> produtos)
        {
            foreach (Product produto in produtos)
            {
                ProductDto productDto = new ProductDto()
                {
                    Id = produto.Id,
                    Name = produto.Name,
                    Price = produto.Price                    
                };

                _products.Add(productDto);
            }

            return _products;
        }

        public ProductDto MapperToDTO(Product produto)
        {
            ProductDto productDto = new ProductDto()
            {
                Id = produto.Id,
                Name = produto.Name,
                Price = produto.Price
            };

            return productDto;
        }

        public Product MapperToEntity(ProductDto produtoDTO)
        {
            Product product = new Product()
            {
                Id = produtoDTO.Id,
                Name = produtoDTO.Name,
                Price = produtoDTO.Price
            };

            return product;
        }
    }
}
