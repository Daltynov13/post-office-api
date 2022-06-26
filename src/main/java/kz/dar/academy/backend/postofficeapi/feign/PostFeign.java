package kz.dar.academy.backend.postofficeapi.feign;

import java.util.List;
import kz.dar.academy.backend.postofficeapi.model.PostModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("post-core-api")
public interface PostFeign {


  @GetMapping("/post/check")
  String checkPost();

  @GetMapping("/post/all")
  List<PostModel> getAllPosts();

  @GetMapping("/post/{postId}")
  PostModel getPostById(@PathVariable String postId);
}
