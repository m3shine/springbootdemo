import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class T{
    @RequestMapping("/")
    String home(){
        "Hello World!"
    }
}