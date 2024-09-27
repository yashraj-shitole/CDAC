  function CheckEmpty(controlID, errorDivID, errorMessage) {
        var refToSomeInput = document.getElementById(controlID);
        var refToErrorLocation = document.getElementById(errorDivID);

        if (refToSomeInput.value == "") {
          refToErrorLocation.innerText = errorMessage;
        } else {
          console.log(refToSomeInput.value);
          refToErrorLocation.innerText = "";
        }
      }