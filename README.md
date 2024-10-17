# E-Commerce WebApp

# Product Service
# CRUD endpoints - Please go through the Controllers
# products catalog can be accessed at "my-host/products"
# specific product can be accessed at "my-host/products/{id}" where id is an integer value
# product can be created using "my-host/products" - give a json payload with a product dto structure

#Kafka
# Acts as a Producer: whenever a new product is added- a send email event is added to Kafka
# emailService consumes the event to send the email
# Thus, Kafka facilitates asynchronous communication between this ecom_webServices/Product Service and Email Service

#Authentication
# Product Service goes to User Service to user-service-url/validate the 'Token - JWT' it received in request


