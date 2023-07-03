using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.application.Dto;
using WebApi.Domain.Model;

namespace WebApi.Infrastructure.CrossCutting.Adapter.Interface
{
    public interface IProductMapper
    {
        Product MapperToEntity(ProductDto produtoDTO);
        IEnumerable<ProductDto> MapperListProdutos(IEnumerable<Product> clientes);

        ProductDto MapperToDTO(Product produto);

    }
}
