package br.com.fiap.mp.controller;
import br.com.fiap.mp.model.entity.Pedido;
import br.com.fiap.mp.model.entity.StatusPedido;
import br.com.fiap.mp.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController{
  @Autowired
  private PedidoRepository pedidoRepository;
  
  @GetMapping
  public ModelAndView home(){
    List<Pedido> pedidos = pedidoRepository.findAll();
    ModelAndView mv = new ModelAndView("home");
    mv.addObject("pedidos",pedidos);
    return mv;
  }

  @GetMapping("/{status}")
  public ModelAndView porStatus(@PathVariable("status") String status){
    List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
    ModelAndView mv = new ModelAndView("home");
    mv.addObject("pedidos", pedidos);
    mv.addObject("status",status);
    return mv;
  }
  @ExceptionHandler(IllegalAccessException.class)
  public ModelAndView onError(){
    ModelAndView mv = new ModelAndView("redirect:/home");
    return mv;
  }
}
