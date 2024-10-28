![Gym Management Logo](https://static.vecteezy.com/system/resources/previews/018/795/372/original/fitness-and-gym-logo-free-png.png)

# Aplicación de Gestión de Gimnasio 💪🏋️

Esta es una aplicación para gestionar las actividades y perfiles de un gimnasio, enfocándose en entrenadores, aprendices y sus entrenamientos. La aplicación utiliza una arquitectura de microservicios para separar la gestión de usuarios y la gestión de actividades, garantizando escalabilidad y facilidad de mantenimiento.

## Características Principales

- **Registro y Gestión de Entrenadores y Aprendices**: La aplicación permite registrar y modificar los perfiles de los entrenadores y aprendices, así como la asociación de cada aprendiz con un entrenador.
- **Registro de Actividades de Entrenamiento**: Los aprendices pueden registrar sus entrenamientos especificando la categoría, tiempo dedicado y entrenador correspondiente.
- **Reporte Mensual de Actividades**: Generación de reportes mensuales de actividades de los aprendices, detallando sus entrenamientos semana a semana.

## Requisitos Funcionales

### 1. Registro de Entrenadores y Aprendices
- **Entrenador**:
    - ID: Identificador único.
    - Nombre, correo electrónico, contraseña.
    - Especialidad, experiencia, certificaciones.
- **Aprendiz**:
    - ID: Identificador único.
    - Nombre, correo electrónico, contraseña.
    - Fecha de nacimiento, género, objetivo de entrenamiento, nivel de condición física.
    - Entrenador asociado.

### 2. Registro de Actividades de Entrenamiento
- Categorías de entrenamiento: Tren Superior, Pierna y Cardio.
- Registro de tiempo dedicado y entrenador correspondiente.

## Arquitectura de Microservicios

1. **Microservicio Principal** (base de datos relacional)
    - Gestión de perfiles de entrenadores y aprendices.
    - Administración de contraseñas y acceso.
    - Registro de actividades de entrenamiento.
    - Generación de reportes mensuales comunicándose con el Microservicio de Actividades.

2. **Microservicio de Actividades** (base de datos no relacional - MongoDB)
    - Registro de actividades de entrenamiento con detalles de fecha, tipo de entrenamiento y duración.
    - Generación de reportes de actividades para cada aprendiz.

## Tecnologías Utilizadas

- **Backend**: Java, Spring Framework (Spring Boot, Spring Security)
   
  <img src="https://vectorseek.com/wp-content/uploads/2023/09/Spring-Logo-Vector.svg-.png" alt="Backend logo" width="60"/>

- **Bases de Datos**: MySQL (Microservicio Principal), MongoDB (Microservicio de Actividades)  

  <img src="https://cdn-icons-png.flaticon.com/512/919/919836.png" alt="MySQL logo" width="60"/>

- **Autenticación**: JWT para gestión de usuarios en el Microservicio Principal  

  <img src="https://byte-mind.net/wp-content/uploads/2022/02/JWT.jpg" alt="JWT logo" width="60"/>

- **Documentación**: Swagger para la documentación de la API REST  

  <img src="https://www.aurigait.com/wp-content/uploads/2023/01/pasted-image-0.png" alt="Documentación logo" width="70"/>

- **Pruebas**: Creación de pruebas unitarias y de integración  

  <img src="https://scontent.feoh6-1.fna.fbcdn.net/v/t1.6435-9/170326123_289022702599572_7782433131700673715_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=833d8c&_nc_ohc=vOKhm8LsbiAQ7kNvgH53sl8&_nc_zt=23&_nc_ht=scontent.feoh6-1.fna&_nc_gid=AsXYX_-zgBLmyWoKPOZho6G&oh=00_AYC1PR8KpeYpf8uBODGxUjB5UqvoiMRzy6L1W_dJSIV3-A&oe=67466BE2" alt="Pruebas logo" width="60"/>


## Estructura del Proyecto

- **Controller**: Controladores REST para manejar solicitudes de API.
- **Service**: Servicios que contienen la lógica de negocio.
- **Repository**: Interfaz JPA para acceso a datos en el Microservicio Principal.
- **Model**: Clases de entidad para representar datos de la base de datos.
- **ExceptionHandler**: Manejo de excepciones personalizadas.
- **External**: Cliente de comunicación con el Microservicio de Actividades.

## Ejemplo de Reporte Mensual

Reporte Mensual del Aprendiz 12345 (Marzo 2024):
- **Semana 1**:
    - Lunes: 2024-03-01, Entrenamiento de Piernas
    - Martes: 2024-03-02, Entrenamiento Cardiovascular
    - Jueves: 2024-03-04, Entrenamiento de Piernas
- **Semana 2**:
    - Lunes: 2024-03-08, Entrenamiento de Tren Superior
    - Miércoles: 2024-03-10, Entrenamiento Cardiovascular
    - Viernes: 2024-03-12, Entrenamiento de Tren Superior

## Instalación y Configuración

1. Clona estos dos repositorios:
   ```bash
   git clone https://github.com/jedatoos/gym-management-system.git
   git clone https://github.com/jedatoos/MicroB.git
