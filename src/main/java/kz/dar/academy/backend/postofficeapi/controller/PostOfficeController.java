package kz.dar.academy.backend.postofficeapi.controller;

import java.util.List;
import kz.dar.academy.backend.postofficeapi.feign.ClientFeign;
import kz.dar.academy.backend.postofficeapi.feign.PostFeign;
import kz.dar.academy.backend.postofficeapi.model.ClientModel;
import kz.dar.academy.backend.postofficeapi.model.ClientResponse;
import kz.dar.academy.backend.postofficeapi.model.PostModel;
import kz.dar.academy.backend.postofficeapi.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post-office")
public class PostOfficeController {

  @Autowired
  private ClientFeign clientFeign;

  @Autowired
  private PostFeign postFeign;

  @GetMapping("check")
  public String checkPostOffice() {
    return "Post office is WORKING";
  }

  @GetMapping("/client/check")
  public String checkClient() {
    return clientFeign.checkClient();
  }

  @GetMapping("/post/check")
  public String checkPost() {
    return postFeign.checkPost();
  }

  @GetMapping("/post/all")
  public List<PostModel> getAllPosts() {
    return postFeign.getAllPosts();
  }

  @GetMapping("/post/{postId}")
  public PostModel getPostById(@PathVariable String postId) {
    return postFeign.getPostById(postId);
  }

  @GetMapping("/client/all")
  public List<ClientModel> getAllClients() {
    return clientFeign.getAllClients();
  }

  @GetMapping("/client/{clientId}")
  public ClientModel getClientById(@PathVariable String clientId) {
    return clientFeign.getClientById(clientId);
  }

  @GetMapping("/post-details/{postId}")
  public PostResponse getPostDetailsById(@PathVariable String postId) {
    PostModel post = postFeign.getPostById(postId);
    ClientModel client = clientFeign.getClientById(post.getClientId());
    ClientModel postRecipient = clientFeign.getClientById(post.getPostRecipientId());
    return new PostResponse(post, client, postRecipient);
  }
}
