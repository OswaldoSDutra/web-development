using AspNetCoreApi.Controllers;
using FluentAssertions;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Moq;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TestApi.Data;
using WebApi.application.Interface;
using Xunit;

namespace TestApi.Controller.unit
{
    public class ClientControllerTest
    {
        [Fact]
        public void Should_Call_IClientApplicationService_GetAll()
        {
            //Arrange
            var clientService = new Mock<IClientApplicationService>();

            clientService.Setup(s => s.GetAll()).Returns(ClientData.GetClients());

            var sut = new ClientController(clientService.Object);

            //Act
            var result = (OkObjectResult)sut.Get().Result;


            //Assert
            result.StatusCode.Should().Be(200);
        }
        public void Should_Call_IClientApplicationService_Add()
        {
            //Arrange
            var clientService = new Mock<IClientApplicationService>();
            var newClient = ClientData.GetClient();

            var sut = new ClientController(clientService.Object);

            //Act
            var result = (OkObjectResult)sut.Post(newClient);

            //Assert
            clientService.Verify(s => s.Add(newClient), Times.Exactly(1));
        }     

    }
}
