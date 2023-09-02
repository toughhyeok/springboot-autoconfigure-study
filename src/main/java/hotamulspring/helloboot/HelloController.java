package hotamulspring.helloboot;

public class HelloController {
    public String hello(String name) {
        SimpleHelloService helloService = new SimpleHelloService();
        return helloService.sayHello(name);
    }
}
