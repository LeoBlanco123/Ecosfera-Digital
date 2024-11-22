package br.com.fiap.ecosfera.controller;

import br.com.fiap.ecosfera.mensageria.ProdutorRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class MensageriaRabbitController {

    @Autowired
    private ProdutorRabbit produtorRabbit;

    @Autowired
    private final MessageSource messageSource;

    public MensageriaRabbitController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @GetMapping("/retorna_pag_msg_rabbit")
    public String retonaPagMsgRabbit(Model model) {
        return "enviar_mensagem_rabbit";
    }

    @PostMapping("/enviar_mensagem_rabbit")
    public String enviarMensagemRabbit(@RequestParam("mensagem") String msg, Model model) {
        produtorRabbit.enviarMensagem(msg);
        model.addAttribute("mensagem", "Mensagem enviada com sucesso: " + msg);
        return "enviar_mensagem_rabbit";
    }
}
