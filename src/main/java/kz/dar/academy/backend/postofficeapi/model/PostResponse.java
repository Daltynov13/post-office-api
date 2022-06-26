package kz.dar.academy.backend.postofficeapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponse {

  private String postId;
  private ClientResponse client;
  private ClientResponse receiver;
  private String postItem;
  private String status;

  public PostResponse(PostModel post, ClientModel client, ClientModel postRecipient) {
    this.postId = post.getPostId();
    this.postItem = post.getPostItem();
    this.client = ClientResponse.builder().name(client.getName()).surname(client.getSurname())
        .email(client.getEmail()).build();
    this.receiver = ClientResponse.builder().name(postRecipient.getName())
        .surname(postRecipient.getSurname()).email(postRecipient.getEmail()).build();
    this.status = post.getStatus();
  }
}
