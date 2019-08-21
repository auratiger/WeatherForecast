<%--
 Created by IntelliJ IDEA.
 User: auratiger
 Date: 22.07.19
 Time: 12:15
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WeatherForecast</title>
    <script src="scripts/Jquery/Jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.js"></script>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#"><strong>WeatherForecast</strong></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>

<div class="Jumbotron" align="center" style="background: white">

    <form method="POST" action="http://localhost:8080/WebApplication_war/rest/tutorial">
        <button type="button" class="btn btn-dark" id="btn" style="margin: 10px">Query</button>

        <br>

        <label for="city">City</label>
        <select id="city" name="city">
            <option value="ruse">Ruse</option>
            <option value="sofia">Sofia</option>
            <option value="varna">Varna</option>
            <option value="burgas">Burgas</option>
            <option value="stara+zagora">Stara Zagora</option>
            <option value="plovdiv">Plovdiv</option>
        </select>

        <label for="field">Field</label>
        <select id="field" name="field">
            <option value="oneDay">Single days</option>
            <option value="fiveDay">Five days</option>
            <option value="tenDay">Ten days</option>
            <option value="weekend">Weekends</option>
            <option value="hourly">Hourly</option>
            <option value="day">Get Day</option>
        </select>

        <br>

        <label for="date">Date</label>
        <select id="date" name="date">
            <option value="07-08-2019">07-08-2019</option>
            <option value="05-08-2019">05-08-2019</option>
            <option value="04-08-2019">04-08-2019</option>
            <option value="03-08-2019">03-08-2019</option>
            <option value="02-08-2019">02-08-2019</option>
            <option value="01-08-2019">01-08-2019</option>
            <option value="31-07-2019">31-07-2019</option>
            <option value="30-07-2019">30-07-2019</option>
            <option value="29-07-2019">29-07-2019</option>
        </select>

<%--        <label for="hour">Hour</label>--%>
<%--        <select id="hour" name="hour">--%>
<%--            <% for (int i = 0; i < 23; i++) {--%>
<%--                String value;--%>
<%--                String name;--%>

<%--                if(i == 12){--%>
<%--                    value = "11:59:59 - 13:00:00";--%>
<%--                    name = String.format("%02d:00:00 - %02d:00:00", i, i+1);--%>
<%--                }else {--%>
<%--                    value = String.format("%02d:00:00 - %02d:00:00", i, i+1);--%>
<%--                    name = String.format("%02d:00:00 - %02d:00:00", i, i+1);--%>
<%--                }%>--%>
<%--            <option value="<%=value%>"><%=name%></option>--%>
<%--            <% }%>--%>
<%--        </select>--%>
        <label for="value">value</label>
        <select id="value" name="value">
            <option value="Temperature">Temperature</option>
            <option value="Wind">Wind</option>
            <option value="RainLikelihood">Rain Likelihood</option>
            <option value="RainAmount">Rain Amount</option>
            <option value="Cloudiness">Cloudiness</option>
        </select>

    </form>

    <div class="container">

        <canvas id="myChart"></canvas>

    </div>
</div>

<script src="JS/test.js"></script>

</body>
</html>














