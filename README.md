# Solve
<p align="center">
  <a href="https://github.com/shldhll/Solve">
    <img src="static/icon.png" alt="Logo" width="100" height="100">
  </a>
  <h3 align="center">Solve</h3>
  <p align="center">
    Blog REST API using Spring Boot, H2 Database and Gradle<br><br>
    <img src="https://forthebadge.com/images/badges/made-with-java.svg" />
  </p>
  <h3>Features</h3>
  <ul>
  <li>CRUD operations for a blog</li>
  <li>CRUD operations for a comment</li>
  <li>Create/View nested comments</li>
  <li>Validation and error handling</li>
  </ul>
  <h3>Installation</h3>
  <ol>
  <li>Clone the repository <code>git clone https://github.com/shldhll/Solve.git</code></li>
  <li>Open project and sync gradle</li>
  <li>Build and run the application using <code>gradlew bootRun</code> command</li>
  </ol>
  <h3>Details</h3>
  <h4>SQL Database</h4>
  I have used an SQL Database (H2 Database), here the relationship and structure between a blog and a comment is clearly defined. It is easy to see that both of the models are not very dynamic in nature and considering their dependency a relational database is a good choice for this project.
  <h4>Nesting of Comments</h4>
  A separate field <code>parentId</code> is being used for implementing the nesting of comments. In my opinion, this is the best approach as this allows for lazy-loading/pagination which can lead to great efficiency.
  <h4>Validation and Exception Handling</h4>
  For validation Spring Boot and JPA proved to be of great help, making null checks and implementing custom error messages a breeze. For exception handling, I prefered to use a custom implementation for returning easy-to-read errors.
  <h3>REST APIs</h3>
  If you are using Postman, you can download the Postman Collection <a href="https://www.getpostman.com/collections/739d7620c08d26cd3316">here</a> or import the collection from the repository.
  <h4>Blog</h4>
  <table>
  <tr>
    <th>METHOD</th>
    <th>REQUEST URL</th>
    <th>DETAILS</th>
  </tr>
  <tr>
    <td>POST</td>
    <td>/blogs</td>
    <td>Add a blog</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/blogs</td>
    <td>Get all the blogs</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/blogs/{id}</td>
    <td>Get a blog by ID</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/blogs/{id}</td>
    <td>Delete the blog with given ID</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>/blogs/{id}</td>
    <td>Update the blog with given ID</td>
  </tr>
  </table>
  <h4>Comment</h4>
  <table>
  <tr>
    <th>METHOD</th>
    <th>REQUEST URL</th>
    <th>DETAILS</th>
  </tr>
  <tr>
    <td>POST</td>
    <td>/blogs/{blogId}/comments</td>
    <td>Add a comment</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/blogs/{blogId}/comments</td>
    <td>Get all comments for a blog</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/blogs/{blogId}/comments/{id}</td>
    <td>Get all comments for a comment</td>
  </tr>
  </table>
</p>
