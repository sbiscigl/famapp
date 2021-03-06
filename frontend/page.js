(function() {
    var firstNameBox = document.getElementById('firstname');
    var lastNameBox = document.getElementById('lastname');   
    var sumbitButton = document.getElementById('post-person');
    var responsePerson = document.getElementById('person-response');
    var familyName = document.getElementById('familyname');
    var familyNameMembersButton = document.getElementById('get-family-members');
    var familyMemebersResponse = document.getElementById('familyresponsememebers');
    var memberlist = document.getElementById('memberlist');
    familyNameMembersButton.onclick = familyMembersListener;
    sumbitButton.onclick = submitListener;

    function postperson (firstname, lastname) {
        var myRequest = new XMLHttpRequest();
        myRequest.open("POST", "http://10.0.0.4:8080/people");
        myRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        myRequest.send(JSON.stringify({firstName:firstname, lastName:lastname}));
    };

    function getMembersFromResponse(responsetext) {
        var response = JSON.parse(responsetext);
        var memberList = response.members;
        var nameList = [];
        var key;
        for (key in memberList) {
            nameList.push(memberList[key].firstName + " " + memberList[key].lastName);
        }
        return nameList;
    };

    function addToNameList(nameList) {
        var key;
        for(key in nameList) {
            var li = document.createElement("li");
            li.appendChild(document.createTextNode(nameList[key]));
            memberlist.appendChild(li);
        }
    };

    function getfamilymembers(familyname) {
        var myRequest = new XMLHttpRequest();
        myRequest.onreadystatechange = function () {
            if (myRequest.readyState === 4) {
                if (myRequest.status === 200) {
                    var nameList = getMembersFromResponse(myRequest.responseText);
                    addToNameList(nameList);
                }
            }
        };
        myRequest.open("GET", "http://10.0.0.4:8080/families?familyName=" + familyname + "&returnMembers=true");
        myRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        myRequest.send();
    };

    function familyMembersListener () {
        var listItems = Array.prototype.slice.call(memberlist.childNodes);
        var i;
        while (i = listItems.pop()) {
            memberlist.removeChild(i);
        }
        var validate = true;
        var inputFam = familyName.value.split(" ");
        if (inputFam.length > 1) {
            validate = false;
        };
        if (validate === false) {
            alert("Not all required fields entered");
        } else {
            getfamilymembers(familyName.value);
        };
    };

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
    };
}());
