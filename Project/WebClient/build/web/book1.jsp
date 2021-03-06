<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

        <!-- My CSS -->
        <link rel="stylesheet" href="styles/main.css">
        <link rel="stylesheet" href="styles/book.css">

        <!-- Jquery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <title>Book Now</title>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top drop-shadow-0-4-10 mb-5">
            <div class="container-fluid">
                <!-- Navbar Toggler -->
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02"
                        aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>


                <!-- Navbar  -->
                <a class="navbar-brand rubik-bold color-green" href="#">日々つ HIBITSU</a>
                <div class="collapse navbar-collapse justify-content-end" id="navbarTogglerDemo02">
                    <ul class="navbar-nav mb-2 mb-lg-0">
                        <li class="nav-item me-3">
                            <a class="nav-link rubik-normal" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item me-3">
                            <a class="nav-link active rubik-bold color-green" aria-current="page" href="book1.jsp">Book
                                Now</a>
                        </li>
                        <% if (session.getAttribute("idUser") == null) { %>
                        <li class="nav-item me-3">
                            <a class="nav-link rubik-normal" href="login.jsp">Login</a>
                        </li>
                        <% }%>
                        <% if (session.getAttribute("idUser") != null) { %>
                        <li class="nav-item me-3">
                            <a class="nav-link rubik-normal" href="track-order.jsp">Track Order</a>
                        </li>
                        <li class="nav-item me-3">
                            <form method='POST' action='login-handler.jsp'>
                                <input type='hidden' name='command' value='logout'>
                                <button type='submit' class="nav-link rubik-normal" style='padding-right: .5rem; border: none; background: none;' href="login.jsp">Logout</a>
                            </form>
                        </li>
                        <% }%>
                    </ul>
                    <button class="btn btn-success background-green"><a href="https://drive.google.com/uc?export=download&id=1ILQiR2KmkBBEBSSA4bdQ198P8s_MnPPX" class="rubik-bold color-white" style="text-decoration: none;">Download App</a>
                    </button>
                </div>
            </div>
        </nav>
        <%
            String keteranganSuksesGagal = "";
            try {
                com.ubaya.disprog.WebServiceServer_Service service = new com.ubaya.disprog.WebServiceServer_Service();
                com.ubaya.disprog.WebServiceServer port = service.getWebServiceServerPort();

                java.lang.String result = port.displayVillaAllWeb();
                System.out.println(result);
                String[] resultSplitted = result.split(";;");
                keteranganSuksesGagal = resultSplitted[1];

                if (keteranganSuksesGagal.equals("true")) {
                    out.println(resultSplitted[2]);
                } else {
                    out.println("<p class='rubik-bold color-red'>404 : Sorry there's a problem</p>");
                }

            } catch (Exception ex) {
                System.out.println("Error Display Villa All : " + ex);
            }
        %>
        <!-- Add Hotel Here -->
        <!--
        <div class='grid-container box-model box-model1' style='padding: 0'>
            <div class='grid-left' style='padding: 0'>
                <img src='assets/images/hotel1.png' class='img-hotel' alt=''>
            </div>
            <div class='grid-right'>
                <p class='rubik-bold' style='font-size: 1.4em;;'>The La'llorona</p>
                <p class='karla-normal'>A beautiful near beach villa, with a wonderful neighboorhood. Be amazed! Be
                    Refreshed!
                    Other activities to do here is surfing, skying, running, jumping and other stuff!</p>
                <form method='GET' action='book2.jsp'>
                    <input type='hidden' name='idVilla' value='1'>
                    <button class='btn btn-success rubik-bold color-white background-green' type='submit'>View Details</button>
                </form>
            </div>
        </div>
        -->

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous">
        </script>

        <script>
            $(document).ready(function () {
                $(window).scroll(function () {
                    var height = $('.grid-container').height();
                    var scrollTop = $(window).scrollTop();

                    if (scrollTop >= 20) {
                        $('nav').addClass('solid-nav');
                    } else {
                        $('nav').removeClass('solid-nav');
                    }

                });
            });
        </script>

    </body>

</html>