package kz.dar.academy.backend.postofficeapi.feign;

import java.util.List;
import kz.dar.academy.backend.postofficeapi.model.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("client-core-api")
public interface ClientFeign {

  @GetMapping("/client/check")
  String checkClient();

  @GetMapping("/client/all")
  List<ClientModel> getAllClients();

  @GetMapping("/client/{clientId}")
  ClientModel getClientById(@PathVariable String clientId);
}
