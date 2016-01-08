(function() {
    var firstNameBox = document.getElementById('firstname');
    var lastNameBox = document.getElementById('lastname');   
    var sumbitButton = document.getElementById('post-person');
    var responsePerson = document.getElementById('person-response');
    var familyName = document.getElementById('familyname');
    var familyNameButton = document.getElementById('get-family');
    var famliyResponse = document.getElementById('familyresponse');
    familyNameButton.onclick = famliyLister;
    sumbitButton.onclick = submitListener;

    function postperson (firstname, lastname) {
        var myRequest = new XMLHttpRequest();
        myRequest.onreadystatechange = function () {
            console.log(myRequest.responseText);
            responsePerson.textContent = myRequest.responseText;
        };
        myRequest.open("POST", "http://localhost:8080/people");
        myRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        myRequest.send(JSON.stringify({firstName:firstname, lastName:lastname}));
    }

    function getfamily (familyname) {
        var myRequest = new XMLHttpRequest();
        myRequest.onreadystatechange = function () {
            console.log(myRequest.responseText);
            famliyResponse.textContent = myRequest.responseText;
        };
        myRequest.open("GET", "http://localhost:8080/families?familyName=" + familyname);
        myRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        myRequest.send();
    }

    function famliyLister () {
        var validate = true;
        var inputFam = familyName.value.split(" ");
        if (inputFam.length > 1) {
            validate = false;
        };

        if (validate === false) {
            alert("Not all required fields entered");
        } else {
            getfamily(familyName.value);
        };
    }

    function submitListener () {
        var validate = true;
        var inputArrayOne = firstname.value.split(" ");
        var inputArrayTwo = firstname.value.split(" ");
        if (firstNameBox.value.length === 0 ||
            lastNameBox.value.length === 0) {
            validate = false;
        } else if (inputArrayOne.length > 1 ||
            inputArrayTwo.length > 1) {
            validate = false;
        };

        if (validate === false) {
            alert("Not all required fields entered");
        } else {
            postperson(firstNameBox.value, lastNameBox.value);
        };
    }
}());