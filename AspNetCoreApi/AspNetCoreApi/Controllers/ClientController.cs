using Microsoft.AspNetCore.Mvc;
using WebApi.application.Dto;
using WebApi.application.Interface;

namespace AspNetCoreApi.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class ClientController : ControllerBase
    {
        private readonly IClientApplicationService _clientApplicationService;

        public ClientController(IClientApplicationService clientApplicationService)
        {
            _clientApplicationService = clientApplicationService;
        }

        [HttpGet]
        public ActionResult<IEnumerable<string>> Get()
        {
            return Ok(_clientApplicationService.GetAll());
        }

        [HttpPost]
        public ActionResult Post([FromBody] ClientDto clienteDTO)
        {
            try
            {
                if (clienteDTO == null)
                    return NotFound();

                _clientApplicationService.Add(clienteDTO);

                return Ok("Cliente Cadastrado com sucesso!");
            }
            catch (Exception ex)
            {
                throw ex;
            }

        }
    }
}
