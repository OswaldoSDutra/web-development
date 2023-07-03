using Autofac;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WebApi.Infrastructure.CrossCutting.IoC
{
    public class DependencyModule : Module
    {
        protected override void Load(ContainerBuilder builder)
        {
            DependencyConfig.Load(builder);
        }
    }
}
