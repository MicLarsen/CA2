$(document).ready(function () {

    $("#submitPerson").click(function () {

        var firstname = $("#firstname").val();
        var lastname = $("#lastname").val();
        var address = $("#address").val();
        var city = $("#city").val();
        var zip = $("#zip").val();

        var phone1 = $("#phonenumber1").val();
        var phoneDesc1 = $("#phoneDescription1").val();
        var phone2 = $("#phonenumber2").val();
        var phoneDesc2 = $("#phoneDescription2").val();
        var phone3 = $("#phonenumber3").val();
        var phoneDesc3 = $("#phoneDescription3").val();
        var hobby1 = $("#hobby1").val();
        var hobbyDesc1 = $("#hobbyDescription1").val();
        var hobby2 = $("#hobby2").val();
        var hobbyDesc2 = $("#hobbyDescription2").val();
        var hobby3 = $("#hobby3").val();
        var hobbyDesc3 = $("#hobbyDescription3").val();

        var hej = "";

        console.log(hej);
        console.log(firstname + " " + lastname);
        console.log(address + " " + city + " " + zip);
        console.log(phone1 + " " + phoneDesc1);
        console.log(phone2 + " " + phoneDesc2);
        console.log(phone3 + " " + phoneDesc3);
        console.log(hobby1 + " " + hobbyDesc1);
        console.log(hobby2 + " " + hobbyDesc2);
        console.log(hobby3 + " " + hobbyDesc3);
    })


    $("#addPhone").click(function () {
        $("#phoneAdded").append('<div>Phonenumber : <input class="phone#" type="text" placeholder="add new number"> Phonedesciption : <input class="phoneDesc" type="text" placeholder="add phone desciption"><br></div>');
    })
    $("#addHobby").click(function () {
        $("#hobbyAdded").append('<div>Hobby : <input class="phone#" type="text" placeholder="add new hobby"> Hobbydesciption : <input class="phoneDesc" type="text" placeholder="add hobby desciption"><br></div>');
    })
})
   