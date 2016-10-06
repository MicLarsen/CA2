$(document).ready(function () {

    $("#submitPerson").click(function () {

        var phones = new Array;
        $('#phones :input').each(function () {
            var attr = $(this).val();
            phones.push(attr);
        });
        var phoneList = new Array;
        for (var i = 0; i < phones.length; i++) {
            if (i % 2 === 0) {
                var phone = {
                    number: phones[i],
                    description: phones[i + 1]
                }
                phoneList.push(phone);
            }
        }
        var hobbies = new Array;
        $('#hobbies :input').each(function () {
            var attr = $(this).val();
            hobbies.push(attr);
        })
        var hobbyList = new Array;
        for (var i = 0; i < hobbies.length; i++) {
            if (i % 2 === 0) {
                var hobby = {
                    name: hobbies[i],
                    description: hobbies[i + 1]
                }
                hobbyList.push(hobby);
            }
        }
        var address = {
            Street: $("#city").val(),
            AdditionalInfo: $("#zip").val()
        }

        var person = {
            firstName: $("#firstname").val(),
            lastName: $("#lastname").val(),
            address: address,
            phones: phoneList,
            email: $("#email").val(),
            hobbies: hobbyList
        }

        $.ajax({
            type: "POST",
            url: "api/person/add",
            data: JSON.stringify(person), // now data come in this function
            contentType: "application/json; charset=utf-8",
            crossDomain: true,
            dataType: "json",
            success: function (data, status, jqXHR) {

                console.log("success"); // write success in " "
            },
            error: function (jqXHR, status) {
                // error handler
                console.log(jqXHR);
                console.log('fail' + status.code);
            }
        });

    })

$(document).on("pageload",function(){
    
  

});

    $("#addPhone").click(function () {
        $("#phoneAdded").append('<div id="phoneDiv">Phonenumber : <input class="phone#" type="text" placeholder="add new number"> Phonedesciption : <input class="phoneDesc" type="text" placeholder="add phone desciption"><br></div>');
    })


    $("#remove").click(function () {
        console.log("hello there");
        $(this).closest("#phoneDiv").fadeOut(300);
    })

    $("#addHobby").click(function () {
        $("#hobbyAdded").append('<div>Hobby : <input class="phone#" type="text" placeholder="add new hobby"> Hobbydesciption : <input class="phoneDesc" type="text" placeholder="add hobby desciption"><br></div>');
    })
})
   