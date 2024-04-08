# Vehicle Tracking System

This Spring Boot application provides a platform for tracking vehicles in real-time. It offers functionalities to manage vehicle information, monitor their locations, and analyze historical data. The system is designed to be scalable, efficient, and easy to integrate with existing fleet management solutions.

## Features

- **Vehicle Management**: Add, update, and delete vehicle information such as make, model, registration details, and ownership information.
- **Real-time Tracking**: Monitor the real-time location of vehicles on a map interface using WebSocket communication.
- **RESTful API**: Exposes a set of RESTful APIs for seamless integration with other systems and applications.

## Technologies Used

- **Spring Boot**: Provides a robust framework for building enterprise-level Java applications.
- **Socket IO**: Facilitates real-time communication between the server and clients for tracking updates.
- **JUnit/Mockito**: For unit and integration testing.
- **MongoDB**: A NoSQL database for storing vehicle information and tracking data.
- **Aspects**: For exception handling.
## Getting Started

1. **Clone the Repository**: `git clone https://github.com/https://github.com/mikechiloane/vehicle-tracker.git`
2. **Navigate to Project Directory**: `cd vehicle-tracker`
3. **Configure Database**: Replace the MONGODB_URI iin the application.properties file`.
4. **Build the Application**: `mvn clean install`
5. **Access the Application**: Open your web browser and go to `http://localhost:8080`.

## License

This project is licensed under the [MIT License](LICENSE).

## Support

For any inquiries or support, feel free to contact the project maintainers at [email@example.com](mailto:email@example.com).

