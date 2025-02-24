<jsp:include page="include/header.jsp" />

<link rel="stylesheet" href="..\..\pub\CSS\about.css">
<script src="..\..\pub\JavaScript\about.js"></script>
<title>About</title>

<section class="about">
<h1>About Us</h1>
</section>
</section>

<section class="about-us">

    <div class="row">
        <div class="about-col">
            <h1>We're working hard to improve Pok&#233;Theory each and everyday</h1>
            <p>Thank you for using Pok&#233;Theory. A team of dedicated, passionate people helped bring this dream into a reality.</p>
            <a href="https://github.com/lindorG" class="hero-btn">EXPLORE NOW</a>
        </div>
        <div class="about-col">
            <img src="../../pub/images/about.png">
        </div>
    </div>
</section>

<section class="contact">
    <div class="container">
        <form onsubmit="sendEmail(); reset(); return false;">
            <h3>CONTACT</h3>
            <input type="text" id="nameId" placeholder="Your Name" required>
            <input type="email" id="emailId" placeholder="Email" required>
            <input type="text" id="phoneId" placeholder="Phone no." required>
            <input type="text" id="subjectId" placeholder="Subject" required>
            <textarea id="messageId" rows="6" placeholder="How may we help you?"></textarea>
            <button type="submit">Send</button>
        </form>
    </div>
</section>

</section>

<script src=" https://smtpjs.com/v3/smtp.js"></script>
<script>
    function sendEmail() {
        Email.send({
            Host : "smtp.gmail.com",
            Username : "poketheorySPT@gmail.com",
            Password : "SupportingTrainers2@#",
            To : 'lindorgiorvanny@gmail.com',
            From : document.getElementById("emailId").value,
            Subject : document.getElementById("subjectId").value,
            Body : "Name : " + document.getElementById("nameId").value
                + "<br>Email: " + document.getElementById("emailId").value
                + "<br>Phone no: " + document.getElementById("phoneId").value
                + "<br><br>Message:<br>" + document.getElementById("messageId").value
        }).then(
            message => alert("Message Sent Successfully")
        )}
</script>

<jsp:include page="include/footer.jsp" />