package gfg.restapis.demorestapi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ImageController {

    @GetMapping(value = "/image",produces = {MediaType.IMAGE_JPEG_VALUE})
    public byte[] getImage(@RequestParam(value = "id",required = false) Integer id,
                           @RequestParam(value = "length",required = false) Integer length,
                           @RequestParam(value = "bredth",required = false) Integer breadth){
        RestTemplate restTemplate=new RestTemplate();
        String url="https://picsum.photos/id/"+id+"/"+length+"/"+breadth;
        return restTemplate.getForObject(url,byte[].class);

    }
}
