package com.jeanlucasbs.proposta_app.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    //Fila que referencia uma proposta pendente
    @Bean
    public Queue criarFilaPropostaPendenteMsAnaliseCredito(){
        return QueueBuilder.durable("proposta-pendente.ms-proposta").build();
    }

    //Fila que consume uma notificação para envio do consumer para notifica-lo da resposta daquela mensagem
    @Bean
    public Queue criarFilaPropostaPendenteMsNotificao(){
        return QueueBuilder.durable("proposta-pendente.ms-notificacao").build();
    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsProposta(){
        return QueueBuilder.durable("proposta-concluida.ms-proposta").build();
    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsNotificao() {
        return QueueBuilder.durable("proposta-concluida.ms-notificacao").build();
    }

    @Bean
    public RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializarAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }

    //Criar a exchange. Vai ser a mesma para os bindings
//    @Bean
//    public FanoutExchange criarFanoutExchangePropostaPendente(){
//        return ExchangeBuilder.fanoutExchange("proposta-pendente.ex").build();
//    }

//    @Bean
//    public Binding criarBindingPrpostaPendenteMSAnaliseCredito(){
//        return BindingBuilder.bind(criarFilaPropostaPendenteMsAnaliseCredito()).to(criarFanoutExchangePropostaPendente());
//    }
//
//    @Bean
//    public Binding criarBindingPropostaPendenteMSNotificacao(){
//        return BindingBuilder.bind(criarFilaPropostaPendenteMsNotificao()).to(criarFanoutExchangePropostaPendente());
//    }

}
