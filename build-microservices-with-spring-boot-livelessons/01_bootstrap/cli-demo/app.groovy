@RestController
public class Application {

    @RequestMapping('/')
    def String hello() {
        return 'Hello World!'
    }
}