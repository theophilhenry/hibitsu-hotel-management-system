<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("idUser") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
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
        <link rel="stylesheet" href="styles/track-order.css">

        <!-- Jquery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <title>Template</title>
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
                            <a class="nav-link rubik-normal" href="book1.jsp">Book Now</a>
                        </li>
                        <li class="nav-item me-3">
                            <a class="nav-link active rubik-bold color-green" aria-current="page"
                               href="track-order.jsp">Track Order</a>
                        </li>
                        <% if (session.getAttribute("idUser") == null) { %>
                        <li class="nav-item me-3">
                            <a class="nav-link rubik-normal" href="login.jsp">Login</a>
                        </li>
                        <% }%>
                        <% if (session.getAttribute("idUser") != null) { %>
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

        <div class="content">
            <% if (session.getAttribute("printTrack") != null) { %>
            <p class="rubik-bold color-green mt-5" style='text-align: center;'><% out.println(String.valueOf(session.getAttribute("printTrack"))); %></p>
            <% }
                session.removeAttribute("printTrack");
            %>
            <div class="track-container">
                <p class="rubik-bold color-green" style="font-size: 2em">TRACK ORDER</p>
                <div class="mb-3">
                    <form method="POST">
                        <label for="exampleFormControlInput1" class="form-label mb-3">INPUT YOUR ORDER ID</label>
                        <input type="text" class="form-control mb-3" id="exampleFormControlInput1" name="idReservation"
                               placeholder="20010101001">
                        <button class="btn btn-success rubik-bold color-white background-green mb-3" type="submit"
                                style="width: 100%;">Track</button>
                    </form>
                </div>
                <%
                    if (request.getParameter("idReservation") != null) {
                        String getIdReservation = request.getParameter("idReservation");
                        int idReservation = Integer.parseInt(getIdReservation);

                        try {
                            com.ubaya.disprog.WebServiceServer_Service service = new com.ubaya.disprog.WebServiceServer_Service();
                            com.ubaya.disprog.WebServiceServer port = service.getWebServiceServerPort();

                            java.lang.String result = port.trackOrder1(idReservation);
                            out.println(result);

                        } catch (Exception ex) {
                            System.out.println("Error Track Order.jsp : " + ex);
                        }
                    }
                %>
                <!--                
                                                <p class='rubik-bold'>20200701001</p>
                                                <div class='track-details mb-4'>
                                                    <div class='information'>
                                                        <p class='rubik-bold'>YOUR NAME</p>
                                                        <p>Theophil Henry Soegianto</p>
                                                    </div>
                                
                                
                                                    <div class='information'>
                                                        <p class='rubik-bold'>VILLAS</p>
                                                        <p>The Lallorona</p>
                                                    </div>
                                
                                
                                                    <div class='information'>
                                                        <p class='rubik-bold'>DATE</p>
                                                        <p>09 June 2021 - 21 June 2021</p>
                                                    </div>
                                
                                
                                                    <div class='information'>
                                                        <p class='rubik-bold'>TOTAL GUEST</p>
                                                        <p>4 People</p>
                                                    </div>
                                
                                                    <div class='information'>
                                                        <p class='rubik-bold'>DATE OF ORDER</p>
                                                        <p>Rp. 1.000.000</p>
                                                    </div>
                                
                                                    <div class='information'>
                                                        <p class='rubik-bold'>TOTAL PRICE</p>
                                                        <p>Rp. 1.000.000</p>
                                                    </div>
                                
                                
                                                    <div class='information'>
                                                        <p class='rubik-bold'>NOTES</p>
                                                        <p>4 Extra Grill</p>
                                                    </div>
                                
                                
                                                    <div class='information'>
                                                        <p class='rubik-bold'>STATUS</p>
                                                        <p class='rubik-bold status-pending'>PENDING</p>
                                                        <div class='mb-3'>
                                                            <label for='formFileSm' class='form-label karla-normal' style='text-align: left;'>Payment Slip hasn't uploaded yet.
                                                                <br>To Upload payment slip, you need to
                                                                <br>1. Upload your payment slip photo to Google Drive
                                                                <br>2. Share and get the link
                                                                <br>3. Set the link to anyone can view
                                                                <br>4. Copy the link and paste it here.</label>
                                                            <input type='email' class='form-control mb-3' id='exampleFormControlInput1'
                                                                   placeholder='https://drive.google.com/file/d/xxx'>
                                                            <button class='btn btn-success rubik-bold color-white background-green mb-3' type='submit' style='width: 100%;'>Upload</button>
                                                        </div>
                                                    </div>
                                
                                
                                                </div>
                                        </div>
                -->
                <div class="track-details mb-4">
                    <p>If you have any question or problem with your order, please kindly contact us using consultation menu
                        on our App. </p>
                    <p class="karla-bold">Download app in the button above.</p>
                </div>

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
            </div>


    </body>

</html>