package com.faboda.vehicletracker.config;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SocketIORunner implements CommandLineRunner {
    private final SocketIOServer socketIOServer;

    @Override
    public void run(String... args) throws Exception {
       try {
            socketIOServer.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
