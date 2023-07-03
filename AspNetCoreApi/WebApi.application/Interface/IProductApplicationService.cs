using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.application.Dto;

namespace WebApi.application.Interface
{
    public interface IProductApplicationService : IDisposable
    {
        void Add(ProductDto obj);

        ProductDto GetById(int id);

        IEnumerable<ProductDto> GetAll();

        void Update(ProductDto obj);

        void Remove(ProductDto obj);
    }
}
