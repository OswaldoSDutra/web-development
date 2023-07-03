using Autofac;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebApi.application.Interface;
using WebApi.application.Service;
using WebApi.Domain.Core.Interface.Repository;
using WebApi.Domain.Core.Interface.Service;
using WebApi.Domain.Services;
using WebApi.Infrastructure.CrossCutting.Adapter.Interface;
using WebApi.Infrastructure.CrossCutting.Adapter.Mapper;
using WebApi.Infrastructure.Repository;

namespace WebApi.Infrastructure.CrossCutting.IoC
{
    public class DependencyConfig
    {
        public static void Load(ContainerBuilder builder)
        {
            builder.RegisterType<ClientApplicationService>().As<IClientApplicationService> ();
            builder.RegisterType<ProductApplicationService>().As<IProductApplicationService>();

            builder.RegisterType<ClientDomainService>().As<IClientDomainService>();
            builder.RegisterType<ProductDomainService>().As<IProductDomainService>();

            builder.RegisterType<ClientRepository>().As<IClientRepository>();
            builder.RegisterType<ProdutcRepository>().As<IProductRepository>();

            builder.RegisterType<ClientMapper>().As<IClientMapper>();
            builder.RegisterType<ProductMapper>().As<IProductMapper>();
        }
    }
}
