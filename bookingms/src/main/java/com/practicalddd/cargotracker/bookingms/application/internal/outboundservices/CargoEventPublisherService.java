package com.practicalddd.cargotracker.bookingms.application.internal.outboundservices;

import com.practicalddd.cargotracker.bookingms.infrastructure.brokers.rabbitmq.CargoEventSource;
import com.practicalddd.cargotracker.shareddomain.events.CargoBookedEvent;
import com.practicalddd.cargotracker.shareddomain.events.CargoRoutedEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 绑定消息通道，并对事件进行监听处理
 */
@Service
@EnableBinding(CargoEventSource.class)
public class CargoEventPublisherService {

    CargoEventSource cargoEventSource;

    public CargoEventPublisherService(CargoEventSource cargoEventSource){
        this.cargoEventSource = cargoEventSource;
    }

    // 声明对事件的监听处理
    @TransactionalEventListener
    public void handleCargoBookedEvent(CargoBookedEvent cargoBookedEvent){
        try {
            System.out.println("****"+cargoBookedEvent);
            System.out.println("****"+cargoBookedEvent.getCargoBookedEventData());
            cargoEventSource.cargoBooking().send(MessageBuilder.withPayload(cargoBookedEvent).build());
            System.out.println("Sent message ...");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @TransactionalEventListener
    public void handleCargoRoutedEvent(CargoRoutedEvent cargoRoutedEvent){
        cargoEventSource.cargoRouting().send(MessageBuilder.withPayload(cargoRoutedEvent).build());
    }
}
