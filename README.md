# Microservice - Netflix OSS
Microservice Integrated Netflix OSS Components

<b>1. Service registry <i>(Eureka Server)</i></b><br>
<b>2. Service Discovery <i>(Eureka Client)</i></b><br>
<b>3. Registry Aware Client <i>(Feign Client)</i></b><br>
<b>4. Client Side Load Balancing <i>(Ribbon Client)</i></b><br>
<b>5. Circuit Breaker <i>(Hystrix)</i></b><br>

# URLs

<table>
  <tr>
    <th>No</th>
    <th>Component</th>
    <th>URL</th>
  </tr>
  <tr>
    <td>1</td>
    <td>Eureka Server</td>
    <td>http://localhost:8761, http://localhost:8762</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Store Service</td>
    <td>http://localhost:9090/inventory</td>
  </tr>
  <tr>
    <td>3</td>
    <td>Inventory Service</td>
    <td>http://localhost:8090/store</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Swagger</td>
    <td>http://localhost:9090/store/swagger-ui.html, http://localhost:9090/inventory/swagger-ui.html</td>
  </tr>
  <tr>
    <td>5</td>
    <td>Hystrix Stream</td>
    <td>http://localhost:8090/store/actuator/hystrix.stream</td>
  </tr>
  <tr>
    <td>6</td>
    <td>Hystrix Dashboard</td>
    <td>http://localhost:8090/store/hystrix</td>
  </tr>
</table>
