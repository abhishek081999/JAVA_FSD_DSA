// Function to register an employee
function registerEmployee(name, role) {
  var xhr = new XMLHttpRequest();
  if (name.value && role.value) {
    var empDetails = {
      name: name.value,
      role: role.value,
    };
    xhr.open("POST", "https://reqres.in/api/users");
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.send(JSON.stringify(empDetails));
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 201) {
        var response = xhr.response;
        var parsedResponse = JSON.parse(response);
        alert(
          "Employee with ID " + parsedResponse.id + " successfully registered!"
        );
        sessionStorage.setItem("user-details", xhr.responseText);
      }
    };
  } else {
    alert("Please input both the fields in the form.");
  }
}

// Function to update the role of an employee
function updateEmployee(name, role) {
  var xhr = new XMLHttpRequest();
  if (name.value && role.value) {
    var empDetails = {
      name: name.value,
      role: role.value,
    };

    // Difference in PUT Method
    xhr.open("PUT", "https://reqres.in/api/users");
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.send(JSON.stringify(empDetails));
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        alert("Role updated successfully!");
        sessionStorage.setItem("user-details", xhr.responseText);
      }
    };
  } else {
    alert("Please input both the fields in the form.");
  }
}
