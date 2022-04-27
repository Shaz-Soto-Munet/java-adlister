<%--
  Created by IntelliJ IDEA.
  User: shaz
  Date: 4/27/22
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza Order</title>
</head>
<body>

<h1>Select your pizza:</h1>

    <form method="POST" action="/PizzaOrder">

        <div>
            <legend style="font-weight: bold">Crust:</legend>
                <input type="radio" id="crunchy-thin" name="crust" value="crunchy-thin">
               <label for="crunchy-thin">Crunchy Thin</label>
                    <br>
                <input type="radio" id="hand-tossed" name="crust" value="hand-tossed">
                <label for="hand-tossed">Hand-tossed</label>
                    <br>
                <input type="radio" id="cheese-stuffed" name="crust" value="cheese-stuffed">
                <label for="cheese-stuffed">Cheese-stuffed</label>
        </div>
        <br>
        <div>
            <legend style="font-weight: bold">Sauce:</legend>
                <input type="radio" id="tomato" name="sauce" value="tomato">
                <label for="tomato">Tomato</label>
                    <br>
                <input type="radio" id="alfredo" name="sauce" value="alfredo">
                <label for="alfredo">Alfredo</label>
                    <br>
                <input type="radio" id="bbq" name="sauce" value="bbq">
                <label for="bbq">BBQ</label>
        </div>
        <br>
        <div>
            <legend style="font-weight: bold">Size:</legend>
            <input type="radio" id="personal" name="size" value="personal">
            <label for="personal">Personal</label>
            <br>
            <input type="radio" id="regular" name="size" value="regular">
            <label for="Regular">Regular</label>
            <br>
            <input type="radio" id="large" name="size" value="large">
            <label for="large">Large</label>
        </div>
        <br>
        <div>
            <legend style="font-weight: bold">Toppings:</legend>
            <input type="checkbox" id="pepperoni" name="toppings1" value="pepperoni">
            <label for="pepperoni">Pepperoni</label>
            <br>
            <input type="checkbox" id="mushrooms" name="toppings2" value="mushrooms">
            <label for="mushrooms">Mushrooms</label>
            <br>
            <input type="checkbox" id="onions" name="toppings3" value="onions">
            <label for="onions">Onions</label>
            <br>
            <input type="checkbox" id="black-olives" name="toppings4" value="black-olives">
            <label for="black-olives">Black Olives</label>
            <br>
            <input type="checkbox" id="pineapple" name="toppings5" value="pineapple">
            <label for="pineapple">Pineapple</label>
        </div>
        <br>
        <input type="text" id="address" name="address" placeholder="Please type in the delivery address here" style="height: 50px; width: 300px">
        <br>
        <br>
        <button>Place your order</button>


    </form>


</body>
</html>
